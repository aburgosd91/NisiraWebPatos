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
@XStreamAlias("GENERACIONCODIGOS")
public class GeneracionCodigo {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDGENERACION")
    private int IDGENERACION;
    @XStreamAlias("TIPO")
    private int TIPO;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("NUMDIGITOTOTAL")
    private int NUMDIGITOTOTAL;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("SINCRONIZADO")
    private int SINCRONIZADO;
    @XStreamAlias("PARAMETRO")
    private String PARAMETRO;
    @XStreamAlias("IDPROCESO")
    private int IDPROCESO;
    
    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDGENERACION() {
        return IDGENERACION;
    }

    public void setIDGENERACION(int IDGENERACION) {
        this.IDGENERACION = IDGENERACION;
    }

    public int getTIPO() {
        return TIPO;
    }

    public void setTIPO(int TIPO) {
        this.TIPO = TIPO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getNUMDIGITOTOTAL() {
        return NUMDIGITOTOTAL;
    }

    public void setNUMDIGITOTOTAL(int NUMDIGITOTOTAL) {
        this.NUMDIGITOTOTAL = NUMDIGITOTOTAL;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public String getPARAMETRO() {
        return PARAMETRO;
    }

    public void setPARAMETRO(String DATO) {
        this.PARAMETRO = DATO;
    }

    public int getSINCRONIZADO() {
        return SINCRONIZADO;
    }

    public void setSINCRONIZADO(int SINCRONIZADO) {
        this.SINCRONIZADO = SINCRONIZADO;
    }

    public int getIDPROCESO() {
        return IDPROCESO;
    }

    public void setIDPROCESO(int IDPROCESO) {
        this.IDPROCESO = IDPROCESO;
    }
    public boolean isBEstado() {
        return this.getESTADO()== 1;
    }

    public void setBEstado(boolean band) {
        this.setESTADO((band) ? (int) 1 : (int) 0);
    }
}
