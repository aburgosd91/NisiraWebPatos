/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Caracteristicas_ProductoDao;
import com.nisira.core.entity.Caracteristicas_Producto;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "caracteristicasProducto")
@SessionScoped
public class Caracteristicas_ProductoAction extends AbstactListAction<Caracteristicas_Producto> {

    private Caracteristicas_ProductoDao carapDao;
    private List<Caracteristicas_Producto> detcProd;
    private Caracteristicas_Producto slcdetcProd;
    private Caracteristicas_Producto ncdetcProd;
    private UsuarioBean user;
    private boolean botonNuevoDetalleTabla;
    private boolean botonEliminarDetalleTabla;

    public Caracteristicas_ProductoAction() {
        carapDao = new Caracteristicas_ProductoDao();
        detcProd = new ArrayList<Caracteristicas_Producto>();
        slcdetcProd = new Caracteristicas_Producto();
        ncdetcProd = new Caracteristicas_Producto();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Caracteristicas_Producto");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            actualiza_ventana("wMnt_Caracteristicas_Producto");
            setListaDatos(carapDao.findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(Caracteristicas_ProductoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        carapDao = new Caracteristicas_ProductoDao();
        detcProd = new ArrayList<Caracteristicas_Producto>();
        slcdetcProd = new Caracteristicas_Producto();
        ncdetcProd = new Caracteristicas_Producto();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        setBotonNuevoDetalleTabla(true);
        actualiza_ventana("wMnt_Caracteristicas_Producto");
        return "";
    }

    public void findDetalle() throws Exception {
        slcdetcProd = new Caracteristicas_Producto();
        if (getDatoEdicion().getIdcaracteristicas() != 0) {
            detcProd = carapDao.findDet(getDatoEdicion().getIdcaracteristicas());
        }
    }

    public void InhabilitarTablaDetalle() {
        slcdetcProd.setEstado(0);
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void onRowSelectMultitablaDetalle(SelectEvent event) throws IOException {
        botonEliminarDetalleTabla = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void onRowUnselectMultitablaDetalle(UnselectEvent event) throws IOException {
        botonEliminarDetalleTabla = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Caracteristicas_Producto());
        detcProd = new ArrayList<Caracteristicas_Producto>();
        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setEstado(1);
    }

    @Override
    public void grabar() {
        try {
            int i = carapDao.grabar(getDatoEdicion());
            int k = 1;
            for (Caracteristicas_Producto c : detcProd) {
                if (c.getValor() == 0) {
                    c.setValor(k);
                }
                c.setDep_id(i);
                k++;
            }
            carapDao.grabardet(getDatoEdicion().getIdempresa(),detcProd);
        } catch (Exception ex) {
            Logger.getLogger(Caracteristicas_ProductoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarDetalleMultitabla() {
        ncdetcProd.setEstado(1);
        ncdetcProd.setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
        detcProd.add(ncdetcProd);
        ncdetcProd = new Caracteristicas_Producto();
        RequestContext.getCurrentInstance().update("datos:tbl");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dmultitabla').hide()");
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
            int i = carapDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(Caracteristicas_ProductoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Caracteristicas_Producto> getDetcProd() {
        return detcProd;
    }

    public void setDetcProd(List<Caracteristicas_Producto> detcProd) {
        this.detcProd = detcProd;
    }

    public Caracteristicas_Producto getSlcdetcProd() {
        return slcdetcProd;
    }

    public void setSlcdetcProd(Caracteristicas_Producto slcdetcProd) {
        this.slcdetcProd = slcdetcProd;
    }

    public boolean isBotonNuevoDetalleTabla() {
        return botonNuevoDetalleTabla;
    }

    public void setBotonNuevoDetalleTabla(boolean botonNuevoDetalleTabla) {
        this.botonNuevoDetalleTabla = botonNuevoDetalleTabla;
    }

    public boolean isBotonEliminarDetalleTabla() {
        return botonEliminarDetalleTabla;
    }

    public void setBotonEliminarDetalleTabla(boolean botonEliminarDetalleTabla) {
        this.botonEliminarDetalleTabla = botonEliminarDetalleTabla;
    }

    public Caracteristicas_Producto getNcdetcProd() {
        return ncdetcProd;
    }

    public void setNcdetcProd(Caracteristicas_Producto ncdetcProd) {
        this.ncdetcProd = ncdetcProd;
    }

}
