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
@XStreamAlias("DPROGRAMACIONUBICACIONALMACEN")
public class DProgramacionUbicacionAlmacen {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDPROGRAMACIONUBICACIONALMACEN")
    private String IDPROGRAMACIONUBICACIONALMACEN;
    @XStreamAlias("cIDREGISTROPALETA")
    private String IDREGISTROPALETA;
    @XStreamAlias("cITEM")
    private String ITEM;
    @XStreamAlias("cNROPALETA")
    private String NROPALETA;
    @XStreamAlias("cIDCAMPANA")
    private String IDCAMPANA;
    @XStreamAlias("cESTADO")
    private String ESTADO;
    @XStreamAlias("cIDTIPOUBICACION")
    private String IDTIPOUBICACION;
    @XStreamAlias("cIDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("cIDREFERENCIA")
    private String IDREFERENCIA;
    @XStreamAlias("cIDUBICACIONREFERENCIA")
    private String IDUBICACIONREFERENCIA;

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
     * @return the IDPROGRAMACIONUBICACIONALMACEN
     */
    public String getIDPROGRAMACIONUBICACIONALMACEN() {
        return IDPROGRAMACIONUBICACIONALMACEN;
    }

    /**
     * @param IDPROGRAMACIONUBICACIONALMACEN the IDPROGRAMACIONUBICACIONALMACEN to set
     */
    public void setIDPROGRAMACIONUBICACIONALMACEN(String IDPROGRAMACIONUBICACIONALMACEN) {
        this.IDPROGRAMACIONUBICACIONALMACEN = IDPROGRAMACIONUBICACIONALMACEN;
    }

    /**
     * @return the IDREGISTROPALETA
     */
    public String getIDREGISTROPALETA() {
        return IDREGISTROPALETA;
    }

    /**
     * @param IDREGISTROPALETA the IDREGISTROPALETA to set
     */
    public void setIDREGISTROPALETA(String IDREGISTROPALETA) {
        this.IDREGISTROPALETA = IDREGISTROPALETA;
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
     * @return the NROPALETA
     */
    public String getNROPALETA() {
        return NROPALETA;
    }

    /**
     * @param NROPALETA the NROPALETA to set
     */
    public void setNROPALETA(String NROPALETA) {
        this.NROPALETA = NROPALETA;
    }

    /**
     * @return the IDCAMPANA
     */
    public String getIDCAMPANA() {
        return IDCAMPANA;
    }

    /**
     * @param IDCAMPANA the IDCAMPANA to set
     */
    public void setIDCAMPANA(String IDCAMPANA) {
        this.IDCAMPANA = IDCAMPANA;
    }

    /**
     * @return the ESTADO
     */
    public String getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the IDTIPOUBICACION
     */
    public String getIDTIPOUBICACION() {
        return IDTIPOUBICACION;
    }

    /**
     * @param IDTIPOUBICACION the IDTIPOUBICACION to set
     */
    public void setIDTIPOUBICACION(String IDTIPOUBICACION) {
        this.IDTIPOUBICACION = IDTIPOUBICACION;
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
     * @return the IDREFERENCIA
     */
    public String getIDREFERENCIA() {
        return IDREFERENCIA;
    }

    /**
     * @param IDREFERENCIA the IDREFERENCIA to set
     */
    public void setIDREFERENCIA(String IDREFERENCIA) {
        this.IDREFERENCIA = IDREFERENCIA;
    }

    /**
     * @return the IDUBICACIONREFERENCIA
     */
    public String getIDUBICACIONREFERENCIA() {
        return IDUBICACIONREFERENCIA;
    }

    /**
     * @param IDUBICACIONREFERENCIA the IDUBICACIONREFERENCIA to set
     */
    public void setIDUBICACIONREFERENCIA(String IDUBICACIONREFERENCIA) {
        this.IDUBICACIONREFERENCIA = IDUBICACIONREFERENCIA;
    }
}
