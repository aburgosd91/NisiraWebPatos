/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDistribucionUbicacion;
import com.nisira.core.entity.FechaCampanaAnual;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Paleta;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.DAlmacen_RacksService;
import com.nisira.core.service.DDistribucionUbicacionService;
import com.nisira.core.service.FechaCampanaAnualService;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.PaletaService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.Car;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public final class ProgramacionAction {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    private String empresa;
    /****************************PALETAS**************************/
    private PaletaService paletaService;
    private Paleta selectPaleta;
    private List<Paleta> listPaleta;
    private List<Paleta> filterPaleta;
    private List<Paleta> selectPaletas;
    private int paletasSeleccionas;
    /*******************************CAMPAÑAS***********************/
    private FechaCampanaAnualService serviceFechaCampanaAnual;
    private FechaCampanaAnual fechaCampanaAnual;
    private List<FechaCampanaAnual> listFechaCampanaAnual;
    private String IDFECHA;
    /*******************************TIPO UBICACIÓN***********************/
    private MultitablaService serviceTipoUbicacion;
    private Multitabla tipoUbicacion;
    private List<Multitabla> listTipoUbicacion;
    /***********************SUCURSAL*******************************/
    private SucursalService serviceSucursal;
    private List<Sucursal> listSucursa;
    private String IDSUCURSAL;
    /***********************ALMACEN********************************/
    private AlmacenService serviceAlmacen;
    private Almacen almacen;
    private List<Almacen> listAlmacen;
    private String IDALMACEN;
    /*+++++++++++++++++++++++++++++++++++++++DISTRIBUCIÓN UBICACIÓN++++++++++++++++++++++++++++++++++++++++*/
    private DDistribucionUbicacionService dDistribucionUbicacionService;
    private List<DDistribucionUbicacion> listDDistribucionUbicacion;
    private String IDDISTRIBUCION;
    /*******************************RACK***********************/
    private DAlmacen_RacksService serviceRacks;
    private DAlmacen_Racks selectRacks;
    private List<DAlmacen_Racks> listRacks;
    public ProgramacionAction() throws Exception {
        empresa=ConstantesBD.IDEMPRESA;
        paletasSeleccionas=0;
        /*Listas*/
        listPaleta=new ArrayList<Paleta>();
        selectPaletas=new ArrayList<Paleta>();
        listRacks=new ArrayList<DAlmacen_Racks>();
        listAlmacen=new ArrayList<Almacen>();
        listSucursa=new ArrayList<Sucursal>();
        listFechaCampanaAnual=new ArrayList<FechaCampanaAnual>();
        listDDistribucionUbicacion=new ArrayList<DDistribucionUbicacion>();
        selectRacks=new DAlmacen_Racks();
        /*Service*/
        paletaService=new PaletaService();
        serviceSucursal=new SucursalService();
        serviceAlmacen=new AlmacenService();
        serviceRacks=new DAlmacen_RacksService();
        serviceTipoUbicacion=new MultitablaService();
        serviceFechaCampanaAnual=new FechaCampanaAnualService();
        dDistribucionUbicacionService=new DDistribucionUbicacionService();
        /****************Llenar Listas*******************/
        getRecordFechaCampanaAnual();
        getRecordSucursal();
        IDFECHA="";
        IDSUCURSAL="";
        IDALMACEN="";
        IDDISTRIBUCION="";
    }
    /*********************************PROCESOS**************************************/
    public void onCheck(){
        paletasSeleccionas= selectPaletas.size();
    }
    public void grabarUbicacion(){
        paletasSeleccionas=selectPaletas.size();
        RequestContext.getCurrentInstance().update("datos:informacion");
        return;
    }
    public void getRecordFechaCampanaAnual() throws Exception{
        listFechaCampanaAnual=serviceFechaCampanaAnual.findByEmpresa(empresa);
        RequestContext.getCurrentInstance().update("datos:cbofechacampana");
        return;
    }
    public void getRecordSucursal() throws Exception{
        listSucursa=serviceSucursal.getRecordSucursalEmpresaActivo(empresa);
        RequestContext.getCurrentInstance().update("datos:cbosucursal");
        return;
    }
    public void onCampanaChange() throws Exception {
        if(!IDFECHA.equalsIgnoreCase(""))
            listPaleta=paletaService.findByTotalPaletaCampana(empresa, IDFECHA);
        RequestContext.getCurrentInstance().update("datos:listPaleta");
        RequestContext.getCurrentInstance().update("datos:informacion");
        return;
    }
    public void onSucursalChange() throws Exception {
        if(!IDSUCURSAL.equalsIgnoreCase(""))
            listAlmacen=serviceAlmacen.getRecordAlmacenEmpresa(empresa, IDSUCURSAL);
        RequestContext.getCurrentInstance().update("datos:cboalmacen");
        return;
    }
    public void onAlmacenChange() throws Exception {
        if(!IDALMACEN.equalsIgnoreCase(""))
            listDDistribucionUbicacion=dDistribucionUbicacionService.getRecordDDistribucionUbicacionEmpresaActivo(empresa,IDSUCURSAL, IDALMACEN);
        RequestContext.getCurrentInstance().update("datos:cbodistribucion");
        return;
    }
    public void onDistribucionChange() throws Exception {
        if(!IDDISTRIBUCION.equalsIgnoreCase(""))
            listRacks=serviceRacks.getRecordAlmacenEmpresaCapacidad(empresa, IDSUCURSAL,IDALMACEN, IDDISTRIBUCION);
        RequestContext.getCurrentInstance().update("datos:tblRacks");
        return;
    }
    public void rackSeleccionado() {
        int pos=listRacks.indexOf(selectRacks);
        if(selectRacks.isSELECCION())
            selectRacks.setSELECCION(false);
        else
            selectRacks.setSELECCION(true);
        listRacks.set(pos, selectRacks);
//        FacesMessage msg = new FacesMessage("Selected",idrack);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().update("datos2:listRacks");
        RequestContext.getCurrentInstance().update("datos2:listRacks:cuadroRack");
        return ;
//        String summary = value2 ? "Checked" : "Unchecked";
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    /*******************************************************************************************************/
    /**
     * @return the paletaService
     */
    public PaletaService getPaletaService() {
        return paletaService;
    }

    /**
     * @param paletaService the paletaService to set
     */
    public void setPaletaService(PaletaService paletaService) {
        this.paletaService = paletaService;
    }

    /**
     * @return the listPaleta
     */
    public List<Paleta> getListPaleta() {
        return listPaleta;
    }

    /**
     * @param listPaleta the listPaleta to set
     */
    public void setListPaleta(List<Paleta> listPaleta) {
        this.listPaleta = listPaleta;
    }

    /**
     * @return the filterPaleta
     */
    public List<Paleta> getFilterPaleta() {
        return filterPaleta;
    }

    /**
     * @param filterPaleta the filterPaleta to set
     */
    public void setFilterPaleta(List<Paleta> filterPaleta) {
        this.filterPaleta = filterPaleta;
    }

    /**
     * @return the serviceFechaCampanaAnual
     */
    public FechaCampanaAnualService getServiceFechaCampanaAnual() {
        return serviceFechaCampanaAnual;
    }

    /**
     * @param serviceFechaCampanaAnual the serviceFechaCampanaAnual to set
     */
    public void setServiceFechaCampanaAnual(FechaCampanaAnualService serviceFechaCampanaAnual) {
        this.serviceFechaCampanaAnual = serviceFechaCampanaAnual;
    }

    /**
     * @return the fechaCampanaAnual
     */
    public FechaCampanaAnual getFechaCampanaAnual() {
        return fechaCampanaAnual;
    }

    /**
     * @param fechaCampanaAnual the fechaCampanaAnual to set
     */
    public void setFechaCampanaAnual(FechaCampanaAnual fechaCampanaAnual) {
        this.fechaCampanaAnual = fechaCampanaAnual;
    }

    /**
     * @return the listFechaCampanaAnual
     */
    public List<FechaCampanaAnual> getListFechaCampanaAnual() {
        return listFechaCampanaAnual;
    }

    /**
     * @param listFechaCampanaAnual the listFechaCampanaAnual to set
     */
    public void setListFechaCampanaAnual(List<FechaCampanaAnual> listFechaCampanaAnual) {
        this.listFechaCampanaAnual = listFechaCampanaAnual;
    }

    /**
     * @return the IDFECHA
     */
    public String getIDFECHA() {
        return IDFECHA;
    }

    /**
     * @param IDFECHA the IDFECHA to set
     */
    public void setIDFECHA(String IDFECHA) {
        this.IDFECHA = IDFECHA;
    }

    /**
     * @return the serviceTipoUbicacion
     */
    public MultitablaService getServiceTipoUbicacion() {
        return serviceTipoUbicacion;
    }

    /**
     * @param serviceTipoUbicacion the serviceTipoUbicacion to set
     */
    public void setServiceTipoUbicacion(MultitablaService serviceTipoUbicacion) {
        this.serviceTipoUbicacion = serviceTipoUbicacion;
    }

    /**
     * @return the tipoUbicacion
     */
    public Multitabla getTipoUbicacion() {
        return tipoUbicacion;
    }

    /**
     * @param tipoUbicacion the tipoUbicacion to set
     */
    public void setTipoUbicacion(Multitabla tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    /**
     * @return the listTipoUbicacion
     */
    public List<Multitabla> getListTipoUbicacion() {
        return listTipoUbicacion;
    }

    /**
     * @param listTipoUbicacion the listTipoUbicacion to set
     */
    public void setListTipoUbicacion(List<Multitabla> listTipoUbicacion) {
        this.listTipoUbicacion = listTipoUbicacion;
    }

    /**
     * @return the serviceAlmacen
     */
    public AlmacenService getServiceAlmacen() {
        return serviceAlmacen;
    }

    /**
     * @param serviceAlmacen the serviceAlmacen to set
     */
    public void setServiceAlmacen(AlmacenService serviceAlmacen) {
        this.serviceAlmacen = serviceAlmacen;
    }

    /**
     * @return the almacen
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
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
     * @return the selectPaleta
     */
    public Paleta getSelectPaleta() {
        return selectPaleta;
    }

    /**
     * @param selectPaleta the selectPaleta to set
     */
    public void setSelectPaleta(Paleta selectPaleta) {
        this.selectPaleta = selectPaleta;
    }

    /**
     * @return the serviceRacks
     */
    public DAlmacen_RacksService getServiceRacks() {
        return serviceRacks;
    }

    /**
     * @param serviceRacks the serviceRacks to set
     */
    public void setServiceRacks(DAlmacen_RacksService serviceRacks) {
        this.serviceRacks = serviceRacks;
    }

    /**
     * @return the selectRacks
     */
    public DAlmacen_Racks getSelectRacks() {
        return selectRacks;
    }

    /**
     * @param selectRacks the selectRacks to set
     */
    public void setSelectRacks(DAlmacen_Racks selectRacks) {
        this.selectRacks = selectRacks;
    }

    /**
     * @return the listRacks
     */
    public List<DAlmacen_Racks> getListRacks() {
        return listRacks;
    }

    /**
     * @param listRacks the listRacks to set
     */
    public void setListRacks(List<DAlmacen_Racks> listRacks) {
        this.listRacks = listRacks;
    }

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
     * @return the serviceSucursal
     */
    public SucursalService getServiceSucursal() {
        return serviceSucursal;
    }

    /**
     * @param serviceSucursal the serviceSucursal to set
     */
    public void setServiceSucursal(SucursalService serviceSucursal) {
        this.serviceSucursal = serviceSucursal;
    }

    /**
     * @return the listSucursa
     */
    public List<Sucursal> getListSucursa() {
        return listSucursa;
    }

    /**
     * @param listSucursa the listSucursa to set
     */
    public void setListSucursa(List<Sucursal> listSucursa) {
        this.listSucursa = listSucursa;
    }

    /**
     * @return the IDSUCURSAL
     */
    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the IDALMACEN
     */
    public String getIDALMACEN() {
        return IDALMACEN;
    }

    /**
     * @param IDALMACEN the IDALMACEN to set
     */
    public void setIDALMACEN(String IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    /**
     * @return the dDistribucionUbicacionService
     */
    public DDistribucionUbicacionService getdDistribucionUbicacionService() {
        return dDistribucionUbicacionService;
    }

    /**
     * @param dDistribucionUbicacionService the dDistribucionUbicacionService to set
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
     * @return the selectPaletas
     */
    public List<Paleta> getSelectPaletas() {
        return selectPaletas;
    }

    /**
     * @param selectPaletas the selectPaletas to set
     */
    public void setSelectPaletas(List<Paleta> selectPaletas) {
        this.selectPaletas = selectPaletas;
    }

    /**
     * @return the paletasSeleccionas
     */
    public int getPaletasSeleccionas() {
        return paletasSeleccionas;
    }

    /**
     * @param paletasSeleccionas the paletasSeleccionas to set
     */
    public void setPaletasSeleccionas(int paletasSeleccionas) {
        this.paletasSeleccionas = paletasSeleccionas;
    }
    
}
