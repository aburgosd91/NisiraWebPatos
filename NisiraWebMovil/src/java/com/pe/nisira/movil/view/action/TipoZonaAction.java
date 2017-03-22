/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.TipoZonaDao;
import com.nisira.core.entity.TipoZona;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "tipoZonaAction")
@SessionScoped
public class TipoZonaAction extends AbstactListAction<TipoZona> implements Serializable {

    private String mensaje;
    private TipoZonaDao tipoZonaDao;
    private UsuarioBean user;

    public TipoZonaAction() {
        mensaje = "";
        tipoZonaDao = new TipoZonaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_tipoZona");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_tipoZona");
            setListaDatos(tipoZonaDao.findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(TipoZonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        tipoZonaDao = new TipoZonaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_tipoZona");
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
            RequestContext.getCurrentInstance().update("datos:dlGuardarTipoZona");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarTipoZona').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new TipoZona());
        getDatoEdicion().setESTADO(true);
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        RequestContext.getCurrentInstance().update("datos:dlGuardarTipoZona");
        RequestContext.getCurrentInstance().execute("PF('dlGuardarTipoZona').show()");

    }

    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getDESCRIPCION().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese DESCRIPCION");
            } else {
                if (getDatoEdicion().getIDTIPOZONA() == 0) {//Nuevo
                    setMensaje(tipoZonaDao.addTipoZona(getDatoEdicion()));
                    if (!mensaje.equals("")) {
                        WebUtil.info("TipoZona " + getDatoEdicion().getDESCRIPCION() + " registrado con éxito.");
                    }
                } else if (getDatoEdicion().getIDTIPOZONA() != 0) {//Modificar
                    setMensaje(tipoZonaDao.editTipoZona(getDatoEdicion()));
                    if (!mensaje.equals("")) {
                        WebUtil.info("TipoZona " + getDatoEdicion().getDESCRIPCION() + " actualizado con éxito.");
                    }
                }
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().update("datos:tbl");

            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(getMensaje());

            return;
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(false);
                mensaje = tipoZonaDao.editTipoZona(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                tipoZonaDao.anular(getDatoEdicion());
            }

        } catch (Exception ex) {
            Logger.getLogger(OperarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
