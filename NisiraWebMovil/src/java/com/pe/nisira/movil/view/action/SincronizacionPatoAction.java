/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.util.Encryption;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author azamora
 */
@ManagedBean
@ViewScoped
public class SincronizacionPatoAction {

    private String json;
    private String xml="";
    private String cadena;
    private int tablas;
    private String mensaje;
    private Map<String, String> parameterHTML;
    private ExternalContext externalContext;

    public SincronizacionPatoAction() {
        try {
            /*TOMAR DATOS DE URL*/
            externalContext = FacesContext.getCurrentInstance().getExternalContext();
            parameterHTML = (Map<String, String>) externalContext.getRequestParameterMap();
            /*DEFINICION DE DATOS*/
            cadena = "";
            /*ASIGNAR VALORS*/
            cadena = URLDecoder.decode(Encryption.decrypt(parameterHTML.get("xml") != null ? parameterHTML.get("xml") : ""));
            tablas = Integer.parseInt(Encryption.decrypt(parameterHTML.get("tabla") != null ? parameterHTML.get("tabla") : "0"));
            Administrador(cadena,tablas);
            if(cadena !=""){
                xml=cadena;
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void Administrador(String xml,int tablas) throws ClassNotFoundException{
        
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }
    
}
