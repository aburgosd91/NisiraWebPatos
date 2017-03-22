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
public class Plantilla {
    @XStreamAlias("cIDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("cIDPLANTILLA")
    private int IDPLANTILLA;
    @XStreamAlias("cDESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("cWIDTH")
    private int WIDTH;
    @XStreamAlias("cHEIGHT")
    private int HEIGHT;
    @XStreamAlias("cESTADO")
    private boolean ESTADO;

    /**
     * @return the IDEMPRESA
     */
    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDPLANTILLA
     */
    public int getIDPLANTILLA() {
        return IDPLANTILLA;
    }

    /**
     * @param IDPLANTILLA the IDPLANTILLA to set
     */
    public void setIDPLANTILLA(int IDPLANTILLA) {
        this.IDPLANTILLA = IDPLANTILLA;
    }

    /**
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    /**
     * @return the WIDTH
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * @param WIDTH the WIDTH to set
     */
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    /**
     * @return the HEIGHT
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * @param HEIGHT the HEIGHT to set
     */
    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    /**
     * @return the ESTADO
     */
    public boolean isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
}
