/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.PuertoDestinoDao;
import com.nisira.core.entity.Motivo;
import com.nisira.core.entity.PuertoDestino;
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
@ManagedBean(name = "PuertoDestinoAction")
@SessionScoped
public class PuertoDestinoAction extends AbstactListAction<PuertoDestino> implements Serializable {

    PuertoDestinoDao puerDao;
    private UsuarioBean user;

    public PuertoDestinoAction() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        puerDao = new PuertoDestinoDao();
        actualiza_ventana("wMnt_PuertoDestino");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(puerDao.findAll(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(ParametrosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        puerDao = new PuertoDestinoDao();
        actualiza_ventana("wMnt_PuertoDestino");
        return null;
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new PuertoDestino());
        getDatoEdicion().setESTADO(1);
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
    }

    @Override
    public void grabar() {
        try {
            puerDao.grabar(getDatoEdicion(), getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDPUERTODESTINO());
        } catch (Exception ex) {
            Logger.getLogger(PuertoDestinoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setESTADO(1);
            }
            puerDao.grabar(getDatoEdicion(), getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDPUERTODESTINO());
        } catch (Exception ex) {
            Logger.getLogger(PuertoDestinoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
