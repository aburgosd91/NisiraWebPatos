/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.DAlmacen_ColumnasService;
import com.nisira.core.service.DDNForma_UbicacionService;
import com.nisira.core.service.DNForma_UbicacionService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public class NivelUbicacionAction {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    private String empresa;
    private String mensaje;
    /***********************SUCURSAL*******************************/
    private SucursalService serviceSucursal;
    private List<Sucursal> listSucursal;
    private String IDSUCURSAL;
    /***********************ALMACEN********************************/
    private boolean botonBuscar;
    private AlmacenService serviceAlmacen;
    private Almacen almacen;
    private List<Almacen> listAlmacen;
    private String IDALMACEN;
    private DAlmacen_ColumnasService dAlmacen_ColumnasService;
    private String cboFilaxColumna;
    private List<Combos> listaFilaxColumna;
    private Combos selectFilaxColumna;
    /***********************DNFORMAUBICACION********************************/
    private List<DNFormaUbicacion> listDNForma_Ubicacion;
    private DNFormaUbicacion dnUbicacion;
    private DNForma_UbicacionService dNForma_UbicacionService;
    /***********************DDNFORMAUBICACION********************************/
    private List<DDNFormaUbicacion> listDDNForma_Ubicacion;
    private List<DDNFormaUbicacion> TempListDDNForma_Ubicacion;
    private DDNFormaUbicacion selectDDNUbicacion;
    private DDNForma_UbicacionService dDNForma_UbicacionService;
    private int posicion;
    private List<Integer> arregloTemp;
    public NivelUbicacionAction() {
        empresa=ConstantesBD.IDEMPRESA;
        /***********************SUCURSAL*******************************/
        listSucursal=new ArrayList<Sucursal>();
        serviceSucursal=new SucursalService();
        /***********************ALMACEN********************************/
        listAlmacen=new ArrayList<Almacen>();
        serviceAlmacen=new AlmacenService();
        botonBuscar=true;
        listaFilaxColumna=new ArrayList<Combos>();
        cboFilaxColumna="";
        selectFilaxColumna=new Combos();
        dAlmacen_ColumnasService=new DAlmacen_ColumnasService();
        /***********************DNFORMAUBICACION********************************/
        listDNForma_Ubicacion=new ArrayList<DNFormaUbicacion>();
        dNForma_UbicacionService=new DNForma_UbicacionService();
        dnUbicacion=new DNFormaUbicacion();
        /***********************DDNFORMAUBICACION********************************/
        listDDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        TempListDDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>(); 
        dDNForma_UbicacionService=new DDNForma_UbicacionService();
        arregloTemp=new ArrayList<Integer>();
    }
    public void getRecordSucursal() throws Exception{
        setListSucursa(getServiceSucursal().getRecordSucursalEmpresaActivo(getEmpresa()));
        RequestContext.getCurrentInstance().update("datos:cbosucursal");
        
        return;
    }
    public void getRecordFilasxDistribucion() throws Exception{
        listaFilaxColumna=dAlmacen_ColumnasService.getRecordDAlmacen_cbofilasXcolumnas(empresa, getIDSUCURSAL(), getIDALMACEN(), "001", "001", "001");
        RequestContext.getCurrentInstance().update("datos:listaFilaxColumna");
        return;
    }
    public void onSucursalChange() throws Exception {
        if(!IDSUCURSAL.equalsIgnoreCase(""))
            setListAlmacen(getServiceAlmacen().getRecordAlmacenEmpresa(getEmpresa(), getIDSUCURSAL()));
        RequestContext.getCurrentInstance().update("datos:cboalmacen");
        return;
    }
    public void onAlmacenChange() throws Exception {
        if(!IDALMACEN.equalsIgnoreCase("")){
            //listRacks=dAlmacen_ColumnasService.getRecordDAlmacen_RacksFilaColumnas(empresa, getIDSUCURSAL(), getIDALMACEN(),"","001","001");
            botonBuscar=false;
        }
        RequestContext.getCurrentInstance().update("datos:ibotonBuscar");
        return;
    }
    public void onFilaxDistribucionChange() throws Exception {
        arregloTemp=new ArrayList<Integer>();
        if(selectFilaxColumna.isESTADO()){
            /*EDITAR*/
            /*CARGAR DATOS DE LA BASE*/
            listDNForma_Ubicacion=dNForma_UbicacionService.getRecordNForma_Ubicacion(empresa, IDSUCURSAL, IDALMACEN);
            TempListDDNForma_Ubicacion=dDNForma_UbicacionService.getRecordDForma_Ubicacion(empresa, IDSUCURSAL, IDALMACEN, "", selectFilaxColumna.getFilas(), selectFilaxColumna.getColumnas());
            setListDDNForma_Ubicacion(reportarGuardado(empresa,IDSUCURSAL,IDALMACEN,selectFilaxColumna.getFilas(),selectFilaxColumna.getColumnas()));         
            posicion=0;
            if(TempListDDNForma_Ubicacion.size()>0){
                for(int i=0;i<TempListDDNForma_Ubicacion.size();i++){
                    if(TempListDDNForma_Ubicacion.get(i).getPRIORIDAD()!=0){
                        arregloTemp.add(TempListDDNForma_Ubicacion.get(i).getPRIORIDAD());
                        posicion++;
                    }
                }
                /*ORDENAR ARREGLO ASCENDENTE*/
                int temp=0;
                for(int i=0;i<arregloTemp.size()-1;i++){
                    for(int j=i+1;j<arregloTemp.size();j++){
                        if(arregloTemp.get(i)>arregloTemp.get(j)){
                            temp=arregloTemp.get(i);
                            arregloTemp.set(i, arregloTemp.get(j));
                            arregloTemp.set(j, temp);
                        }
                    }
                }
            }
        }
        else{
            /*DEFINIR DNFORMA_UBICACION*/
            if(empresa.equals("") & empresa==null){
                this.mensaje = "No se encuentra Empresa";
                WebUtil.MensajeError(this.mensaje);
            }else if(IDSUCURSAL.equals("") & IDSUCURSAL==null){
                this.mensaje = "No se encuentra Sucursal";
                WebUtil.MensajeError(this.mensaje);
            }else if(IDALMACEN.equals("") & IDALMACEN==null){
                this.mensaje = "No se encuentra Almacen";
                WebUtil.MensajeError(this.mensaje);
            }else{
                dnUbicacion=new DNFormaUbicacion();
                dnUbicacion.setIDEMPRESA(empresa);
                dnUbicacion.setIDSUCURSAL(IDSUCURSAL);
                dnUbicacion.setIDALMACEN(IDALMACEN);
                dnUbicacion.setIDNFORMACIONUBICACION("");
                dnUbicacion.setFILAS(selectFilaxColumna.getFilas());
                dnUbicacion.setCOLUMNAS(selectFilaxColumna.getColumnas());
                dnUbicacion.setDESCRIPCION("");
                dnUbicacion.setESTADO(1);
                listDDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
                /*DEFINIR DDNFORMA_UBICACION*/
                for(int i=0;i<selectFilaxColumna.getFilas();i++){
                    for(int j=0;j<selectFilaxColumna.getColumnas();j++){
                        DDNFormaUbicacion dDNUbicacion=new DDNFormaUbicacion();
                        dDNUbicacion.setIDEMPRESA(empresa);
                        dDNUbicacion.setIDSUCURSAL(IDSUCURSAL);
                        dDNUbicacion.setIDALMACEN(IDALMACEN);
                        dDNUbicacion.setIDNFORMACIONUBICACION("");
                        dDNUbicacion.setFILAS(selectFilaxColumna.getFilas());
                        dDNUbicacion.setCOLUMNAS(selectFilaxColumna.getColumnas());
                        dDNUbicacion.setIDFILA(WebUtil.idGeneradoTres(i+1));
                        dDNUbicacion.setIDCOLUMNA(WebUtil.idGeneradoTres(j+1));
                        dDNUbicacion.setPRIORIDAD(0);
                        dDNUbicacion.setESTADO(1);
                        dDNUbicacion.setSELECCIONADO(false);
    //                    getTempListDDNForma_Ubicacion().add(dDNUbicacion);
                        listDDNForma_Ubicacion.add(dDNUbicacion);
                    }
                }
            }
            
        }
        RequestContext.getCurrentInstance().update("FormularioDistribucionNivel:listDDNForma_Ubicacion");
        return;
    }
    /*DISTRIBUCION POR RACK*/
    public void filaColumnaSeleccionado() {
        try{
            int pos=listDDNForma_Ubicacion.indexOf(selectDDNUbicacion);
            posicion=0;
            int temp=0;
            /*ACCION DE SELECCION*/
            if(selectDDNUbicacion.isSELECCIONADO()){
                selectDDNUbicacion.setSELECCIONADO(false);
                if(listDDNForma_Ubicacion.get(pos).getPRIORIDAD()!=0){
                    arregloTemp.remove(arregloTemp.indexOf(listDDNForma_Ubicacion.get(pos).getPRIORIDAD()));
                    selectDDNUbicacion.setPRIORIDAD(0);
                }
            }
            else{
                selectDDNUbicacion.setSELECCIONADO(true);
                /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                if(arregloTemp.size()>0){
                   /*ORDENAR ARREGLO ASCENDENTE*/
                    for(int i=0;i<arregloTemp.size()-1;i++){
                        for(int j=i+1;j<arregloTemp.size();j++){
                            if(arregloTemp.get(i)>arregloTemp.get(j)){
                                temp=arregloTemp.get(i);
                                arregloTemp.set(i, arregloTemp.get(j));
                                arregloTemp.set(j, temp);
                            }
                        }
                    }
                    posicion=obtenerPosicion(arregloTemp);
                }
                else{
                    posicion++;
                }
                arregloTemp.add(posicion);
                selectDDNUbicacion.setPRIORIDAD(posicion);
            }
            listDDNForma_Ubicacion.set(pos,selectDDNUbicacion);
            RequestContext.getCurrentInstance().update("FormularioDistribucionNivel:listDDNForma_Ubicacion");
            RequestContext.getCurrentInstance().update("FormularioDistribucionNivel:listDDNForma_Ubicacion:cuadroNivel");
        }catch(Exception ex){
            
        }
        return ;
    }
    public int obtenerPosicion(List<Integer> arreglo){
        int pos=0;boolean t=true;
        for(int i=0;i<arreglo.size() & t;i++){
            if(i>0){
                if(arreglo.get(i)-arreglo.get(i-1)>1){
                    t=false;
                    pos=arreglo.get(i-1)+1;
                }
            }
            else{
                if(arreglo.get(i)!=1){
                    t=false;
                    pos=1;
                }
            }
        }
        if(pos==0)
            pos=arreglo.get(arreglo.size()-1)+1;
        return pos;
    }
    public void asignarDistribucionXnivel(){
        if(arregloTemp.size() ==(selectFilaxColumna.getFilas()*selectFilaxColumna.getColumnas())){
            Combos temp=selectFilaxColumna;
            temp.setESTADO(true);
            listaFilaxColumna.set(listaFilaxColumna.indexOf(selectFilaxColumna), temp);
            listDNForma_Ubicacion.add(dnUbicacion);
            if(!TempListDDNForma_Ubicacion.containsAll(listDDNForma_Ubicacion))
                TempListDDNForma_Ubicacion.addAll(listDDNForma_Ubicacion);
            RequestContext.getCurrentInstance().update("FormularioDistribucionNivel:listDDNForma_Ubicacion");
            RequestContext.getCurrentInstance().update("datos:listaFilaxColumna");
            RequestContext.getCurrentInstance().execute("PF('dlDistribucionNivel').hide()");
        }else{
            this.mensaje = "Deberá asignar numero a todas las cuadrículas";
            WebUtil.MensajeAdvertencia(this.mensaje);
        }
    }
    public List<DDNFormaUbicacion> reportarGuardado(String idempresa,String idsucursal,String idalmacen,int filas, int columnas){
        List<DDNFormaUbicacion> temporal=new ArrayList<DDNFormaUbicacion>();
        DDNFormaUbicacion o=new DDNFormaUbicacion();
        for(int i=0;i<TempListDDNForma_Ubicacion.size();i++){
            o=TempListDDNForma_Ubicacion.get(i);
            if(idempresa.equalsIgnoreCase(o.getIDEMPRESA()) & idsucursal.equalsIgnoreCase(o.getIDSUCURSAL()) &
                    idalmacen.equalsIgnoreCase(o.getIDALMACEN()) & filas==o.getFILAS() & columnas==o.getCOLUMNAS()){
                temporal.add(o);
            }
        }
        return temporal;
    } 
    public void Grabar(){
        try{
            /*VALIDAR INGRESO*/
            if(empresa.equals("") & empresa==null){
                this.mensaje = "No se encuentra Empresa";
                WebUtil.MensajeError(this.mensaje);
            }else if(IDSUCURSAL.equals("") & IDSUCURSAL==null){
                this.mensaje = "No se encuentra Sucursal";
                WebUtil.MensajeError(this.mensaje);
            }else if(IDALMACEN.equals("") & IDALMACEN==null){
                this.mensaje = "No se encuentra Almacen";
                WebUtil.MensajeError(this.mensaje);
            }else{
                this.mensaje=dNForma_UbicacionService.addXmlDFormaUbicacion(empresa, IDSUCURSAL, IDALMACEN, DNForma_UbicacionXml());
                if(mensaje.equalsIgnoreCase("OK")){
                    dDNForma_UbicacionService.addXmlDFormaUbicacion(empresa, IDSUCURSAL, IDALMACEN, "", 0, 0, DDNForma_UbicacionXml());
                }
            }
        }catch(Exception ex){
            this.mensaje = ex.getMessage();
            WebUtil.MensajeError(this.mensaje);
        }
    }
    public String DNForma_UbicacionXml(){
        System.out.println("DNForma_ubicacion XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE PISO
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DNForma_Ubicacion = new XStream();
        xStream_DNForma_Ubicacion.processAnnotations(DNFormaUbicacion.class);
        return xml + xStream_DNForma_Ubicacion.toXML(listDNForma_Ubicacion);
    }
    public String DDNForma_UbicacionXml(){
        System.out.println("DDNForma_ubicacion XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE PISO
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DDNForma_Ubicacion = new XStream();
        xStream_DDNForma_Ubicacion.processAnnotations(DDNFormaUbicacion.class);
        return xml + xStream_DDNForma_Ubicacion.toXML(TempListDDNForma_Ubicacion);
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
        return listSucursal;
    }

    /**
     * @param listSucursa the listSucursa to set
     */
    public void setListSucursa(List<Sucursal> listSucursa) {
        this.listSucursal = listSucursa;
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
     * @return the cboFilaxColumna
     */
    public String getCboFilaxColumna() {
        return cboFilaxColumna;
    }

    /**
     * @param cboFilaxColumna the cboFilaxColumna to set
     */
    public void setCboFilaxColumna(String cboFilaxColumna) {
        this.cboFilaxColumna = cboFilaxColumna;
    }

    /**
     * @return the listaFilaxColumna
     */
    public List<Combos> getListaFilaxColumna() {
        return listaFilaxColumna;
    }

    /**
     * @param listaFilaxColumna the listaFilaxColumna to set
     */
    public void setListaFilaxColumna(List<Combos> listaFilaxColumna) {
        this.listaFilaxColumna = listaFilaxColumna;
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
     * @return the selectFilaxColumna
     */
    public Combos getSelectFilaxColumna() {
        return selectFilaxColumna;
    }

    /**
     * @param selectFilaxColumna the selectFilaxColumna to set
     */
    public void setSelectFilaxColumna(Combos selectFilaxColumna) {
        this.selectFilaxColumna = selectFilaxColumna;
    }

    /**
     * @return the listDNForma_Ubicacion
     */
    public List<DNFormaUbicacion> getListDNForma_Ubicacion() {
        return listDNForma_Ubicacion;
    }

    /**
     * @param listDNForma_Ubicacion the listDNForma_Ubicacion to set
     */
    public void setListDNForma_Ubicacion(List<DNFormaUbicacion> listDNForma_Ubicacion) {
        this.listDNForma_Ubicacion = listDNForma_Ubicacion;
    }

    /**
     * @return the dNForma_UbicacionService
     */
    public DNForma_UbicacionService getdNForma_UbicacionService() {
        return dNForma_UbicacionService;
    }

    /**
     * @param dNForma_UbicacionService the dNForma_UbicacionService to set
     */
    public void setdNForma_UbicacionService(DNForma_UbicacionService dNForma_UbicacionService) {
        this.dNForma_UbicacionService = dNForma_UbicacionService;
    }

    /**
     * @return the listDDNForma_Ubicacion
     */
    public List<DDNFormaUbicacion> getListDDNForma_Ubicacion() {
        return listDDNForma_Ubicacion;
    }

    /**
     * @param listDDNForma_Ubicacion the listDDNForma_Ubicacion to set
     */
    public void setListDDNForma_Ubicacion(List<DDNFormaUbicacion> listDDNForma_Ubicacion) {
        this.listDDNForma_Ubicacion = listDDNForma_Ubicacion;
    }

    /**
     * @return the dDNForma_UbicacionService
     */
    public DDNForma_UbicacionService getdDNForma_UbicacionService() {
        return dDNForma_UbicacionService;
    }

    /**
     * @param dDNForma_UbicacionService the dDNForma_UbicacionService to set
     */
    public void setdDNForma_UbicacionService(DDNForma_UbicacionService dDNForma_UbicacionService) {
        this.dDNForma_UbicacionService = dDNForma_UbicacionService;
    }

    /**
     * @return the dnUbicacion
     */
    public DNFormaUbicacion getDnUbicacion() {
        return dnUbicacion;
    }

    /**
     * @param dnUbicacion the dnUbicacion to set
     */
    public void setDnUbicacion(DNFormaUbicacion dnUbicacion) {
        this.dnUbicacion = dnUbicacion;
    }

    /**
     * @return the selectDNUbicacion
     */
    public DDNFormaUbicacion getSelectDDNUbicacion() {
        return selectDDNUbicacion;
    }

    /**
     * @param selectDNUbicacion the selectDNUbicacion to set
     */
    public void setSelectDDNUbicacion(DDNFormaUbicacion selectDNUbicacion) {
        this.selectDDNUbicacion = selectDNUbicacion;
    }

    /**
     * @return the TempListDDNForma_Ubicacion
     */
    public List<DDNFormaUbicacion> getTempListDDNForma_Ubicacion() {
        return TempListDDNForma_Ubicacion;
    }

    /**
     * @param TempListDDNForma_Ubicacion the TempListDDNForma_Ubicacion to set
     */
    public void setTempListDDNForma_Ubicacion(List<DDNFormaUbicacion> TempListDDNForma_Ubicacion) {
        this.TempListDDNForma_Ubicacion = TempListDDNForma_Ubicacion;
    }
    
}
