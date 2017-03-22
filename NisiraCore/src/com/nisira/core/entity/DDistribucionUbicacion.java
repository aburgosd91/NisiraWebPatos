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
@XStreamAlias("DALMACEN_DISTRIBUCIONUBICACION")
public class DDistribucionUbicacion {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("cIDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("cIDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("cFECHAINICIO")
    private String FECHAINICIO;
    @XStreamAlias("cFECHAFIN")
    private String FECHAFIN;
    @XStreamAlias("cESTADO")
    private Boolean ESTADO;

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
     * @return the IDDISTRIBUCION
     */
    public String getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    /**
     * @param IDDISTRIBUCION the IDDISTRIBUCION to set
     */
    public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
    }

    /**
     * @return the FECHAINICIO
     */
    public String getFECHAINICIO() {
        return FECHAINICIO;
    }

    /**
     * @param FECHAINICIO the FECHAINICIO to set
     */
    public void setFECHAINICIO(String FECHAINICIO) {
        this.FECHAINICIO = FECHAINICIO;
    }

    /**
     * @return the FECHAFIN
     */
    public String getFECHAFIN() {
        return FECHAFIN;
    }

    /**
     * @param FECHAFIN the FECHAFIN to set
     */
    public void setFECHAFIN(String FECHAFIN) {
        this.FECHAFIN = FECHAFIN;
    }

    /**
     * @return the ESTADO
     */
    public Boolean getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(Boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
}
