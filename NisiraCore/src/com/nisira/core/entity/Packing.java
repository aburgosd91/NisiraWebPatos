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
@XStreamAlias("PACKINGLIST")
public class Packing {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDPACKING")
    private int IDPACKING;
    @XStreamAlias("FECHA")
    private String FECHA;
    @XStreamAlias("CONTENEDOR")
    private String CONTENEDOR;
    @XStreamAlias("IDDOCUMENTO")
    private String IDDOCUMENTO;
    @XStreamAlias("SERIE")
    private String SERIE;
    @XStreamAlias("NUMERO")
    private String NUMERO;
    @XStreamAlias("IDRESPONSABLE")
    private int IDRESPONSABLE;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("IDPUERTODESTINO")
    private String IDPUERTODESTINO;
    @XStreamAlias("IDMOTIVO")
    private String IDMOTIVO;
    @XStreamAlias("IDCLIENTE")
    private String IDCLIENTE;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;

    public Packing() {
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

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getCONTENEDOR() {
        return CONTENEDOR;
    }

    public void setCONTENEDOR(String CONTENEDOR) {
        this.CONTENEDOR = CONTENEDOR;
    }

    public String getIDDOCUMENTO() {
        return IDDOCUMENTO;
    }

    public void setIDDOCUMENTO(String IDDOCUMENTO) {
        this.IDDOCUMENTO = IDDOCUMENTO;
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

    public int getIDRESPONSABLE() {
        return IDRESPONSABLE;
    }

    public void setIDRESPONSABLE(int IDRESPONSABLE) {
        this.IDRESPONSABLE = IDRESPONSABLE;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getIDPUERTODESTINO() {
        return IDPUERTODESTINO;
    }

    public void setIDPUERTODESTINO(String IDPUERTODESTINO) {
        this.IDPUERTODESTINO = IDPUERTODESTINO;
    }

    public String getIDMOTIVO() {
        return IDMOTIVO;
    }

    public void setIDMOTIVO(String IDMOTIVO) {
        this.IDMOTIVO = IDMOTIVO;
    }

    public String getIDCLIENTE() {
        return IDCLIENTE;
    }

    public void setIDCLIENTE(String IDCLIENTE) {
        this.IDCLIENTE = IDCLIENTE;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public boolean isBEstado() {
        return this.getESTADO() == 1;
    }

    public void setBEstado(boolean band) {
        this.setESTADO((band) ? (int) 1 : (int) 0);
    }
}
