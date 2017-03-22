/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.mSysFormularioDAO;
import com.nisira.core.entity.mSysFormulario;
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
@ManagedBean(name = "cntSysFormulariosAction")
@ViewScoped
public class CntSysFormulariosAction implements Serializable{
    private List<mSysFormulario> datos;
    @PostConstruct
    public void init() {
        mSysFormularioDAO sf = new mSysFormularioDAO();
        try {
            setDatos(sf.findAllFrm());
        } catch (Exception ex) {
            Logger.getLogger(CntSysFormulariosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(mSysFormulario t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<mSysFormulario> getDatos() {
        return datos;
    }

    public void setDatos(List<mSysFormulario> datos) {
        this.datos = datos;
    }
}
