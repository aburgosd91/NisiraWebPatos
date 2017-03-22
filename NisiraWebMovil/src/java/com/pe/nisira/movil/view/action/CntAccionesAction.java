/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AccionesDao;
import com.nisira.core.entity.Acciones;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "cntAccionesAction")
@ViewScoped
public class CntAccionesAction implements Serializable{
    private List<Acciones> datos;
    @PostConstruct
    public void init() {
        AccionesDao ac = new AccionesDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(ac.findAll(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntAccionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Acciones t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Acciones> getDatos() {
        return datos;
    }

    public void setDatos(List<Acciones> datos) {
        this.datos = datos;
    }
}
