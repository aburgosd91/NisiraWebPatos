/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Victor Zavala Llanos
 */
@XStreamAlias("NumEmisor")
public class NumEmisor {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA="";
    @XStreamAlias("IDDOCUMENTO")
    private String IDDOCUMENTO="";
    @XStreamAlias("ITEM")
    private String ITEM="";
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL="";
    @XStreamAlias("SERIE")
    private String SERIE="";
    @XStreamAlias("NUMERO")
    private String NUMERO="";
    @XStreamAlias("ESTADO")
    private int ESTADO=1;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    private transient Sucursal SUCURSAL;
    
    
    
    
    public String getITEM() {
        return ITEM;
    }

    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    
    public Sucursal getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(Sucursal SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }
    

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDDOCUMENTO() {
        return IDDOCUMENTO;
    }

    public void setIDDOCUMENTO(String IDDOCUMENTO) {
        this.IDDOCUMENTO = IDDOCUMENTO;
    }

    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public String getSERIE() {
        return SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
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




}
