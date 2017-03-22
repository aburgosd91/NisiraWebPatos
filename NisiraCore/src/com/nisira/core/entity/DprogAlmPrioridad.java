/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author azamora
 */
@XStreamAlias("DPROGRAMAALMPRIORIDAD")
public class DprogAlmPrioridad {

    @XStreamAlias("idprogramaalm")
    private int idprogramaalm;
    @XStreamAlias("idsucursal")
    private int idsucursal;
    @XStreamAlias("idalmacen")
    private int idalmacen;
    @XStreamAlias("idrack")
    private int idrack;
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idregla")
    private int idregla;
    @XStreamAlias("prioridadalmacen")
    private int prioridadalmacen;
    @XStreamAlias("prioridadrack")
    private int prioridadrack;
    @XStreamAlias("estado")
    private int estado;
    @XStreamAlias("sincroniza")
    private int sincroniza;
    @XStreamAlias("fechacreacion")
    private String fechacreacion;
    private DDProgramacionalmprioridad fubicacion;
    private boolean detalle;

    public DprogAlmPrioridad() {
    }

    public int getIdprogramaalm() {
        return idprogramaalm;
    }

    public void setIdprogramaalm(int idprogramaalm) {
        this.idprogramaalm = idprogramaalm;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getIdrack() {
        return idrack;
    }

    public void setIdrack(int idrack) {
        this.idrack = idrack;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdregla() {
        return idregla;
    }

    public void setIdregla(int idregla) {
        this.idregla = idregla;
    }

    public int getPrioridadalmacen() {
        return prioridadalmacen;
    }

    public void setPrioridadalmacen(int prioridadalmacen) {
        this.prioridadalmacen = prioridadalmacen;
    }

    public int getPrioridadrack() {
        return prioridadrack;
    }

    public void setPrioridadrack(int prioridadrack) {
        this.prioridadrack = prioridadrack;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSincroniza() {
        return sincroniza;
    }

    public void setSincroniza(int sincroniza) {
        this.sincroniza = sincroniza;
    }

    public DDProgramacionalmprioridad getFubicacion() {
        return fubicacion;
    }

    public void setFubicacion(DDProgramacionalmprioridad fubicacion) {
        this.fubicacion = fubicacion;
    }

    public boolean isDetalle() {
        return detalle;
    }

    public void setDetalle(boolean detalle) {
        this.detalle = detalle;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

}
