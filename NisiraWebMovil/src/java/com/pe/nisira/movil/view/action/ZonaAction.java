/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.dao.TipoZonaDao;
import com.nisira.core.dao.UnidadMedidaDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.entity.TipoZona;
import com.nisira.core.entity.UnidadMedida;
import com.nisira.core.entity.Zona;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DZonaAccesorioDao;
import com.nisira.core.dao.DZonaAlmacenDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.ProcesosDao;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DZonaAlmacen;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.TablaAlmacen;
import com.nisira.core.entity.Zona;
import com.pe.nisira.movil.view.bean.TablaAccesorio;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "zonaAction")
@SessionScoped
public class ZonaAction extends AbstactListAction<Zona> implements Serializable {

    private String mensaje;
    private ZonaDao daoZona;
    private boolean botonEditar;
    private boolean botonEliminar;
    /**
     * ******************************SUCURSAL*************************************
     */
    private TipoZonaDao daoTipoZona;
    private List<TipoZona> listTipoZona;
    private int IDTIPOZONA;
    /**
     * ******************************TIPOZONA*************************************
     */
    private SucursalDao daoSucursal;
    private List<Sucursal> listSucursals;
    private int IDSUCURSAL;
    /**
     * ******************************UNIDAD
     * MEDIDA*************************************
     */
    private UnidadMedidaDao daoUnidadMedida;
    private List<UnidadMedida> listUnidadMedida;
    private int IDUNIDADMEDIDA;
    /**
     * *********************************ALMACEN*****************************************
     */
    private List<Almacen> listalmacen;
    private List<Almacen> Templistalmacen;
    private AlmacenDao daoAlmacen;
    private DAlmacen_ColumnasDao daoDAlmacen_Columnas;
    private List<TablaAlmacen> tablaAlmacen;
    private TablaAlmacen obj;
    private int totalcuadros;
    private int totalcapacidad;
    /**
     * *********************************DZONAALMACEN*****************************************
     */
    private DZonaAlmacenDao daoDZonaAlmacen;
    private List<DZonaAlmacen> listDZonaAlmacen;
    /**
     * *********************************DZONAACCESORIO*****************************************
     */
    private List<TablaAccesorio> tablaAccesorio;
    private List<DZonaAccesorio> TempDZonaAccesorio;
    private TablaAccesorio objT;
    private List<DZonaAccesorio> listDZonaAccesorio;
    private DZonaAccesorio dzonaAccesorio;
    private DZonaAccesorioDao daoDZonaAccesorio;
    /**
     * ********************************CONTROLES***************************************
     */
    private boolean estadoAlmacen;
    private boolean estadoAccesorio;
    /**
     * ********************************MULTITABLA***************************************
     */
    private List<Multitabla> listMultitabla;
    public List<Procesos> lstproceso;
    public UsuarioBean user;

    public ZonaAction() {
        mensaje = "";
        daoZona = new ZonaDao();
        botonEditar = false;
        botonEliminar = false;
        daoTipoZona = new TipoZonaDao();
        listTipoZona = new ArrayList<TipoZona>();
        daoSucursal = new SucursalDao();
        listSucursals = new ArrayList<Sucursal>();
        daoUnidadMedida = new UnidadMedidaDao();
        listUnidadMedida = new ArrayList<UnidadMedida>();
        listalmacen = new ArrayList<Almacen>();
        Templistalmacen = new ArrayList<Almacen>();
        daoAlmacen = new AlmacenDao();
        daoDAlmacen_Columnas = new DAlmacen_ColumnasDao();
        tablaAlmacen = new ArrayList<TablaAlmacen>();
        obj = new TablaAlmacen();
        daoDZonaAlmacen = new DZonaAlmacenDao();
        listDZonaAlmacen = new ArrayList<DZonaAlmacen>();
        tablaAccesorio = new ArrayList<TablaAccesorio>();
        TempDZonaAccesorio = new ArrayList<DZonaAccesorio>();
        objT = new TablaAccesorio();
        listDZonaAccesorio = new ArrayList<DZonaAccesorio>();
        dzonaAccesorio = new DZonaAccesorio();
        daoDZonaAccesorio = new DZonaAccesorioDao();
        estadoAlmacen = false;
        estadoAccesorio = false;
        listMultitabla = new ArrayList<Multitabla>();
        lstproceso = new ArrayList<Procesos>();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Zona");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(daoZona.findAll(user.getIDEMPRESA(), Constantes.IDSUCURSALGENERAL));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(ZonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        daoZona = new ZonaDao();
        botonEditar = false;
        botonEliminar = false;
        daoTipoZona = new TipoZonaDao();
        listTipoZona = new ArrayList<TipoZona>();
        daoSucursal = new SucursalDao();
        listSucursals = new ArrayList<Sucursal>();
        daoUnidadMedida = new UnidadMedidaDao();
        listUnidadMedida = new ArrayList<UnidadMedida>();
        listalmacen = new ArrayList<Almacen>();
        Templistalmacen = new ArrayList<Almacen>();
        daoAlmacen = new AlmacenDao();
        daoDAlmacen_Columnas = new DAlmacen_ColumnasDao();
        tablaAlmacen = new ArrayList<TablaAlmacen>();
        obj = new TablaAlmacen();
        daoDZonaAlmacen = new DZonaAlmacenDao();
        listDZonaAlmacen = new ArrayList<DZonaAlmacen>();
        tablaAccesorio = new ArrayList<TablaAccesorio>();
        TempDZonaAccesorio = new ArrayList<DZonaAccesorio>();
        objT = new TablaAccesorio();
        listDZonaAccesorio = new ArrayList<DZonaAccesorio>();
        dzonaAccesorio = new DZonaAccesorio();
        daoDZonaAccesorio = new DZonaAccesorioDao();
        estadoAlmacen = false;
        estadoAccesorio = false;
        listMultitabla = new ArrayList<Multitabla>();
        lstproceso = new ArrayList<Procesos>();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Zona");
        return "";
    }

    public void findDetalle() {
        estadoAccesorio = true;
        estadoAlmacen = true;
        totalcuadros = 0;
        totalcapacidad = 0;
        getIdTipo();
        getRecordUnidadMedida();
        getRecordTipoZona();
        getRecordSucursal();
        getProcesos();
        if (getDatoEdicion().getIDZONA() != 0) {
            getAlmacen();
            getDZonaAlmacen();
            getDZonaAccesorio();
            activarGrilla();
        }
    }

    public void getRecordUnidadMedida() {
        try {
            listUnidadMedida = daoUnidadMedida.findAllActivo(getDatoEdicion().getIDEMPRESA());
            RequestContext.getCurrentInstance().update("datos");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getIdTipo() {
        try {
            setListMultitabla((new MultitablaDao()).findTiporAccesorio(getDatoEdicion().getIDEMPRESA()));
            Templistalmacen = daoAlmacen.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            RequestContext.getCurrentInstance().update("datos:cbomultitabla");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getRecordTipoZona() {
        try {
            listTipoZona = daoTipoZona.findAllActivo(getDatoEdicion().getIDEMPRESA());
            RequestContext.getCurrentInstance().update("datos");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getRecordSucursal() {
        try {
            listSucursals = daoSucursal.findAllActivo(getDatoEdicion().getIDEMPRESA());
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getAlmacen() {
        try {
            listalmacen = daoAlmacen.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
            Templistalmacen = daoAlmacen.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL());
//            Constantes.estadoDocumento=0;
//            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:cboalmacen");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getProcesos() {
        try {
            setLstproceso((new ProcesosDao()).findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos:cboalmacen");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getDZonaAlmacen() {
        try {
            listDZonaAlmacen = daoDZonaAlmacen.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA());
            transferenciaTablaAlmacen();
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(this.getMensaje());
            return;
        }
    }

    public void getDZonaAccesorio() {
        try {
            listDZonaAccesorio = daoDZonaAccesorio.findAll(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA());
            transferenciaTablaAlmacen();
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(this.getMensaje());
            return;
        }
    }

    public void activarGrilla() {
        switch (getDatoEdicion().getIDTIPOZONA()) {
            case 1:
                estadoAccesorio = true;
                estadoAlmacen = false;
                listDZonaAccesorio.clear();
//                tablaAccesorio.clear();
                ;
                break;
            case 2:
                estadoAccesorio = false;
                estadoAlmacen = true;
                tablaAlmacen.clear();
                totalcuadros = 0;
                totalcapacidad = 0;
                ;
                break;
        }

    }

    public void transferenciaTablaAlmacen() {
        try {
            if (listDZonaAlmacen.size() > 0) {
                TablaAlmacen al;
                tablaAlmacen.clear();
                for (DZonaAlmacen dzonaalmacen : listDZonaAlmacen) {
                    al = new TablaAlmacen();
                    al.setId(tablaAlmacen.size() + 1);
                    al.setIdempresa(dzonaalmacen.getIDEMPRESA());
                    al.setIdsucursal(dzonaalmacen.getIDSUCURSAL());
                    al.setIdalmacen("" + dzonaalmacen.getIDALMACEN());
                    al.setAlmacen(dzonaalmacen.getALMACEN());
                    al.setListaRacks(daoDAlmacen_Columnas.findAllRacksPisosFilasColumnasTotal(dzonaalmacen.getIDEMPRESA(), dzonaalmacen.getIDSUCURSAL(), dzonaalmacen.getIDALMACEN(), "", "", ""));
                    al.setCapacidad(obtenerCapacidad(al.getListaRacks()));
                    al.setCapvista(obtenerCapacidadVistaArriba(al.getListaRacks()));
                    al.setEstado(1);
                    tablaAlmacen.add(al);
                }
                totalcuadros = obtenerCapacidadVistaArribaTotal();
                totalcapacidad = obtenerCapacidadTotal();
            }
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
        }
    }

    public int obtenerCapacidad(List<DAlmacen_Racks> lista) {
        int capacidad = 0;
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                capacidad += lista.get(i).getCAPACIDAD();
            }
        } else {
            this.setMensaje("Falta Asignar Estructura");
            WebUtil.error(mensaje);
        }
        return capacidad;
    }

    public int obtenerCapacidadVistaArriba(List<DAlmacen_Racks> lista) {
        int capacidad = 0;
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                capacidad += lista.get(i).getFILAS() * lista.get(i).getCOLUMNAS();
            }
        } else {
            this.setMensaje("Falta Asignar Estructura");
            WebUtil.error(mensaje);
        }
        return capacidad;
    }

    public int obtenerCapacidadVistaArribaTotal() {
        int capacidad = 0;
        for (int i = 0; i < tablaAlmacen.size(); i++) {
            capacidad += tablaAlmacen.get(i).getCapvista();
        }
        return capacidad;
    }

    public int obtenerCapacidadTotal() {
        int capacidad = 0;
        for (int i = 0; i < tablaAlmacen.size(); i++) {
            capacidad += tablaAlmacen.get(i).getCapacidad();
        }
        return capacidad;
    }

    public void eventoSucursal() {
        getAlmacen();
        clearCalculos();
    }

    public void eventTipoZona() {
        activarGrilla();
        clearCalculos();
    }

    public void regularLargoAncho(String comando) {
        try {
            if (getDatoEdicion().getAREAUNIDADDIAGRAMA() > 0) {
                if (comando.equalsIgnoreCase("L")) {
                    if (getDatoEdicion().getAREAUNIDADDIAGRAMA() >= getDatoEdicion().getLARGOUNIDADDIAGRAMA()) {
                        getDatoEdicion().setANCHOUNIDADDIAGRAMA((int) (getDatoEdicion().getAREAUNIDADDIAGRAMA() / getDatoEdicion().getLARGOUNIDADDIAGRAMA()));
                    } else {
                        this.setMensaje("Largo debe ser menor que Area Diagrama");
                        WebUtil.MensajeError(mensaje);
                    }
                } else if (comando.equalsIgnoreCase("A")) {
                    if (getDatoEdicion().getAREAUNIDADDIAGRAMA() >= getDatoEdicion().getANCHOUNIDADDIAGRAMA()) {
                        getDatoEdicion().setLARGOUNIDADDIAGRAMA((int) (getDatoEdicion().getAREAUNIDADDIAGRAMA() / getDatoEdicion().getANCHOUNIDADDIAGRAMA()));
                    } else {
                        this.setMensaje("Largo debe ser menor que Area Diagrama");
                        WebUtil.MensajeError(mensaje);
                    }
                }
                RequestContext.getCurrentInstance().update("FormularioGrabarZona:largou");
                RequestContext.getCurrentInstance().update("FormularioGrabarZona:anchou");
            } else {
                this.setMensaje("Area Unidad de Diagrama no calculable");
                WebUtil.MensajeError(mensaje);
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void clearCalculos() {
        getDatoEdicion().setAREA(0.00d);
        getDatoEdicion().setAREAUNIDADDIAGRAMA(0);
        getDatoEdicion().setANCHOUNIDADDIAGRAMA(0);
        getDatoEdicion().setLARGOUNIDADDIAGRAMA(0);
        RequestContext.getCurrentInstance().update("datos:area");
        RequestContext.getCurrentInstance().update("datos:areaunidaddiagrama");
        RequestContext.getCurrentInstance().update("datos:largou");
        RequestContext.getCurrentInstance().update("datos:anchou");
        RequestContext.getCurrentInstance().update("datos:agregarAlmacen");
        RequestContext.getCurrentInstance().update("datos:tablaAlmacen");
        RequestContext.getCurrentInstance().update("datos:agregarAccesorio");
        RequestContext.getCurrentInstance().update("datos:listDZonaAccesorio");
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Zona());        
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setIDSUCURSAL(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        eventoSucursal();
        getDatoEdicion().setESTADO(true);
        tablaAlmacen = new ArrayList<TablaAlmacen>();
        listDZonaAccesorio = new ArrayList<DZonaAccesorio>();
    }
    public void changeColor(){
        RequestContext.getCurrentInstance().update("datos:colorPicker");
        RequestContext.getCurrentInstance().update("datos:color");
    }
    public void agregarTablaAlmacen() {
        try {
            if (listalmacen.size() > tablaAlmacen.size()) {
                obj = new TablaAlmacen();
                obj.setIdempresa(getDatoEdicion().getIDEMPRESA());
                obj.setIdsucursal(getDatoEdicion().getIDSUCURSAL());
                obj.setId(tablaAlmacen.size() + 1);
                tablaAlmacen.add(obj);
//                reponerAlmacen();
                RequestContext.getCurrentInstance().update("datos:tablaAlmacen");
            } else {
                this.setMensaje("No hay almacenes disponibles");
                WebUtil.MensajeError(this.getMensaje());
            }
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(this.getMensaje());
            return;
        }
    }

    public void calcular() {
        try {
            if (getDatoEdicion().getIDUNIDADMEDIDA() == 0) {
                this.setMensaje("Seleccionar Unidad Medida");
                WebUtil.MensajeError(mensaje);
            } else if (getDatoEdicion().getAREA() <= 0.00d) {
                this.setMensaje("Área no válida");
                WebUtil.MensajeError(mensaje);
            } else {
                getDatoEdicion().setAREAUNIDADDIAGRAMA(Integer.parseInt(daoZona.calculoAreaDiagrama(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDUNIDADMEDIDA(), getDatoEdicion().getAREA())));
                RequestContext.getCurrentInstance().update("FormularioGrabarZona:areaunidaddiagrama");
                if (getDatoEdicion().getAREAUNIDADDIAGRAMA() > 0) {
                    if (((int) (Math.sqrt(getDatoEdicion().getAREAUNIDADDIAGRAMA()))) % 2 == 0) {
                        getDatoEdicion().setLARGOUNIDADDIAGRAMA((int) Math.sqrt(getDatoEdicion().getAREAUNIDADDIAGRAMA()));
                        getDatoEdicion().setANCHOUNIDADDIAGRAMA((int) Math.sqrt(getDatoEdicion().getAREAUNIDADDIAGRAMA()));
                    } else {
                        if (getDatoEdicion().getAREAUNIDADDIAGRAMA() == 1) {
                            getDatoEdicion().setANCHOUNIDADDIAGRAMA((int) getDatoEdicion().getAREAUNIDADDIAGRAMA());
                        } else {
                            getDatoEdicion().setANCHOUNIDADDIAGRAMA((int) Math.sqrt(getDatoEdicion().getAREAUNIDADDIAGRAMA()));
                            getDatoEdicion().setLARGOUNIDADDIAGRAMA((int) (getDatoEdicion().getAREAUNIDADDIAGRAMA() / getDatoEdicion().getANCHOUNIDADDIAGRAMA()));
                        }
                    }
                    RequestContext.getCurrentInstance().update("FormularioGrabarZona");
                    RequestContext.getCurrentInstance().update("FormularioGrabarZona:largou");
                    RequestContext.getCurrentInstance().update("FormularioGrabarZona:anchou");
                } else {
                    this.setMensaje("Area Unidad de Diagrama no calculable");
                    WebUtil.MensajeError(mensaje);
                }
            }
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void agregarTablaAccesorio() {
        try {
            dzonaAccesorio = new DZonaAccesorio();
            dzonaAccesorio.setIDEMPRESA(getDatoEdicion().getIDEMPRESA());
            dzonaAccesorio.setIDSUCURSAL(getDatoEdicion().getIDSUCURSAL());
            dzonaAccesorio.setIDZONA(getDatoEdicion().getIDZONA());
            dzonaAccesorio.setIDACCESORIO(listDZonaAccesorio.size() + 1);
            dzonaAccesorio.setESTADO(true);
            listDZonaAccesorio.add(dzonaAccesorio);
            RequestContext.getCurrentInstance().update("datos:listDZonaAccesorio");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(this.getMensaje());
            ex.printStackTrace();
        }
    }

    public void actualizarDescripcionCapacidadAlmacen() {
        try {
            tablaAlmacen.get(tablaAlmacen.size() - 1).setAlmacen(buscarAlmacen(tablaAlmacen.get(tablaAlmacen.size() - 1).getIdalmacen()).getDESCRIPCION());
            tablaAlmacen.get(tablaAlmacen.size() - 1).setListaRacks(daoDAlmacen_Columnas.findAllRacksPisosFilasColumnasTotal(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), tablaAlmacen.get(tablaAlmacen.size() - 1).getIdalmacen(), "", "", ""));
            tablaAlmacen.get(tablaAlmacen.size() - 1).setCapacidad(obtenerCapacidad(tablaAlmacen.get(tablaAlmacen.size() - 1).getListaRacks()));
            tablaAlmacen.get(tablaAlmacen.size() - 1).setCapvista(obtenerCapacidadVistaArriba(tablaAlmacen.get(tablaAlmacen.size() - 1).getListaRacks()));
            this.totalcuadros = obtenerCapacidadVistaArribaTotal();
            this.totalcapacidad = obtenerCapacidadTotal();
            getDatoEdicion().setAREA(totalcuadros);
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tablaAlmacen");
            RequestContext.getCurrentInstance().update("datos:area");
        } catch (Exception ex) {
            this.setMensaje(ex.getMessage());
            WebUtil.error(mensaje);
        }
    }

    public Almacen buscarAlmacen(String idalmacen) {
        Almacen obj = null;
        for (int i = 0; i < Templistalmacen.size(); i++) {
            if (Templistalmacen.get(i).getIDALMACEN().equalsIgnoreCase(idalmacen)) {
                obj = Templistalmacen.get(i);
                break;
            }
        }
        return obj;
    }

    public void onRowCancelAccesorio(RowEditEvent event) {
        listDZonaAccesorio.remove(((DZonaAccesorio) event.getObject()));
        RequestContext.getCurrentInstance().update("tabla:tablaAccesorio");
    }

    public void onRowEditAlmacen(RowEditEvent event) {
//        ((TablaAlmacen) event.getObject());
        if (((TablaAlmacen) event.getObject()).getIdalmacen() != null) {
            reponerAlmacen();
//            actualizarDescripcionAlmacen(); 
        } else {
            this.mensaje = "Seleccionar almacen";
            WebUtil.MensajeError(mensaje);
        }
        RequestContext.getCurrentInstance().update("tabla:tablaAlmacen");
    }

    public void reponerAlmacen() {
        Almacen obj = null;
        listalmacen.clear();
        listalmacen.addAll(Templistalmacen);
        removerAlmacen();
    }

    public void removerAlmacen() {
        Almacen obj = null;
        for (int j = 0; j < tablaAlmacen.size(); j++) {
            for (int i = 0; i < listalmacen.size(); i++) {
                if (listalmacen.get(i).getIDALMACEN().equalsIgnoreCase(tablaAlmacen.get(j).getIdalmacen())) {
                    obj = listalmacen.get(i);
                    break;
                }
            }
            if (obj != null) {
                listalmacen.remove(obj);
            }
        }
    }

    public void onRowCancelAlmacen(RowEditEvent event) {
        if (((TablaAlmacen) event.getObject()).getIdalmacen() != null) {
            tablaAlmacen.remove(((TablaAlmacen) event.getObject()));
            totalcuadros = obtenerCapacidadVistaArribaTotal();
            totalcapacidad = obtenerCapacidadTotal();
            getDatoEdicion().setAREA(totalcuadros);
            getDatoEdicion().setAREAUNIDADDIAGRAMA(0);
            getDatoEdicion().setANCHOUNIDADDIAGRAMA(0);
            getDatoEdicion().setLARGOUNIDADDIAGRAMA(0);
        }
        RequestContext.getCurrentInstance().update("datos:totalcuadros");
        RequestContext.getCurrentInstance().update("datos:totalcapacidad");
        RequestContext.getCurrentInstance().update("datos:area");
        RequestContext.getCurrentInstance().update("datos:areaunidaddiagrama");
        RequestContext.getCurrentInstance().update("datos:largou");
        RequestContext.getCurrentInstance().update("datos:anchou");
    }

    public void onCellEditAlmacen(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onCellEditAccesorio(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getDESCRIPCION().equals("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.setMensaje("Ingrese DESCRIPCION");
            } else {                
                if (getDatoEdicion().getIDZONA() == 0) {
                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
                    daoZona.addZonaDetalle(getDatoEdicion(), tablaAlmacen, listDZonaAccesorio);
                    WebUtil.info("Zona " + getDatoEdicion().getDESCRIPCION() + " registrado con éxito.");

                } else {                    
                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
                    daoZona.editZonaDetalle(getDatoEdicion(), tablaAlmacen, listDZonaAccesorio);
                    WebUtil.info("Zona " + getDatoEdicion().getDESCRIPCION() + " actualizado con éxito.");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ZonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                daoZona.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                daoZona.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 2);
            }
        } catch (Exception ex) {
            Logger.getLogger(ZonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isBotonEditar() {
        return botonEditar;
    }

    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public List<TipoZona> getListTipoZona() {
        return listTipoZona;
    }

    public void setListTipoZona(List<TipoZona> listTipoZona) {
        this.listTipoZona = listTipoZona;
    }

    public int getIDTIPOZONA() {
        return IDTIPOZONA;
    }

    public void setIDTIPOZONA(int IDTIPOZONA) {
        this.IDTIPOZONA = IDTIPOZONA;
    }

    public List<Sucursal> getListSucursals() {
        return listSucursals;
    }

    public void setListSucursals(List<Sucursal> listSucursals) {
        this.listSucursals = listSucursals;
    }

    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public List<UnidadMedida> getListUnidadMedida() {
        return listUnidadMedida;
    }

    public void setListUnidadMedida(List<UnidadMedida> listUnidadMedida) {
        this.listUnidadMedida = listUnidadMedida;
    }

    public int getIDUNIDADMEDIDA() {
        return IDUNIDADMEDIDA;
    }

    public void setIDUNIDADMEDIDA(int IDUNIDADMEDIDA) {
        this.IDUNIDADMEDIDA = IDUNIDADMEDIDA;
    }

    public List<Almacen> getListalmacen() {
        return listalmacen;
    }

    public void setListalmacen(List<Almacen> listalmacen) {
        this.listalmacen = listalmacen;
    }

    public List<Almacen> getTemplistalmacen() {
        return Templistalmacen;
    }

    public void setTemplistalmacen(List<Almacen> Templistalmacen) {
        this.Templistalmacen = Templistalmacen;
    }

    public List<TablaAlmacen> getTablaAlmacen() {
        return tablaAlmacen;
    }

    public void setTablaAlmacen(List<TablaAlmacen> tablaAlmacen) {
        this.tablaAlmacen = tablaAlmacen;
    }

    public TablaAlmacen getObj() {
        return obj;
    }

    public void setObj(TablaAlmacen obj) {
        this.obj = obj;
    }

    public int getTotalcuadros() {
        return totalcuadros;
    }

    public void setTotalcuadros(int totalcuadros) {
        this.totalcuadros = totalcuadros;
    }

    public int getTotalcapacidad() {
        return totalcapacidad;
    }

    public void setTotalcapacidad(int totalcapacidad) {
        this.totalcapacidad = totalcapacidad;
    }

    public List<DZonaAlmacen> getListDZonaAlmacen() {
        return listDZonaAlmacen;
    }

    public void setListDZonaAlmacen(List<DZonaAlmacen> listDZonaAlmacen) {
        this.listDZonaAlmacen = listDZonaAlmacen;
    }

    public List<TablaAccesorio> getTablaAccesorio() {
        return tablaAccesorio;
    }

    public void setTablaAccesorio(List<TablaAccesorio> tablaAccesorio) {
        this.tablaAccesorio = tablaAccesorio;
    }

    public List<DZonaAccesorio> getTempDZonaAccesorio() {
        return TempDZonaAccesorio;
    }

    public void setTempDZonaAccesorio(List<DZonaAccesorio> TempDZonaAccesorio) {
        this.TempDZonaAccesorio = TempDZonaAccesorio;
    }

    public TablaAccesorio getObjT() {
        return objT;
    }

    public void setObjT(TablaAccesorio objT) {
        this.objT = objT;
    }

    public List<DZonaAccesorio> getListDZonaAccesorio() {
        return listDZonaAccesorio;
    }

    public void setListDZonaAccesorio(List<DZonaAccesorio> listDZonaAccesorio) {
        this.listDZonaAccesorio = listDZonaAccesorio;
    }

    public DZonaAccesorio getDzonaAccesorio() {
        return dzonaAccesorio;
    }

    public void setDzonaAccesorio(DZonaAccesorio dzonaAccesorio) {
        this.dzonaAccesorio = dzonaAccesorio;
    }

    public boolean isEstadoAlmacen() {
        return estadoAlmacen;
    }

    public void setEstadoAlmacen(boolean estadoAlmacen) {
        this.estadoAlmacen = estadoAlmacen;
    }

    public boolean isEstadoAccesorio() {
        return estadoAccesorio;
    }

    public void setEstadoAccesorio(boolean estadoAccesorio) {
        this.estadoAccesorio = estadoAccesorio;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    public List<Procesos> getLstproceso() {
        return lstproceso;
    }

    public void setLstproceso(List<Procesos> lstproceso) {
        this.lstproceso = lstproceso;
    }

}
