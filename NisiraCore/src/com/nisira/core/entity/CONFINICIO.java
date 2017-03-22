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
@XStreamAlias("CONFINICIO")
public class CONFINICIO {

    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDCONFIG")
    private int IDCONFIG;
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
    @XStreamAlias("RUTPRO")
    private String RUTPRO;
    @XStreamAlias("PARAMINI")
    private String PARAMINI;
    @XStreamAlias("PARAMFIN")
    private String PARAMFIN;
    @XStreamAlias("PARAMERRINI")
    private String PARAMERRINI;
    @XStreamAlias("PARAMERRFIN")
    private String PARAMERRFIN;
    @XStreamAlias("TIPO")
    private String TIPO;
    @XStreamAlias("IDMONTACARGA")
    private String IDMONTACARGA;
    @XStreamAlias("PUERTOCM")
    private String PUERTOCM;
    @XStreamAlias("MAC")
    private String MAC;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamOmitField
    private String DESCRIPCION;
    public CONFINICIO() {
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

    public int getIDCONFIG() {
        return IDCONFIG;
    }

    public void setIDCONFIG(int IDCONFIG) {
        this.IDCONFIG = IDCONFIG;
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

    public String getRUTPRO() {
        return RUTPRO;
    }

    public void setRUTPRO(String RUTPRO) {
        this.RUTPRO = RUTPRO;
    }

    public String getPARAMINI() {
        return PARAMINI;
    }

    public void setPARAMINI(String PARAMINI) {
        this.PARAMINI = PARAMINI;
    }

    public String getPARAMFIN() {
        return PARAMFIN;
    }

    public void setPARAMFIN(String PARAMFIN) {
        this.PARAMFIN = PARAMFIN;
    }

    public String getPARAMERRINI() {
        return PARAMERRINI;
    }

    public void setPARAMERRINI(String PARAMERRINI) {
        this.PARAMERRINI = PARAMERRINI;
    }

    public String getPARAMERRFIN() {
        return PARAMERRFIN;
    }

    public void setPARAMERRFIN(String PARAMERRFIN) {
        this.PARAMERRFIN = PARAMERRFIN;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    public void setIDMONTACARGA(String IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }

    public String getPUERTOCM() {
        return PUERTOCM;
    }

    public void setPUERTOCM(String PUERTOCM) {
        this.PUERTOCM = PUERTOCM;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
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
