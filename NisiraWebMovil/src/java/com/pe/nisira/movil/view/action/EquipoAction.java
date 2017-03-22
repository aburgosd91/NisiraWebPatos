/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.EquipoDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.entity.Equipo;
import com.nisira.core.entity.Multitabla;

import com.nisira.core.service.EquipoService;
import com.nisira.core.service.EquipoService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Victor Zavala Llanos <vzavala@nisira.com.pe>
 */
@ManagedBean(name = "equipoAction")
@SessionScoped
public class EquipoAction extends AbstactListAction<Equipo> implements Serializable {

    private EquipoService equipoService;
    private String mensaje;
    private UsuarioBean user;
    private List<Multitabla> listMultitabla;
    public EquipoAction() {
        equipoService = new EquipoService();
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        listMultitabla = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_equipo");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_equipo");
            listMultitabla = (new MultitablaDao()).findDetalleTabla(user.getIDEMPRESA(), "18");
            setListaDatos(equipoService.getRecordEquipo(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(EquipoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        equipoService = new EquipoService();
        mensaje = "";
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        listMultitabla = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_equipo");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Equipo());
        getDatoEdicion().setIDEMPRESA(user.getIDEMPRESA());
        getDatoEdicion().setESTADO(true);
    }

    @Override
    public void grabar() {
        try {
            if (validarCabecera()) {
                mensaje = equipoService.saveEquipo(getDatoEdicion());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EquipoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarCabecera() {
        try {
            if (getDatoEdicion().getDESCRIPCION() == null) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeEquipo", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioEquipo:descripcion');");
                return false;
            }
            if (getDatoEdicion().getDESCRIPCION().trim().length() == 0) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeErrorNuevo("mensajeEquipo", this.mensaje);
                RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioEquipo:descripcion');");
                return false;
            }
        } catch (Exception ex) {
            this.mensaje = ex.toString();
            WebUtil.MensajeErrorNuevo("mensajeEquipo", "Error validar Cabecera: " + this.mensaje);
            RequestContext.getCurrentInstance().execute("PrimeFaces.focus('FormularioEquipo:codigo');");
            return false;
        }
        return true;
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(false);
                mensaje = equipoService.saveEquipo(getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                (new EquipoDao()).anular(getDatoEdicion().getIDEMPRESA(),getDatoEdicion().getIDEQUIPO());
            }
        } catch (Exception ex) {
            Logger.getLogger(MotivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

}
