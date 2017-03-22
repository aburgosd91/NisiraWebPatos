/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
@XStreamAlias("MONTACARGA")
public class Montacarga {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("CODIGOEQUIVALENTE")
    private String CODIGOEQUIVALENTE;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;/*transient -> campo no debe de ser serealizado*/
    private transient List<DMontacargaCpuMovil> listaCpuMovil;

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

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public List<DMontacargaCpuMovil> getListaCpuMovil() {
        return listaCpuMovil;
    }

    public void setListaCpuMovil(List<DMontacargaCpuMovil> listaCpuMovils) {
        this.listaCpuMovil = listaCpuMovils;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public String getCODIGOEQUIVALENTE() {
        return CODIGOEQUIVALENTE;
    }

    public void setCODIGOEQUIVALENTE(String CODIGOEQUIVALENTE) {
        this.CODIGOEQUIVALENTE = CODIGOEQUIVALENTE;
    }



}
