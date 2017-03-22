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
@XStreamAlias("DPACKINGLIST")
public class Dpacking {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDPACKING")
    private int IDPACKING;
    @XStreamAlias("ITEM")
    private int ITEM;
    @XStreamAlias("NROPALETA")
    private String NROPALETA;
    @XStreamAlias("IDPRODUCTO")
    private String IDPRODUCTO;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("IDLOTEP")
    private String IDLOTEP;
    @XStreamAlias("IDMEDIDA")
    private String IDMEDIDA;
    @XStreamAlias("IDTALLA")
    private String IDTALLA;
    @XStreamAlias("CANTIDAD")
    private double CANTIDAD;
    @XStreamAlias("PESO")
    private double PESO;
    @XStreamAlias("PERSOTARA")
    private double PERSOTARA;

    public Dpacking() {
    }

    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public int getIDPACKING() {
        return IDPACKING;
    }

    public void setIDPACKING(int IDPACKING) {
        this.IDPACKING = IDPACKING;
    }

    public int getITEM() {
        return ITEM;
    }

    public void setITEM(int ITEM) {
        this.ITEM = ITEM;
    }

    public String getNROPALETA() {
        return NROPALETA;
    }

    public void setNROPALETA(String NROPALETA) {
        this.NROPALETA = NROPALETA;
    }

    public String getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(String IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getIDLOTEP() {
        return IDLOTEP;
    }

    public void setIDLOTEP(String IDLOTEP) {
        this.IDLOTEP = IDLOTEP;
    }

    public String getIDMEDIDA() {
        return IDMEDIDA;
    }

    public void setIDMEDIDA(String IDMEDIDA) {
        this.IDMEDIDA = IDMEDIDA;
    }

    public String getIDTALLA() {
        return IDTALLA;
    }

    public void setIDTALLA(String IDTALLA) {
        this.IDTALLA = IDTALLA;
    }

    public double getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(double CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public double getPESO() {
        return PESO;
    }

    public void setPESO(double PESO) {
        this.PESO = PESO;
    }

    public double getPERSOTARA() {
        return PERSOTARA;
    }

    public void setPERSOTARA(double PERSOTARA) {
        this.PERSOTARA = PERSOTARA;
    }

}
