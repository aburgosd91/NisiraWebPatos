/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.entity.Procesos;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "procesosAction")
@SessionScoped
public class ProcesosAction extends AbstactListAction<Procesos> implements Serializable {

    private String mensaje;
    private ProcesosDao proDao;
    private UsuarioBean user;
    private Date fechainicio;

    public ProcesosAction() {
        mensaje = "";
        proDao = new ProcesosDao();
        fechainicio = null;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Procesos");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_Procesos");
            setListaDatos(proDao.findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        proDao = new ProcesosDao();
        fechainicio = null;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Procesos");
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
            fechainicio = new Date(getDatoEdicion().getFechainicio().getTime());
            RequestContext.getCurrentInstance().update("datos:dlGuardarProceso");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarProceso').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Procesos());
            getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
            getDatoEdicion().setEstado(1);
            fechainicio = null;
            RequestContext.getCurrentInstance().update("datos:dlGuardarProceso");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarProceso').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getDescripcion() == null) {
            return false;
        }
        return fechainicio != null;
    }

    @Override
    public void grabar() {
        try {
            if (validarEdicion()) {
                getDatoEdicion().setFechainicio(new Timestamp(fechainicio.getTime()));
                proDao.grabar(getDatoEdicion());
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().execute("PF('dlGuardarProceso').hide()");
            }
        } catch (Exception ex) {
            Logger.getLogger(ProcesosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ver() {
        setLadd(0);
        setDatoEdicion(getDatoSeleccionado());
        RequestContext.getCurrentInstance().update("datos:dlGuardarProceso");
        RequestContext.getCurrentInstance().execute("PF('dlGuardarProceso').show()");
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                proDao.anular(getDatoEdicion(), 0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                proDao.anular(getDatoEdicion(), 2);
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

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

}
