/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.mSysFormularioDAO;
import com.nisira.core.entity.mSysFormulario;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "mSysFormularioAction")
@SessionScoped
public class mSysFormularioAction extends AbstactListAction<mSysFormulario> implements Serializable {

    private mSysFormularioDAO frmDao;
    private String mensaje;
    private boolean n;

    public mSysFormularioAction() {
        frmDao = new mSysFormularioDAO();
        mensaje = "";
        n = false;
        actualiza_ventana("wMnt_mSysFormulario");
    }

    @Override
    public void buscarTodo() {
        actualiza_ventana("wMnt_mSysFormulario");
        try {
            setListaDatos(frmDao.findAllFrm());
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        frmDao = new mSysFormularioDAO();
        mensaje = "";
        n = false;
        actualiza_ventana("wMnt_mSysFormulario");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new mSysFormulario());
        n = true;
    }

    @Override
    public void grabar() {
        try {
            if (n) {
                frmDao.grabarSysFrm(1, getDatoEdicion());

            } else {
                frmDao.grabarSysFrm(2, getDatoEdicion());
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }

    }

    @Override
    public void eliminar() {
        if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
            
        }
        if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
            
        }
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
