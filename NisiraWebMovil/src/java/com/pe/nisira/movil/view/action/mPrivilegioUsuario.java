/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.mGrupoUsuarioDAO;
import com.nisira.core.dao.mSysFormularioDAO;
import com.nisira.core.entity.mGrupoUsuario;
import com.nisira.core.entity.mGrupoUsuarioPrivilegio;
import com.nisira.core.entity.mSysFormulario;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "mPrivilegioUsuarioAction")
@SessionScoped
public class mPrivilegioUsuario extends AbstactListAction<mGrupoUsuario> {
    
    private List<mGrupoUsuarioPrivilegio> lgup;
    private mGrupoUsuarioPrivilegio gup;
    private List<mSysFormulario> lfrm;
    private mSysFormulario frm;
    private mSysFormularioDAO frmDAO;
    private mGrupoUsuarioDAO mgrupdo;
    
    public mPrivilegioUsuario() {
        lgup = new ArrayList<mGrupoUsuarioPrivilegio>();
        gup = new mGrupoUsuarioPrivilegio();
        lfrm = new ArrayList<mSysFormulario>();
        frm = new mSysFormulario();
        frmDAO = new mSysFormularioDAO();
        mgrupdo = new mGrupoUsuarioDAO();
        actualiza_ventana("wMnt_GrupoUsuario");
    }
    
    @Override
    public void buscarTodo() {
        try {
            actualiza_ventana("wMnt_GrupoUsuario");
            setListaDatos(mgrupdo.findAll());
        } catch (Exception ex) {
            Logger.getLogger(mPrivilegioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getIniciar() {
        lgup = new ArrayList<mGrupoUsuarioPrivilegio>();
        gup = new mGrupoUsuarioPrivilegio();
        lfrm = new ArrayList<mSysFormulario>();
        frm = new mSysFormulario();
        frmDAO = new mSysFormularioDAO();
        mgrupdo = new mGrupoUsuarioDAO();
        actualiza_ventana("wMnt_GrupoUsuario");
        return "";
    }
    
    @Override
    public void nuevo() {
        setDatoEdicion(new mGrupoUsuario());
        getDatoEdicion().setBEs_administrador(false);
    }
    
    @Override
    public void grabar() {
        try {
            mgrupdo.grabarGrupos(getDatoEdicion(), lgup);
        } catch (Exception ex) {
            Logger.getLogger(mPrivilegioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar() {
        if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
            
        }
        if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
            
        }
    }
    
    public void verDetalle() throws Exception {
        if (getDatoEdicion().getIdgrupousuario() != null) {
            lgup = mgrupdo.findbyGrupoUsuario(getDatoEdicion().getIdgrupousuario());
        }else{
            lgup = new ArrayList<mGrupoUsuarioPrivilegio>();
        }
        lfrm = frmDAO.findAllFrm();
    }
    
    public void selectFrm() {
        if (getDatoEdicion().getIdgrupousuario() != null) {
            mGrupoUsuarioPrivilegio ngrup = new mGrupoUsuarioPrivilegio();
            ngrup.setIdformulario(frm.getIdformulario());
            ngrup.setIdgrupousuario(getDatoEdicion().getIdgrupousuario());
            lgup.add(ngrup);
        }else{
            WebUtil.MensajeAdvertencia("Falta ingresar Codigo de Grupo");
        }
        
    }
    
    public void delDetalle() {
        lgup.remove(gup);
    }
    
    public List<mGrupoUsuarioPrivilegio> getLgup() {
        return lgup;
    }
    
    public void setLgup(List<mGrupoUsuarioPrivilegio> lgup) {
        this.lgup = lgup;
    }
    
    public mGrupoUsuarioPrivilegio getGup() {
        return gup;
    }
    
    public void setGup(mGrupoUsuarioPrivilegio gup) {
        this.gup = gup;
    }
    
    public List<mSysFormulario> getLfrm() {
        return lfrm;
    }
    
    public void setLfrm(List<mSysFormulario> lfrm) {
        this.lfrm = lfrm;
    }
    
    public mSysFormulario getFrm() {
        return frm;
    }
    
    public void setFrm(mSysFormulario frm) {
        this.frm = frm;
    }
    
}
