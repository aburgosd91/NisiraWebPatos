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
@XStreamAlias("DDPROGRAMACIONALMPRIORIDAD")
public class DDProgramacionalmprioridad {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idsucursal")
    private int idsucursal;
    @XStreamAlias("idprogramaalm")
    private int idprogramaalm;
    @XStreamAlias("idalmacen")
    private int idalmacen;
    @XStreamAlias("idrack")
    private int idrack;
    @XStreamAlias("prioridadalmacen")
    private int prioridadalmacen;
    @XStreamAlias("prioridadrack")
    private int prioridadrack;
    @XStreamAlias("idnformacionubicacion")
    private String idnformacionubicacion;
    @XStreamAlias("idregla")
    private int idregla;
    @XStreamAlias("iddistribucionpiso")
    private int iddistribucionpiso;
    @XStreamAlias("fechacreacion")
    private String fechacreacion;

    public DDProgramacionalmprioridad() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdprogramaalm() {
        return idprogramaalm;
    }

    public void setIdprogramaalm(int idprogramaalm) {
        this.idprogramaalm = idprogramaalm;
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

    public String getIdnformacionubicacion() {
        return idnformacionubicacion;
    }

    public void setIdnformacionubicacion(String idnformacionubicacion) {
        this.idnformacionubicacion = idnformacionubicacion;
    }

    public int getIdregla() {
        return idregla;
    }

    public void setIdregla(int idregla) {
        this.idregla = idregla;
    }

    public int getIddistribucionpiso() {
        return iddistribucionpiso;
    }

    public void setIddistribucionpiso(int iddistribucionpiso) {
        this.iddistribucionpiso = iddistribucionpiso;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

}
