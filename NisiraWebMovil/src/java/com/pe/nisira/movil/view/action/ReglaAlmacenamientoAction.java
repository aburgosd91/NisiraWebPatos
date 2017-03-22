/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Combos;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDFormaUbicacion;
import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DFormaUbicacion;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.entity.FormaUbicacion;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.ParametroDistribucion;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.service.AlmacenService;
import com.nisira.core.service.DAlmacen_ColumnasService;
import com.nisira.core.service.DAlmacen_RacksService;
import com.nisira.core.service.DDFormaUbicacionService;
import com.nisira.core.service.DDNForma_UbicacionService;
import com.nisira.core.service.DFormaUbicacionService;
import com.nisira.core.service.DNForma_UbicacionService;
import com.nisira.core.service.FormaUbicacionService;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.ParametroDistribucionService;
import com.nisira.core.service.SucursalService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.DistribucionNivel;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ViewScoped
public class ReglaAlmacenamientoAction {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    /******************************************************/
    private String empresa;
    private String mensaje;
    /*******************************TIPO UBICACIÓN***********************/
    private MultitablaService serviceMultitabla;
    private List<Multitabla> listTipoParametro;
    private String IDTIPOPARAMETRO;
    /**************************PARAMETROS DE DISTRIBUCION*************************/
    private ParametroDistribucionService parametroDistribucionService;
    private List<ParametroDistribucion> listParametroDistribucion;
    private ParametroDistribucion selectParametroDistribucion;
    /***********************SUCURSAL*******************************/
    private SucursalService serviceSucursal;
    private List<Sucursal> listSucursa;
    private String IDSUCURSAL;
    /***********************ALMACEN********************************/
    private AlmacenService serviceAlmacen;
    private Almacen almacen;
    private List<Almacen> listAlmacen;
    private String IDALMACEN;
    /*******************************RACK***********************/
    private DAlmacen_RacksService serviceRacks;
    private DAlmacen_Racks selectRacks;
    private List<DAlmacen_Racks> listRacks;
    private int posicion;
    private List<Integer> arregloTemp;
    private boolean botonAsignacionNivel;
    /***********************DATA DALMACEN***********************/
    private DAlmacen_ColumnasService dAlmacen_ColumnasService;
    private List<DAlmacen_Columnas> listDAlmacen_Columnas;
    /************************DISTRIBUCION NIVEL**************************/
    private String parametroOrdenamiento;
    private List<Multitabla> listDistribucionNivel;
    private List<DistribucionNivel> listNivel;
    /********************FORMAUBICACION*************************/
    private List<FormaUbicacion> listFormaUbicacion;
    private FormaUbicacionService formaUbicacionService;
    private FormaUbicacion selectFormaUbicacion;
    private List<FormaUbicacion> listSelectFormaUbicacion;
    /********************DFORMAUBICACION*************************/
    private List<DFormaUbicacion> listDFormaUbicacion;
    private DFormaUbicacionService dformaUbicacionService;
    private DFormaUbicacion selectDFormaUbicacion;
    private List<DFormaUbicacion> listSelectDFormaUbicacion;
    /********************DDFORMAUBICACION*************************/
    private List<DDFormaUbicacion> listDDFormaUbicacion;
    private DDFormaUbicacionService dDformaUbicacionService;
    private DDFormaUbicacion selectDDFormaUbicacion;
    private List<DDFormaUbicacion> listSelectDDFormaUbicacion;
    /*TIPO DISTRIBUCION*/
    private String tipoDistribucion;/*(G)GENERIGO - (P)PARTICULAR*/
    private String CONTENIDO;
    /*DISTRIBUCION - NIVEL POR RACK*/
    private int r_filas;
    private int r_columnas;
    private String cboFilaxColumna;
    private List<Combos> listaFilaxColumna;
    private String parametroNivel;
    private boolean visibleGenerar;
    private boolean visibleClonar;
    /*TABLA NIVELES*/
    /***********************DNFORMAUBICACION********************************/
    private List<DNFormaUbicacion> listDNForma_Ubicacion;
    private DNForma_UbicacionService dNForma_UbicacionService;
    private String IDNFORMACIONUBICACION;
    private DNFormaUbicacion selectFilaxColumna;
    /***********************DDNFORMAUBICACION********************************/
    private List<DDNFormaUbicacion> listDDNForma_Ubicacion;
    private DDNForma_UbicacionService dDNForma_UbicacionService;
    public ReglaAlmacenamientoAction() {
        empresa=ConstantesBD.IDEMPRESA;
        listTipoParametro=new ArrayList<Multitabla>();
        serviceMultitabla=new MultitablaService();
        /*SUCURSAL*/
        IDSUCURSAL="";
        serviceSucursal=new SucursalService();
        listSucursa=new ArrayList<Sucursal>();
        /*ALMACEN*/
        IDALMACEN="";
        serviceAlmacen=new AlmacenService();
        listAlmacen=new ArrayList<Almacen>();
        /*RACKS*/
        serviceRacks=new DAlmacen_RacksService();
        listRacks=new ArrayList<DAlmacen_Racks>();
        /*********PARAMETRO DISTRIBUCION**********/
        parametroDistribucionService=new ParametroDistribucionService();
        listParametroDistribucion=new ArrayList<ParametroDistribucion>();
        selectParametroDistribucion=new ParametroDistribucion();
        posicion=0;
        arregloTemp=new ArrayList<Integer>();
        parametroOrdenamiento="0";
        listNivel=new ArrayList<DistribucionNivel>();
        botonAsignacionNivel=true;
        /******FORMAUBICACION*****/
        listFormaUbicacion = new ArrayList<FormaUbicacion>();
        selectFormaUbicacion=new FormaUbicacion();
        formaUbicacionService = new FormaUbicacionService();
        /******DFORMAUBICACION*****/
        listDFormaUbicacion = new ArrayList<DFormaUbicacion>();
        dformaUbicacionService = new DFormaUbicacionService();
        tipoDistribucion="G";
        CONTENIDO="";
        r_filas=0;
        r_columnas=0;
        /*DALMACEN_COLUMNAS*/
        dAlmacen_ColumnasService=new DAlmacen_ColumnasService();
        listDAlmacen_Columnas=new ArrayList<DAlmacen_Columnas>();
        /*Combo FILAxCOLUMNA*/
        cboFilaxColumna="";
        listaFilaxColumna=new ArrayList<Combos>();
        parametroNivel="1";
        visibleGenerar=false;
        visibleClonar=true;
        /******DNFORMAUBICACION*********/
        listDNForma_Ubicacion=new ArrayList<DNFormaUbicacion>();
        dNForma_UbicacionService=new DNForma_UbicacionService();
        IDNFORMACIONUBICACION="";
        selectFilaxColumna=new DNFormaUbicacion();
        /******DDNFORMAUBICACION*********/
        listDDNForma_Ubicacion=new ArrayList<DDNFormaUbicacion>();
        dDNForma_UbicacionService=new DDNForma_UbicacionService();
    }
    public void getRecordDNFORMAUBICACION() throws Exception{
        setListDNForma_Ubicacion(getdNForma_UbicacionService().getRecordNForma_Ubicacion(empresa, IDSUCURSAL, IDALMACEN));
        RequestContext.getCurrentInstance().update("datos:cboFilasColumnas");
        return;
    }
    public void getRecordTipoParametro() throws Exception{
        listTipoParametro=getServiceMultitabla().getRecordParametroRegla(empresa);
        RequestContext.getCurrentInstance().update("datos:cbosucursal");
        return;
    }
    public void getRecordDistribucionNivel() throws Exception{
        listDistribucionNivel=getServiceMultitabla().getRecordDistribucionNivel(empresa);
        RequestContext.getCurrentInstance().update("datos2:cboParametro");
        return;
    }
    public void getRecordSucursal() throws Exception{
        setListSucursa(getServiceSucursal().getRecordSucursalEmpresaActivo(getEmpresa()));
        RequestContext.getCurrentInstance().update("datos:cbosucursal");
        return;
    }
    public void getRecordParametrosDistribucion() throws Exception{
        listParametroDistribucion=parametroDistribucionService.getRecordParametroDistribucionTipoParametro(empresa, IDTIPOPARAMETRO);
        RequestContext.getCurrentInstance().update("datos:listParametroDistribucion");
        return;
    }
    public void getRecordDAlmacenColumnas() throws Exception{
        setListDAlmacen_Columnas(dAlmacen_ColumnasService.getRecordDAlmacen_ColumnasDistribucionActiva(empresa, IDSUCURSAL, IDALMACEN, selectRacks.getIDRACK(), "001"));
        //RequestContext.getCurrentInstance().update("datos:listParametroDistribucion");
        return;
    }
    public void getRecordCboFilasxDistribucion() throws Exception{
        setListaFilaxColumna(dAlmacen_ColumnasService.getRecordDAlmacen_cbofilasXcolumnas(empresa, getIDSUCURSAL(), getIDALMACEN(), "", "001", "001"));
        return;
    }
    public void seleccionFormaUbicacionNivel() {
        if(getParametroNivel().equals("1")){
            visibleClonar=true;
            visibleGenerar=false;
        }
        else{
            visibleGenerar=true;
            visibleClonar=false;
        }
        RequestContext.getCurrentInstance().update("datos:frmGenerar");
        RequestContext.getCurrentInstance().update("datos:frmClonar");
//        String summary = value2 ? "Checked" : "Unchecked";
    }
    public void onDistribucionNivelChange() throws Exception {
        if(!IDNFORMACIONUBICACION.equalsIgnoreCase("")){
            /*OBTENER ELEMENTO SELECCIONADO*/
            for(int i=0;i<listDNForma_Ubicacion.size();i++){
                if(listDNForma_Ubicacion.get(i).getIDNFORMACIONUBICACION().equalsIgnoreCase(IDNFORMACIONUBICACION)
                        & listDNForma_Ubicacion.get(i).getIDEMPRESA().equalsIgnoreCase(empresa) &
                        listDNForma_Ubicacion.get(i).getIDSUCURSAL().equalsIgnoreCase(IDSUCURSAL) &
                        listDNForma_Ubicacion.get(i).getIDALMACEN().equalsIgnoreCase(IDALMACEN)){
                    selectFilaxColumna=listDNForma_Ubicacion.get(i);
                }//_4H8VF34O6E21AE
            }
            if(selectFilaxColumna!=null)
                listDDNForma_Ubicacion=dDNForma_UbicacionService.getRecordDForma_Ubicacion_idnformacionubicacion(empresa, IDSUCURSAL,IDALMACEN,selectFilaxColumna.getIDNFORMACIONUBICACION(),selectFilaxColumna.getFILAS(), selectFilaxColumna.getCOLUMNAS());
        }
        RequestContext.getCurrentInstance().update("datos:listDDNForma_Ubicacion");
        //RequestContext.getCurrentInstance().update("datos:cboalmacen");
        return;
    }
    public void onParametroDistribucionChange() throws Exception{
        getRecordParametrosDistribucion();
        return;
    }
    public void onCheck(){
        try{
//            getRecordParametrosDistribucion();
        }catch(Exception ex){
            
        }
        //paletasSeleccionas= selectPaletas.size();
    }
    public void onCheckSelecionRack(){
        try{

        }catch(Exception ex){
            
        }
    }
    public void onTipoParametroChange() throws Exception {
        if(!IDTIPOPARAMETRO.equalsIgnoreCase(""))
            listParametroDistribucion=parametroDistribucionService.getRecordParametroDistribucionTipoParametro(empresa,IDTIPOPARAMETRO);
        RequestContext.getCurrentInstance().update("datos:listParametroDistribucion");
//        RequestContext.getCurrentInstance().update("datos:listParametroDistribucion");
        return;
    }
    public void onSucursalChange() throws Exception {
        if(!IDSUCURSAL.equalsIgnoreCase(""))
            setListAlmacen(getServiceAlmacen().getRecordAlmacenEmpresa(getEmpresa(), getIDSUCURSAL()));
        RequestContext.getCurrentInstance().update("datos:cboalmacen");
        /*RESET*/
        botonAsignacionNivel=true;
        parametroOrdenamiento="0";
        arregloTemp=new ArrayList<Integer>();
        listDFormaUbicacion=new ArrayList<DFormaUbicacion>();
        listRacks=new ArrayList<DAlmacen_Racks>();
        listSelectDFormaUbicacion=new ArrayList<DFormaUbicacion>();
        RequestContext.getCurrentInstance().update("datos2:listRacks");
        RequestContext.getCurrentInstance().update("datos:tablaSeleccionRacks");
        RequestContext.getCurrentInstance().update("datos:btnGenerico");
        RequestContext.getCurrentInstance().update("datos:btnParticular");
        return;
    }
    public void onAlmacenChange() throws Exception {
        if(!IDALMACEN.equalsIgnoreCase("")){
            listRacks=dAlmacen_ColumnasService.getRecordDAlmacen_RacksFilaColumnas(empresa, getIDSUCURSAL(), getIDALMACEN(),"","001","001");
        }
        RequestContext.getCurrentInstance().update("datos2:listRacks");
        /*RESET*/
        botonAsignacionNivel=true;
        parametroOrdenamiento="1";
        arregloTemp=new ArrayList<Integer>();
        listDFormaUbicacion=new ArrayList<DFormaUbicacion>();
        listSelectDFormaUbicacion=new ArrayList<DFormaUbicacion>();
        RequestContext.getCurrentInstance().update("datos:tablaSeleccionRacks");
        RequestContext.getCurrentInstance().update("datos:btnGenerico");
        RequestContext.getCurrentInstance().update("datos:btnParticular");
        return;
    }
    /*DISTRIBUCION POR RACK*/
    public void rackSeleccionado() {
        try{
            int pos=getListRacks().indexOf(getSelectRacks());
            posicion=0;
            int temp=0;
            /*CCION DE SELECCION*/
            if(getSelectRacks().isSELECCION()){
                getSelectRacks().setSELECCION(false);
                if(listRacks.get(pos).getPosicion()!=0){
                    getArregloTemp().remove(getArregloTemp().indexOf(listRacks.get(pos).getPosicion()));
                    selectRacks.setPosicion(0);
                }
            }
            else{
                getSelectRacks().setSELECCION(true);
                /*VERIFICAR SI HAY ELEMENTOS EN EL ARREGLO*/
                if(getArregloTemp().size()>0){
                   /*ORDENAR ARREGLO ASCENDENTE*/
                    for(int i=0;i<getArregloTemp().size()-1;i++){
                        for(int j=i+1;j<getArregloTemp().size();j++){
                            if(getArregloTemp().get(i)>getArregloTemp().get(j)){
                                temp=getArregloTemp().get(i);
                                getArregloTemp().set(i, getArregloTemp().get(j));
                                getArregloTemp().set(j, temp);
                            }
                        }
                    }
                    posicion=obtenerPosicion(getArregloTemp());
                }
                else{
                    posicion++;
                }
                getArregloTemp().add(posicion);
                selectRacks.setPosicion(posicion);
            }
            getListRacks().set(pos, getSelectRacks());
            RequestContext.getCurrentInstance().update("datos2:listRacks");
            RequestContext.getCurrentInstance().update("datos2:listRacks:cuadroRack");
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
    public void getAsignarDistribucionRack()throws Exception{
        if(selectParametroDistribucion==null){
            this.setMensaje("Debe Seleccionar Parametro de Distribución");
            WebUtil.MensajeError(this.mensaje);
        }
        else if(IDSUCURSAL.equalsIgnoreCase("")){
            this.setMensaje("Debe Seleccionar Sucursal");
            WebUtil.MensajeError("Debe Seleccionar Sucursal");
            
        }
        else if(IDALMACEN.equalsIgnoreCase("")){
            this.setMensaje("Debe Seleccionar Almacen");
            WebUtil.MensajeError("Debe Seleccionar Almacen");
            
        }
        else if(listRacks.size()>0){
            int contador=0;
            for(int i=0;i<listRacks.size();i++){
                if(listRacks.get(i).getPosicion()!=0)
                    contador++;
            }
            if(contador>0){
                getRecordDNFORMAUBICACION();
                if(this.listDNForma_Ubicacion.size()==0){
                    this.setMensaje("No Existe ordenamiento en rack");
                    WebUtil.MensajeError(this.mensaje);
                }else
                    botonAsignacionNivel=false;
            }   
            else{
                this.setMensaje("Debe Seleccionar Almacen");
                WebUtil.MensajeError(this.mensaje);
            }
        }else{
            this.setMensaje("Debe Seleccionar Almacen");
            WebUtil.MensajeError(this.mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:btnGenerico");
        RequestContext.getCurrentInstance().update("datos:btnParticular");
        return;
    }
    public void obtenerDFormaUbicacion(String parametro){
        if(listDFormaUbicacion.size()==0){
            for(int i=0;i<listRacks.size();i++){
                if(listRacks.get(i).getPosicion()!=0){
                    DFormaUbicacion o=new DFormaUbicacion();
                    o.setIDEMPRESA(empresa);
                    o.setIDSUCURSAL(IDSUCURSAL);
                    o.setIDALMACEN(IDALMACEN);
                    o.setIDPARAMETRO(selectParametroDistribucion.getIDPARAMETRO());
                    o.setIDFORMACIONUBICACION("");
                    o.setIDRACK(listRacks.get(i).getIDRACK());
                    o.setPRIORIDAD(listRacks.get(i).getPosicion());
                    o.setTIPONIVEL(Integer.parseInt(parametro));
                    o.setIDNFORMACIONUBICACION(IDNFORMACIONUBICACION);
                    listDFormaUbicacion.add(o);
                }
            }
        }else{
            for(int i=0;i<listDFormaUbicacion.size();i++){
                DFormaUbicacion o=listDFormaUbicacion.get(i);
                o.setTIPONIVEL(Integer.parseInt(parametro));
                o.setIDNFORMACIONUBICACION(IDNFORMACIONUBICACION);
                listDFormaUbicacion.set(i,o);
            }
        }
        RequestContext.getCurrentInstance().update("datos:tablaSeleccionRacks");
        return;
    }
    /*DISTRIBUCION POR NIVEL*/
    public void getActionGenerico(){
        try{
//            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//            context.redirect(context.getRequestContextPath() + "/faces/sistema/distribucionNivelx.xhtml?parametro=1");
            tipoDistribucion="G";
            RequestContext.getCurrentInstance().update("datos:nivelDialog");
            RequestContext.getCurrentInstance().execute("PF('nivelDialog').show()");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void getActionParticular(){
        try{
//            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//            context.redirect(context.getRequestContextPath() + "/faces/sistema/distribucionNivelx.xhtml?parametro=1");
            tipoDistribucion="P";
            RequestContext.getCurrentInstance().update("datos:nivelDialog");
            RequestContext.getCurrentInstance().execute("PF('nivelDialog').show()");
            return;
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    /**
     * @param event
     * @return the empresa
     */
    public void handleClose(CloseEvent event){
//        WebUtil.MensajeAlerta("Close Dialog:"+event.getComponent().getId());
        try{
            if(tipoDistribucion.equals("G"))
                obtenerDFormaUbicacion(parametroOrdenamiento);
            else if(tipoDistribucion.equals("P")){
                for(int i=0;i<listSelectDFormaUbicacion.size();i++){
                    DFormaUbicacion o=listSelectDFormaUbicacion.get(i);
                    int pos=listDFormaUbicacion.indexOf(o);
                    o.setTIPONIVEL(Integer.parseInt(parametroOrdenamiento));
                    o.setIDNFORMACIONUBICACION(IDNFORMACIONUBICACION);
                    listDFormaUbicacion.set(pos, o);
//                    selectDFormaUbicacion=new DFormaUbicacion();  
                }
                listSelectDFormaUbicacion=new ArrayList<DFormaUbicacion>();
            }
            RequestContext.getCurrentInstance().update("datos:listDFormaUbicacion");
            return;
        }catch(Exception ex){
            
        }
    }
    public void asignarDistribucionXnivel(){
        try{
            if(tipoDistribucion.equals("G"))
                obtenerDFormaUbicacion(parametroOrdenamiento);
            else if(tipoDistribucion.equals("P")){
                for(int i=0;i<listSelectDFormaUbicacion.size();i++){
                    DFormaUbicacion o=listSelectDFormaUbicacion.get(i);
                    int pos=listDFormaUbicacion.indexOf(o);
                    o.setTIPONIVEL(Integer.parseInt(parametroOrdenamiento));
                    o.setIDNFORMACIONUBICACION(IDNFORMACIONUBICACION);
                    listDFormaUbicacion.set(pos, o);
//                    selectDFormaUbicacion=new DFormaUbicacion();  
                }
                listSelectDFormaUbicacion=new ArrayList<DFormaUbicacion>();
            }
            RequestContext.getCurrentInstance().update("datos:listDFormaUbicacion");
            RequestContext.getCurrentInstance().update("datos:nivelDialog");
            RequestContext.getCurrentInstance().execute("PF('nivelDialog').hide()");
            return;
        }catch(Exception ex){
            
        }
    }
    public void getGrabarReglaUbicacion(){
        try{
            CONTENIDO="CREADO: "+WebUtil.fechaDMY(new Date(), 3);
            RequestContext.getCurrentInstance().update("datos:guardadoDialog");
            RequestContext.getCurrentInstance().execute("PF('guardadoDialog').show()");
        }catch(Exception ex){
           this.mensaje=ex.getMessage();
           WebUtil.MensajeError(mensaje);
        }
        return;
    }
    public void grabarReglaUbicacion(){
        try{
            String IDFORMAUBICACION="";
            /*******CREACIÓN FORMAUBICACIÓN********/
            selectFormaUbicacion=new FormaUbicacion();
            selectFormaUbicacion.setIDEMPRESA(empresa);
            selectFormaUbicacion.setIDSUCURSAL(IDSUCURSAL);
            selectFormaUbicacion.setIDALMACEN(IDALMACEN);
            selectFormaUbicacion.setIDPARAMETRO(IDTIPOPARAMETRO);
            selectFormaUbicacion.setIDFORMACIONUBICACION("");
            selectFormaUbicacion.setDESCRIPCION(CONTENIDO);
            selectFormaUbicacion.setESTADO(true);
            IDFORMAUBICACION=formaUbicacionService.addFormaUbicacion(selectFormaUbicacion);
            if(!IDFORMAUBICACION.equals("")){
                for(int i=0;i<listDFormaUbicacion.size();i++){
                    DFormaUbicacion dFormaUbicaicon=listDFormaUbicacion.get(i);
                    dFormaUbicaicon.setIDFORMACIONUBICACION(IDFORMAUBICACION);
                    listDFormaUbicacion.set(i, dFormaUbicaicon);
                }
                dformaUbicacionService.addXmlDFormaUbicacion(empresa, IDSUCURSAL, IDALMACEN, IDTIPOPARAMETRO, IDFORMAUBICACION, DFormaUbicacionXml());
            }
        }catch(Exception ex){
           this.mensaje=ex.getMessage();
           WebUtil.MensajeError(mensaje);
        }
        return;
    }
    
    /*TRAER NUMERO DE FILAS X COLUMAS -> RACK*/
    public void numeroFilasxColumna(){
        try{
          List<Integer> parametros= dAlmacen_ColumnasService.getRecordDAlmacen_filasXcolumnas(empresa,IDSUCURSAL, IDALMACEN, selectRacks.getIDRACK(), "001");
          r_filas=parametros.get(0);
          r_columnas=parametros.get(1);
        }catch(Exception ex){
            setMensaje(ex.getMessage());
        }
    }
    /*CONVERTIR A XML*/
    public String DFormaUbicacionXml(){
        System.out.println("DFormaUbicacion XML -> TERMINADO ...");
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DFormaUbicacion = new XStream();
        xStream_DFormaUbicacion.processAnnotations(DFormaUbicacion.class);
        return xml + xStream_DFormaUbicacion.toXML(listDFormaUbicacion);
    }
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
     * @return the serviceMultitabla
     */
    public MultitablaService getServiceTipoParametro() {
        return getServiceMultitabla();
    }

    /**
     * @param serviceMultitabla the serviceMultitabla to set
     */
    public void setServiceTipoParametro(MultitablaService serviceMultitabla) {
        this.setServiceMultitabla(serviceMultitabla);
    }
    /**
     * @return the listTipoParametro
     */
    public List<Multitabla> getListTipoParametro() {
        return listTipoParametro;
    }

    /**
     * @param listTipoParametro the listTipoParametro to set
     */
    public void setListTipoParametro(List<Multitabla> listTipoParametro) {
        this.listTipoParametro = listTipoParametro;
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
     * @return the IDTIPOPARAMETRO
     */
    public String getIDTIPOPARAMETRO() {
        return IDTIPOPARAMETRO;
    }

    /**
     * @param IDTIPOPARAMETRO the IDTIPOPARAMETRO to set
     */
    public void setIDTIPOPARAMETRO(String IDTIPOPARAMETRO) {
        this.IDTIPOPARAMETRO = IDTIPOPARAMETRO;
    }

    /**
     * @return the parametroDistribucionService
     */
    public ParametroDistribucionService getParametroDistribucionService() {
        return parametroDistribucionService;
    }

    /**
     * @param parametroDistribucionService the parametroDistribucionService to set
     */
    public void setParametroDistribucionService(ParametroDistribucionService parametroDistribucionService) {
        this.parametroDistribucionService = parametroDistribucionService;
    }

    /**
     * @return the listParametroDistribucion
     */
    public List<ParametroDistribucion> getListParametroDistribucion() {
        return listParametroDistribucion;
    }

    /**
     * @param listParametroDistribucion the listParametroDistribucion to set
     */
    public void setListParametroDistribucion(List<ParametroDistribucion> listParametroDistribucion) {
        this.listParametroDistribucion = listParametroDistribucion;
    }

    /**
     * @return the selectParametroDistribucion
     */
    public ParametroDistribucion getSelectParametroDistribucion() {
        return selectParametroDistribucion;
    }

    /**
     * @param selectParametroDistribucion the selectParametroDistribucion to set
     */
    public void setSelectParametroDistribucion(ParametroDistribucion selectParametroDistribucion) {
        this.selectParametroDistribucion = selectParametroDistribucion;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
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
     * @return the arregloTemp
     */
    public List<Integer> getArregloTemp() {
        return arregloTemp;
    }

    /**
     * @param arregloTemp the arregloTemp to set
     */
    public void setArregloTemp(List<Integer> arregloTemp) {
        this.arregloTemp = arregloTemp;
    }

    /**
     * @return the parametroOrdenamiento
     */
    public String getParametroOrdenamiento() {
        return parametroOrdenamiento;
    }

    /**
     * @param parametroOrdenamiento the parametroOrdenamiento to set
     */
    public void setParametroOrdenamiento(String parametroOrdenamiento) {
        this.parametroOrdenamiento = parametroOrdenamiento;
    }

    /**
     * @return the listDistribucionNivel
     */
    public List<Multitabla> getListDistribucionNivel() {
        return listDistribucionNivel;
    }

    /**
     * @param listDistribucionNivel the listDistribucionNivel to set
     */
    public void setListDistribucionNivel(List<Multitabla> listDistribucionNivel) {
        this.listDistribucionNivel = listDistribucionNivel;
    }

    /**
     * @return the listNivel
     */
    public List<DistribucionNivel> getListNivel() {
        return listNivel;
    }

    /**
     * @param listNivel the listNivel to set
     */
    public void setListNivel(List<DistribucionNivel> listNivel) {
        this.listNivel = listNivel;
    }

    /**
     * @return the botonAsignacionNivel
     */
    public boolean isBotonAsignacionNivel() {
        return botonAsignacionNivel;
    }

    /**
     * @param botonAsignacionNivel the botonAsignacionNivel to set
     */
    public void setBotonAsignacionNivel(boolean botonAsignacionNivel) {
        this.botonAsignacionNivel = botonAsignacionNivel;
    }

    /**
     * @return the serviceMultitabla
     */
    public MultitablaService getServiceMultitabla() {
        return serviceMultitabla;
    }

    /**
     * @param serviceMultitabla the serviceMultitabla to set
     */
    public void setServiceMultitabla(MultitablaService serviceMultitabla) {
        this.serviceMultitabla = serviceMultitabla;
    }

    /**
     * @return the listDFormaUbicacion
     */
    public List<DFormaUbicacion> getListDFormaUbicacion() {
        return listDFormaUbicacion;
    }

    /**
     * @param listDFormaUbicacion the listDFormaUbicacion to set
     */
    public void setListDFormaUbicacion(List<DFormaUbicacion> listDFormaUbicacion) {
        this.listDFormaUbicacion = listDFormaUbicacion;
    }

    /**
     * @return the dFormaUbicacionService
     */
    public DFormaUbicacionService getdFormaUbicacionService() {
        return getDformaUbicacionService();
    }

    /**
     * @param dFormaUbicacionService the dFormaUbicacionService to set
     */
    public void setdFormaUbicacionService(DFormaUbicacionService dFormaUbicacionService) {
        this.setDformaUbicacionService(dFormaUbicacionService);
    }

    /**
     * @return the dformaUbicacionService
     */
    public DFormaUbicacionService getDformaUbicacionService() {
        return dformaUbicacionService;
    }

    /**
     * @param dformaUbicacionService the dformaUbicacionService to set
     */
    public void setDformaUbicacionService(DFormaUbicacionService dformaUbicacionService) {
        this.dformaUbicacionService = dformaUbicacionService;
    }

    /**
     * @return the selectDFormaUbicacion
     */
    public DFormaUbicacion getSelectDFormaUbicacion() {
        return selectDFormaUbicacion;
    }

    /**
     * @param selectDFormaUbicacion the selectDFormaUbicacion to set
     */
    public void setSelectDFormaUbicacion(DFormaUbicacion selectDFormaUbicacion) {
        this.selectDFormaUbicacion = selectDFormaUbicacion;
    }

    /**
     * @return the tipoDistribucion
     */
    public String getTipoDistribucion() {
        return tipoDistribucion;
    }

    /**
     * @param tipoDistribucion the tipoDistribucion to set
     */
    public void setTipoDistribucion(String tipoDistribucion) {
        this.tipoDistribucion = tipoDistribucion;
    }

    /**
     * @return the listSelectDFormaUbicacion
     */
    public List<DFormaUbicacion> getListSelectDFormaUbicacion() {
        return listSelectDFormaUbicacion;
    }

    /**
     * @param listSelectDFormaUbicacion the listSelectDFormaUbicacion to set
     */
    public void setListSelectDFormaUbicacion(List<DFormaUbicacion> listSelectDFormaUbicacion) {
        this.listSelectDFormaUbicacion = listSelectDFormaUbicacion;
    }

    /**
     * @return the CONTENIDO
     */
    public String getCONTENIDO() {
        return CONTENIDO;
    }

    /**
     * @param CONTENIDO the CONTENIDO to set
     */
    public void setCONTENIDO(String CONTENIDO) {
        this.CONTENIDO = CONTENIDO;
    }

    /**
     * @return the r_filas
     */
    public int getR_filas() {
        return r_filas;
    }

    /**
     * @param r_filas the r_filas to set
     */
    public void setR_filas(int r_filas) {
        this.r_filas = r_filas;
    }

    /**
     * @return the r_columnas
     */
    public int getR_columnas() {
        return r_columnas;
    }

    /**
     * @param r_columnas the r_columnas to set
     */
    public void setR_columnas(int r_columnas) {
        this.r_columnas = r_columnas;
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
     * @return the parametroNivel
     */
    public String getParametroNivel() {
        return parametroNivel;
    }

    /**
     * @param parametroNivel the parametroNivel to set
     */
    public void setParametroNivel(String parametroNivel) {
        this.parametroNivel = parametroNivel;
    }

    /**
     * @return the visibleGenerar
     */
    public boolean isVisibleGenerar() {
        return visibleGenerar;
    }

    /**
     * @param visibleGenerar the visibleGenerar to set
     */
    public void setVisibleGenerar(boolean visibleGenerar) {
        this.visibleGenerar = visibleGenerar;
    }

    /**
     * @return the visibleClonar
     */
    public boolean isVisibleClonar() {
        return visibleClonar;
    }

    /**
     * @param visibleClonar the visibleClonar to set
     */
    public void setVisibleClonar(boolean visibleClonar) {
        this.visibleClonar = visibleClonar;
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
     * @return the IDNFORMACIONUBICACION
     */
    public String getIDNFORMACIONUBICACION() {
        return IDNFORMACIONUBICACION;
    }

    /**
     * @param IDNFORMACIONUBICACION the IDNFORMACIONUBICACION to set
     */
    public void setIDNFORMACIONUBICACION(String IDNFORMACIONUBICACION) {
        this.IDNFORMACIONUBICACION = IDNFORMACIONUBICACION;
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
     * @return the selectFilaxColumna
     */
    public DNFormaUbicacion getSelectFilaxColumna() {
        return selectFilaxColumna;
    }

    /**
     * @param selectFilaxColumna the selectFilaxColumna to set
     */
    public void setSelectFilaxColumna(DNFormaUbicacion selectFilaxColumna) {
        this.selectFilaxColumna = selectFilaxColumna;
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
     * @return the listFormaUbicacion
     */
    public List<FormaUbicacion> getListFormaUbicacion() {
        return listFormaUbicacion;
    }

    /**
     * @param listFormaUbicacion the listFormaUbicacion to set
     */
    public void setListFormaUbicacion(List<FormaUbicacion> listFormaUbicacion) {
        this.listFormaUbicacion = listFormaUbicacion;
    }

    /**
     * @return the formaUbicacionService
     */
    public FormaUbicacionService getFormaUbicacionService() {
        return formaUbicacionService;
    }

    /**
     * @param formaUbicacionService the formaUbicacionService to set
     */
    public void setFormaUbicacionService(FormaUbicacionService formaUbicacionService) {
        this.formaUbicacionService = formaUbicacionService;
    }

    /**
     * @return the selectFormaUbicacion
     */
    public FormaUbicacion getSelectFormaUbicacion() {
        return selectFormaUbicacion;
    }

    /**
     * @param selectFormaUbicacion the selectFormaUbicacion to set
     */
    public void setSelectFormaUbicacion(FormaUbicacion selectFormaUbicacion) {
        this.selectFormaUbicacion = selectFormaUbicacion;
    }

    /**
     * @return the listSelectFormaUbicacion
     */
    public List<FormaUbicacion> getListSelectFormaUbicacion() {
        return listSelectFormaUbicacion;
    }

    /**
     * @param listSelectFormaUbicacion the listSelectFormaUbicacion to set
     */
    public void setListSelectFormaUbicacion(List<FormaUbicacion> listSelectFormaUbicacion) {
        this.listSelectFormaUbicacion = listSelectFormaUbicacion;
    }

    /**
     * @return the listDDFormaUbicacion
     */
    public List<DDFormaUbicacion> getListDDFormaUbicacion() {
        return listDDFormaUbicacion;
    }

    /**
     * @param listDDFormaUbicacion the listDDFormaUbicacion to set
     */
    public void setListDDFormaUbicacion(List<DDFormaUbicacion> listDDFormaUbicacion) {
        this.listDDFormaUbicacion = listDDFormaUbicacion;
    }

    /**
     * @return the dDformaUbicacionService
     */
    public DDFormaUbicacionService getdDformaUbicacionService() {
        return dDformaUbicacionService;
    }

    /**
     * @param dDformaUbicacionService the dDformaUbicacionService to set
     */
    public void setdDformaUbicacionService(DDFormaUbicacionService dDformaUbicacionService) {
        this.dDformaUbicacionService = dDformaUbicacionService;
    }

    /**
     * @return the selectDDFormaUbicacion
     */
    public DDFormaUbicacion getSelectDDFormaUbicacion() {
        return selectDDFormaUbicacion;
    }

    /**
     * @param selectDDFormaUbicacion the selectDDFormaUbicacion to set
     */
    public void setSelectDDFormaUbicacion(DDFormaUbicacion selectDDFormaUbicacion) {
        this.selectDDFormaUbicacion = selectDDFormaUbicacion;
    }

    /**
     * @return the listSelectDDFormaUbicacion
     */
    public List<DDFormaUbicacion> getListSelectDDFormaUbicacion() {
        return listSelectDDFormaUbicacion;
    }

    /**
     * @param listSelectDDFormaUbicacion the listSelectDDFormaUbicacion to set
     */
    public void setListSelectDDFormaUbicacion(List<DDFormaUbicacion> listSelectDDFormaUbicacion) {
        this.listSelectDDFormaUbicacion = listSelectDDFormaUbicacion;
    }
}
