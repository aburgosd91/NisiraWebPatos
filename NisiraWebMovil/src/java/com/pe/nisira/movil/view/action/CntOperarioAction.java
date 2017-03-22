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
@ManagedBean(name = "cntOperarioAction")
@ViewScoped
public class CntOperarioAction implements Serializable{
    private List<Operario> datos;
    @PostConstruct
    public void init() {
        OperarioService op = new OperarioService();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(op.filtrar(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntOperarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Operario t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Operario> getDatos() {
        return datos;
    }

    public void setDatos(List<Operario> datos) {
        this.datos = datos;
    }
}
