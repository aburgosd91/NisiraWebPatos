/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author azamora
 */
@XStreamAlias("PARAMETROS")
public class Parametros {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDPARAMETRO")
    private String IDPARAMETRO;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("VALOR")
    private int VALOR;
    @XStreamAlias("CODIGOEQUIVALENTE")
    private String CODIGOEQUIVALENTE;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;

    public Parametros() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDPARAMETRO() {
        return IDPARAMETRO;
    }

    public void setIDPARAMETRO(String IDPARAMETRO) {
        this.IDPARAMETRO = IDPARAMETRO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getVALOR() {
        return VALOR;
    }

    public void setVALOR(int VALOR) {
        this.VALOR = VALOR;
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

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }
    public boolean isBEstado() {
        return this.getESTADO()== 1;
    }

    public void setBEstado(boolean band) {
        this.setESTADO((band) ? (int) 1 : (int) 0);
    }
}
