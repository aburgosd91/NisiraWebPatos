/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DProgAlmMontacargaDao;
import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.Montacarga;
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
@ManagedBean(name = "cntMontacargaAction")
@ViewScoped
public class CntMontacargaAction {
    private List<Montacarga> datos;
    @PostConstruct
    public void init() {
        MontacargaDao rd= new MontacargaDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.findAll(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntOperarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Montacarga t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Montacarga> getDatos() {
        return datos;
    }

    public void setDatos(List<Montacarga> datos) {
        this.datos = datos;
    }
}
