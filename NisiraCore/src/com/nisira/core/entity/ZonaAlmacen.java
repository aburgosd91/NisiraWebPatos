/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

/**
 *
 * @author azamora
 */
public class ZonaAlmacen {
    private int IDEMPRESA;
    private int IDSUCURSAL;
    private int IDZONA;
    private int IDALMACEN;
    private String SUCURSAL;
    private String DESCRIPCION;
    private String ALMACEN;
    private double AREA;
    private int AREAUNIDADDIAGRAMA;
    private int LARGOUNIDADDIAGRAMA;
    private int ANCHOUNIDADDIAGRAMA;
    private String TIPOZONA;
    private String UNIDADMEDIDA;

    public ZonaAlmacen() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public int getIDZONA() {
        return IDZONA;
    }

    public void setIDZONA(int IDZONA) {
        this.IDZONA = IDZONA;
    }

    public int getIDALMACEN() {
        return IDALMACEN;
    }

    public void setIDALMACEN(int IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    public String getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getALMACEN() {
        return ALMACEN;
    }

    public void setALMACEN(String ALMACEN) {
        this.ALMACEN = ALMACEN;
    }

    public double getAREA() {
        return AREA;
    }

    public void setAREA(double AREA) {
        this.AREA = AREA;
    }

    public int getAREAUNIDADDIAGRAMA() {
        return AREAUNIDADDIAGRAMA;
    }

    public void setAREAUNIDADDIAGRAMA(int AREAUNIDADDIAGRAMA) {
        this.AREAUNIDADDIAGRAMA = AREAUNIDADDIAGRAMA;
    }

    public int getLARGOUNIDADDIAGRAMA() {
        return LARGOUNIDADDIAGRAMA;
    }

    public void setLARGOUNIDADDIAGRAMA(int LARGOUNIDADDIAGRAMA) {
        this.LARGOUNIDADDIAGRAMA = LARGOUNIDADDIAGRAMA;
    }

    public int getANCHOUNIDADDIAGRAMA() {
        return ANCHOUNIDADDIAGRAMA;
    }

    public void setANCHOUNIDADDIAGRAMA(int ANCHOUNIDADDIAGRAMA) {
        this.ANCHOUNIDADDIAGRAMA = ANCHOUNIDADDIAGRAMA;
    }   

    public String getTIPOZONA() {
        return TIPOZONA;
    }

    public void setTIPOZONA(String TIPOZONA) {
        this.TIPOZONA = TIPOZONA;
    }

    public String getUNIDADMEDIDA() {
        return UNIDADMEDIDA;
    }

    public void setUNIDADMEDIDA(String UNIDADMEDIDA) {
        this.UNIDADMEDIDA = UNIDADMEDIDA;
    }
      
}
