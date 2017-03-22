/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author aburgos
 */
@XStreamAlias("DALMACENDIAGRAMA")
public class DAlmacenDiagrama{
    @XStreamAlias("cIDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("cIDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("cIDALMACEN")
    private int IDALMACEN;
    @XStreamAlias("cIDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("cCORDENADAX")
    private int CORDENADAX;
    @XStreamAlias("cCORDENADAY")
    private int CORDENADAY;
    @XStreamAlias("cIDRACK")
    private String IDRACK;
    @XStreamAlias("cCOLORHEXADECIMAL")
    private String COLORHEXADECIMAL;
    @XStreamAlias("cFECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("cESTADO")
    private int ESTADO;
    @XStreamAlias("cSINCRONIZA")
    private int SINCRONIZA;
    @XStreamOmitField
    private int BIGVALUE;
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
     * @return the COLORHEXADECIMAL
     */
    public String getCOLORHEXADECIMAL() {
        return COLORHEXADECIMAL;
    }

    /**
     * @param COLORHEXADECIMAL the COLORHEXADECIMAL to set
     */
    public void setCOLORHEXADECIMAL(String COLORHEXADECIMAL) {
        this.COLORHEXADECIMAL = COLORHEXADECIMAL;
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

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    public int getBIGVALUE() {
        return BIGVALUE;
    }

    public void setBIGVALUE(int BIGVALUE) {
        this.BIGVALUE = BIGVALUE;
    }


    /**
     * @return the ESTADO
     */
    
    
}
