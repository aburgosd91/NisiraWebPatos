/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Victor Zavala <vzavala@gmail.com>
 */
@XStreamAlias("DMONTACARGAOPERARIO")
public class DMontacargaOperario {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("IDOPERARIO")
    private String IDOPERARIO;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    
    private transient Operario OPERARIO;

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

    public String getIDOPERARIO() {
        return IDOPERARIO;
    }

    public void setIDOPERARIO(String IDOPERARIO) {
        this.IDOPERARIO = IDOPERARIO;
    }

    public int setESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Operario getOPERARIO() {
        return OPERARIO;
    }

    public void setOPERARIO(Operario OPERARIO) {
        this.OPERARIO = OPERARIO;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }


}
