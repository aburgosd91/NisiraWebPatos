/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ResponsableDao;
import com.nisira.core.entity.Operario;
import com.nisira.core.entity.Responsable;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
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
@ManagedBean(name = "responsableAction")
@SessionScoped
public class ResponsableAction extends AbstactListAction<Responsable> implements Serializable {

    private ResponsableDao redao;
    private UsuarioBean user;
    private String mensaje;
    private Operario op;
    private int idnuevo;
    
    public ResponsableAction() {
        op = new Operario();
        redao = new ResponsableDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Responsable");
    }

    @Override
    public void buscarTodo() {
        try {
            actualiza_ventana("wMnt_Responsable");
            setListaDatos(redao.findAll(user.getIDEMPRESA()));
            if (!getListaDatos().isEmpty()) {
                idnuevo = getListaDatos().get(getListaDatos().size() - 1).getIdresponsable()+1;
            }
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        op = new Operario();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        redao = new ResponsableDao();
        actualiza_ventana("wMnt_Responsable");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Responsable());
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setFechacreacion(new Timestamp(new Date().getTime()));
        getDatoEdicion().setIdresponsable(idnuevo);
    }

    @Override
    public void grabar() {
        try {
            redao.insertaRespo(getDatoEdicion());
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
            }
            redao.insertaRespo(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(ResponsableAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void verCntOperario() {
        RequestContext.getCurrentInstance().openDialog("cntOperario", modalOptions, null);
    }

    public void llenarOperario(SelectEvent event) {
        this.op = (Operario) event.getObject();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Operario getOp() {
        return op;
    }

    public void setOp(Operario op) {
        this.op = op;
    }

}
