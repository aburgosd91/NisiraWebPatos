/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ParametrosDao;
import com.nisira.core.entity.Parametros;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "ParametrosAction")
@SessionScoped
public class ParametrosAction extends AbstactListAction<Parametros> implements Serializable{
    ParametrosDao patDao;
    private UsuarioBean user;
    public ParametrosAction() {
        patDao = new ParametrosDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Parametros");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(patDao.findAll(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(ParametrosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        patDao = new ParametrosDao();
        actualiza_ventana("wMnt_Parametros");
        return null;
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Parametros());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setESTADO(1);
    }

    @Override
    public void grabar() {
        try {
            patDao.grabar(getDatoEdicion(),getDatoEdicion().getIDEMPRESA(),getDatoEdicion().getIDPARAMETRO());
        } catch (Exception ex) {
            Logger.getLogger(ParametrosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setESTADO(2);
            }
            patDao.grabar(getDatoEdicion(),getDatoEdicion().getIDEMPRESA(),getDatoEdicion().getIDPARAMETRO());
        } catch (Exception ex) {
            Logger.getLogger(ParametrosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
