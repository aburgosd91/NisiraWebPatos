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
@XStreamAlias("PARAMETRO_DISTRIBUCION")
public class ParametroDistribucion {
    @XStreamAlias("cIDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("cIDPARAMETRO")
    private String IDPARAMETRO;
    @XStreamAlias("cNOMBRE")
    private String NOMBRE;
    @XStreamAlias("cTIPO")
    private int TIPO;
    @XStreamAlias("cFECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("cFECHA_DETALLE")
    private String FECHA_DETALLE;
    @XStreamAlias("cESTADO")
    private boolean ESTADO;
    @XStreamAlias("cTIPOREGLA")
    private String TIPOREGLA;

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
     * @return the NOMBRE
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * @param NOMBRE the NOMBRE to set
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * @return the TIPO
     */
    public int getTIPO() {
        return TIPO;
    }

    /**
     * @param TIPO the TIPO to set
     */
    public void setTIPO(int TIPO) {
        this.TIPO = TIPO;
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

    /**
     * @return the FECHA_DETALLE
     */
    public String getFECHA_DETALLE() {
        return FECHA_DETALLE;
    }

    /**
     * @param FECHA_DETALLE the FECHA_DETALLE to set
     */
    public void setFECHA_DETALLE(String FECHA_DETALLE) {
        this.FECHA_DETALLE = FECHA_DETALLE;
    }

    /**
     * @return the ESTADO
     */
    public boolean isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the TIPOREGLA
     */
    public String getTIPOREGLA() {
        return TIPOREGLA;
    }

    /**
     * @param TIPOREGLA the TIPOREGLA to set
     */
    public void setTIPOREGLA(String TIPOREGLA) {
        this.TIPOREGLA = TIPOREGLA;
    }
    
}
