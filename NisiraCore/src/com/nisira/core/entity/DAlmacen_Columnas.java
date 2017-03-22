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
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("DALMACEN_COLUMNAS")
public class DAlmacen_Columnas {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("IDRACK")
    private String IDRACK;
    @XStreamAlias("IDPISO")
    private String IDPISO;
    @XStreamAlias("IDFILA")
    private String IDFILA;
    @XStreamAlias("IDCOLUMNA")
    private String IDCOLUMNA;
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("ITEMFILA")
    private String ITEMFILA;
    @XStreamAlias("ITEMPISO")
    private String ITEMPISO;
    @XStreamAlias("ITEMRACK")
    private String ITEMRACK;
    @XStreamAlias("ITEM")
    private String ITEM;
    @XStreamAlias("TIPOUBICACION")
    private String TIPOUBICACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("CODIGOCLIENTE")
    private String CODIGOCLIENTE;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamOmitField
    private boolean SELECCIONADO;
    @XStreamOmitField
    private int PRIORIDAD;
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
     * @return the IDPISO
     */
    public String getIDPISO() {
        return IDPISO;
    }

    /**
     * @param IDPISO the IDPISO to set
     */
    public void setIDPISO(String IDPISO) {
        this.IDPISO = IDPISO;
    }

    /**
     * @return the IDFILA
     */
    public String getIDFILA() {
        return IDFILA;
    }

    /**
     * @param IDFILA the IDFILA to set
     */
    public void setIDFILA(String IDFILA) {
        this.IDFILA = IDFILA;
    }

    /**
     * @return the IDCOLUMNA
     */
    public String getIDCOLUMNA() {
        return IDCOLUMNA;
    }

    /**
     * @param IDCOLUMNA the IDCOLUMNA to set
     */
    public void setIDCOLUMNA(String IDCOLUMNA) {
        this.IDCOLUMNA = IDCOLUMNA;
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
     * @return the ITEMFILA
     */
    public String getITEMFILA() {
        return ITEMFILA;
    }

    /**
     * @param ITEMFILA the ITEMFILA to set
     */
    public void setITEMFILA(String ITEMFILA) {
        this.ITEMFILA = ITEMFILA;
    }

    /**
     * @return the ITEMPISO
     */
    public String getITEMPISO() {
        return ITEMPISO;
    }

    /**
     * @param ITEMPISO the ITEMPISO to set
     */
    public void setITEMPISO(String ITEMPISO) {
        this.ITEMPISO = ITEMPISO;
    }

    /**
     * @return the ITEMRACK
     */
    public String getITEMRACK() {
        return ITEMRACK;
    }

    /**
     * @param ITEMRACK the ITEMRACK to set
     */
    public void setITEMRACK(String ITEMRACK) {
        this.ITEMRACK = ITEMRACK;
    }

    /**
     * @return the ITEM
     */
    public String getITEM() {
        return ITEM;
    }

    /**
     * @param ITEM the ITEM to set
     */
    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    /**
     * @return the TIPOUBICACION
     */
    public String getTIPOUBICACION() {
        return TIPOUBICACION;
    }

    /**
     * @param TIPOUBICACION the TIPOUBICACION to set
     */
    public void setTIPOUBICACION(String TIPOUBICACION) {
        this.TIPOUBICACION = TIPOUBICACION;
    }

    /**
     * @return the ESTADO
     */
    public int getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the CODIGOCLIENTE
     */
    public String getCODIGOCLIENTE() {
        return CODIGOCLIENTE;
    }

    /**
     * @param CODIGOCLIENTE the CODIGOCLIENTE to set
     */
    public void setCODIGOCLIENTE(String CODIGOCLIENTE) {
        this.CODIGOCLIENTE = CODIGOCLIENTE;
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

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }

    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }
    
}
