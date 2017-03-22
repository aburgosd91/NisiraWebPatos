/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Filas;
import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Rack;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.DAlmacen_ColumnasService;
import com.nisira.core.service.DAlmacen_FilasService;
import com.nisira.core.service.DAlmacen_PisosService;
import com.nisira.core.service.DAlmacen_RacksService;
import com.nisira.core.service.DDistribucionUbicacionService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.Car;
import com.pe.nisira.movil.view.bean.TablaDistribucion;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.swing.text.TabableView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public class AlmacenAction {
    /* 
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */

    /**
     * ***********************************TABLA GENERACIÓN
     * DISTRIBUCIÓN*************************************
     */
    private TablaDistribucion generacionDistribucion;
    private List<TablaDistribucion> listGeneracionDistribucion;
    private boolean visibleHomogeneo;
    private boolean visibleVariado;
    private boolean parametroDistribucion;
    /*++++CONTROLES+++++*/
    private boolean botonBuscar;
    private boolean botonPeriodo;
    private boolean botonGenerar;
    /**
     * *******************************************MULTITABLA***********************************************
     */
    private List<Multitabla> listTipoRacks;
    /*+++++++++++++++++++++++++++++++++++++++DISTRIBUCIÓN UBICACIÓN++++++++++++++++++++++++++++++++++++++++*/
    private DDistribucionUbicacionService dDistribucionUbicacionService;
    private List<DDistribucionUbicacion> listDDistribucionUbicacion;
    private DDistribucionUbicacion newDDistribucionUbicacion;
    private HashMap hashmap_DDistribucionUbicacion;
    private String IDDISTRIBUCION;
    private Date fechaInicio;
    /*+++++++++++++++++++++++++++++++++++++++ALMACEN++++++++++++++++++++++++++++++++++++++++*/
    private AlmacenService almacenService;
    private List<Almacen> listAlmacen;
    private List<Almacen> filterAlmacen;
    private Almacen selectAlmacen;
    private ServletContext servletContext;
    private String empresa;
    private String mensaje;
    /*+++++++++++++++++++++++++++++++++++++++RACKS++++++++++++++++++++++++++++++++++++++++*/
    private DAlmacen_RacksService dAlmacen_RacksService;
    private List<DAlmacen_Racks> listDAlmacen_Racks;
    private List<DAlmacen_Racks> filterDAlmacen_Racks;
    private DAlmacen_Racks selectdAlmacen_Racks;
    /*+++++++++++++++++++++++++++++++++++++++PISOS++++++++++++++++++++++++++++++++++++++++*/
    private DAlmacen_PisosService dAlmacen_PisosService;
    private List<DAlmacen_Pisos> listDAlmacen_Pisos;
    private List<DAlmacen_Pisos> filterDAlmacen_Pisos;
    private DAlmacen_Pisos selectdAlmacen_Pisos;
    /*+++++++++++++++++++++++++++++++++++++++FILAS++++++++++++++++++++++++++++++++++++++++*/
    private DAlmacen_FilasService dAlmacen_FilasService;
    private List<DAlmacen_Filas> listDAlmacen_Filas;
    private List<DAlmacen_Filas> filterDAlmacen_Filas;
    private DAlmacen_Filas selectdAlmacen_Filas;
    /*+++++++++++++++++++++++++++++++++++++++COLUMNAS++++++++++++++++++++++++++++++++++++++++*/
    private DAlmacen_ColumnasService dAlmacen_ColumnasService;
    private List<DAlmacen_Columnas> listDAlmacen_Columnas;
    private List<DAlmacen_Columnas> filterDAlmacen_Columnas;
    private DAlmacen_Columnas selectdAlmacen_Columnas;
    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

    public AlmacenAction() {
        this.IDDISTRIBUCION = "";
        servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        empresa = ConstantesBD.IDEMPRESA;
        /**
         * **CONTROLES***
         */
        botonBuscar = true;
        botonPeriodo = true;
        botonGenerar = true;
        listTipoRacks = new ArrayList<Multitabla>();
        /*+++++++++++++++++++++++DDISTRIBUCIONSUCURSAL++++++++++++++++++++++++++*/
        dDistribucionUbicacionService = new DDistribucionUbicacionService();
        listDDistribucionUbicacion = new ArrayList<DDistribucionUbicacion>();
        fechaInicio = new Date();
        /*+++++++++++++++++++++++ALMACEN++++++++++++++++++++++++++*/
        almacenService = new AlmacenService();
        listAlmacen = new ArrayList<Almacen>();
        /*+++++++++++++++++++++++RACKS SERVICE++++++++++++++++++++++++++*/
        dAlmacen_RacksService = new DAlmacen_RacksService();
        /*+++++++++++++++++++++++PISOS SERVICE++++++++++++++++++++++++++*/
        dAlmacen_PisosService = new DAlmacen_PisosService();
        /*+++++++++++++++++++++++FILAS SERVICE++++++++++++++++++++++++++*/
        dAlmacen_FilasService = new DAlmacen_FilasService();
        /*+++++++++++++++++++++++COLUMNAS SERVICE++++++++++++++++++++++++++*/
        dAlmacen_ColumnasService = new DAlmacen_ColumnasService();
        /**
         * ********************LISTAS DISTRIBUCION*****************************
         */
        listDAlmacen_Racks = new ArrayList<DAlmacen_Racks>();
        listDAlmacen_Pisos = new ArrayList<DAlmacen_Pisos>();
        listDAlmacen_Filas = new ArrayList<DAlmacen_Filas>();
        listDAlmacen_Columnas = new ArrayList<DAlmacen_Columnas>();
    }

    /**
     * ******************************OPERACIONES
     * ALMACEN+SUCURSAL*****************************************
     */
    public void getTipoRacks() {
        try {
            this.listTipoRacks = (new MultitablaDao()).findTiporRacks(empresa);
            RequestContext.getCurrentInstance().update("FormularioGenerarAlmacenDistribucionUbicacion:frmHomogenea:tiporack");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(mensaje);
            return;
        }
    }

    public void getRecordAlmacenEmpresaActivo() {
        try {
            this.listAlmacen = almacenService.getRecordAlmacenEmpresaActivo(empresa, Constantes.getIDSUCURSALGENERAL());
            RequestContext.getCurrentInstance().update("datosAlmacen:tblAlmacen");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(mensaje);
            return;
        }
    }

    public void onRowSelectAlmacen(SelectEvent event) throws IOException {
//        selectAlmacen=((Almacen) event.getObject());
        Constantes.selectAlmacen = ((Almacen) event.getObject());
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/faces/sistema/wMnt_distribucionAlmacen.xhtml");
    }

    public void onRowSelectRack(SelectEvent event) throws IOException {
        selectdAlmacen_Racks = ((DAlmacen_Racks) event.getObject());
        getRecordDistribucionPiso();
        getRecordDistribucionFilas();
        getRecordDistribucionColumnas();
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect(context.getRequestContextPath() + "/faces/sistema/wMnt_distribucionAlmacen.xhtml");
    }

    public void onRowSelectPiso(SelectEvent event) throws IOException {
        selectdAlmacen_Pisos = ((DAlmacen_Pisos) event.getObject());
        getRecordDistribucionFilas();
        getRecordDistribucionColumnas();
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect(context.getRequestContextPath() + "/faces/sistema/wMnt_distribucionAlmacen.xhtml");
    }

    public void onRowSelectFila(SelectEvent event) throws IOException {
        selectdAlmacen_Filas = ((DAlmacen_Filas) event.getObject());
        getRecordDistribucionColumnas();
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect(context.getRequestContextPath() + "/faces/sistema/wMnt_distribucionAlmacen.xhtml");
    }

    public void onRowSelectColumna(SelectEvent event) throws IOException {
        selectdAlmacen_Columnas = ((DAlmacen_Columnas) event.getObject());
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//        context.redirect(context.getRequestContextPath() + "/faces/sistema/wMnt_distribucionAlmacen.xhtml");
    }

    public void onRowUnselectAlmacen(UnselectEvent event) throws IOException {
        selectAlmacen = ((Almacen) event.getObject());
        getRecordDDistribucionUbicacion();
        RequestContext.getCurrentInstance().update("frmPeriodo");
//        RequestContext.getCurrentInstance().execute("javascript:window.location ="+(String) servletContext.getRealPath("sistema/wregalmacen_principal.xhtml")+";");
    }

    public void getRegresarListaAlmacenSucursal() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/faces/sistema/wList_almacen.xhtml");
    }

    /**
     * **************************OPERACIONES EN
     * DISTRIBUCIONES*********************************************
     */
    public void getConsultarDDistribucionUbicacion() {
        try {
            Constantes.estadoDocumento = 1;
            getRecordDistribucionRack();
            getRecordDistribucionPiso();
            getRecordDistribucionFilas();
            getRecordDistribucionColumnas();
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getActionGenerarDDistribucionUbicacion() {
        try {
            Constantes.estadoDocumento = 2;
            RequestContext.getCurrentInstance().update("FormularioAlmacenDistribucionUbicacion");
            RequestContext.getCurrentInstance().execute("PF('FormularioGenerarAlmacenDistribucionUbicacion').show()");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getActionNuevoDDistribucionUbicacion() {
        try {
            Constantes.estadoDocumento = 2;
//            RequestContext.getCurrentInstance().update("FormularioAlmacenDistribucionUbicacion");
            RequestContext.getCurrentInstance().execute("PF('dlAlmacenDistribucionUbicacion').show()");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void loadDistribicionUbicacion() {
        try {
            if (Constantes.selectAlmacen != null) {
                selectAlmacen = Constantes.selectAlmacen;
                getRecordDDistribucionUbicacion();
                this.newDDistribucionUbicacion = new DDistribucionUbicacion();
                this.newDDistribucionUbicacion.setIDEMPRESA(empresa);
                this.newDDistribucionUbicacion.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                this.newDDistribucionUbicacion.setIDALMACEN(selectAlmacen.getIDALMACEN());
                this.newDDistribucionUbicacion.setESTADO(true);
                /*ESTRUCTURA GENERACION DE DISTRIBUCION*/
                generacionDistribucion = new TablaDistribucion();
                listGeneracionDistribucion = new ArrayList<TablaDistribucion>();
                if (listDDistribucionUbicacion.size() > 0) {
                    botonBuscar = false;
                    botonGenerar = false;
                }
                botonPeriodo = false;
                visibleHomogeneo = false;
                visibleVariado = true;
                parametroDistribucion = true;
                RequestContext.getCurrentInstance().update("principal:datosAlmacen");
            }
        } catch (Exception ex) {

        }
    }

    public void getRecordDDistribucionUbicacion() {
        try {
            setListDDistribucionUbicacion(getdDistribucionUbicacionService().getRecordDDistribucionUbicacionEmpresaActivo(ConstantesBD.IDEMPRESA,
                    selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN()));
            this.IDDISTRIBUCION = "";
//            this.newAlmacen.setIDTIPOALMACEN("0");
//            RequestContext.getCurrentInstance().update("frmPeriodo:cbofechainicio");
        } catch (Exception e) {
        }
    }

    public void NuevoDDistribucionUbicacion() {
        try {
            if (this.fechaInicio == null) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese Fecha Inicio";
            } else {
                Constantes.estadoDocumento = 1;
                newDDistribucionUbicacion.setFECHAINICIO(WebUtil.fechaDMY(fechaInicio, 1));
//                RequestContext.getCurrentInstance().update("FormularioAlmacenDistribucionUbicacion");
//                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//                context.redirect(context.getRequestContextPath() + "/faces/sistema/wregalmacen_principal.xhtml");
                setMensaje(dDistribucionUbicacionService.addDDistribucionUbicacion(newDDistribucionUbicacion));
                RequestContext.getCurrentInstance().update("FormularioAlmacenDistribucionUbicacion");
                getRecordDDistribucionUbicacion();
                this.botonBuscar = false;
                this.botonGenerar = false;
                RequestContext.getCurrentInstance().update("datosAlmacen");
                WebUtil.info(WebUtil.exitoRegistrar("Documento Periódo Distribución", newDDistribucionUbicacion.getFECHAINICIO()));
                RequestContext.getCurrentInstance().execute("PF('dlAlmacenDistribucionUbicacion').hide()");
                newDDistribucionUbicacion = new DDistribucionUbicacion();
                newDDistribucionUbicacion.setIDEMPRESA(empresa);
                newDDistribucionUbicacion.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                newDDistribucionUbicacion.setIDALMACEN(selectAlmacen.getIDALMACEN());
                newDDistribucionUbicacion.setFECHAINICIO("");
                newDDistribucionUbicacion.setESTADO(true);
                getConsultarDDistribucionUbicacion();
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void oneRowDDistribucionUbicacion() {
        for (int i = 1; i <= generacionDistribucion.getNumRacks(); i++) {
            DAlmacen_Racks racks = new DAlmacen_Racks();
            racks.setIDEMPRESA(empresa);
            racks.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
            racks.setIDALMACEN(selectAlmacen.getIDALMACEN());
            racks.setIDDISTRIBUCION(IDDISTRIBUCION);
            racks.setIDRACK(WebUtil.idGeneradoTres(i));
            racks.setIDTIPORACK(generacionDistribucion.getIdtiporacks());
            racks.setIDUBICACION(WebUtil.ubicacionGeneracionRacks(WebUtil.idGeneradoTres(i), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
            racks.setESTADO(1);
            listDAlmacen_Racks.add(racks);
            for (int j = 1; j <= generacionDistribucion.getNumPisos(); j++) {
                DAlmacen_Pisos pisos = new DAlmacen_Pisos();
                pisos.setIDEMPRESA(empresa);
                pisos.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                pisos.setIDALMACEN(selectAlmacen.getIDALMACEN());
                pisos.setIDDISTRIBUCION(IDDISTRIBUCION);
                pisos.setIDRACK(WebUtil.idGeneradoTres(i));
                pisos.setIDPISO(WebUtil.idGeneradoTres(j));
                pisos.setESTADO(1);
                pisos.setIDUBICACION(WebUtil.ubicacionGeneracionPisos(WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(i), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                listDAlmacen_Pisos.add(pisos);
                for (int k = 1; k <= generacionDistribucion.getNumFilas(); k++) {
                    DAlmacen_Filas filas = new DAlmacen_Filas();
                    filas.setIDEMPRESA(empresa);
                    filas.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                    filas.setIDALMACEN(selectAlmacen.getIDALMACEN());
                    filas.setIDDISTRIBUCION(IDDISTRIBUCION);
                    filas.setIDRACK(WebUtil.idGeneradoTres(i));
                    filas.setIDPISO(WebUtil.idGeneradoTres(j));
                    filas.setIDFILA(WebUtil.idGeneradoTres(k));
                    filas.setESTADO(1);
                    filas.setIDUBICACION(WebUtil.ubicacionGeneracionFilas(WebUtil.idGeneradoTres(k), WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(i), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                    listDAlmacen_Filas.add(filas);
                    for (int z = 1; z <= generacionDistribucion.getNumColumnas(); z++) {
                        DAlmacen_Columnas columnas = new DAlmacen_Columnas();
                        columnas.setIDEMPRESA(empresa);
                        columnas.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                        columnas.setIDALMACEN(selectAlmacen.getIDALMACEN());
                        columnas.setIDDISTRIBUCION(IDDISTRIBUCION);
                        columnas.setIDRACK(WebUtil.idGeneradoTres(i));
                        columnas.setIDPISO(WebUtil.idGeneradoTres(j));
                        columnas.setIDFILA(WebUtil.idGeneradoTres(k));
                        columnas.setIDCOLUMNA(WebUtil.idGeneradoTres(z));
                        columnas.setESTADO(1);
                        columnas.setIDUBICACION(WebUtil.ubicacionGeneracionColumnas(WebUtil.idGeneradoTres(z), WebUtil.idGeneradoTres(k), WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(i), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                        listDAlmacen_Columnas.add(columnas);
                    }
                }
            }
        }
        generacionDistribucion = new TablaDistribucion();
    }

    public void multiRowDDistribucionUbicacion() {
        int bandera = 0;
        if (listGeneracionDistribucion.size() > 0) {
            TablaDistribucion e = new TablaDistribucion();
            for (int g = 0; g < listGeneracionDistribucion.size(); g++) {
                e = listGeneracionDistribucion.get(g);
                if(e.getNumRacks()>0){
                    if(e.getNumPisos()>0){
                        if(e.getNumFilas()>0){
                            if(e.getNumColumnas()==0){
                                this.mensaje="Numero de Columnas Menor que 1";
                                return;
                            }
                        }else{
                            this.mensaje="Numero de Filas Menor que 1";
                            return;
                        }
                    }else{
                        this.mensaje="Numero de Pisos Menor que 1";
                        return;
                    }
                }else{
                    this.mensaje="Numero de Racks Menor que 1";
                    return;
                }
                for (int i = 1; i <= e.getNumRacks(); i++) {
                    bandera++;
                    DAlmacen_Racks racks = new DAlmacen_Racks();
                    racks.setIDEMPRESA(empresa);
                    racks.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                    racks.setIDALMACEN(selectAlmacen.getIDALMACEN());
                    racks.setIDDISTRIBUCION(IDDISTRIBUCION);
                    racks.setIDTIPORACK(e.getIdtiporacks());
                    racks.setIDRACK(WebUtil.idGeneradoTres(bandera));
                    racks.setIDUBICACION(WebUtil.ubicacionGeneracionRacks(WebUtil.idGeneradoTres(bandera), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                    racks.setESTADO(1);
                    listDAlmacen_Racks.add(racks);
                    for (int j = 1; j <= e.getNumPisos(); j++) {
                        DAlmacen_Pisos pisos = new DAlmacen_Pisos();
                        pisos.setIDEMPRESA(empresa);
                        pisos.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                        pisos.setIDALMACEN(selectAlmacen.getIDALMACEN());
                        pisos.setIDDISTRIBUCION(IDDISTRIBUCION);
                        pisos.setIDRACK(WebUtil.idGeneradoTres(bandera));
                        pisos.setIDPISO(WebUtil.idGeneradoTres(j));
                        pisos.setESTADO(1);
                        pisos.setIDUBICACION(WebUtil.ubicacionGeneracionPisos(WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(bandera), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                        listDAlmacen_Pisos.add(pisos);
                        for (int k = 1; k <= e.getNumFilas(); k++) {
                            DAlmacen_Filas filas = new DAlmacen_Filas();
                            filas.setIDEMPRESA(empresa);
                            filas.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                            filas.setIDALMACEN(selectAlmacen.getIDALMACEN());
                            filas.setIDDISTRIBUCION(IDDISTRIBUCION);
                            filas.setIDRACK(WebUtil.idGeneradoTres(bandera));
                            filas.setIDPISO(WebUtil.idGeneradoTres(j));
                            filas.setIDFILA(WebUtil.idGeneradoTres(k));
                            filas.setESTADO(1);
                            filas.setIDUBICACION(WebUtil.ubicacionGeneracionFilas(WebUtil.idGeneradoTres(k), WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(bandera), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                            listDAlmacen_Filas.add(filas);
                            for (int z = 1; z <= e.getNumColumnas(); z++) {
                                DAlmacen_Columnas columnas = new DAlmacen_Columnas();
                                columnas.setIDEMPRESA(empresa);
                                columnas.setIDSUCURSAL(selectAlmacen.getIDSUCURSAL());
                                columnas.setIDALMACEN(selectAlmacen.getIDALMACEN());
                                columnas.setIDDISTRIBUCION(IDDISTRIBUCION);
                                columnas.setIDRACK(WebUtil.idGeneradoTres(bandera));
                                columnas.setIDPISO(WebUtil.idGeneradoTres(j));
                                columnas.setIDFILA(WebUtil.idGeneradoTres(k));
                                columnas.setIDCOLUMNA(WebUtil.idGeneradoTres(z));
                                columnas.setESTADO(1);
                                columnas.setIDUBICACION(WebUtil.ubicacionGeneracionColumnas(WebUtil.idGeneradoTres(z), WebUtil.idGeneradoTres(k), WebUtil.idGeneradoTres(j), WebUtil.idGeneradoTres(bandera), selectAlmacen.getIDALMACEN(), selectAlmacen.getIDSUCURSAL()));
                                listDAlmacen_Columnas.add(columnas);
                            }
                        }
                    }
                }
            }
        }
        listGeneracionDistribucion = new ArrayList<TablaDistribucion>();
//        generacionDistribucion=new TablaDistribucion();
    }

    public void generarDDistribucionUbicacion() {
        try {
            if (IDDISTRIBUCION.equalsIgnoreCase("")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "No existe periodo";
            } else {
                RequestContext.getCurrentInstance().update("datosAlmacen:tblRacks");
                RequestContext.getCurrentInstance().update("datosAlmacen:tblPisos");
                RequestContext.getCurrentInstance().update("datosAlmacen:tblFilas");
                RequestContext.getCurrentInstance().update("datosAlmacen:tblColumnas");
                RequestContext.getCurrentInstance().update("datosAlmacen");
                Constantes.estadoDocumento = 1;
                if (parametroDistribucion) {
                    oneRowDDistribucionUbicacion();
                } else {
                    multiRowDDistribucionUbicacion();
                }

                RequestContext.getCurrentInstance().execute("PF('dlGenerarAlmacenDistribucionUbicacion').hide()");
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void guardarDDistribucionUbicacion() {
        try {
            if (listDAlmacen_Racks.size() > 0 & listDAlmacen_Pisos.size() > 0 & listDAlmacen_Filas.size() > 0 & listDAlmacen_Columnas.size() > 0) {
                dAlmacen_RacksService.addXmlDAlmacen_Racks(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, cadenaRackXml());
                dAlmacen_PisosService.addXmlDAlmacen_Pisos(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, "", cadenaPisoXml());
                dAlmacen_FilasService.addXmlDAlmacen_Filas(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, "", "", cadenaFilaXml());
                dAlmacen_ColumnasService.addXmlDAlmacen_Columnas(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, "", "", "", cadenaColumnasXml());
                getConsultarDDistribucionUbicacion();
            }
            return;
        } catch (Exception ex) {

        }
    }

    public void getVaciar() {
        try {
            listDAlmacen_Racks = new ArrayList<DAlmacen_Racks>();
            listDAlmacen_Pisos = new ArrayList<DAlmacen_Pisos>();
            listDAlmacen_Filas = new ArrayList<DAlmacen_Filas>();
            listDAlmacen_Columnas = new ArrayList<DAlmacen_Columnas>();
            RequestContext.getCurrentInstance().update("datosAlmacen:tblRacks");
            RequestContext.getCurrentInstance().update("datosAlmacen:tblPisos");
            RequestContext.getCurrentInstance().update("datosAlmacen:tblFilas");
            RequestContext.getCurrentInstance().update("datosAlmacen:tblColumnas");

            return;
        } catch (Exception ex) {

        }
    }

    public String cadenaRackXml() {
        System.out.println("RACK XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_rack = new XStream();
        xStream_rack.processAnnotations(DAlmacen_Racks.class);
        return xml + xStream_rack.toXML(listDAlmacen_Racks);
    }

    public String cadenaPisoXml() {
        System.out.println("PISO XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE PISO
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_piso = new XStream();
        xStream_piso.processAnnotations(DAlmacen_Pisos.class);
        return xml + xStream_piso.toXML(listDAlmacen_Pisos);
    }

    public String cadenaFilaXml() {
        System.out.println("FILA XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_fila = new XStream();
        xStream_fila.processAnnotations(DAlmacen_Filas.class);
        return xml + xStream_fila.toXML(listDAlmacen_Filas);
    }

    public String cadenaColumnasXml() {
        System.out.println("COLUMNAS XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_columnas = new XStream();
        xStream_columnas.processAnnotations(DAlmacen_Columnas.class);
        return xml + xStream_columnas.toXML(listDAlmacen_Columnas);
    }

    /**
     * *************************************EDIT
     * DATATABLE***************************************************
     */
    public void seleccionTipoDistribucion() {
        if (parametroDistribucion) {
            visibleVariado = true;
            visibleHomogeneo = false;
        } else {
            visibleHomogeneo = true;
            visibleVariado = false;
        }
        RequestContext.getCurrentInstance().update("FormularioGenerarAlmacenDistribucionUbicacion:frmHomogenea");
        RequestContext.getCurrentInstance().update("FormularioGenerarAlmacenDistribucionUbicacion:frmVariada");
//        String summary = value2 ? "Checked" : "Unchecked";
    }

    public void agregarRowTablaGenerada() {
        TablaDistribucion row = new TablaDistribucion();
        row.setNumRacks(0);
        row.setNumPisos(0);
        row.setNumFilas(0);
        row.setNumColumnas(0);
        listGeneracionDistribucion.add(row);
        RequestContext.getCurrentInstance().update("FormularioGenerarAlmacenDistribucionUbicacion:tblGeneracionDistribucion");
    }

    public void eliminarRowTablaGenerada() {
        if (listGeneracionDistribucion.size() > 0) {
            listGeneracionDistribucion.remove(listGeneracionDistribucion.size() - 1);
            RequestContext.getCurrentInstance().update("FormularioGenerarAlmacenDistribucionUbicacion:tblGeneracionDistribucion");
        } else {
            FacesMessage msg = new FacesMessage("Alerta", "No hay Datos");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("TablaDistribucion Edited", "" + ((TablaDistribucion) event.getObject()).getNumRacks());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ("" + ((TablaDistribucion) event.getObject()).getNumRacks()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

//        if(newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
    }

    /**
     * *******************************************LISTADOS
     * DISTRIBUCIÓN*****************************************
     */
    public void getRecordDistribucionRack() {
        try {
            this.listDAlmacen_Racks = dAlmacen_RacksService.getRecordAlmacenEmpresa(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION);
            RequestContext.getCurrentInstance().update("datosAlmacen:tblRacks");
            selectdAlmacen_Racks = listDAlmacen_Racks.get(0);
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getRecordDistribucionPiso() {
        try {
            this.listDAlmacen_Pisos = dAlmacen_PisosService.getRecordAlmacenEmpresa(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, selectdAlmacen_Racks.getIDRACK());
            RequestContext.getCurrentInstance().update("datosAlmacen:tblPisos");
            selectdAlmacen_Pisos = listDAlmacen_Pisos.get(0);
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getRecordDistribucionFilas() {
        try {
            this.listDAlmacen_Filas = dAlmacen_FilasService.getRecordDAlmacen_FilasEmpresa(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, selectdAlmacen_Racks.getIDRACK(), selectdAlmacen_Pisos.getIDPISO());
            RequestContext.getCurrentInstance().update("datosAlmacen:tblFilas");
            selectdAlmacen_Filas = listDAlmacen_Filas.get(0);
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void getRecordDistribucionColumnas() {
        try {
            this.listDAlmacen_Columnas = dAlmacen_ColumnasService.getRecordDAlmacen_ColumnasEmpresa(empresa, selectAlmacen.getIDSUCURSAL(), selectAlmacen.getIDALMACEN(), IDDISTRIBUCION, selectdAlmacen_Racks.getIDRACK(), selectdAlmacen_Pisos.getIDPISO(), selectdAlmacen_Filas.getIDFILA());
            RequestContext.getCurrentInstance().update("datosAlmacen:tblColumnas");
            selectdAlmacen_Columnas = listDAlmacen_Columnas.get(0);
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    /**
     * ****************************************************************************************************
     */
    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the almacenService
     */
    public AlmacenService getAlmacenService() {
        return almacenService;
    }

    /**
     * @param almacenService the almacenService to set
     */
    public void setAlmacenService(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    /**
     * @return the listAlmacen
     */
    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    /**
     * @param listAlmacen the listAlmacen to set
     */
    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    /**
     * @return the filterAlmacen
     */
    public List<Almacen> getFilterAlmacen() {
        return filterAlmacen;
    }

    /**
     * @param filterAlmacen the filterAlmacen to set
     */
    public void setFilterAlmacen(List<Almacen> filterAlmacen) {
        this.filterAlmacen = filterAlmacen;
    }

    /**
     * @return the selectAlmacen
     */
    public Almacen getSelectAlmacen() {
        return selectAlmacen;
    }

    /**
     * @param selectAlmacen the selectAlmacen to set
     */
    public void setSelectAlmacen(Almacen selectAlmacen) {
        this.selectAlmacen = selectAlmacen;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * @param servletContext the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * @return the dAlmacen_RacksService
     */
    public DAlmacen_RacksService getdAlmacen_RacksService() {
        return dAlmacen_RacksService;
    }

    /**
     * @param dAlmacen_RacksService the dAlmacen_RacksService to set
     */
    public void setdAlmacen_RacksService(DAlmacen_RacksService dAlmacen_RacksService) {
        this.dAlmacen_RacksService = dAlmacen_RacksService;
    }

    /**
     * @return the listDAlmacen_Racks
     */
    public List<DAlmacen_Racks> getListDAlmacen_Racks() {
        return listDAlmacen_Racks;
    }

    /**
     * @param listDAlmacen_Racks the listDAlmacen_Racks to set
     */
    public void setListDAlmacen_Racks(List<DAlmacen_Racks> listDAlmacen_Racks) {
        this.listDAlmacen_Racks = listDAlmacen_Racks;
    }

    /**
     * @return the filterDAlmacen_Racks
     */
    public List<DAlmacen_Racks> getFilterDAlmacen_Racks() {
        return filterDAlmacen_Racks;
    }

    /**
     * @param filterDAlmacen_Racks the filterDAlmacen_Racks to set
     */
    public void setFilterDAlmacen_Racks(List<DAlmacen_Racks> filterDAlmacen_Racks) {
        this.filterDAlmacen_Racks = filterDAlmacen_Racks;
    }

    /**
     * @return the selectdAlmacen_Racks
     */
    public DAlmacen_Racks getSelectdAlmacen_Racks() {
        return selectdAlmacen_Racks;
    }

    /**
     * @param selectdAlmacen_Racks the selectdAlmacen_Racks to set
     */
    public void setSelectdAlmacen_Racks(DAlmacen_Racks selectdAlmacen_Racks) {
        this.selectdAlmacen_Racks = selectdAlmacen_Racks;
    }

    /**
     * @return the IDDISTRIBUCION
     */
    public String getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    /**
     * @param IDDISTRIBUCION the IDDISTRIBUCION to set
     */
    public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
    }

    /**
     * @return the hashmap_DDistribucionUbicacion
     */
    public HashMap getHashmap_DDistribucionUbicacion() {
        return hashmap_DDistribucionUbicacion;
    }

    /**
     * @param hashmap_DDistribucionUbicacion the hashmap_DDistribucionUbicacion
     * to set
     */
    public void setHashmap_DDistribucionUbicacion(HashMap hashmap_DDistribucionUbicacion) {
        this.hashmap_DDistribucionUbicacion = hashmap_DDistribucionUbicacion;
    }

    /**
     * @return the dDistribucionUbicacionService
     */
    public DDistribucionUbicacionService getdDistribucionUbicacionService() {
        return dDistribucionUbicacionService;
    }

    /**
     * @param dDistribucionUbicacionService the dDistribucionUbicacionService to
     * set
     */
    public void setdDistribucionUbicacionService(DDistribucionUbicacionService dDistribucionUbicacionService) {
        this.dDistribucionUbicacionService = dDistribucionUbicacionService;
    }

    /**
     * @return the listDDistribucionUbicacion
     */
    public List<DDistribucionUbicacion> getListDDistribucionUbicacion() {
        return listDDistribucionUbicacion;
    }

    /**
     * @param listDDistribucionUbicacion the listDDistribucionUbicacion to set
     */
    public void setListDDistribucionUbicacion(List<DDistribucionUbicacion> listDDistribucionUbicacion) {
        this.listDDistribucionUbicacion = listDDistribucionUbicacion;
    }

    /**
     * @return the dAlmacen_PisosService
     */
    public DAlmacen_PisosService getdAlmacen_PisosService() {
        return dAlmacen_PisosService;
    }

    /**
     * @param dAlmacen_PisosService the dAlmacen_PisosService to set
     */
    public void setdAlmacen_PisosService(DAlmacen_PisosService dAlmacen_PisosService) {
        this.dAlmacen_PisosService = dAlmacen_PisosService;
    }

    /**
     * @return the listDAlmacen_Pisos
     */
    public List<DAlmacen_Pisos> getListDAlmacen_Pisos() {
        return listDAlmacen_Pisos;
    }

    /**
     * @param listDAlmacen_Pisos the listDAlmacen_Pisos to set
     */
    public void setListDAlmacen_Pisos(List<DAlmacen_Pisos> listDAlmacen_Pisos) {
        this.listDAlmacen_Pisos = listDAlmacen_Pisos;
    }

    /**
     * @return the filterDAlmacen_Pisos
     */
    public List<DAlmacen_Pisos> getFilterDAlmacen_Pisos() {
        return filterDAlmacen_Pisos;
    }

    /**
     * @param filterDAlmacen_Pisos the filterDAlmacen_Pisos to set
     */
    public void setFilterDAlmacen_Pisos(List<DAlmacen_Pisos> filterDAlmacen_Pisos) {
        this.filterDAlmacen_Pisos = filterDAlmacen_Pisos;
    }

    /**
     * @return the selectdAlmacen_Pisos
     */
    public DAlmacen_Pisos getSelectdAlmacen_Pisos() {
        return selectdAlmacen_Pisos;
    }

    /**
     * @param selectdAlmacen_Pisos the selectdAlmacen_Pisos to set
     */
    public void setSelectdAlmacen_Pisos(DAlmacen_Pisos selectdAlmacen_Pisos) {
        this.selectdAlmacen_Pisos = selectdAlmacen_Pisos;
    }

    /**
     * @return the dAlmacen_FilasService
     */
    public DAlmacen_FilasService getdAlmacen_FilasService() {
        return dAlmacen_FilasService;
    }

    /**
     * @param dAlmacen_FilasService the dAlmacen_FilasService to set
     */
    public void setdAlmacen_FilasService(DAlmacen_FilasService dAlmacen_FilasService) {
        this.dAlmacen_FilasService = dAlmacen_FilasService;
    }

    /**
     * @return the listDAlmacen_Filas
     */
    public List<DAlmacen_Filas> getListDAlmacen_Filas() {
        return listDAlmacen_Filas;
    }

    /**
     * @param listDAlmacen_Filas the listDAlmacen_Filas to set
     */
    public void setListDAlmacen_Filas(List<DAlmacen_Filas> listDAlmacen_Filas) {
        this.listDAlmacen_Filas = listDAlmacen_Filas;
    }

    /**
     * @return the filterDAlmacen_Filas
     */
    public List<DAlmacen_Filas> getFilterDAlmacen_Filas() {
        return filterDAlmacen_Filas;
    }

    /**
     * @param filterDAlmacen_Filas the filterDAlmacen_Filas to set
     */
    public void setFilterDAlmacen_Filas(List<DAlmacen_Filas> filterDAlmacen_Filas) {
        this.filterDAlmacen_Filas = filterDAlmacen_Filas;
    }

    /**
     * @return the selectdAlmacen_Filas
     */
    public DAlmacen_Filas getSelectdAlmacen_Filas() {
        return selectdAlmacen_Filas;
    }

    /**
     * @param selectdAlmacen_Filas the selectdAlmacen_Filas to set
     */
    public void setSelectdAlmacen_Filas(DAlmacen_Filas selectdAlmacen_Filas) {
        this.selectdAlmacen_Filas = selectdAlmacen_Filas;
    }

    /**
     * @return the dAlmacen_ColumnasService
     */
    public DAlmacen_ColumnasService getdAlmacen_ColumnasService() {
        return dAlmacen_ColumnasService;
    }

    /**
     * @param dAlmacen_ColumnasService the dAlmacen_ColumnasService to set
     */
    public void setdAlmacen_ColumnasService(DAlmacen_ColumnasService dAlmacen_ColumnasService) {
        this.dAlmacen_ColumnasService = dAlmacen_ColumnasService;
    }

    /**
     * @return the listDAlmacen_Columnas
     */
    public List<DAlmacen_Columnas> getListDAlmacen_Columnas() {
        return listDAlmacen_Columnas;
    }

    /**
     * @param listDAlmacen_Columnas the listDAlmacen_Columnas to set
     */
    public void setListDAlmacen_Columnas(List<DAlmacen_Columnas> listDAlmacen_Columnas) {
        this.listDAlmacen_Columnas = listDAlmacen_Columnas;
    }

    /**
     * @return the filterDAlmacen_Columnas
     */
    public List<DAlmacen_Columnas> getFilterDAlmacen_Columnas() {
        return filterDAlmacen_Columnas;
    }

    /**
     * @param filterDAlmacen_Columnas the filterDAlmacen_Columnas to set
     */
    public void setFilterDAlmacen_Columnas(List<DAlmacen_Columnas> filterDAlmacen_Columnas) {
        this.filterDAlmacen_Columnas = filterDAlmacen_Columnas;
    }

    /**
     * @return the selectdAlmacen_Columnas
     */
    public DAlmacen_Columnas getSelectdAlmacen_Columnas() {
        return selectdAlmacen_Columnas;
    }

    /**
     * @param selectdAlmacen_Columnas the selectdAlmacen_Columnas to set
     */
    public void setSelectdAlmacen_Columnas(DAlmacen_Columnas selectdAlmacen_Columnas) {
        this.selectdAlmacen_Columnas = selectdAlmacen_Columnas;
    }

    /**
     * @return the newDDistribucionUbicacion
     */
    public DDistribucionUbicacion getNewDDistribucionUbicacion() {
        return newDDistribucionUbicacion;
    }

    /**
     * @param newDDistribucionUbicacion the newDDistribucionUbicacion to set
     */
    public void setNewDDistribucionUbicacion(DDistribucionUbicacion newDDistribucionUbicacion) {
        this.newDDistribucionUbicacion = newDDistribucionUbicacion;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the generacionDistribucion
     */
    public TablaDistribucion getGeneracionDistribucion() {
        return generacionDistribucion;
    }

    /**
     * @param generacionDistribucion the generacionDistribucion to set
     */
    public void setGeneracionDistribucion(TablaDistribucion generacionDistribucion) {
        this.generacionDistribucion = generacionDistribucion;
    }

    /**
     * @return the listGeneracionDistribucion
     */
    public List<TablaDistribucion> getListGeneracionDistribucion() {
        return listGeneracionDistribucion;
    }

    /**
     * @param listGeneracionDistribucion the listGeneracionDistribucion to set
     */
    public void setListGeneracionDistribucion(List<TablaDistribucion> listGeneracionDistribucion) {
        this.listGeneracionDistribucion = listGeneracionDistribucion;
    }

    /**
     * @return the botonBuscar
     */
    public boolean isBotonBuscar() {
        return botonBuscar;
    }

    /**
     * @param botonBuscar the botonBuscar to set
     */
    public void setBotonBuscar(boolean botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    /**
     * @return the botonPeriodo
     */
    public boolean isBotonPeriodo() {
        return botonPeriodo;
    }

    /**
     * @param botonPeriodo the botonPeriodo to set
     */
    public void setBotonPeriodo(boolean botonPeriodo) {
        this.botonPeriodo = botonPeriodo;
    }

    /**
     * @return the botonGenerar
     */
    public boolean isBotonGenerar() {
        return botonGenerar;
    }

    /**
     * @param botonGenerar the botonGenerar to set
     */
    public void setBotonGenerar(boolean botonGenerar) {
        this.botonGenerar = botonGenerar;
    }

    /**
     * @return the visibleVariado
     */
    public boolean isVisibleVariado() {
        return visibleVariado;
    }

    /**
     * @param visibleVariado the visibleVariado to set
     */
    public void setVisibleVariado(boolean visibleVariado) {
        this.visibleVariado = visibleVariado;
    }

    /**
     * @return the visibleHomogeneo
     */
    public boolean isVisibleHomogeneo() {
        return visibleHomogeneo;
    }

    /**
     * @param visibleHomogeneo the visibleHomogeneo to set
     */
    public void setVisibleHomogeneo(boolean visibleHomogeneo) {
        this.visibleHomogeneo = visibleHomogeneo;
    }

    /**
     * @return the parametroDistribucion
     */
    public boolean isParametroDistribucion() {
        return parametroDistribucion;
    }

    /**
     * @param parametroDistribucion the parametroDistribucion to set
     */
    public void setParametroDistribucion(boolean parametroDistribucion) {
        this.parametroDistribucion = parametroDistribucion;
    }

    public List<Multitabla> getListTipoRacks() {
        return listTipoRacks;
    }

    public void setListTipoRacks(List<Multitabla> listTipoRacks) {
        this.listTipoRacks = listTipoRacks;
    }

}
