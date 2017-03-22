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
@XStreamAlias("DDNFORMAUBICACION")
public class DDNFormaUbicacion {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDNFORMACIONUBICACION")
    private String IDNFORMACIONUBICACION;
    @XStreamAlias("FILAS")
    private int FILAS;
    @XStreamAlias("COLUMNAS")
    private int COLUMNAS;
    @XStreamAlias("IDFILA")
    private String IDFILA;
    @XStreamAlias("IDCOLUMNA")
    private String IDCOLUMNA;
    @XStreamAlias("PRIORIDAD")
    private int PRIORIDAD;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("SELECCIONADO")
    private boolean SELECCIONADO;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
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
     * @return the IDNFORMACIONUBICACION
     */
    public String getIDNFORMACIONUBICACION() {
        return IDNFORMACIONUBICACION;
    }

    /**
     * @param IDNFORMACIONUBICACION the IDNFORMACIONUBICACION to set
     */
    public void setIDNFORMACIONUBICACION(String IDNFORMACIONUBICACION) {
        this.IDNFORMACIONUBICACION = IDNFORMACIONUBICACION;
    }


    /**
     * @return the FILAS
     */
    public int getFILAS() {
        return FILAS;
    }

    /**
     * @param FILAS the FILAS to set
     */
    public void setFILAS(int FILAS) {
        this.FILAS = FILAS;
    }

    /**
     * @return the COLUMNAS
     */
    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    /**
     * @param COLUMNAS the COLUMNAS to set
     */
    public void setCOLUMNAS(int COLUMNAS) {
        this.COLUMNAS = COLUMNAS;
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
     * @return the ESTADO
     */
    public int isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the SELECCIONADO
     */
    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    /**
     * @param SELECCIONADO the SELECCIONADO to set
     */
    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }
    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }
}
