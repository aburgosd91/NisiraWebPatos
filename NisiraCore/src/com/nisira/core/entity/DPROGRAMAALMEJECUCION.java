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
@XStreamAlias("DPROGRAMAALMEJECUCION")
public class DPROGRAMAALMEJECUCION {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDPROGRAMAALM")
    private int IDPROGRAMAALM;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private int IDALMACEN;
    @XStreamAlias("IDRACK")
    private String IDRACK;
    @XStreamAlias("IDFORMAUBICACION")
    private String IDFORMAUBICACION;
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("IDPISO")
    private int IDPISO;
    @XStreamAlias("IDFILA")
    private int IDFILA;
    @XStreamAlias("IDCOLUMNA")
    private int IDCOLUMNA;
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("PRIORIDAD")
    private int PRIORIDAD;
    @XStreamAlias("IDPALETAPROGRAMADA")
    private String IDPALETAPROGRAMADA;
    @XStreamAlias("NROPALETAPROGRAMA")
    private String NROPALETAPROGRAMA;
    @XStreamAlias("IDPALETAREGISTRADA")
    private String IDPALETAREGISTRADA;
    @XStreamAlias("NROPALETAREGISTRADA")
    private String NROPALETAREGISTRADA;
    @XStreamAlias("IDCAMPANA")
    private String IDCAMPANA;
    @XStreamAlias("FECHAPROGRAMACION")
    private String FECHAPROGRAMACION;
    @XStreamAlias("IDMONTACARGA")
    private int IDMONTACARGA;
    @XStreamAlias("ESTADO")
    private String ESTADO;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;

    public DPROGRAMAALMEJECUCION() {
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

    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    public int getIDALMACEN() {
        return IDALMACEN;
    }

    public void setIDALMACEN(int IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    public String getIDRACK() {
        return IDRACK;
    }

    public void setIDRACK(String IDRACK) {
        this.IDRACK = IDRACK;
    }

    public String getIDFORMAUBICACION() {
        return IDFORMAUBICACION;
    }

    public void setIDFORMAUBICACION(String IDFORMAUBICACION) {
        this.IDFORMAUBICACION = IDFORMAUBICACION;
    }

    public String getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
    }

    public int getIDPISO() {
        return IDPISO;
    }

    public void setIDPISO(int IDPISO) {
        this.IDPISO = IDPISO;
    }

    public int getIDFILA() {
        return IDFILA;
    }

    public void setIDFILA(int IDFILA) {
        this.IDFILA = IDFILA;
    }

    public int getIDCOLUMNA() {
        return IDCOLUMNA;
    }

    public void setIDCOLUMNA(int IDCOLUMNA) {
        this.IDCOLUMNA = IDCOLUMNA;
    }

    public String getIDUBICACION() {
        return IDUBICACION;
    }

    public void setIDUBICACION(String IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    public String getIDPALETAPROGRAMADA() {
        return IDPALETAPROGRAMADA;
    }

    public void setIDPALETAPROGRAMADA(String IDPALETAPROGRAMADA) {
        this.IDPALETAPROGRAMADA = IDPALETAPROGRAMADA;
    }

    public String getNROPALETAPROGRAMA() {
        return NROPALETAPROGRAMA;
    }

    public void setNROPALETAPROGRAMA(String NROPALETAPROGRAMA) {
        this.NROPALETAPROGRAMA = NROPALETAPROGRAMA;
    }

    public String getIDPALETAREGISTRADA() {
        return IDPALETAREGISTRADA;
    }

    public void setIDPALETAREGISTRADA(String IDPALETAREGISTRADA) {
        this.IDPALETAREGISTRADA = IDPALETAREGISTRADA;
    }

    public String getNROPALETAREGISTRADA() {
        return NROPALETAREGISTRADA;
    }

    public void setNROPALETAREGISTRADA(String NROPALETAREGISTRADA) {
        this.NROPALETAREGISTRADA = NROPALETAREGISTRADA;
    }

    public String getIDCAMPANA() {
        return IDCAMPANA;
    }

    public void setIDCAMPANA(String IDCAMPANA) {
        this.IDCAMPANA = IDCAMPANA;
    }

    public String getFECHAPROGRAMACION() {
        return FECHAPROGRAMACION;
    }

    public void setFECHAPROGRAMACION(String FECHAPROGRAMACION) {
        this.FECHAPROGRAMACION = FECHAPROGRAMACION;
    }

    public int getIDMONTACARGA() {
        return IDMONTACARGA;
    }

    public void setIDMONTACARGA(int IDMONTACARGA) {
        this.IDMONTACARGA = IDMONTACARGA;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
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
