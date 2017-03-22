/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ResponsableDao;
import com.nisira.core.entity.Responsable;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
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
@ManagedBean(name = "cntResponsableAction")
@ViewScoped
public class CntResponsableAction {
    private List<Responsable> datos;
    @PostConstruct
    public void init() {
        ResponsableDao rd= new ResponsableDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.findAll(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntOperarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Responsable t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Responsable> getDatos() {
        return datos;
    }

    public void setDatos(List<Responsable> datos) {
        this.datos = datos;
    }
}