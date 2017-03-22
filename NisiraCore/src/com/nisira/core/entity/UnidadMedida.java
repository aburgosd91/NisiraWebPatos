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
@XStreamAlias("UNIDADMEDIDA")
public class UnidadMedida {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDUNIDAD")
    private int IDUNIDAD;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("FACTORUNIDADDIAGRAMA")
    private double FACTORUNIDADDIAGRAMA;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;

    public boolean isESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
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
     * @return the IDUNIDAD
     */
    public int getIDUNIDAD() {
        return IDUNIDAD;
    }

    /**
     * @param IDUNIDAD the IDUNIDAD to set
     */
    public void setIDUNIDAD(int IDUNIDAD) {
        this.IDUNIDAD = IDUNIDAD;
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
     * @return the FACTORUNIDADDIAGRAMA
     */
    public double getFACTORUNIDADDIAGRAMA() {
        return FACTORUNIDADDIAGRAMA;
    }

    /**
     * @param FACTORUNIDADDIAGRAMA the FACTORUNIDADDIAGRAMA to set
     */
    public void setFACTORUNIDADDIAGRAMA(double FACTORUNIDADDIAGRAMA) {
        this.FACTORUNIDADDIAGRAMA = FACTORUNIDADDIAGRAMA;
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
}
