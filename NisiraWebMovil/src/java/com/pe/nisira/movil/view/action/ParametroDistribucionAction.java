/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ParametroDistribucionDao;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.ParametroDistribucion;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.ParametroDistribucionService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "parametroDistribucionAction")
@SessionScoped
public class ParametroDistribucionAction extends AbstactListAction<ParametroDistribucion> implements Serializable {

    private List<Multitabla> listMultitabla;
    private MultitablaService multitablaService;
    private Date fechaCreacion;
    private Date fechaDetalle;
    private String mensaje;
    private ParametroDistribucionService parametroDistribucionService;
    private boolean estadoDoc;
    private boolean visibleFechaDetalle;
    private UsuarioBean user;

    public ParametroDistribucionAction() {
        listMultitabla = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        parametroDistribucionService = new ParametroDistribucionService();
        fechaCreacion = new Date();
        fechaDetalle = new Date();
        visibleFechaDetalle = false;
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_parametroDistribucion");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_parametroDistribucion");
            setListaDatos(parametroDistribucionService.getRecordParametroDistribucion(user.getIDEMPRESA()));
            setListMultitabla(multitablaService.getRecordParametroRegla(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(ParametroDistribucionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        listMultitabla = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        parametroDistribucionService = new ParametroDistribucionService();
        fechaCreacion = new Date();
        fechaDetalle = new Date();
        visibleFechaDetalle = false;
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_parametroDistribucion");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new ParametroDistribucion());
        getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
        getDatoEdicion().setESTADO(true);
        getDatoEdicion().setTIPO(0);
        getDatoEdicion().setFECHACREACION(WebUtil.fechaDMY(fechaDetalle, 1));
        RequestContext.getCurrentInstance().update("datos:dlGuardarParametroDistribucion");
        RequestContext.getCurrentInstance().execute("PF('dlGuardarParametroDistribucion').show()");
    }

    @Override
    public void doNuevo() throws IOException {
        setLadd(1);
        nuevo();
    }

    @Override
    public void doEditar_lista() throws IOException {
        try {
            if (getDatoSeleccionado() == null) {
                WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

            } else {

                setLadd(2);
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                fechaCreacion = format.parse(getDatoSeleccionado().getFECHACREACION());
                if (getDatoSeleccionado().getFECHA_DETALLE() != null) {
                    fechaDetalle = format.parse(getDatoSeleccionado().getFECHA_DETALLE());
                    setVisibleFechaDetalle(true);
                }
                setDatoEdicion(getDatoSeleccionado());
                RequestContext.getCurrentInstance().update("datos:dlGuardarParametroDistribucion");
                RequestContext.getCurrentInstance().execute("PF('dlGuardarParametroDistribucion').show()");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ParametroDistribucionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onTipoParametroChange() {
        if (getDatoEdicion().getTIPO() == 2)//FECHA VENCIMIENTO
        {
            visibleFechaDetalle = true;
        } else {
            visibleFechaDetalle = false;
        }
        return;
    }

    public boolean esVistaValida() {
        if (getDatoEdicion().getNOMBRE().equals("")) {
            WebUtil.MensajeAlerta("Ingrese Descripción");
            this.mensaje = "Ingrese Descripción";
            return false;
        } else if (getDatoEdicion().getTIPO() == 0) {
            WebUtil.MensajeAlerta("Ingrese Tipo");
            this.mensaje = "Ingrese Tipo";
            return false;
        } else if (fechaCreacion == null) {
            WebUtil.MensajeAlerta("Ingrese Creación");
            this.mensaje = "Ingrese Fecha Creación";
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                getDatoEdicion().setFECHACREACION(WebUtil.fechaDMY(fechaCreacion, 1));
                if (getDatoEdicion().getTIPO() == 2) {
                    getDatoEdicion().setFECHA_DETALLE(WebUtil.fechaDMY(fechaDetalle, 1));
                } else {
                    getDatoEdicion().setFECHA_DETALLE(null);
                }
                if (getDatoEdicion().getIDPARAMETRO() == null) {

                    parametroDistribucionService.addParametroDistribucion(getDatoEdicion());
                    RequestContext.getCurrentInstance().update("datos");
                    RequestContext.getCurrentInstance().execute("PF('dlGuardarParametroDistribucion').hide()");
                } else {
                    parametroDistribucionService.editParametroDistribucion(getDatoEdicion());
                    RequestContext.getCurrentInstance().update("datos");
                    RequestContext.getCurrentInstance().execute("PF('dlGuardarParametroDistribucion').hide()");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ParametroDistribucionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {

                getDatoEdicion().setESTADO(false);
                parametroDistribucionService.editParametroDistribucion(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new ParametroDistribucionDao()).anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDPARAMETRO());
            }
        } catch (Exception ex) {
            Logger.getLogger(ParametroDistribucionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaDetalle() {
        return fechaDetalle;
    }

    public void setFechaDetalle(Date fechaDetalle) {
        this.fechaDetalle = fechaDetalle;
    }

    public boolean isEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(boolean estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    public boolean isVisibleFechaDetalle() {
        return visibleFechaDetalle;
    }

    public void setVisibleFechaDetalle(boolean visibleFechaDetalle) {
        this.visibleFechaDetalle = visibleFechaDetalle;
    }

}
