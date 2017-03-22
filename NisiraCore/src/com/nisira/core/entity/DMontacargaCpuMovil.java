/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
@XStreamAlias("DMONTACARGACPUMOVIL")
public class DMontacargaCpuMovil {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("IDCPUMOVIL")
    private String IDCPUMOVIL;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("CODIGOEQUIVALENTE")
    private String CODIGOEQUIVALENTE;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    private String CPUMOVILDESCRIPCION;
    private transient CpuMovil CPUMOVIL;


    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    public void setIDMONTACARGA(String IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }

    public String getIDCPUMOVIL() {
        return IDCPUMOVIL;
    }

    public void setIDCPUMOVIL(String IDCPUMOVIL) {
        this.IDCPUMOVIL = IDCPUMOVIL;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public CpuMovil getCPUMOVIL() {
        return CPUMOVIL;
    }

    public void setCPUMOVIL(CpuMovil CPUMOVIL) {
        this.CPUMOVIL = CPUMOVIL;
    }

    public String getCODIGOEQUIVALENTE() {
        return CODIGOEQUIVALENTE;
    }

    public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
        this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    /**
     * @return the CPUMOVILDESCRIPCION
     */
    public String getCPUMOVILDESCRIPCION() {
        return CPUMOVILDESCRIPCION;
    }

    /**
     * @param CPUMOVILDESCRIPCION the CPUMOVILDESCRIPCION to set
     */
    public void setCPUMOVILDESCRIPCION(String CPUMOVILDESCRIPCION) {
        this.CPUMOVILDESCRIPCION = CPUMOVILDESCRIPCION;
    }
}
