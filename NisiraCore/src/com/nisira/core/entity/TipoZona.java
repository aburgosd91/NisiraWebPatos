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
@XStreamAlias("TIPOZONA")
public class TipoZona {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDTIPOZONA")
    private int IDTIPOZONA;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;

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
     * @return the IDTIPOZONA
     */
    public int getIDTIPOZONA() {
        return IDTIPOZONA;
    }

    /**
     * @param IDTIPOZONA the IDTIPOZONA to set
     */
    public void setIDTIPOZONA(int IDTIPOZONA) {
        this.IDTIPOZONA = IDTIPOZONA;
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
}
