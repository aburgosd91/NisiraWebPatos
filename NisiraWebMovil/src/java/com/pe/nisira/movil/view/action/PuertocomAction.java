/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.PuertocomDao;
import com.nisira.core.entity.Puertocom;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "puertocomAction")
@SessionScoped
public class PuertocomAction extends AbstactListAction<Puertocom> implements Serializable {

    private String mensaje;
    private PuertocomDao pdao;
    private UsuarioBean user;

    public PuertocomAction() {
        mensaje = "";
        pdao = new PuertocomDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Puertocom");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_Puertocom");
            setListaDatos(pdao.findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        pdao = new PuertocomDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Puertocom");
        return "";
    }

    @Override
    public void doNuevo() throws IOException {
        setLadd(1);
        nuevo();
    }

    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");
        } else {
            setLadd(2);
            setDatoEdicion(getDatoSeleccionado());
            RequestContext.getCurrentInstance().update("datos:dlGuardarPuertos");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarPuertos').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Puertocom());
            getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            getDatoEdicion().setEstado(1);
            RequestContext.getCurrentInstance().update("datos:dlGuardarPuertos");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarPuertos').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        return getDatoEdicion().getDescripcion() != null;
    }

    @Override
    public void grabar() {
        try {
            if (validarEdicion()) {
                pdao.grabar(getDatoEdicion());
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().execute("PF('dlGuardarPuertos').hide()");
            }
        } catch (Exception ex) {
            Logger.getLogger(ProcesosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                pdao.anular(getDatoEdicion(), 0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                pdao.anular(getDatoEdicion(), 2);
            }
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            Logger.getLogger(ProcesosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
