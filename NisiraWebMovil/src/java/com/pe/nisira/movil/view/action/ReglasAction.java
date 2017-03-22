/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Reglas;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.service.ReglasService;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "reglasAction")
@SessionScoped
public class ReglasAction extends AbstactListAction<Reglas> implements Serializable {

    private List<Dreglas> listDReglas;
    private Dreglas selectReglas;
    private ReglasService reglasservice;
    private String mensaje;
    private UsuarioBean user;
    private List<Multitabla> listMultitabla;
    private MultitablaService multitablaService;

    public ReglasAction() {
        listMultitabla = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        listDReglas = new ArrayList<Dreglas>();
        setDatoSeleccionado(new Reglas());
        selectReglas = new Dreglas();
        reglasservice = new ReglasService();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Reglas");
        mensaje = null;
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            listMultitabla = multitablaService.getRecordParametroRegla(user.getIDEMPRESA());
            actualiza_ventana("wMnt_Reglas");
            setListaDatos(reglasservice.findReglas(Integer.parseInt(user.getIDEMPRESA())));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        listMultitabla = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        setDatoSeleccionado(new Reglas());
        listDReglas = new ArrayList<Dreglas>();
        selectReglas = new Dreglas();
        reglasservice = new ReglasService();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = null;
        actualiza_ventana("wMnt_Reglas");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Reglas());
        getDatoEdicion().setEstado(1);
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
    }

    @Override
    public void grabar() {
        try {
            List<Reglas> l = new ArrayList<Reglas>();
            l.add(getDatoEdicion());

            XStream xstream = new XStream(new DomDriver());

            xstream.alias("regla", Reglas.class);

            String xml = xstream.toXML(l);

            //
            xstream = new XStream(new DomDriver());
            xstream.alias("dregla", Dreglas.class);

            String xmlDReglas = xstream.toXML(listDReglas);
            if (getDatoEdicion().getIdregla() == 0) {
                int idregla = reglasservice.insertaReglas(1, xml, Integer.parseInt(user.getIDEMPRESA()), 0);
                reglasservice.insertaDreglas(1, xmlDReglas, Integer.parseInt(user.getIDEMPRESA()), idregla);
            } else {
                Integer idregla = reglasservice.insertaReglas(2, xml, Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIdregla());
                reglasservice.insertaDreglas(2, xmlDReglas, Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIdregla());
            }
        } catch (Exception ex) {
            Logger.getLogger(ReglasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newDRegla() {
        Dreglas dr = new Dreglas();
        dr.setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        dr.setIdregla(getDatoEdicion().getIdregla());
        dr.setEstado(1);
        listDReglas.add(dr);
    }

    public void delDRegla() {
        listDReglas.remove(selectReglas);
    }

    public void dReglasReglas() throws Exception {

        if (getLadd() == 1) {
//            Dreglas dr = new Dreglas();
//            dr.setIdparamentro(1);
//            listDReglas.add(dr);
            listDReglas = new ArrayList<Dreglas>();
        } else {
            listDReglas = reglasservice.findDreglas(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdregla());
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
            }
            List<Reglas> l = new ArrayList<Reglas>();
            l.add(getDatoEdicion());

            XStream xstream = new XStream(new DomDriver());

            xstream.alias("regla", Reglas.class);

            String xml = xstream.toXML(l);
            Integer idregla = reglasservice.insertaReglas(2, xml, Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIdregla());
        } catch (Exception ex) {
            Logger.getLogger(ReglasAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Dreglas> getListDReglas() {
        return listDReglas;
    }

    public void setListDReglas(List<Dreglas> listDReglas) {
        this.listDReglas = listDReglas;
    }

    public Dreglas getSelectReglas() {
        return selectReglas;
    }

    public void setSelectReglas(Dreglas selectReglas) {
        this.selectReglas = selectReglas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

}
