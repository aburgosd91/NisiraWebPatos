/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;


import com.nisira.core.dao.ReglasDao;
import com.nisira.core.entity.Reglas;
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
@ManagedBean(name = "cntRegla")
@ViewScoped
public class CntRegla {
    private List<Reglas> datos;
    @PostConstruct
    public void init() {
        ReglasDao op = new ReglasDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(op.findReglas(Integer.parseInt(u.getIDEMPRESA())));
        } catch (Exception ex) {
            Logger.getLogger(CntOperarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Reglas t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Reglas> getDatos() {
        return datos;
    }

    public void setDatos(List<Reglas> datos) {
        this.datos = datos;
    }
}