/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Operario;
import com.nisira.core.service.OperarioService;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "cntVistaAction")
@ViewScoped
public class CntVistaAction implements Serializable{
    private List<String> listVista;
    @PostConstruct
    public void init() {
        try {
            setDatos(llenarCatalogo());
        } catch (Exception ex) {
            Logger.getLogger(CntVistaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(String t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<String> getDatos() {
        return listVista;
    }

    public void setDatos(List<String> datos) {
        this.listVista = datos;
    }
    public List<String> llenarCatalogo() throws Exception{
        List<String> lista=new ArrayList<String>();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        lista.add((String) servletContext.getRealPath("sistema"));
//        lista.add((String) servletContext.getRealPath("sistema/ubiccamara"));
        return Constantes.catalagoXHTML(lista);
    }
}
