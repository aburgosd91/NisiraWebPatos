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
@XStreamAlias("TABLAPRIORIDADES")
public class TablaPrioridades {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDALMACEN")
    private int idalmacen;
    @XStreamAlias("IDDISTRIBUCION")
    private String iddistribucion;
    @XStreamAlias("IDRACK")
    private int idrack;
    @XStreamAlias("IDPISO")
    private String idpiso;
    @XStreamAlias("IDFILA")
    private String idfila;
    @XStreamAlias("IDCOLUMNA")
    private String idcolumna;
    @XStreamAlias("PIDALMACEN")
    private int pidalmacen;
    @XStreamAlias("PIDRACK")
    private int pidrack;
    @XStreamAlias("PIDPISO")
    private int pidpiso;
    @XStreamAlias("PIDFILA")
    private int pidfila;
    @XStreamAlias("PIDCOLUMNA")
    private int pidcolumna;
    @XStreamAlias("IDPROGRAMACIONLLENADO")
    private String idprogramacionllenado;

    public TablaPrioridades() {
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

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getIddistribucion() {
        return iddistribucion;
    }

    public void setIddistribucion(String iddistribucion) {
        this.iddistribucion = iddistribucion;
    }

    public int getIdrack() {
        return idrack;
    }

    public void setIdrack(int idrack) {
        this.idrack = idrack;
    }

    public String getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(String idpiso) {
        this.idpiso = idpiso;
    }

    public String getIdfila() {
        return idfila;
    }

    public void setIdfila(String idfila) {
        this.idfila = idfila;
    }

    public String getIdcolumna() {
        return idcolumna;
    }

    public void setIdcolumna(String idcolumna) {
        this.idcolumna = idcolumna;
    }

    public int getPidalmacen() {
        return pidalmacen;
    }

    public void setPidalmacen(int pidalmacen) {
        this.pidalmacen = pidalmacen;
    }

    public int getPidrack() {
        return pidrack;
    }

    public void setPidrack(int pidrack) {
        this.pidrack = pidrack;
    }

    public int getPidpiso() {
        return pidpiso;
    }

    public void setPidpiso(int pidpiso) {
        this.pidpiso = pidpiso;
    }

    public int getPidfila() {
        return pidfila;
    }

    public void setPidfila(int pidfila) {
        this.pidfila = pidfila;
    }

    public int getPidcolumna() {
        return pidcolumna;
    }

    public void setPidcolumna(int pidcolumna) {
        this.pidcolumna = pidcolumna;
    }

    public String getIdprogramacionllenado() {
        return idprogramacionllenado;
    }

    public void setIdprogramacionllenado(String idprogramacionllenado) {
        this.idprogramacionllenado = idprogramacionllenado;
    }

}
