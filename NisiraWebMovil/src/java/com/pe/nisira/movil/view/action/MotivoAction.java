/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.MotivoDao;
import com.nisira.core.entity.Motivo;
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
@ManagedBean(name = "MotivoAction")
@SessionScoped
public class MotivoAction extends AbstactListAction<Motivo> implements Serializable {

    MotivoDao motDao;
    private UsuarioBean user;

    public MotivoAction() {
        motDao = new MotivoDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Motivos");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(motDao.findAll(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(ParametrosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Motivo());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
    }

    @Override
    public void grabar() {
        try {
            motDao.grabar(getDatoEdicion(), getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDMOTIVO());
        } catch (Exception ex) {
            Logger.getLogger(MotivoAction.class.getName()).log(Level.SEVERE, null, ex);
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
            motDao.grabar(getDatoEdicion(), getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDMOTIVO());
        } catch (Exception ex) {
            Logger.getLogger(MotivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
