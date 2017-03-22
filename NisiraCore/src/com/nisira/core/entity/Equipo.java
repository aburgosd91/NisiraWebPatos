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
@XStreamAlias("EQUIPO")
public class Equipo {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDEQUIPO")
    private int IDEQUIPO;
    @XStreamAlias("NROSERIE")
    private String NROSERIE;
    @XStreamAlias("IDTIPOEQUIPOMONTACARGA")
    private int IDTIPOEQUIPOMONTACARGA;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;
    
    private transient TipoEquipoMontacarga tipoequipomontacarga;

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDEQUIPO() {
        return IDEQUIPO;
    }

    public void setIDEQUIPO(int IDEQUIPO) {
        this.IDEQUIPO = IDEQUIPO;
    }

    public String getNROSERIE() {
        return NROSERIE;
    }

    public void setNROSERIE(String NROSERIE) {
        this.NROSERIE = NROSERIE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public boolean getESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    public TipoEquipoMontacarga getTipoequipomontacarga() {
        return tipoequipomontacarga;
    }

    public void setTipoequipomontacarga(TipoEquipoMontacarga tipoequipomontacarga) {
        this.tipoequipomontacarga = tipoequipomontacarga;
    }

    public int getIDTIPOEQUIPOMONTACARGA() {
        return IDTIPOEQUIPOMONTACARGA;
    }

    public void setIDTIPOEQUIPOMONTACARGA(int IDTIPOEQUIPOMONTACARGA) {
        this.IDTIPOEQUIPOMONTACARGA = IDTIPOEQUIPOMONTACARGA;
    }

    
  
}
