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
@XStreamAlias("DZONAACCESORIO")
public class DZonaAccesorio {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDZONA")
    private int IDZONA;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDACCESORIO")
    private int IDACCESORIO;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;
    @XStreamOmitField
    private boolean picked;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("IDTIPOACCESORIO")
    private int IDTIPOACCESORIO;
    @XStreamOmitField
    private boolean asignado;
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
     * @return the IDZONA
     */
    public int getIDZONA() {
        return IDZONA;
    }

    /**
     * @param IDZONA the IDZONA to set
     */
    public void setIDZONA(int IDZONA) {
        this.IDZONA = IDZONA;
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
     * @return the IDACCESORIO
     */
    public int getIDACCESORIO() {
        return IDACCESORIO;
    }

    /**
     * @param IDACCESORIO the IDACCESORIO to set
     */
    public void setIDACCESORIO(int IDACCESORIO) {
        this.IDACCESORIO = IDACCESORIO;
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

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    /**
     * @return the IDTIPOACCESORIO
     */
    public int getIDTIPOACCESORIO() {
        return IDTIPOACCESORIO;
    }

    /**
     * @param IDTIPOACCESORIO the IDTIPOACCESORIO to set
     */
    public void setIDTIPOACCESORIO(int IDTIPOACCESORIO) {
        this.IDTIPOACCESORIO = IDTIPOACCESORIO;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
    
}
