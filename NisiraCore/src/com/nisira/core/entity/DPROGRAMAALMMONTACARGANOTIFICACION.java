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
@XStreamAlias("DPROGRAMAALMMONTACARGANOTIFICACION")
public class DPROGRAMAALMMONTACARGANOTIFICACION {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDPROGRAMAALM")
    private int IDPROGRAMAALM;
    @XStreamAlias("IDMONTACARGA")
    private int IDMONTACARGA;
    @XStreamAlias("IDNOTIFICACION")
    private int IDNOTIFICACION;
    @XStreamAlias("FECHARECEPCION")
    private String FECHARECEPCION;
    @XStreamAlias("FECHALECTURA")
    private String FECHALECTURA;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;

    public DPROGRAMAALMMONTACARGANOTIFICACION() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDPROGRAMAALM() {
        return IDPROGRAMAALM;
    }

    public void setIDPROGRAMAALM(int IDPROGRAMAALM) {
        this.IDPROGRAMAALM = IDPROGRAMAALM;
    }

    public int getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    public void setIDMONTACARGA(int IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }

    public int getIDNOTIFICACION() {
        return IDNOTIFICACION;
    }

    public void setIDNOTIFICACION(int IDNOTIFICACION) {
        this.IDNOTIFICACION = IDNOTIFICACION;
    }

    public String getFECHARECEPCION() {
        return FECHARECEPCION;
    }

    public void setFECHARECEPCION(String FECHARECEPCION) {
        this.FECHARECEPCION = FECHARECEPCION;
    }

    public String getFECHALECTURA() {
        return FECHALECTURA;
    }

    public void setFECHALECTURA(String FECHALECTURA) {
        this.FECHALECTURA = FECHALECTURA;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
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

}
