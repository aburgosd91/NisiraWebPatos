/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author azamora
 */
@XStreamAlias("CONFOG")
public class CONFOG {

    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDOGCONFIG")
    private int IDOGCONFIG;
    @XStreamAlias("GESTOR")
    private String GESTOR;
    @XStreamAlias("SERVIDOR")
    private String SERVIDOR;
    @XStreamAlias("INSTANCIA")
    private String INSTANCIA;
    @XStreamAlias("USUARIO")
    private String USUARIO;
    @XStreamAlias("CLAVE")
    private String CLAVE;
    @XStreamAlias("BASEDATOS")
    private String BASEDATOS;
    @XStreamAlias("URL")
    private String URL;
    @XStreamAlias("TIPO")
    private String TIPO;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamOmitField
    private String DESCRIPCION;
    public CONFOG() {
    }

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public int getIDOGCONFIG() {
        return IDOGCONFIG;
    }

    public void setIDOGCONFIG(int IDOGCONFIG) {
        this.IDOGCONFIG = IDOGCONFIG;
    }

    public String getGESTOR() {
        return GESTOR;
    }

    public void setGESTOR(String GESTOR) {
        this.GESTOR = GESTOR;
    }

    public String getSERVIDOR() {
        return SERVIDOR;
    }

    public void setSERVIDOR(String SERVIDOR) {
        this.SERVIDOR = SERVIDOR;
    }

    public String getINSTANCIA() {
        return INSTANCIA;
    }

    public void setINSTANCIA(String INSTANCIA) {
        this.INSTANCIA = INSTANCIA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getBASEDATOS() {
        return BASEDATOS;
    }

    public void setBASEDATOS(String BASEDATOS) {
        this.BASEDATOS = BASEDATOS;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
    
}
