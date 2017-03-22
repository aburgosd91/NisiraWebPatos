/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aburgos
 */
@XStreamAlias("DSINCRONIZA")
public class DSincroniza {
    private int IDEMPRESA;
    private int IDSUCURSAL;
    private int IDSINCRONIZA;
    private int IDDSINCRONIZA;
    private String TABLA;
    private int PENDIENTES;
    private int AFECTADOS;
    private String FECHACREACION;

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

    public int getIDSINCRONIZA() {
        return IDSINCRONIZA;
    }

    public void setIDSINCRONIZA(int IDSINCRONIZA) {
        this.IDSINCRONIZA = IDSINCRONIZA;
    }

    public int getIDDSINCRONIZA() {
        return IDDSINCRONIZA;
    }

    public void setIDDSINCRONIZA(int IDDSINCRONIZA) {
        this.IDDSINCRONIZA = IDDSINCRONIZA;
    }

    public String getTABLA() {
        return TABLA;
    }

    public void setTABLA(String TABLA) {
        this.TABLA = TABLA;
    }

    public int getPENDIENTES() {
        return PENDIENTES;
    }

    public void setPENDIENTES(int PENDIENTES) {
        this.PENDIENTES = PENDIENTES;
    }

    public int getAFECTADOS() {
        return AFECTADOS;
    }

    public void setAFECTADOS(int AFECTADOS) {
        this.AFECTADOS = AFECTADOS;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }
    
}
