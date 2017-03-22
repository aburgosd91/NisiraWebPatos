/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DGeneracionCodigoDao;
import com.nisira.core.dao.GeneracionCodigoDao;
import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.core.entity.GeneracionCodigo;
import com.nisira.core.entity.SincronizacionInicial;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author aburgos
 */
@ManagedBean
@ViewScoped
public class SincronizacionDGeneracionCodigoAction {
    
    /**
     * VARIABLES
     */
    private List<DGeneracionCodigo> listDGeneracionCodigo;
    private String json;
    private String xml;
    private String cadena;
    private int idempresa;
    private int idsucursal;
    private String mensaje;
    private Map<String, String> parameterHTML;
    private ExternalContext externalContext;
    public SincronizacionDGeneracionCodigoAction() {
        try{
            /*TOMAR DATOS DE URL*/
            externalContext = FacesContext.getCurrentInstance().getExternalContext();
            parameterHTML = (Map<String, String>)externalContext.getRequestParameterMap();
            /*DEFINICION DE DATOS*/
            cadena = "";
            /*ASIGNAR VALORS*/
            idempresa=Integer.parseInt(parameterHTML.get("idempresa"));
            /*LLENADO DE DATOS*/
            getDGeneracionCodigo();
            /*ENVIAR DATOS*/
            Constantes.TIPOSINCRO = CoreUtil.valoresBase().get(5);
            if(Constantes.TIPOSINCRO.equals("1")){//XML
                cadena = (WebUtil.XmlToString("com.nisira.core.entity.DGeneracionCodigo",listDGeneracionCodigo));
            }
            else{//JSON
                cadena=WebUtil.convertObjectJSon(listDGeneracionCodigo);
            }
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
        
    }
    /*METODOS A GENERAR*/
    public void getDGeneracionCodigo(){
        try{
            setListDGeneracionCodigo((new DGeneracionCodigoDao()).findAll(idempresa));
        }catch(Exception ex){
            this.setMensaje(ex.toString());
            return;
        }
    }

    public String getJson() {
        return json;
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

    public List<DGeneracionCodigo> getListDGeneracionCodigo() {
        return listDGeneracionCodigo;
    }

    public void setListDGeneracionCodigo(List<DGeneracionCodigo> listDGeneracionCodigo) {
        this.listDGeneracionCodigo = listDGeneracionCodigo;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }
    
}
