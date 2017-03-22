/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "sucursalAction")
@SessionScoped
public class SucursalAction extends AbstactListAction<Sucursal> implements Serializable {

    private SucursalService sucursalService;
    private String mensaje;
    private boolean botonAlmacenEditarDis;
    private boolean botonAlmacenEliminarDis;
    private MultitablaService multitablaService;
    private List<Multitabla> listMultitabla;
    private AlmacenService almacenService;
    private List<Almacen> listAlmacen;
    private List<Almacen> fillAlmacen;
    private Almacen selectAlmacen;
    private Almacen newAlmacen;
    private UsuarioBean user;

    public SucursalAction() {
        sucursalService = new SucursalService();
        mensaje = "";
        botonAlmacenEditarDis = true;
        botonAlmacenEliminarDis = true;
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        almacenService = new AlmacenService();
        listAlmacen = new ArrayList<Almacen>();
        selectAlmacen = new Almacen();
        newAlmacen = new Almacen();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_sucursal");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_sucursal");
            setListaDatos(sucursalService.getRecordSucursalEmpresa(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        sucursalService = new SucursalService();
        mensaje = "";
        botonAlmacenEditarDis = true;
        botonAlmacenEliminarDis = true;
        multitablaService = new MultitablaService();
        listMultitabla = new ArrayList<Multitabla>();
        almacenService = new AlmacenService();
        listAlmacen = new ArrayList<Almacen>();
        selectAlmacen = new Almacen();
        newAlmacen = new Almacen();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_sucursal");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Sucursal());
        getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
        getDatoEdicion().setESTADO(true);
        getDatoEdicion().setSINCRONIZA("0");
        getDatoEdicion().setDISTRIBUIR("0");
    }

    public boolean esVistaValida() {
        if (getDatoEdicion().getDESCRIPCION().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Descripcion de la Sucursal");
            return false;
        }
        if (getDatoEdicion().getDIRECCION().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Direccion de la Sucursal");
            return false;
        }
        return true;
    }

    public boolean esDetValida() {
        if (newAlmacen.getDESCRIPCION().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Descripcion de la Almacen");
            return false;
        }
        if (newAlmacen.getDIRECCION().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Direccion de la Almacen");
            return false;
        }
        if (newAlmacen.getNOMBRE_CORTO().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Nombre Corto de la Almacen");
            return false;
        }
        if (newAlmacen.getIDTIPOALMACEN() == 0) {
            WebUtil.MensajeError("Ingrese Tipo Almacen");
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                if (getDatoEdicion().getIDSUCURSAL() == null) {
                    setMensaje(sucursalService.addSucursal(getDatoEdicion()));
                } else {
                    setMensaje(sucursalService.editSucursal(getDatoEdicion()));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(false);
                setMensaje(sucursalService.deleteSucursal(getDatoEdicion()));
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new SucursalDao()).anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            }
        } catch (Exception ex) {
            Logger.getLogger(ReglasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelectNumEmisor(SelectEvent event) throws IOException {
        setBotonAlmacenEditarDis(false);
        setBotonAlmacenEliminarDis(false);
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void onRowUnselectNumEmisor(UnselectEvent event) throws IOException {
        setBotonAlmacenEditarDis(true);
        setBotonAlmacenEliminarDis(true);
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void findDetalle() throws Exception {

        listMultitabla = multitablaService.getRecordTipoAlmacen(getDatoEdicion().getIDEMPRESA());
        if (getDatoEdicion().getIDSUCURSAL() != null) {
            listAlmacen = almacenService.getRecordAlmacenEmpresa(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            fillAlmacen = listAlmacen;
        }
    }

    public void ActionNuevoAlmacen() {
        newAlmacen = new Almacen();
        newAlmacen.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
        newAlmacen.setSINCRONIZA("0");
        if (getDatoEdicion().getIDSUCURSAL() != null) {
            newAlmacen.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
        }
        RequestContext.getCurrentInstance().update("datos:dlgnew_almacen");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_almacen').show()");
    }

    public void getActionEditarAlmacenEmpresa() {
        setNewAlmacen(selectAlmacen);
        RequestContext.getCurrentInstance().update("datos:dlgnew_almacen");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_almacen').show()");
    }

    public void InhabilitarAlmacenEmpresa() {
        try {
            selectAlmacen.setESTADO(0);
            setMensaje(almacenService.deleteAlmacen(selectAlmacen));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addAlmacen() throws Exception {
        if (esDetValida()) {
            if (newAlmacen.getIDALMACEN() == null) {
                newAlmacen.setESTADO(1);
                listAlmacen.add(newAlmacen);
                setMensaje(almacenService.addAlmacen(newAlmacen));
            } else {
                setMensaje(almacenService.editAlmacen(newAlmacen));
            }
            RequestContext.getCurrentInstance().update("datos:tbl");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_almacen').hide()");
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isBotonAlmacenEditarDis() {
        return botonAlmacenEditarDis;
    }

    public void setBotonAlmacenEditarDis(boolean botonAlmacenEditarDis) {
        this.botonAlmacenEditarDis = botonAlmacenEditarDis;
    }

    public boolean isBotonAlmacenEliminarDis() {
        return botonAlmacenEliminarDis;
    }

    public void setBotonAlmacenEliminarDis(boolean botonAlmacenEliminarDis) {
        this.botonAlmacenEliminarDis = botonAlmacenEliminarDis;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    public Almacen getSelectAlmacen() {
        return selectAlmacen;
    }

    public void setSelectAlmacen(Almacen selectAlmacen) {
        this.selectAlmacen = selectAlmacen;
    }

    public Almacen getNewAlmacen() {
        return newAlmacen;
    }

    public void setNewAlmacen(Almacen newAlmacen) {
        this.newAlmacen = newAlmacen;
    }

    public List<Almacen> getFillAlmacen() {
        return fillAlmacen;
    }

    public void setFillAlmacen(List<Almacen> fillAlmacen) {
        this.fillAlmacen = fillAlmacen;
    }

}
