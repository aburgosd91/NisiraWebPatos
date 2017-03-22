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
@XStreamAlias("CONFIGTABLASINCRO")
public class CONFIGTABLASINCRO {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDTABLASINCRO")
    private int IDTABLASINCRO;
    @XStreamAlias("TABLA")
    private String TABLA;
    @XStreamAlias("TIPOSINCRO")
    private int TIPOSINCRO;
    @XStreamAlias("UPDOWN")
    private int UPDOWN;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;

    public CONFIGTABLASINCRO() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDTABLASINCRO() {
        return IDTABLASINCRO;
    }

    public void setIDTABLASINCRO(int IDTABLASINCRO) {
        this.IDTABLASINCRO = IDTABLASINCRO;
    }

    public String getTABLA() {
        return TABLA;
    }

    public void setTABLA(String TABLA) {
        this.TABLA = TABLA;
    }

    public int getTIPOSINCRO() {
        return TIPOSINCRO;
    }

    public void setTIPOSINCRO(int TIPOSINCRO) {
        this.TIPOSINCRO = TIPOSINCRO;
    }

    public int getUPDOWN() {
        return UPDOWN;
    }

    public void setUPDOWN(int UPDOWN) {
        this.UPDOWN = UPDOWN;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }
    public boolean isBESTADO() {
        return this.getESTADO() == 1;
    }

    public void setBESTADO(boolean band) {
        this.setESTADO((band) ? (int) 1 : (int) 0);
    }
}
