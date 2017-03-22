/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DALMACEN_DISTRIBUCIONUBICACIONDAO;
import com.nisira.core.dao.DAlmacenDiagramaDAO;
import com.nisira.core.dao.DAlmacenDiagramaUbicacionDao;
import com.nisira.core.dao.DAlmacen_ColumnasDao;
import com.nisira.core.dao.DAlmacen_FilasDao;
import com.nisira.core.dao.DAlmacen_PisosDao;
import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.dao.DDNFormaUbicacionDao;
import com.nisira.core.dao.DDProgramacionalmprioridadDao;
import com.nisira.core.dao.DFormaUbicacionDao;
import com.nisira.core.dao.DGeneracionCodigoDao;
import com.nisira.core.dao.DMontacargaEquipoDao;
import com.nisira.core.dao.DMontacargaOperarioDao;
import com.nisira.core.dao.DNForma_UbicacionDao;
import com.nisira.core.dao.DPROGRAMAALMEJECUCIONDao;
import com.nisira.core.dao.DPROGRAMAALMMONTACARGANOTIFICACIONDao;
import com.nisira.core.dao.DProgAlmMontacargaDao;
import com.nisira.core.dao.DZonaAccesorioDao;
import com.nisira.core.dao.DZonaAlmacenDao;
import com.nisira.core.dao.DZonaDiagramaDao;
import com.nisira.core.dao.DZonaDiagramaUbicacionDao;
import com.nisira.core.dao.DZonaGeneralDao;
import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.dao.DprogAlmPrioridadDao;
import com.nisira.core.dao.FormaUbicacionDao;
import com.nisira.core.dao.GeneracionCodigoDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.dao.MotivoDao;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.dao.PackingDao;
import com.nisira.core.dao.PaletaDao;
import com.nisira.core.dao.ParametrosDao;
import com.nisira.core.dao.ProgramaAlmDao;
import com.nisira.core.dao.PuertoDestinoDao;
import com.nisira.core.dao.ReglasDao;
import com.nisira.core.dao.ResponsableDao;
import com.nisira.core.dao.SincronizaDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.dao.ZonaDao;
import com.nisira.core.dao.ZonaGeneralDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.CONFIGTABLASINCRO;
import com.nisira.core.entity.DALMACEN_DISTRIBUCIONUBICACION;
import com.nisira.core.entity.DAlmacenDiagrama;
import com.nisira.core.entity.DAlmacenDiagramaUbicacion;
import com.nisira.core.entity.DAlmacen_Columnas;
import com.nisira.core.entity.DAlmacen_Filas;
import com.nisira.core.entity.DAlmacen_Pisos;
import com.nisira.core.entity.DAlmacen_Racks;
import com.nisira.core.entity.DDNFormaUbicacion;
import com.nisira.core.entity.DDProgramacionalmprioridad;
import com.nisira.core.entity.DFormaUbicacion;
import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.core.entity.DMontacargaEquipo;
import com.nisira.core.entity.DMontacargaOperario;
import com.nisira.core.entity.DNFormaUbicacion;
import com.nisira.core.entity.DPROGRAMAALMEJECUCION;
import com.nisira.core.entity.DPROGRAMAALMMONTACARGANOTIFICACION;
import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.core.entity.DZonaAlmacen;
import com.nisira.core.entity.DZonaDiagrama;
import com.nisira.core.entity.DZonaDiagramaUbicacion;
import com.nisira.core.entity.DZonaGeneral;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.DprogAlmPrioridad;
import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.FormaUbicacion;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.Montacarga;
import com.nisira.core.entity.Motivo;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Packing;
import com.nisira.core.entity.Paleta;
import com.nisira.core.entity.ParametroDistribucion;
import com.nisira.core.entity.Parametros;
import com.nisira.core.entity.ProgramaAlm;
import com.nisira.core.entity.PuertoDestino;
import com.nisira.core.entity.Reglas;
import com.nisira.core.entity.Responsable;
import com.nisira.core.entity.SincronizacionInicial;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.entity.TablaSincroniza;
import com.nisira.core.entity.TipoZona;
import com.nisira.core.entity.Zona;
import com.nisira.core.entity.ZonaGeneral;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import com.nisira.core.util.Encryption;
import com.pe.nisira.movil.view.util.Constantes;
import static com.pe.nisira.movil.view.util.Encryption.decrypt;
import com.pe.nisira.movil.view.util.WebUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;
/**
 *
 * @author aburgos
 */
@ManagedBean
@ViewScoped
public class SincronizacionAction {
    /**
     * VARIABLES
     */
    /***************************************TABLA ESTRUCTURA************************************/
    private List<CONFIGTABLASINCRO> listConf;
    private List<TablaSincroniza> listTablaSincroniza;
    /*ORDENAMIENTO POR TABLAS*/
    private List<Almacen> listAlmacen;                                                                                      
    private List<DAlmacen_Columnas> listDAlmacen_Columnas;                                                                  
    private List<DAlmacen_Filas> listDAlmacen_Filas;                                                                       
    private List<DAlmacen_Pisos> listDAlmacen_Pisos;                                                                       
    private List<DAlmacen_Racks> listDAlmacen_Racks;                                                                        
    private List<DAlmacenDiagrama> listDAlmacenDiagrama;                                                                    
    private List<DAlmacenDiagramaUbicacion> listDAlmacenDiagramaUbicacion;                                                                                                                      //(6)
    private List<DMontacargaEquipo> listDMontacargaEquipo;                                                                  
    private List<DMontacargaOperario> listDMontacargaOperario;                                                              
    private List<Documento> listDocumento;                                                                                  
    private List<DprogAlmMontacarga> listDprogAlmMontacarga; 
    private List<DZonaAccesorio> listDZonaAccesorio;
    private List<DZonaAlmacen> listDZonaAlmacen;
    private List<DZonaDiagrama> listDZonaDiagrama;
    private List<DZonaDiagramaUbicacion> listDZonaDiagramaUbicacion;
    private List<DZonaGeneral> listDZonaGeneral;
    private List<Montacarga> listMontacarga;
    private List<NumEmisor> listNumEmisor;
    private List<ParametroDistribucion> listParametroDistribucion;
    private List<Paleta> listPaleta;
    private List<Responsable> listResponsable;
    private List<Sucursal> listSucursales;
    private List<TipoZona> listTipoZona;
    private List<Zona> listZona;
    private List<ZonaGeneral> listZonaGeneral;
    /******************************GENERACION CODIGO*****************************************/
    private List<GeneracionCodigo> listGeneracionCodigo;
    /******************************DGENERACION CODIGO*****************************************/
    private List<DGeneracionCodigo> listDGeneracionCodigo;
    /**************************************************************************************/
    private String json;
    private String xml;
    private String cadena;
    private int idempresa;
    private int idsucursal;
    private String desde;
    private String hasta;
    private String nameTable;
    private int tablas;
    private int idmontacar;
    private String mensaje;
    private Map<String, String> parameterHTML;
    private ExternalContext externalContext;
    private Notificacion nota;
    public SincronizacionAction() {
        try{
            /*TOMAR DATOS DE URL*/
            externalContext = FacesContext.getCurrentInstance().getExternalContext();
            parameterHTML = (Map<String, String>)externalContext.getRequestParameterMap();
            /*DEFINICION DE DATOS*/
            cadena = "";
            /*ASIGNAR VALORS*/
            idempresa=Integer.parseInt(parameterHTML.get("idempresa")!=null?Encryption.decrypt(parameterHTML.get("idempresa")):"0");
            idsucursal=Integer.parseInt(parameterHTML.get("idsucursal")!=null?Encryption.decrypt(parameterHTML.get("idsucursal")):"0");
            desde = parameterHTML.get("desde")!=null?Encryption.decrypt(parameterHTML.get("desde")):"";
            hasta =parameterHTML.get("hasta")!=null? Encryption.decrypt(parameterHTML.get("hasta")):"";
            tablas = Integer.parseInt(parameterHTML.get("tabla")!=null?Encryption.decrypt(parameterHTML.get("tabla")):"0");
            idmontacar = Integer.parseInt(parameterHTML.get("idmontacarga")!=null?Encryption.decrypt(parameterHTML.get("idmontacarga")):"0");
            nameTable = parameterHTML.get("nametabla")!=null?Encryption.decrypt(parameterHTML.get("nametabla")):"";
            Administrador(tablas);
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
        
    }
    /******************ADMINISTRADOR*****************/
    public void SincronizarDatos() throws ClassNotFoundException, Exception{
        int PRETTY_PRINT_INDENT_FACTOR = 4;
        String xml=(new SincronizaDao()).getEstructura(nameTable,desde, hasta,idempresa,idsucursal);
        Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
        if(Constantes.TIPOSINCRO.equals("1")){//XML
            cadena=xml;
//          cadena=(WebUtil.XmlToString("com.nisira.core.entity.TablaSincroniza",listTablaSincroniza));
        }
        else{//JSON
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
            cadena =jsonPrettyPrintString;
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public void Administrador(int tablas) throws ClassNotFoundException, Exception{
        /*
            TABLAS
            (0)     ESTRUCTURA DE TABLAS DSINCRONIZA
            (1)     ALMACEN
            (2)     DGENERACIONCODIGO
            (3)     ZONA GENERAL
            (4)     DZONA GENERAL
            (5)     GENERACIONCODIGO
            (6)     DALMACEN_COLUMNAS
            (7)     DALMACEN_FILAS
            (8)     DALMACEN_PISOS
            (9)     DALMACEN_RACKS
            (10)    DALMACENDIAGRAMA
            (11)    DALMACENDIAGRAMAUBICACION
        */
        switch(tablas){
            case 0:cargarEstructuraSincronizado();break;
            default:SincronizarDatos();
//            case 1:cargarAlmacen();break;
//            case 7:cargarDAlmacen_Columnas(); break; // DALMACEN_COLUMNAS
//            case 8:cargarDalmDist(); break; //DALMACEN_DISTRIBUCIONUBICACION
//            case 9:cargarDAlmacen_Filas(); break; //DALMACEN_FILAS
//            case 10:cargarDAlmacen_Pisos(); break; //DALMACEN_PISOS
//            case 11:cargarDAlmacen_Raks(); break; //DALMACEN_RACKS
//            case 14: cargarDDNformaUbicacion();break; //DDNFORMAUBICACION
//            case 15:cargarDDprogalmPrio();break;
//            case 16: break; // DFORMAUBICACION
//            case 17:cargarDGeneracionCodigo();break;
//            case 20:cargarDNformaUbicacion();;break;
//            case 22:cargarDProggalmEjec();break;
//            case 23:cargarDprogalmMont();break;
//            case 24:cargarDprogNot(); break; 
//            case 25:cargarDprogalmPrio();break;
//            case 26:cargarDreglas();break;
//            case 28:cargarDZonaAccesorio(); break; //DZONAACCESORIO
//            case 29:cargarDZonaAlmacen(); break; //  DZONAALMACEN
//            case 30:cargarDZonaDiagrama(); break; //DZONADIAGRAMA
//            case 31:cargarDZonaDiagramaUbicacion(); break; //DZONADIAGRAMAUBICACION
//            case 32:cargarDZonaGeneral();break;
//            case 36:cargarGeneracionCodigo();break; 
//            case 35: break; //FORMAUBICACION
//            case 39:cargarMotivo(); break; 
//            case 40:cargarNotificacion();break; 
//            case 42:cargarPacking(); break; 
//            case 44:cargarParametro(); break;
//            case 46:cargaProgramaAlmc();break;
//            case 48:cargarPuerto(); break;
//            case 50:cargarReglas(); break;  
//            case 51:cargarResponsable();break;
//            case 62:cargarZona(); break; //ZONA
//            case 63:cargarZonaGeneral();break;
            
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    
    /****************METODOS A GENERAR**************/
    public void cargarZona(){
        try{
            listZona = new ArrayList<Zona>();
            setListZona((new ZonaDao()).sincronizarZona(idempresa,idsucursal,desde,hasta));
            if(getListZona().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Zona",listZona));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listZona));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarFormaUbi(){
        try{
            List<FormaUbicacion> lfu = new ArrayList<FormaUbicacion>();
            lfu=(new FormaUbicacionDao()).sincronizaFormUbi(idempresa,idsucursal,desde,hasta);
            if(lfu.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.FormaUbicacion",lfu));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(lfu));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDformaUbi(){
        try{
            List<DFormaUbicacion> lfu = new ArrayList<DFormaUbicacion>();
            lfu=(new DFormaUbicacionDao()).sincronizarDformaUbi(idempresa,idsucursal,desde,hasta);
            if(lfu.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DFormaUbicacion",lfu));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(lfu));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarAlmacen(){
        try{
            setListAlmacen((new AlmacenDao()).sincronizarAlmacen(idempresa,idsucursal,desde,hasta));
            if(getListAlmacen().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Almacen",listAlmacen));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listAlmacen));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacen_Columnas(){
        try{
            setListDAlmacen_Columnas((new DAlmacen_ColumnasDao()).sincronizarDAlmacen_Columnas(idempresa,idsucursal,desde,hasta));
            if(getListDAlmacen_Columnas().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacen_Columnas",listDAlmacen_Columnas));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacen_Columnas));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacen_Filas(){
        try{
            setListDAlmacen_Filas((new DAlmacen_FilasDao()).syncProgalm(idempresa,idsucursal,desde,hasta));
            if(getListDAlmacen_Filas().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacen_Filas",listDAlmacen_Filas));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacen_Filas));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacen_Pisos(){
        try{
            setListDAlmacen_Pisos((new DAlmacen_PisosDao()).syncDalmPisos(idempresa,idsucursal,desde,hasta));
            if(getListDAlmacen_Pisos().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacen_Pisos",listDAlmacen_Pisos));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacen_Pisos));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacen_Raks(){
        try{
            setListDAlmacen_Racks((new DAlmacen_RacksDao()).sincronizarDAlmacen_Racks(idempresa,idsucursal,desde,hasta));
            if(getListDAlmacen_Racks().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacen_Racks",listDAlmacen_Racks));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacen_Racks));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacenDiagrama(){
        try{
            setListDAlmacenDiagrama((new DAlmacenDiagramaDAO()).sincronizarDAlmacenDiagrama(idempresa,idsucursal));
            if(getListDAlmacenDiagrama().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacenDiagrama",listDAlmacenDiagrama));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacenDiagrama));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDAlmacenDiagramaUbicacion(){
        try{
            setListDAlmacenDiagramaUbicacion((new DAlmacenDiagramaUbicacionDao()).sincronizarDAlmacenDiagramaUbicacion(idempresa,idsucursal));
            if(getListDAlmacenDiagramaUbicacion().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DAlmacenDiagramaUbicacion",listDAlmacenDiagramaUbicacion));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDAlmacenDiagramaUbicacion));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDMontaCargaEquipo(){
        try{
            setListDMontacargaEquipo((new DMontacargaEquipoDao()).sincronizarDMontaCargaEquipo(idempresa));
            if(getListDMontacargaEquipo().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DMontacargaEquipo",listDMontacargaEquipo));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDMontacargaEquipo));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDMontacargaOperario(){
        try{
            setListDMontacargaOperario((new DMontacargaOperarioDao()).sincronizarDMontaCargaOperario(idempresa));
            if(getListDMontacargaOperario().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DMontacargaOperario",listDMontacargaOperario));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDMontacargaOperario));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDocumento(){
        try{
            setListDocumento((new DocumentoDao()).sincronizarDocumento(idempresa));
            if(getListDocumento().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Documento",listDocumento));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDocumento));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDPROGRAMAALMMONTACARGA(){
        try{
            setListDprogAlmMontacarga((new DProgAlmMontacargaDao()).sincronizarDProgAlmMontacarga(idempresa));
            if(getListDprogAlmMontacarga().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DProgAlmMontacarga",listDprogAlmMontacarga));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDprogAlmMontacarga));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDZonaAccesorio(){
        try{
            setListDZonaAccesorio((new DZonaAccesorioDao()).sincronizarDZonaAccesorio(idempresa,idsucursal,desde,hasta));
            if(getListDZonaAccesorio().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaAccesorio",listDZonaAccesorio));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDZonaAccesorio));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDZonaAlmacen(){
        try{
            setListDZonaAlmacen((new DZonaAlmacenDao()).sincronizarDZonaAlmacen(idempresa,idsucursal,desde,hasta));
            if(getListDZonaAlmacen().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaAlmacen",listDZonaAlmacen));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDZonaAlmacen));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDZonaDiagrama(){
        try{
            setListDZonaDiagrama((new DZonaDiagramaDao()).sincronizarDZonaDiagrama(idempresa,idsucursal,desde,hasta));
            if(getListDZonaDiagrama().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaDiagrama",listDZonaDiagrama));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDZonaDiagrama));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDZonaDiagramaUbicacion(){
        try{
            setListDZonaDiagramaUbicacion((new DZonaDiagramaUbicacionDao()).sincronizarDZonaDiagramaUbicacion(idempresa,idsucursal,desde,hasta));
            if(getListDZonaDiagramaUbicacion().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaDiagramaUbicacion",listDZonaDiagramaUbicacion));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDZonaDiagramaUbicacion));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarMontacarga(){
        try{
            setListMontacarga((new MontacargaDao()).sincronizarMontacarga(idempresa));
            if(getListMontacarga().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaDiagramaUbicacion",listMontacarga));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listMontacarga));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarNumEmisor(){
        try{
            setListNumEmisor((new NumEmisorDao()).sincronizarNumEmisor(idempresa,idsucursal));
            if(getListNumEmisor().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.NumEmisor",listNumEmisor));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listNumEmisor));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarPaleta(){
        try{
            setListPaleta((new PaletaDao()).sincronizarRegistroPaleta(idempresa,idsucursal,desde,hasta));
            if(getListPaleta().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Paleta",listPaleta));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listPaleta));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarResponsable(){
        try{
            setListResponsable((new ResponsableDao()).sincronizarResponsable(idempresa,idsucursal,desde,hasta));
            if(getListResponsable().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Responsable",listResponsable));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listResponsable));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarSucursal(){
        try{
            setListSucursales((new SucursalDao()).sincronizarSucursal(idempresa,desde,hasta));
            if(getListSucursales().size()>0){
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Sucursales",listSucursales));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listSucursales));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    /****************************************************************************************************************/
    public void cargarGeneracionCodigo(){
        try{
            setListGeneracionCodigo((new GeneracionCodigoDao()).SincroGenCodigo(idempresa,desde,hasta));
            if(getListGeneracionCodigo().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.GeneracionCodigo",listGeneracionCodigo));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listGeneracionCodigo));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDGeneracionCodigo(){
        try{
            setListDGeneracionCodigo((new DGeneracionCodigoDao()).SincDgencodigo(idempresa, desde, hasta));
            if(getListDGeneracionCodigo().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DGeneracionCodigo",listDGeneracionCodigo));
                }
                else{//JSON
                    cadena=WebUtil.convertObjectJSon(listDGeneracionCodigo);
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarZonaGeneral(){
        try{
            setListZonaGeneral((new ZonaGeneralDao()).findAllSincronizacion(idempresa,idsucursal,desde,hasta));
            if(getListZonaGeneral().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.ZonaGeneral",listZonaGeneral));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listZonaGeneral));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDZonaGeneral(){
        try{
            setListDZonaGeneral((new DZonaGeneralDao()).findAllSincronizacion(idempresa,idsucursal,desde,hasta));
            if(getListDZonaGeneral().size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DZonaGeneral",listDZonaGeneral));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDZonaGeneral));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    /**********************************************************************************/
    public void cargarEstructuraSincronizado(){
        try{
            listConf = (new SincronizaDao()).getEstructura(desde, hasta,idempresa);
            if(listConf.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.CONFIGTABLASINCRO",listConf));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listConf));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargaProgramaAlmc(){
        try{
            List<ProgramaAlm> listProgalm = (new ProgramaAlmDao()).syncProgalm(idempresa,idsucursal,desde,hasta);
            if(listProgalm.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.ProgramaAlm",listProgalm));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listProgalm));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void cargarDprogalmMont(){
        try{
            List<DprogAlmMontacarga> listDProgalm = (new DProgAlmMontacargaDao()).SyncDprogAlmMont(idempresa,desde,hasta);
            if(listDProgalm.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DprogAlmMontacarga",listDProgalm));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listDProgalm));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void cargarDprogalmPrio(){
        try{
            List<DprogAlmPrioridad> listProgalm = (new DprogAlmPrioridadDao()).syncDprogAlmPrio(idempresa,idsucursal,desde,hasta);
            if(listProgalm.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.DprogAlmPrioridad",listProgalm));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listProgalm));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    public String getJson() {
        return json;
    }
    public void cargarReglas(){
        try{
            List<Reglas> listProgalm = (new ReglasDao()).syncReglas(idempresa,desde,hasta);
            if(listProgalm.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Reglas",listProgalm));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listProgalm));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void cargarDreglas(){
        try{
            List<Dreglas> listProgalm = (new ReglasDao()).syncDReglas(idempresa,desde,hasta);
            if(listProgalm.size()>0){
               Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if(Constantes.TIPOSINCRO.equals("1")){//XML
                    cadena=(WebUtil.XmlToString("com.nisira.core.entity.Dreglas",listProgalm));
                }
                else{//JSON
                    cadena =(WebUtil.convertObjectJSon(listProgalm));
                } 
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void cargarDNformaUbicacion() {
        try {
            List<DNFormaUbicacion> listProgalm = (new DNForma_UbicacionDao()).syncDNforma(idempresa, idsucursal, desde, hasta);
            if (listProgalm.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DNFormaUbicacion", listProgalm));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(listProgalm));
                }
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void cargarDDNformaUbicacion() {
        try {
            List<DDNFormaUbicacion> listProgalm = (new DDNFormaUbicacionDao()).syncDDNformaU(idempresa, idsucursal, desde, hasta);
            if (listProgalm.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DDNFormaUbicacion", listProgalm));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(listProgalm));
                }
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void cargarDDprogalmPrio(){
        try {
            List<DDProgramacionalmprioridad> listProgalm = (new DDProgramacionalmprioridadDao()).syncDDprog(idempresa, idsucursal, desde, hasta);
            if (listProgalm.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DDProgramacionalmprioridad", listProgalm));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(listProgalm));
                }
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDProggalmEjec(){
        try {
            List<DPROGRAMAALMEJECUCION> listProgalm = (new DPROGRAMAALMEJECUCIONDao()).syncDprogalmejec(idempresa, idsucursal, desde, hasta);
            if (listProgalm.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DPROGRAMAALMEJECUCION", listProgalm));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(listProgalm));
                }
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarNotificacion(){
        try{
            List<Notificacion> lnot = (new DProgAlmMontacargaDao()).syncNotificacion(idempresa,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.Notificacion", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDprogNot(){
        try{
            List<DPROGRAMAALMMONTACARGANOTIFICACION> lnot = (new DPROGRAMAALMMONTACARGANOTIFICACIONDao()).syncDprogMont(idempresa,idsucursal,idmontacar,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DPROGRAMAALMMONTACARGANOTIFICACION", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarMotivo(){
        try{
            List<Motivo> lnot = (new MotivoDao()).Syncronizar(idempresa,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.Motivo", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarDalmDist(){
        try{
            List<DALMACEN_DISTRIBUCIONUBICACION> lnot = (new DALMACEN_DISTRIBUCIONUBICACIONDAO()).sincronizarDal_DistUbi(idempresa,idsucursal,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.DALMACEN_DISTRIBUCIONUBICACION", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarPacking(){
        try{
            List<Packing> lnot = (new PackingDao()).Syncronizar(idempresa,idsucursal,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.Packing", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarParametro(){
        try{
            List<Parametros> lnot = (new ParametrosDao()).Syncronizar(idempresa,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.Parametros", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    public void cargarPuerto(){
        try{
            List<PuertoDestino> lnot = (new PuertoDestinoDao()).Syncronizar(idempresa,desde, hasta);
            if (lnot.size() > 0) {
                Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
                if (Constantes.TIPOSINCRO.equals("1")) {//XML
                    cadena = (WebUtil.XmlToString("com.nisira.core.entity.PuertoDestino", lnot));
                } else {//JSON
                    cadena = (WebUtil.convertObjectJSon(lnot));
                }
            }
        }catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }
    
    public void setJson(String json) {
        this.json = json;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getParameterHTML() {
        return parameterHTML;
    }

    public void setParameterHTML(Map<String, String> parameterHTML) {
        this.parameterHTML = parameterHTML;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public List<GeneracionCodigo> getListGeneracionCodigo() {
        return listGeneracionCodigo;
    }

    public void setListGeneracionCodigo(List<GeneracionCodigo> listGeneracionCodigo) {
        this.listGeneracionCodigo = listGeneracionCodigo;
    }

    public int getTablas() {
        return tablas;
    }

    public void setTablas(int tablas) {
        this.tablas = tablas;
    }

    public List<DGeneracionCodigo> getListDGeneracionCodigo() {
        return listDGeneracionCodigo;
    }

    public void setListDGeneracionCodigo(List<DGeneracionCodigo> listDGeneracionCodigo) {
        this.listDGeneracionCodigo = listDGeneracionCodigo;
    }

    public List<ZonaGeneral> getListZonaGeneral() {
        return listZonaGeneral;
    }

    public void setListZonaGeneral(List<ZonaGeneral> listZonaGeneral) {
        this.listZonaGeneral = listZonaGeneral;
    }

    public List<DZonaGeneral> getListDZonaGeneral() {
        return listDZonaGeneral;
    }

    public void setListDZonaGeneral(List<DZonaGeneral> listDZonaGeneral) {
        this.listDZonaGeneral = listDZonaGeneral;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public List<TablaSincroniza> getListTablaSincroniza() {
        return listTablaSincroniza;
    }

    public void setListTablaSincroniza(List<TablaSincroniza> listTablaSincroniza) {
        this.listTablaSincroniza = listTablaSincroniza;
    }

    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    public List<DAlmacen_Columnas> getListDAlmacen_Columnas() {
        return listDAlmacen_Columnas;
    }

    public void setListDAlmacen_Columnas(List<DAlmacen_Columnas> listDAlmacen_Columnas) {
        this.listDAlmacen_Columnas = listDAlmacen_Columnas;
    }

    public List<DAlmacen_Filas> getListDAlmacen_Filas() {
        return listDAlmacen_Filas;
    }

    public void setListDAlmacen_Filas(List<DAlmacen_Filas> listDAlmacen_Filas) {
        this.listDAlmacen_Filas = listDAlmacen_Filas;
    }

    public List<DAlmacen_Pisos> getListDAlmacen_Pisos() {
        return listDAlmacen_Pisos;
    }

    public void setListDAlmacen_Pisos(List<DAlmacen_Pisos> listDAlmacen_Pisos) {
        this.listDAlmacen_Pisos = listDAlmacen_Pisos;
    }

    public List<DAlmacen_Racks> getListDAlmacen_Racks() {
        return listDAlmacen_Racks;
    }

    public void setListDAlmacen_Racks(List<DAlmacen_Racks> listDAlmacen_Racks) {
        this.listDAlmacen_Racks = listDAlmacen_Racks;
    }

    public List<DAlmacenDiagrama> getListDAlmacenDiagrama() {
        return listDAlmacenDiagrama;
    }

    public void setListDAlmacenDiagrama(List<DAlmacenDiagrama> listDAlmacenDiagrama) {
        this.listDAlmacenDiagrama = listDAlmacenDiagrama;
    }

    public List<DAlmacenDiagramaUbicacion> getListDAlmacenDiagramaUbicacion() {
        return listDAlmacenDiagramaUbicacion;
    }

    public void setListDAlmacenDiagramaUbicacion(List<DAlmacenDiagramaUbicacion> listDAlmacenDiagramaUbicacion) {
        this.listDAlmacenDiagramaUbicacion = listDAlmacenDiagramaUbicacion;
    }

    public List<DMontacargaEquipo> getListDMontacargaEquipo() {
        return listDMontacargaEquipo;
    }

    public void setListDMontacargaEquipo(List<DMontacargaEquipo> listDMontacargaEquipo) {
        this.listDMontacargaEquipo = listDMontacargaEquipo;
    }

    public List<DMontacargaOperario> getListDMontacargaOperario() {
        return listDMontacargaOperario;
    }

    public void setListDMontacargaOperario(List<DMontacargaOperario> listDMontacargaOperario) {
        this.listDMontacargaOperario = listDMontacargaOperario;
    }

    public List<Documento> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<Documento> listDocumento) {
        this.listDocumento = listDocumento;
    }

    public List<DprogAlmMontacarga> getListDprogAlmMontacarga() {
        return listDprogAlmMontacarga;
    }

    public void setListDprogAlmMontacarga(List<DprogAlmMontacarga> listDprogAlmMontacarga) {
        this.listDprogAlmMontacarga = listDprogAlmMontacarga;
    }

    public List<DZonaAccesorio> getListDZonaAccesorio() {
        return listDZonaAccesorio;
    }

    public void setListDZonaAccesorio(List<DZonaAccesorio> listDZonaAccesorio) {
        this.listDZonaAccesorio = listDZonaAccesorio;
    }

    public List<DZonaAlmacen> getListDZonaAlmacen() {
        return listDZonaAlmacen;
    }

    public void setListDZonaAlmacen(List<DZonaAlmacen> listDZonaAlmacen) {
        this.listDZonaAlmacen = listDZonaAlmacen;
    }

    public List<DZonaDiagrama> getListDZonaDiagrama() {
        return listDZonaDiagrama;
    }

    public void setListDZonaDiagrama(List<DZonaDiagrama> listDZonaDiagrama) {
        this.listDZonaDiagrama = listDZonaDiagrama;
    }

    public List<DZonaDiagramaUbicacion> getListDZonaDiagramaUbicacion() {
        return listDZonaDiagramaUbicacion;
    }

    public void setListDZonaDiagramaUbicacion(List<DZonaDiagramaUbicacion> listDZonaDiagramaUbicacion) {
        this.listDZonaDiagramaUbicacion = listDZonaDiagramaUbicacion;
    }

    public List<Montacarga> getListMontacarga() {
        return listMontacarga;
    }

    public void setListMontacarga(List<Montacarga> listMontacarga) {
        this.listMontacarga = listMontacarga;
    }

    public List<NumEmisor> getListNumEmisor() {
        return listNumEmisor;
    }

    public void setListNumEmisor(List<NumEmisor> listNumEmisor) {
        this.listNumEmisor = listNumEmisor;
    }

    public List<ParametroDistribucion> getListParametroDistribucion() {
        return listParametroDistribucion;
    }

    public void setListParametroDistribucion(List<ParametroDistribucion> listParametroDistribucion) {
        this.listParametroDistribucion = listParametroDistribucion;
    }

    public List<Paleta> getListPaleta() {
        return listPaleta;
    }

    public void setListPaleta(List<Paleta> listPaleta) {
        this.listPaleta = listPaleta;
    }

    public List<Responsable> getListResponsable() {
        return listResponsable;
    }

    public void setListResponsable(List<Responsable> listResponsable) {
        this.listResponsable = listResponsable;
    }

    public List<Sucursal> getListSucursales() {
        return listSucursales;
    }

    public void setListSucursales(List<Sucursal> listSucursales) {
        this.listSucursales = listSucursales;
    }

    public List<TipoZona> getListTipoZona() {
        return listTipoZona;
    }

    public void setListTipoZona(List<TipoZona> listTipoZona) {
        this.listTipoZona = listTipoZona;
    }

    public List<Zona> getListZona() {
        return listZona;
    }

    public void setListZona(List<Zona> listZona) {
        this.listZona = listZona;
    }

    public Notificacion getNota() {
        return nota;
    }

    public void setNota(Notificacion nota) {
        this.nota = nota;
    }
    
}
