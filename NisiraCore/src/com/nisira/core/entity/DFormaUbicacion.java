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
@XStreamAlias("DFORMAUBICACION")
public class DFormaUbicacion {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDPARAMETRO")
    private String IDPARAMETRO;
    @XStreamAlias("IDFORMACIONUBICACION")
    private String IDFORMACIONUBICACION;
    @XStreamAlias("IDRACK")
    private String IDRACK;
    @XStreamAlias("R_PRIORIDAD")
    private int R_PRIORIDAD;
    @XStreamOmitField
    private int PRIORIDAD;
    @XStreamOmitField
    private int TIPONIVEL;
    @XStreamOmitField
    private String IDNFORMACIONUBICACION;
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
     * @return the TIPONIVEL
     */
    public int getTIPONIVEL() {
        return TIPONIVEL;
    }

    /**
     * @param TIPONIVEL the TIPONIVEL to set
     */
    public void setTIPONIVEL(int TIPONIVEL) {
        this.TIPONIVEL = TIPONIVEL;
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

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getR_PRIORIDAD() {
        return R_PRIORIDAD;
    }

    public void setR_PRIORIDAD(int R_PRIORIDAD) {
        this.R_PRIORIDAD = R_PRIORIDAD;
    }
    
    
}
