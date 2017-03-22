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
@XStreamAlias("FORMAUBICACION")
public class FormaUbicacion {
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
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;
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
    public boolean getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
    /**
     * @return the getFECHACREACION
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
    
    
}
