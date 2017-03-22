/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.OperarioDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.dao.mGrupoUsuarioDAO;
import com.nisira.core.dao.mUsuarioDAO;
import com.nisira.core.entity.Operario;
import com.nisira.core.entity.Usuario;
import com.nisira.core.entity.mGrupoUsuario;
import com.nisira.core.entity.mUsuario;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.util.Encryption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "mUsuarioAction")
@SessionScoped
public class mUsuarioAction extends AbstactListAction<mUsuario> {

    private List<mGrupoUsuario> lstgu;
    private mGrupoUsuario gu;
    private mUsuarioDAO musuDAO;
    private List<Usuario> lstUsuario;
    private Usuario slcUsu;
    private UsuarioDao usuDao;
    private Operario slcop;
    public mUsuarioAction() {
        this.lstgu = new ArrayList<mGrupoUsuario>();
        this.gu = new mGrupoUsuario();
        this.lstUsuario = new ArrayList<Usuario>();
        this.slcUsu = new Usuario();
        this.usuDao = new UsuarioDao();
        this.musuDAO = new mUsuarioDAO();
        this.slcop = new Operario();
        actualiza_ventana("wMnt_mUsuarios");
    }

    @Override
    public void buscarTodo() {
        try {
            actualiza_ventana("wMnt_mUsuarios");
            setListaDatos(musuDAO.findAll());
            for (mUsuario u : getListaDatos()) {
                u.setClave(Encryption.decrypt(u.getClave()));
            }
            mGrupoUsuarioDAO gdoa = new mGrupoUsuarioDAO();
            lstgu = gdoa.findAll();
            lstUsuario = usuDao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        this.lstgu = new ArrayList<mGrupoUsuario>();
        this.gu = new mGrupoUsuario();
        this.lstUsuario = new ArrayList<Usuario>();
        this.slcUsu = new Usuario();
        this.usuDao = new UsuarioDao();
        this.musuDAO = new mUsuarioDAO();
        this.slcop = new Operario();
        actualiza_ventana("wMnt_mUsuarios");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new mUsuario());
        getDatoEdicion().setEstado(1);
    }

    @Override
    public void grabar() {
        getDatoEdicion().setClave(Encryption.encrypt(getDatoEdicion().getClave()));
        
        
        try {
            musuDAO.grabarMusuario(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        getDatoEdicion().setClave(Encryption.decrypt(getDatoEdicion().getClave()));
    }

    @Override
    public void eliminar() {
        if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
            
        }
        if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
            
        }
    }
    public void verCntOperario() {
        RequestContext.getCurrentInstance().openDialog("cntOperario", modalOptions, null);
    }

    public void llenarOperario(SelectEvent event) {
        this.slcop = (Operario) event.getObject();
        getDatoEdicion().setNombres(slcop.getNOMBRES());
        getDatoEdicion().setIdoperario(slcop.getIDOPERARIO());
    }
    public void selectFrm() {
        getDatoEdicion().setIdgrupousuario(gu.getIdgrupousuario());
        if(gu.getIdgrupousuario().equalsIgnoreCase("ADM")){
            getDatoEdicion().setNombres("USUARIO ADMINISTRADOR");
        }
    }
    public void selectUsu(){
        getDatoEdicion().setIdusuario(slcUsu.getIDUSUARIO());
        getDatoEdicion().setClave(slcUsu.getPASSWORD());
    }
    public List<mGrupoUsuario> getLstgu() {
        return lstgu;
    }

    public void setLstgu(List<mGrupoUsuario> lstgu) {
        this.lstgu = lstgu;
    }

    public mGrupoUsuario getGu() {
        return gu;
    }

    public void setGu(mGrupoUsuario gu) {
        this.gu = gu;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public Usuario getSlcUsu() {
        return slcUsu;
    }

    public void setSlcUsu(Usuario slcUsu) {
        this.slcUsu = slcUsu;
    }

    public Operario getSlcop() {
        return slcop;
    }

    public void setSlcop(Operario slcop) {
        this.slcop = slcop;
    }

}
