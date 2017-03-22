/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDFormaUbicacion {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("cIDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("cIDPARAMETRO")
    private String IDPARAMETRO;
    @XStreamAlias("cIDFORMACIONUBICACION")
    private String IDFORMACIONUBICACION;
    @XStreamAlias("cIDRACK")
    private String IDRACK;
    @XStreamAlias("cPRIORIDAD")
    private int PRIORIDAD;
    @XStreamAlias("cUBICACION")
    private String UBICACION;

    /**
     * @return the IDEMPRESA
     */
    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDSUCURSAL
     */
    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the IDALMACEN
     */
    public String getIDALMACEN() {
        return IDALMACEN;
    }

    /**
     * @param IDALMACEN the IDALMACEN to set
     */
    public void setIDALMACEN(String IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    /**
     * @return the IDPARAMETRO
     */
    public String getIDPARAMETRO() {
        return IDPARAMETRO;
    }

    /**
     * @param IDPARAMETRO the IDPARAMETRO to set
     */
    public void setIDPARAMETRO(String IDPARAMETRO) {
        this.IDPARAMETRO = IDPARAMETRO;
    }

    /**
     * @return the IDFORMACIONUBICACION
     */
    public String getIDFORMACIONUBICACION() {
        return IDFORMACIONUBICACION;
    }

    /**
     * @param IDFORMACIONUBICACION the IDFORMACIONUBICACION to set
     */
    public void setIDFORMACIONUBICACION(String IDFORMACIONUBICACION) {
        this.IDFORMACIONUBICACION = IDFORMACIONUBICACION;
    }

    /**
     * @return the IDRACK
     */
    public String getIDRACK() {
        return IDRACK;
    }

    /**
     * @param IDRACK the IDRACK to set
     */
    public void setIDRACK(String IDRACK) {
        this.IDRACK = IDRACK;
    }

    /**
     * @return the PRIORIDAD
     */
    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    /**
     * @param PRIORIDAD the PRIORIDAD to set
     */
    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    /**
     * @return the UBICACION
     */
    public String getUBICACION() {
        return UBICACION;
    }

    /**
     * @param UBICACION the UBICACION to set
     */
    public void setUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }
    
}
