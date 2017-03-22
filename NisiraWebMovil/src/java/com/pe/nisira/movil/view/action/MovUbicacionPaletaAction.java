/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.nisira.core.dao.PaletaDao;
import com.nisira.core.entity.*;
import com.nisira.core.service.MovUbicacionPaletaService;
import com.nisira.core.dao.MovUbicacionPaletaDao;
import com.nisira.core.service.FechaCampanaAnualService;
import com.nisira.core.service.PrivilegiosService;
import com.nisira.core.service.UbicacionCamaraService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.*;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Victor Zavala LLanos
 */
@ManagedBean(name = "MovUbicacionPaletaAction")
@ViewScoped
public class MovUbicacionPaletaAction implements Serializable {
    
    private String idempresa;
    private String iniciar;
    private String mensaje;
    private String estiloMensaje;
    private String numeroPaletaBuscarCamara;
    private String numeroPaletaBuscarTunel;
    private String numeroPaletaBuscar;
    private String informacionUbicacionActual;
    private Integer filas_camaras_racks;
    private Integer columnas_camaras_racks;
    private UbicacionCamaraBean ubicacioncamaraNuevo;
    private MovUbicacionPaletaBean movubicacionpaletaUbicacionActual;
    private List<MovUbicacionPaletaBean> listamovubicacionpaletaNuevo;
    private Columna columnaseleccionadareporte;

    private Integer indiceAccordeon = null;
    private Boolean habilitarAccordeon = false;
    private Boolean habilitarNuevaUbicacion = false;
    private Boolean habilitarGrabar = false;
    
    private String numeroUbicacionCamaraBuscar;
    
    private MovUbicacionPaletaService movubicacionpaletaService;
    private UbicacionCamaraService ubicacioncamaraService;
    private FechaCampanaAnualService fechacampanaanualService;
    private MovUbicacionPaletaDao ubicacioncamaraDao;
    
    private ArrayList<FechaCampanaAnual> lista_fechacampanaanual;
    public HashMap<String, String> hashmap_fechacampanaanual;
    
    private String color;
    private String menuapro;
    private int contador;
    private Boolean ubicacion_apta;
    
    private Paleta paletagrabar;
    
    private Integer numerofilas;
    private Integer numerocolumnas;
    private String idfechacampanaanual;
    
    //----------------------------
    private ArrayList<DistribucionUbicacionBean> listadistribucion_total = new ArrayList<DistribucionUbicacionBean>();
    private ArrayList<DistribucionUbicacionBean> listadistribucion_por_rack_piso = new ArrayList<DistribucionUbicacionBean>();
    private String idCamaraFiltro;
    private String idPisoFiltro;
    private Date fechafiltro;
    
    private DistribucionUbicacion distribucionUbicacion;
    private ArrayList<Columna> columnas_ubicacionpaletadistribucion;
    private ArrayList<FilasDistribucion> listado_filasdistribucion;
    
    public MovUbicacionPaletaAction() {        
        this.idempresa = ConstantesBD.getIDEMPRESA();
        this.ubicacioncamaraNuevo = null;
        this.movubicacionpaletaUbicacionActual = new MovUbicacionPaletaBean();
        this.mensaje = "";
        this.menuapro = "";
        this.informacionUbicacionActual = "";
        this.estiloMensaje = Constantes.ESTILO_MENSAJE_VACIO;        
        this.listamovubicacionpaletaNuevo = new ArrayList<MovUbicacionPaletaBean>();
        this.movubicacionpaletaService = new MovUbicacionPaletaService();
        this.numeroUbicacionCamaraBuscar = "";
        this.numerofilas = 1;
        this.numerocolumnas = 1;
        try{
            FacesContext facesContext = FacesContext. getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            Map params = externalContext.getRequestParameterMap();
            String cbarra = (String)params.get("cbarra");
            if(cbarra!=""){
                Constantes.cbarra=cbarra;
            }
        }catch(Exception ex){
            
        }
                
    }
    
    public void buscarUbicaciondeCamara(){
        try {
            MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
            this.mensaje = "";
            if (numeroUbicacionCamaraBuscar.length()==0){                
                this.mensaje="Ingresar ubicacion en Camara";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            if (numeroUbicacionCamaraBuscar.length()>15){                
                this.mensaje="La ubicacion debe tener maximo 15 caracteres";
                numeroUbicacionCamaraBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            UbicacionCamara ubicacionCamara= null;
            try{
                ubicacionCamara = ubicacioncamaraService.findByIdUbicacionCamara(idempresa, numeroUbicacionCamaraBuscar.trim());
            }
            catch (Exception e)
            {
                this.mensaje = "Error al buscar Ubicacion en Camara: "+e.toString();
                this.numeroUbicacionCamaraBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            if(ubicacionCamara==null)
            {
                this.mensaje = "La ubicacion :"+numeroUbicacionCamaraBuscar.trim().toUpperCase()+" no existe";
                this.numeroUbicacionCamaraBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            else
            {            
                if (ubicacionCamara.getTipocamara().trim().compareTo("F")==0 || ubicacionCamara.getTipocamara().trim().compareTo("T")==0)
                {
                    
                    ubicacion_apta = true;
                    ubicacioncamaraNuevo = new UbicacionCamaraBean();
                    
                    ubicacioncamaraNuevo.setIdempresa(ubicacionCamara.getIdempresa());
                    ubicacioncamaraNuevo.setIdcamara(ubicacionCamara.getIdcamara());
                    ubicacioncamaraNuevo.setDesccamara(ubicacionCamara.getDesccamara());
                    ubicacioncamaraNuevo.setNombrecortocamara(ubicacionCamara.getNombrecortocamara());
                    ubicacioncamaraNuevo.setTipocamara(ubicacionCamara.getTipocamara());
                    ubicacioncamaraNuevo.setIdubicacion(ubicacionCamara.getIdubicacion());
                    ubicacioncamaraNuevo.setTipoubicacion(ubicacionCamara.getTipoubicacion());                    
                    
                    this.mensaje = "ubicacion correcta";
                    RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                    RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                    return;
                    
                }
                else{
                    mensaje = "La ubicacion :"+numeroUbicacionCamaraBuscar+", no pertenece a una CAMARA DE FRIO o A UN TUNEL";
                    RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                    RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                    return;
                }
            }
        } catch (Exception ex) {                    
            this.mensaje=ex.toString();            
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
            return;
        }
    }
    
    public void buscaUbicacionPaleta() {
        try {
            this.informacionUbicacionActual = "";
            this.indiceAccordeon = null;
            this.habilitarNuevaUbicacion = false;
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblbuscarubicacion");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                        
            MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
            this.mensaje = "";
            if (numeroPaletaBuscar.length()==0){                
                mensaje="Ingresar el numero de Paleta";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            if (numeroPaletaBuscar.length()>20){                
                mensaje="El numero de Paleta debe tener 20 caracteres";
                numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            Paleta paleta = null;
            try{
                paleta = new PaletaDao().findByNroPaleta(idempresa,numeroPaletaBuscar.trim());
            }
            catch (Exception e)
            {
                mensaje = "Error al buscar paleta: "+e.toString();
                numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            if(paleta==null)
            {
                this.mensaje = "No existe PALETA registrada con el NUMERO :"+numeroPaletaBuscar.trim().toUpperCase();
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            else
            {       
                paletagrabar = paleta;
                this.movubicacionpaletaUbicacionActual = new MovUbicacionPaletaBean();
                movubicacionpaleta = movubicacionpaletaService.findUltimoMovUbicacionPaletaByNroPaleta(idempresa,numeroPaletaBuscar);

                if (movubicacionpaleta != null)
                {                
                    this.movubicacionpaletaUbicacionActual.setIdempresa(movubicacionpaleta.getIdempresa());
                    this.movubicacionpaletaUbicacionActual.setNropaleta(movubicacionpaleta.getNropaleta());
                    this.movubicacionpaletaUbicacionActual.setTipoubicacion(movubicacionpaleta.getTipoubicacion());
                    this.movubicacionpaletaUbicacionActual.setIdubicacion(movubicacionpaleta.getIdubicacion());
                    this.movubicacionpaletaUbicacionActual.setIdcliente(movubicacionpaleta.getIdcliente());
                    this.movubicacionpaletaUbicacionActual.setIdmotivo(movubicacionpaleta.getIdmotivo());
                    this.movubicacionpaletaUbicacionActual.setFactor(movubicacionpaleta.getFactor());
                    this.movubicacionpaletaUbicacionActual.setIdproducto(movubicacionpaleta.getIdproducto());
                    this.movubicacionpaletaUbicacionActual.setCantidad(movubicacionpaleta.getCantidad());
                    this.movubicacionpaletaUbicacionActual.setIdenvase(movubicacionpaleta.getIdenvase());
                    this.movubicacionpaletaUbicacionActual.setIdproductor(movubicacionpaleta.getIdproductor());                
                    this.movubicacionpaletaUbicacionActual.setIdlotep(movubicacionpaleta.getIdlotep());
                    this.movubicacionpaletaUbicacionActual.setObservacion(movubicacionpaleta.getObservacion());
                    this.movubicacionpaletaUbicacionActual.setDescubicacion(movubicacionpaleta.getDescubicacion());
                    this.movubicacionpaletaUbicacionActual.setDesccliente(movubicacionpaleta.getDesccliente());
                    this.movubicacionpaletaUbicacionActual.setDescvariedad(movubicacionpaleta.getDescvariedad());
                    this.movubicacionpaletaUbicacionActual.setDescenvase(movubicacionpaleta.getDescenvase());
                    this.movubicacionpaletaUbicacionActual.setDesccategorias(movubicacionpaleta.getDesccategorias());
                    this.movubicacionpaletaUbicacionActual.setDesccalibres(movubicacionpaleta.getDesccalibres());
                    
                    StringBuilder informacion_paleta = new StringBuilder();

                    if(this.movubicacionpaletaUbicacionActual.getIdubicacion() == null)
                    {
                        informacion_paleta.append("UBICACION: " +
                                //"\t\t"+this.movubicacionpaletaUbicacionActual.getDescubicacion()+"\n");
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescubicacion()+"\n");
                        informacion_paleta.append("N° PALLET: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getNropaleta()+"\n");
                        informacion_paleta.append("CLIENTE:   " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccliente()+"\n");
                        informacion_paleta.append("VARIEDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescvariedad()+"\n");
                        informacion_paleta.append("ENVASE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescenvase()+"\n");
                        informacion_paleta.append("CATEGORIAS: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccategorias()+"\n");
                        informacion_paleta.append("CALIBRES: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccalibres()+"\n");
                        informacion_paleta.append("CANTIDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getCantidad()+"\n");
                        informacion_paleta.append("OBSERVACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getObservacion()+"\n");

                        this.informacionUbicacionActual = informacion_paleta.toString();
                        this.indiceAccordeon = 0;
                        this.habilitarNuevaUbicacion = true;
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblbuscarubicacion");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                        RequestContext.getCurrentInstance().execute("setFocus('nroubicacioncamara');");
                        return;
                    }
                    else
                    {
                        informacion_paleta.append("UBICACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescubicacion()+"\n");
                        informacion_paleta.append("N° PALLET: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getNropaleta()+"\n");
                        informacion_paleta.append("CLIENTE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccliente()+"\n");
                        informacion_paleta.append("VARIEDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescvariedad()+"\n");
                        informacion_paleta.append("ENVASE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescenvase()+"\n");
                        informacion_paleta.append("CATEGORIAS: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccategorias()+"\n");
                        informacion_paleta.append("CALIBRES: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccalibres()+"\n");
                        informacion_paleta.append("CANTIDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getCantidad()+"\n");
                        informacion_paleta.append("OBSERVACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getObservacion()+"\n");

                        this.informacionUbicacionActual = informacion_paleta.toString();
                        this.indiceAccordeon = 0;
                        this.habilitarNuevaUbicacion = true;
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblbuscarubicacion");
                        RequestContext.getCurrentInstance().execute("setFocus('nroubicacioncamara');");
                        return;
                    }
                }   
                else
                {
                    this.mensaje="La paleta no tiene ubicacion";
                    RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                    RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                    return;
                }
            }
        } catch (Exception ex) {                    
            mensaje=ex.toString();            
            numeroPaletaBuscar = "";
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
            return;
        }
    }

    public void buscaUbicacionPaleta2() {
        try {
            this.informacionUbicacionActual = "";
            this.indiceAccordeon = null;
            this.habilitarNuevaUbicacion = false;
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
            
            
            MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
            this.mensaje = "";
            if (numeroPaletaBuscar.length()==0){                
                this.mensaje="Ingresar el numero de Paleta";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            if (numeroPaletaBuscar.length()>20){                
                this.mensaje="El numero de Paleta debe tener 20 caracteres";
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }            
            Paleta paleta = null;
            try{
                paleta = new PaletaDao().findByNroPaleta(idempresa,numeroPaletaBuscar.trim());
            }
            catch (Exception e)
            {
                this.mensaje = "Error al buscar paleta: "+e.toString();
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            if(paleta==null)
            {
                this.mensaje = "No existe PALETA registrada con el NUMERO :"+numeroPaletaBuscar.trim().toUpperCase();
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            else
            {       
                paletagrabar = paleta;
                this.movubicacionpaletaUbicacionActual = new MovUbicacionPaletaBean();
                movubicacionpaleta = movubicacionpaletaService.findUltimoMovUbicacionPaletaByNroPaleta(idempresa,numeroPaletaBuscar);

                if (movubicacionpaleta != null)
                {                
                    this.movubicacionpaletaUbicacionActual.setIdempresa(movubicacionpaleta.getIdempresa());
                    this.movubicacionpaletaUbicacionActual.setNropaleta(movubicacionpaleta.getNropaleta());
                    this.movubicacionpaletaUbicacionActual.setTipoubicacion(movubicacionpaleta.getTipoubicacion());
                    this.movubicacionpaletaUbicacionActual.setIdubicacion(movubicacionpaleta.getIdubicacion());
                    this.movubicacionpaletaUbicacionActual.setIdcliente(movubicacionpaleta.getIdcliente());
                    this.movubicacionpaletaUbicacionActual.setIdmotivo(movubicacionpaleta.getIdmotivo());
                    this.movubicacionpaletaUbicacionActual.setFactor(movubicacionpaleta.getFactor());
                    this.movubicacionpaletaUbicacionActual.setIdproducto(movubicacionpaleta.getIdproducto());
                    this.movubicacionpaletaUbicacionActual.setCantidad(movubicacionpaleta.getCantidad());
                    this.movubicacionpaletaUbicacionActual.setIdenvase(movubicacionpaleta.getIdenvase());
                    this.movubicacionpaletaUbicacionActual.setIdproductor(movubicacionpaleta.getIdproductor());                
                    this.movubicacionpaletaUbicacionActual.setIdlotep(movubicacionpaleta.getIdlotep());
                    this.movubicacionpaletaUbicacionActual.setObservacion(movubicacionpaleta.getObservacion());
                    this.movubicacionpaletaUbicacionActual.setDescubicacion(movubicacionpaleta.getDescubicacion());
                    this.movubicacionpaletaUbicacionActual.setDesccliente(movubicacionpaleta.getDesccliente());
                    this.movubicacionpaletaUbicacionActual.setDescvariedad(movubicacionpaleta.getDescvariedad());
                    this.movubicacionpaletaUbicacionActual.setDescenvase(movubicacionpaleta.getDescenvase());
                    this.movubicacionpaletaUbicacionActual.setDesccategorias(movubicacionpaleta.getDesccategorias());
                    this.movubicacionpaletaUbicacionActual.setDesccalibres(movubicacionpaleta.getDesccalibres());
                    
                    StringBuilder informacion_paleta = new StringBuilder();

                    if(this.movubicacionpaletaUbicacionActual.getIdubicacion() == null)
                    {
                        informacion_paleta.append("UBICACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescubicacion()+"\n");
                        informacion_paleta.append("N° PALLET: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getNropaleta()+"\n");
                        informacion_paleta.append("CLIENTE:   " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccliente()+"\n");
                        informacion_paleta.append("VARIEDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescvariedad()+"\n");
                        informacion_paleta.append("ENVASE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescenvase()+"\n");
                        informacion_paleta.append("CATEGORIAS: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccategorias()+"\n");
                        informacion_paleta.append("CALIBRES: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccalibres()+"\n");
                        informacion_paleta.append("CANTIDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getCantidad()+"\n");
                        informacion_paleta.append("OBSERVACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getObservacion()+"\n");

                        this.informacionUbicacionActual = informacion_paleta.toString();
                        this.indiceAccordeon = 0;
                        this.habilitarNuevaUbicacion = true;
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                        
                        return;
                    }
                    else
                    {
                        informacion_paleta.append("UBICACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescubicacion()+"\n");
                        informacion_paleta.append("N° PALLET: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getNropaleta()+"\n");
                        informacion_paleta.append("CLIENTE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccliente()+"\n");
                        informacion_paleta.append("VARIEDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescvariedad()+"\n");
                        informacion_paleta.append("ENVASE: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDescenvase()+"\n");
                        informacion_paleta.append("CATEGORIAS: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccategorias()+"\n");
                        informacion_paleta.append("CALIBRES: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getDesccalibres()+"\n");
                        informacion_paleta.append("CANTIDAD: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getCantidad()+"\n");
                        informacion_paleta.append("OBSERVACION: " +
                                "\t\t"+this.movubicacionpaletaUbicacionActual.getObservacion()+"\n");

                        this.informacionUbicacionActual = informacion_paleta.toString();
                        this.indiceAccordeon = 0;
                        this.habilitarNuevaUbicacion = true;
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                        RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                        return;
                    }
                }   
                else
                {
                    this.mensaje="La paleta no tiene ubicacion";
                    RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                    RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                    return;
                }
            }
        } catch (Exception ex) {                    
            this.mensaje=ex.toString();            
            this.numeroPaletaBuscar = "";
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
            return;
        }
    }
    
    public void grabarPaletUbicacionCamara(){
        String validar = "";
        validar = ValidarMovUbicacionPaleta();
        if(validar.trim().length()==0)
        {
            ArrayList<MovUbicacionPaleta> lista_movimientos = new ArrayList<MovUbicacionPaleta>();
            if (ubicacioncamaraNuevo.getIdubicacion() == null )
            {
                MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
                movubicacionpaleta.setIdempresa(idempresa);
                movubicacionpaleta.setNropaleta(paletagrabar.getNropaleta());
                movubicacionpaleta.setTipoubicacion(ubicacioncamaraNuevo.getTipoubicacion());
                movubicacionpaleta.setIdubicacion(ubicacioncamaraNuevo.getIdubicacion());
                movubicacionpaleta.setIdpaleta(paletagrabar.getIdregistropaleta());
                movubicacionpaleta.setIdcliente(paletagrabar.getIdclieprov());
                movubicacionpaleta.setIdmotivo("INGRESO");
                movubicacionpaleta.setFactor(1);
                movubicacionpaleta.setIdproducto(paletagrabar.getIdproducto());
                movubicacionpaleta.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                movubicacionpaleta.setIdenvase(paletagrabar.getIdenvase());
                movubicacionpaleta.setIdproductor(paletagrabar.getIdproductor());
                movubicacionpaleta.setIdlotep(paletagrabar.getIdlotep());
                movubicacionpaleta.setObservacion(" INGRESO A CAMARA A LA UBICACION: " + ubicacioncamaraNuevo.getIdubicacion().toUpperCase());
                movubicacionpaleta.setIdusuario("001");

                lista_movimientos.add(movubicacionpaleta);
            }
            else
            {
                
                if (movubicacionpaletaUbicacionActual.getIdubicacion() !=null) // INDICA QUE QUIZAS TENGA ALGUNA UBICACION
                {
                    if (movubicacionpaletaUbicacionActual.getFactor() == 1)    //INDICA QUE LA PALETA ACTUALMENTE ESTA EN LA UBICACION INDICADA
                    {

                        MovUbicacionPaleta movubicacionpaleta1 = new MovUbicacionPaleta();
                        movubicacionpaleta1.setIdempresa(idempresa);
                        movubicacionpaleta1.setNropaleta(paletagrabar.getNropaleta());
                        movubicacionpaleta1.setTipoubicacion(movubicacionpaletaUbicacionActual.getTipoubicacion());
                        movubicacionpaleta1.setIdubicacion(movubicacionpaletaUbicacionActual.getIdubicacion());
                        movubicacionpaleta1.setIdpaleta(paletagrabar.getIdregistropaleta());
                        movubicacionpaleta1.setIdcliente(paletagrabar.getIdclieprov());
                        movubicacionpaleta1.setIdmotivo("SALIDA");
                        movubicacionpaleta1.setFactor(2);    // deberia ser -1 pero el json que se genera en sql no convierte calores negativos, alli al guardar se convierte en -1 en el SP sqlserver.
                        movubicacionpaleta1.setIdproducto(paletagrabar.getIdproducto());
                        movubicacionpaleta1.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                        movubicacionpaleta1.setIdenvase(paletagrabar.getIdenvase());
                        movubicacionpaleta1.setIdproductor(paletagrabar.getIdproductor());
                        movubicacionpaleta1.setIdlotep(paletagrabar.getIdlotep());
                        movubicacionpaleta1.setIdlotep(paletagrabar.getIdlotep());
                        movubicacionpaleta1.setObservacion("SALIDA DE UBICACION : " + movubicacionpaletaUbicacionActual.getIdubicacion() + " HACIA LA UBICACION" + ubicacioncamaraNuevo.getIdubicacion());
                        movubicacionpaleta1.setIdusuario("USUARIO");
                        lista_movimientos.add(movubicacionpaleta1);

                        MovUbicacionPaleta movubicacionpaleta2 = new MovUbicacionPaleta();
                        movubicacionpaleta2.setIdempresa(idempresa);
                        movubicacionpaleta2.setNropaleta(paletagrabar.getNropaleta());
                        movubicacionpaleta2.setTipoubicacion(ubicacioncamaraNuevo.getTipoubicacion());
                        movubicacionpaleta2.setIdubicacion(ubicacioncamaraNuevo.getIdubicacion());
                        movubicacionpaleta2.setIdpaleta(paletagrabar.getIdregistropaleta());
                        movubicacionpaleta2.setIdcliente(paletagrabar.getIdclieprov());
                        movubicacionpaleta2.setIdmotivo("INGRESO");
                        movubicacionpaleta2.setFactor(1);
                        movubicacionpaleta2.setIdproducto(paletagrabar.getIdproducto());
                        movubicacionpaleta2.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                        movubicacionpaleta2.setIdenvase(paletagrabar.getIdenvase());
                        movubicacionpaleta2.setIdproductor(paletagrabar.getIdproductor());
                        movubicacionpaleta2.setIdlotep(paletagrabar.getIdlotep());
                        movubicacionpaleta2.setObservacion("INGRESO A UBICACION: "+ubicacioncamaraNuevo.getIdubicacion());
                        movubicacionpaleta2.setIdusuario("IDUSUARIO");

                        lista_movimientos.add(movubicacionpaleta2);

                    }
                    else   ////INDICA QUE LA PALETA ACTUALMENTE NO ESTA EN NIGUNA UBICACION
                    {
                        MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
                        movubicacionpaleta.setIdempresa(idempresa);
                        movubicacionpaleta.setNropaleta(paletagrabar.getNropaleta());
                        movubicacionpaleta.setTipoubicacion(ubicacioncamaraNuevo.getTipoubicacion());
                        movubicacionpaleta.setIdubicacion(ubicacioncamaraNuevo.getIdubicacion());
                        movubicacionpaleta.setIdpaleta(paletagrabar.getIdregistropaleta());
                        movubicacionpaleta.setIdcliente(paletagrabar.getIdclieprov());
                        movubicacionpaleta.setIdmotivo("INGRESO");
                        movubicacionpaleta.setFactor(1);
                        movubicacionpaleta.setIdproducto(paletagrabar.getIdproducto());
                        movubicacionpaleta.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                        movubicacionpaleta.setIdenvase(paletagrabar.getIdenvase());
                        movubicacionpaleta.setIdproductor(paletagrabar.getIdproductor());
                        movubicacionpaleta.setIdlotep(paletagrabar.getIdlotep());
                        movubicacionpaleta.setObservacion("INGRESO A UBICACION: "+ubicacioncamaraNuevo.getIdubicacion());
                        movubicacionpaleta.setIdusuario("usuario");

                        lista_movimientos.add(movubicacionpaleta);
                    }
                }
                 else
                {
                    MovUbicacionPaleta movubicacionpaleta = new MovUbicacionPaleta();
                    movubicacionpaleta.setIdempresa(idempresa);
                    movubicacionpaleta.setNropaleta(paletagrabar.getNropaleta());
                    movubicacionpaleta.setTipoubicacion(ubicacioncamaraNuevo.getTipoubicacion());
                    movubicacionpaleta.setIdubicacion(ubicacioncamaraNuevo.getIdubicacion());
                    movubicacionpaleta.setIdpaleta(paletagrabar.getIdregistropaleta());
                    movubicacionpaleta.setIdcliente(paletagrabar.getIdclieprov());
                    movubicacionpaleta.setIdmotivo("INGRESO");
                    movubicacionpaleta.setFactor(1);
                    movubicacionpaleta.setIdproducto(paletagrabar.getIdproducto());
                    movubicacionpaleta.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                    movubicacionpaleta.setIdenvase(paletagrabar.getIdenvase());
                    movubicacionpaleta.setIdproductor(paletagrabar.getIdproductor());
                    movubicacionpaleta.setIdlotep(paletagrabar.getIdlotep());
                    movubicacionpaleta.setObservacion("INGRESO A UBICACION: "+ubicacioncamaraNuevo.getIdubicacion());
                    movubicacionpaleta.setIdusuario("usuario");

                    lista_movimientos.add(movubicacionpaleta);
                }
            }


            String resultado = "";
            resultado = grabarMovimientoUbicacion(lista_movimientos,movubicacionpaletaUbicacionActual.getIdubicacion()==null? "" : movubicacionpaletaUbicacionActual.getIdubicacion(),ubicacioncamaraNuevo.getIdubicacion(),paletagrabar.getNropaleta());

            if(resultado.trim().compareTo("OK")==0)
            {                
                this.mensaje="SE GUARDO CORRECTAMENTE";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                //vazll
                this.informacionUbicacionActual = "";
                this.indiceAccordeon = null;
                this.habilitarNuevaUbicacion = false;
                this.numeroUbicacionCamaraBuscar="";
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblbuscarubicacion");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nroubicacioncamara");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().execute("setFocus('page1:Formmovubicacionpaleta:nropaleta')");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:idfocus");
                return;
            }
            else
            {
                this.mensaje=resultado;
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
        }
        else
        {
            this.mensaje=validar;
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");            
            return;
        }
    }
    
    
    public void grabarPaletSacarUbicacionCamara(){
        String validar = "";
        validar = ValidarMovUbicacionPaleta2();
        if(validar.trim().length()==0)
        {
            ArrayList<MovUbicacionPaleta> lista_movimientos = new ArrayList<MovUbicacionPaleta>();
            if (movubicacionpaletaUbicacionActual.getIdubicacion() == null )
            {
                this.mensaje="La Pallet ingresada no puede realizar una salida, porque no tiene ubicacion actual";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
            else
            {
                if (movubicacionpaletaUbicacionActual.getFactor() == 1)    //INDICA QUE LA PALETA ACTUALMENTE ESTA EN LA UBICACION INDICADA
                {

                    MovUbicacionPaleta movubicacionpaleta1 = new MovUbicacionPaleta();
                    movubicacionpaleta1.setIdempresa(idempresa);
                    movubicacionpaleta1.setNropaleta(paletagrabar.getNropaleta());
                    movubicacionpaleta1.setTipoubicacion(movubicacionpaletaUbicacionActual.getTipoubicacion());
                    movubicacionpaleta1.setIdubicacion(movubicacionpaletaUbicacionActual.getIdubicacion());
                    movubicacionpaleta1.setIdpaleta(paletagrabar.getIdregistropaleta());
                    movubicacionpaleta1.setIdcliente(paletagrabar.getIdclieprov());
                    movubicacionpaleta1.setIdmotivo("SALIDA");
                    movubicacionpaleta1.setFactor(2);    // deberia ser -1 pero el json que se genera en sql no convierte calores negativos, alli al guardar se convierte en -1 en el SP sqlserver.
                    movubicacionpaleta1.setIdproducto(paletagrabar.getIdproducto());
                    movubicacionpaleta1.setCantidad(Double.parseDouble(paletagrabar.getCantidad()));
                    movubicacionpaleta1.setIdenvase(paletagrabar.getIdenvase());
                    movubicacionpaleta1.setIdproductor(paletagrabar.getIdproductor());
                    movubicacionpaleta1.setIdlotep(paletagrabar.getIdlotep());
                    movubicacionpaleta1.setIdlotep(paletagrabar.getIdlotep());
                    movubicacionpaleta1.setObservacion("SALIDA DE UBICACION : " + movubicacionpaletaUbicacionActual.getIdubicacion());
                    movubicacionpaleta1.setIdusuario("USUARIO");
                    lista_movimientos.add(movubicacionpaleta1);

                }
                else   ////INDICA QUE LA PALETA ACTUALMENTE NO ESTA EN NIGUNA UBICACION
                {                    
                    this.mensaje="La Pallet ingresada no puede realizar una salida, porque no tiene ubicacion actual";
                    RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                    RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                    return;
                }
            }


            String resultado = "";
            resultado = grabarMovimientoUbicacion(lista_movimientos,movubicacionpaletaUbicacionActual.getIdubicacion()==null? "" : movubicacionpaletaUbicacionActual.getIdubicacion(),"",paletagrabar.getNropaleta());

            if(resultado.trim().compareTo("OK")==0)
            {                
                this.mensaje="SE GUARDO CORRECTAMENTE";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                //vazll
                this.informacionUbicacionActual = "";
                this.indiceAccordeon = null;
                this.habilitarNuevaUbicacion = false;
                this.numeroUbicacionCamaraBuscar="";
                this.numeroPaletaBuscar = "";
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:txtubicacionpaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:accordionubicacionpaleta");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:nropaleta");
                RequestContext.getCurrentInstance().execute("setFocus('page1:Formmovubicacionpaleta:nropaleta')");
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:idfocus");
                return;
            }
            else
            {
                this.mensaje=resultado;
                RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                return;
            }
        }
        else
        {
            this.mensaje=validar;
            RequestContext.getCurrentInstance().update("page1:Formmovubicacionpaleta:lblmensaje");
            RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");            
            return;
        }
    }
    
     public String  ValidarMovUbicacionPaleta(){
        String mensaje_error ="";

        if(numeroPaletaBuscar.toString().trim().length()==0){
            mensaje_error="Ingresar Paleta";
            return mensaje_error;
        }
        if(numeroUbicacionCamaraBuscar.toString().trim().length()==0){
            mensaje_error="Ingresar Nueva Ubicacion";
            return mensaje_error;
        }
        return mensaje_error;
    }
     
     public String  ValidarMovUbicacionPaleta2(){
        String mensaje_error ="";

        if(numeroPaletaBuscar.toString().trim().length()==0){
            mensaje_error="Ingresar Paleta";
            return mensaje_error;
        }
        
        return mensaje_error;
    }
    
    public String getIniciar() {        
        this.listamovubicacionpaletaNuevo = new ArrayList<MovUbicacionPaletaBean>();
        this.hashmap_fechacampanaanual = new HashMap<String, String>();
        this.ubicacioncamaraNuevo = null;
        this.paletagrabar = null;
        
        this.movubicacionpaletaUbicacionActual = new MovUbicacionPaletaBean();        
        this.ubicacioncamaraService = new UbicacionCamaraService();
        this.mensaje = "";
        this.numeroPaletaBuscar=Constantes.cbarra;
        this.informacionUbicacionActual="";
        this.numeroUbicacionCamaraBuscar= "";
        this.estiloMensaje = Constantes.ESTILO_MENSAJE_VACIO;
        this.ubicacion_apta = false;        
        
        this.indiceAccordeon = null;
        this.habilitarNuevaUbicacion = false;
        this.habilitarGrabar = false;
        RequestContext.getCurrentInstance().execute("setFocus('page1:Formmovubicacionpaleta:nropaleta')");
        return iniciar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

 
    public void setMenuapro(String aprobar) {
        this.menuapro = aprobar;
    }
    
    public String getNumeroPaletaBuscar() {
        return numeroPaletaBuscar;
    }

    public void setNumeroPaletaBuscar(String numeroPaletaBuscar) {
        this.numeroPaletaBuscar = numeroPaletaBuscar;
    }

    public String getInformacionUbicacionActual() {
        return informacionUbicacionActual;
    }

    public void setInformacionUbicacionActual(String informacionUbicacionActual) {
        this.informacionUbicacionActual = informacionUbicacionActual;
    }

    public String getNumeroUbicacionCamaraBuscar() {
        return numeroUbicacionCamaraBuscar;
    }

    public void setNumeroUbicacionCamaraBuscar(String numeroUbicacionCamaraBuscar) {
        this.numeroUbicacionCamaraBuscar = numeroUbicacionCamaraBuscar;
    }
    
    public void verdatosPaleta(Columna columnareporte){     
        if(columnareporte.getIdubicacion().trim().compareTo("")>0)
        {   
            this.columnaseleccionadareporte = columnareporte;
            RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:dlgpaleta1");            
            RequestContext.getCurrentInstance().execute("PF('dlgpaleta').show()");
        }       
    }
    public void IniciarDistribucion(){        
        this.mensaje = "";
        
        this.hashmap_fechacampanaanual = new HashMap<String, String>();
        this.distribucionUbicacion = null;
        this.columnaseleccionadareporte = new Columna();
        this.numerofilas = 1;
        this.numerocolumnas = 1;
        this.listadistribucion_total = new ArrayList<DistribucionUbicacionBean>();
        this.ubicacioncamaraDao = new MovUbicacionPaletaDao();
        this.columnas_ubicacionpaletadistribucion = new ArrayList<Columna>();
        this.listado_filasdistribucion = new ArrayList<FilasDistribucion>();
        this.numeroPaletaBuscarCamara = "";
        this.fechacampanaanualService = new FechaCampanaAnualService();
        try{
            lista_fechacampanaanual = fechacampanaanualService.findByEmpresa(ConstantesBD.IDEMPRESA);
            
            
            hashmap_fechacampanaanual  = new HashMap<String, String>();
            for(FechaCampanaAnual f : lista_fechacampanaanual){
                hashmap_fechacampanaanual.put(f.getDescripcion(),f.getIdfecha());
            }
            this.idfechacampanaanual = "nada";
            RequestContext.getCurrentInstance().update("page1:cbofechacampanaanual");
        }catch(Exception e){
            
        }
    }
    public void getdistribucionUbicacion(){
        try {  
            this.idCamaraFiltro = "C02";
            this.fechafiltro = new Date(2015, 07, 01);
            this.distribucionUbicacion = this.movubicacionpaletaService.getDistribucionUbicacionByCamara(idempresa,idCamaraFiltro,fechafiltro);           
        }
        catch (Exception e)
        {
            String mensaje = e.toString();
        }
    }
    
    public void buscarPaletaEnDistribuciondeCamara(){    
        try{
            if (idfechacampanaanual.equals("nada")) {                
                this.mensaje = "Seleccione una Campaña";
                RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:dlgmensaje1");
                RequestContext.getCurrentInstance().execute("PF('dlgmensaje').show()");
                
                return;
            }
            
            this.columnas_ubicacionpaletadistribucion = new ArrayList<Columna>();
            Date fecha = new Date(2015, 11,1 );
            this.columnas_ubicacionpaletadistribucion = ubicacioncamaraDao.getDistribucionCamaraByNroPaleta(idempresa,numeroPaletaBuscarCamara,fecha,"F",idfechacampanaanual);
            listado_filasdistribucion = new ArrayList<FilasDistribucion>();
                
            this.numerofilas = 1;
            this.numerocolumnas = 1;
            
            if(this.columnas_ubicacionpaletadistribucion.size()>0){
                
                this.numerofilas = this.columnas_ubicacionpaletadistribucion.get(0).getNrofilas();
                this.numerocolumnas = this.columnas_ubicacionpaletadistribucion.get(0).getNrocolumnas()+1;
                
                FilasDistribucion f = new FilasDistribucion();
                ArrayList<Columna> lista_c = new ArrayList<Columna>();
                for(int i=0;i<columnas_ubicacionpaletadistribucion.size();i++)
                {   
                    Columna c = columnas_ubicacionpaletadistribucion.get(i);
                    if (i % numerocolumnas ==0 && i>0)
                    {
                        f.setLista_columnas(lista_c);
                        f.setDesccamara(c.getDesccamara());
                        f.setDescpiso(c.getIdpiso());
                        f.setDescrack(c.getIdrack());
                        listado_filasdistribucion.add(f);
                        f = new FilasDistribucion();
                        lista_c = new ArrayList<Columna>();                        
                    }
                    lista_c.add(c);
                }                
                f.setLista_columnas(lista_c);
                listado_filasdistribucion.add(f);
            }
            
            RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:accordionResultado");
            RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:txttitulobusqueda1");            
            RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:columnas:txttitulobusqueda2");
            RequestContext.getCurrentInstance().update("page1:FormDistribucioncamara:columnas");
        }
        catch (Exception e)
        {
            String mensaje = e.toString();
        }    
    }
    public void buscarPaletaEnDistribuciondeCamara_1(){    
        try{
            this.columnas_ubicacionpaletadistribucion = new ArrayList<Columna>();
            Date fecha = new Date(2015, 11,1 );
            this.columnas_ubicacionpaletadistribucion = ubicacioncamaraDao.getDistribucionCamaraByNroPaleta(idempresa,numeroPaletaBuscar,fecha,"F",idfechacampanaanual);
            
            if(this.columnas_ubicacionpaletadistribucion.size()>0){
                
                this.numerofilas = this.columnas_ubicacionpaletadistribucion.get(0).getNrofilas();
                this.numerocolumnas = this.columnas_ubicacionpaletadistribucion.get(0).getNrocolumnas();
                
            }
        }
        catch (Exception e)
        {
            String mensaje = e.toString();
        }    
    }
    
    public void buscarPaletaEnDistribuciondeTunel(){    
        try{
            this.columnas_ubicacionpaletadistribucion = new ArrayList<Columna>();
            Date fecha = new Date(2015, 11,1 );
            this.columnas_ubicacionpaletadistribucion = ubicacioncamaraDao.getDistribucionCamaraByNroPaleta(idempresa,numeroPaletaBuscarTunel,fecha,"T",idfechacampanaanual);
            
            if(this.columnas_ubicacionpaletadistribucion.size()>0){                
                this.numerofilas = this.columnas_ubicacionpaletadistribucion.get(0).getNrofilas();
                this.numerocolumnas = this.columnas_ubicacionpaletadistribucion.get(0).getNrocolumnas();
            }
        }
        catch (Exception e)
        {
            String mensaje = e.toString();
        }    
    }
    
    public ArrayList<Rack> getRacks(){
        return this.distribucionUbicacion.getListaracks();
    }
    
    public ArrayList<Fila> getFilasByNroPaleta(){
        this.numeroPaletaBuscar="YAU0101222";
        ArrayList<Fila> lista_filas = new ArrayList<Fila>();
        Columna columnaseleccionada = null;
        for(Columna columna : this.distribucionUbicacion.getListacolumnas_total()){
            if(columna.getNropaleta().trim().toUpperCase().compareTo(this.numeroPaletaBuscar.trim().toUpperCase())==0){
                columnaseleccionada  = columna;
                break;
            }
        }
        if(columnaseleccionada != null){
            Rack rackseleccionado = null;
            for(Rack rack : this.distribucionUbicacion.getListaracks()){
                if(rack.getIdrack().trim().toUpperCase().compareTo(columnaseleccionada.getIdrack().trim().toUpperCase())==0){
                   rackseleccionado = rack;
                   break;
                }        
            }
            Pisos pisoseleccionado = null;
            for(Pisos piso : rackseleccionado.getListapisos()){
                if(piso.getIdpiso().trim().toUpperCase().compareTo(columnaseleccionada.getIdpiso().trim().toUpperCase())==0){
                   pisoseleccionado = piso;
                   break;
                }        
            }
            
            if(pisoseleccionado != null){
                lista_filas = pisoseleccionado.getListafilas();
            }
        }
        return lista_filas;
    }
    
  
  
    public String grabarMovimientoUbicacion(ArrayList<MovUbicacionPaleta> lista_movimientos,String idubicacion_actual,String idubicacion_nueva,String nropaleta){
        try {            
            /*
            String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";

            XStream xStream_tg30 = new XStream();
            xStream_tg30.processAnnotations(MovUbicacionPaleta.class);
            String  XMLMovUbicacionPaleta =xml + xStream_tg30.toXML(lista_movimientos);
            */
            String JSONMovUbicacionPaleta = null;
            Gson gson = new Gson();
            JSONMovUbicacionPaleta = gson.toJson(lista_movimientos);

            String respuesta =  this.movubicacionpaletaService.grabarMovUbicacionByPaleta(idempresa,JSONMovUbicacionPaleta,idubicacion_actual,idubicacion_nueva,nropaleta);
            return  respuesta;

        }
        catch (Exception e)
        {
            return e.toString();
        }
    }

    public Boolean getHabilitarAccordeon() {
        return this.habilitarAccordeon;
    }

    public void setHabilitarAccordeon(Boolean habilitarAccordeon) {
        this.habilitarAccordeon = habilitarAccordeon;
    }

    public Boolean getHabilitarNuevaUbicacion() {
        return this.habilitarNuevaUbicacion;
    }

    public void setHabilitarNuevaUbicacion(Boolean habilitarNuevaUbicacion) {
        this.habilitarNuevaUbicacion = habilitarNuevaUbicacion;
    }

    public Boolean getHabilitarGrabar() {
        return this.habilitarGrabar;
    }

    public void setHabilitarGrabar(Boolean habilitarGrabar) {
        this.habilitarGrabar = habilitarGrabar;
    }

    public Integer getIndiceAccordeon() {
        return this.indiceAccordeon;
    }

    public void setIndiceAccordeon(Integer indiceAccordeon) {
        this.indiceAccordeon = indiceAccordeon;
    }
    
    

    public Integer getColumnas_camaras_racks() {
        return columnas_camaras_racks;
    }

    public void setColumnas_camaras_racks(Integer columnas_camaras_racks) {
        this.columnas_camaras_racks = columnas_camaras_racks;
    }

    public Integer getFilas_camaras_racks() {
        return filas_camaras_racks;
    }

    public void setFilas_camaras_racks(Integer filas_camaras_racks) {
        this.filas_camaras_racks = filas_camaras_racks;
    }
      
    
    public String getIdCamaraFiltro() {
        return idCamaraFiltro;
    }

    public void setIdCamaraFiltro(String idCamaraFiltro) {
        this.idCamaraFiltro = idCamaraFiltro;
    }

    public String getIdPisoFiltro() {
        return idPisoFiltro;
    }

    public void setIdPisoFiltro(String idPisoFiltro) {
        this.idPisoFiltro = idPisoFiltro;
    }

    public Date getFechafiltro() {
        return fechafiltro;
    }

    public void setFechafiltro(Date fechafiltro) {
        this.fechafiltro = fechafiltro;
    }

    public DistribucionUbicacion getDistribucionUbicacion() {
        return distribucionUbicacion;
    }

    public void setDistribucionUbicacion(DistribucionUbicacion distribucionUbicacion) {
        this.distribucionUbicacion = distribucionUbicacion;
    }

    

    public ArrayList<Columna> getColumnas_ubicacionpaletadistribucion() {
        return columnas_ubicacionpaletadistribucion;
    }

    public void setColumnas_ubicacionpaletadistribucion(ArrayList<Columna> columnas_ubicacionpaletadistribucion) {
        this.columnas_ubicacionpaletadistribucion = columnas_ubicacionpaletadistribucion;
    }

    public MovUbicacionPaletaDao getUbicacioncamaraDao() {
        return ubicacioncamaraDao;
    }

    public void setUbicacioncamaraDao(MovUbicacionPaletaDao ubicacioncamaraDao) {
        this.ubicacioncamaraDao = ubicacioncamaraDao;
    }

    public Integer getNumerofilas() {
        return numerofilas;
    }

    public void setNumerofilas(Integer numerofilas) {
        this.numerofilas = numerofilas;
    }

    public Columna getColumnaseleccionadareporte() {
        return columnaseleccionadareporte;
    }

    public void setColumnaseleccionadareporte(Columna columnaseleccionadareporte) {
        this.columnaseleccionadareporte = columnaseleccionadareporte;
    }

    public Integer getNumerocolumnas() {
        return numerocolumnas;
    }

    public void setNumerocolumnas(Integer numerocolumnas) {
        this.numerocolumnas = numerocolumnas;
    }

    public String getNumeroPaletaBuscarCamara() {
        return numeroPaletaBuscarCamara;
    }

    public void setNumeroPaletaBuscarCamara(String numeroPaletaBuscarCamara) {
        this.numeroPaletaBuscarCamara = numeroPaletaBuscarCamara;
    }

    public String getNumeroPaletaBuscarTunel() {
        return numeroPaletaBuscarTunel;
    }

    public void setNumeroPaletaBuscarTunel(String numeroPaletaBuscarTunel) {
        this.numeroPaletaBuscarTunel = numeroPaletaBuscarTunel;
    }

    public ArrayList<FilasDistribucion> getListado_filasdistribucion() {
        return listado_filasdistribucion;
    }

    public void setListado_filasdistribucion(ArrayList<FilasDistribucion> listado_filasdistribucion) {
        this.listado_filasdistribucion = listado_filasdistribucion;
    }

    public FechaCampanaAnualService getFechacampanaanualService() {
        return fechacampanaanualService;
    }

    public void setFechacampanaanualService(FechaCampanaAnualService fechacampanaanualService) {
        this.fechacampanaanualService = fechacampanaanualService;
    }

    public ArrayList<FechaCampanaAnual> getLista_fechacampanaanual() {
        return lista_fechacampanaanual;
    }

    public void setLista_fechacampanaanual(ArrayList<FechaCampanaAnual> lista_fechacampanaanual) {
        this.lista_fechacampanaanual = lista_fechacampanaanual;
    }

    public String getIdfechacampanaanual() {
        return idfechacampanaanual;
    }

    public void setIdfechacampanaanual(String idfechacampanaanual) {
        this.idfechacampanaanual = idfechacampanaanual;
    }

    public HashMap<String, String> getHashmap_fechacampanaanual() {
        return hashmap_fechacampanaanual;
    }

    public void setHashmap_fechacampanaanual(HashMap<String, String> hashmap_fechacampanaanual) {
        this.hashmap_fechacampanaanual = hashmap_fechacampanaanual;
    }

    
}
