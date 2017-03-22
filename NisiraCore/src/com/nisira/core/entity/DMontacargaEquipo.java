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
@XStreamAlias("DMONTACARGAEQUIPO")
public class DMontacargaEquipo {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("IDEQUIPO")
    private String IDEQUIPO;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("CODIGOEQUIVALENTE")
    private String CODIGOEQUIVALENTE;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    
    private transient Equipo EQUIPO;

    private transient TipoEquipoMontacarga TIPOEQUIPOMONTACARGA;

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

    public String getIDEQUIPO() {
        return IDEQUIPO;
    }

    public void setIDEQUIPO(String IDEQUIPO) {
        this.IDEQUIPO = IDEQUIPO;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public TipoEquipoMontacarga getTIPOEQUIPOMONTACARGA() {
        return TIPOEQUIPOMONTACARGA;
    }

    public void setTIPOEQUIPOMONTACARGA(TipoEquipoMontacarga TIPOEQUIPOMONTACARGA) {
        this.TIPOEQUIPOMONTACARGA = TIPOEQUIPOMONTACARGA;
    }

    public Equipo getEQUIPO() {
        return EQUIPO;
    }

    public void setEQUIPO(Equipo EQUIPO) {
        this.EQUIPO = EQUIPO;
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
}
