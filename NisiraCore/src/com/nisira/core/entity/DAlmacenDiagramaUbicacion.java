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
@XStreamAlias("cDALMACENDIAGRAMAUBICACION")
public class DAlmacenDiagramaUbicacion {
    @XStreamAlias("cIDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("cIDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("cIDALMACEN")
    private int IDALMACEN;
    @XStreamAlias("cIDDISTRIBUCION")
    private int IDDISTRIBUCION;
    @XStreamAlias("cCORDENADAX")
    private int CORDENADAX;
    @XStreamAlias("cCORDENADAY")
    private int CORDENADAY;
    @XStreamAlias("cIDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("cFECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("cSINCRONIZA")
    private int SINCRONIZA;
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
     * @return the IDSUCURSAL
     */
    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the IDALMACEN
     */
    public int getIDALMACEN() {
        return IDALMACEN;
    }

    /**
     * @param IDALMACEN the IDALMACEN to set
     */
    public void setIDALMACEN(int IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    /**
     * @return the IDDISTRIBUCION
     */
    public int getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    /**
     * @param IDDISTRIBUCION the IDDISTRIBUCION to set
     */
    public void setIDDISTRIBUCION(int IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
    }

    /**
     * @return the CORDENADAX
     */
    public int getCORDENADAX() {
        return CORDENADAX;
    }

    /**
     * @param CORDENADAX the CORDENADAX to set
     */
    public void setCORDENADAX(int CORDENADAX) {
        this.CORDENADAX = CORDENADAX;
    }

    /**
     * @return the CORDENADAY
     */
    public int getCORDENADAY() {
        return CORDENADAY;
    }

    /**
     * @param CORDENADAY the CORDENADAY to set
     */
    public void setCORDENADAY(int CORDENADAY) {
        this.CORDENADAY = CORDENADAY;
    }

    /**
     * @return the IDUBICACION
     */
    public String getIDUBICACION() {
        return IDUBICACION;
    }

    /**
     * @param IDUBICACION the IDUBICACION to set
     */
    public void setIDUBICACION(String IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    /**
     * @return the FECHACREACION
     */
    public String getFECHACREACION() {
        return FECHACREACION;
    }

    /**
     * @param FECHACREACION the FECHACREACION to set
     */
    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }
}
