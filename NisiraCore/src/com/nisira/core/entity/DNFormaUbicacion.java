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
@XStreamAlias("DNFORMAUBICACION")
public class DNFormaUbicacion {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("IDNFORMACIONUBICACION")
    private String IDNFORMACIONUBICACION;    
    @XStreamAlias("FILAS")
    private int FILAS;
    @XStreamAlias("COLUMNAS")
    private int COLUMNAS;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
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
     * @return the IDRACK
     */

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

    public String getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
    }

    public int getIdregla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }
    
}

