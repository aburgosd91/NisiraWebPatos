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
 * @author aburgos
 */
@XStreamAlias("ZONA")
public class Zona {

    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA; //1 
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL; //2
    @XStreamAlias("IDZONA")
    private int IDZONA; //3
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION; //4
    @XStreamAlias("IDTIPOZONA")
    private int IDTIPOZONA; //5
    @XStreamAlias("IDUNIDADMEDIDA")
    private int IDUNIDADMEDIDA; //6
    @XStreamAlias("AREA")
    private double AREA; //7
    @XStreamAlias("AREAUNIDADDIAGRAMA")
    private int AREAUNIDADDIAGRAMA;  //8
    @XStreamAlias("LARGOUNIDADDIAGRAMA")
    private int LARGOUNIDADDIAGRAMA; //9
    @XStreamAlias("ANCHOUNIDADDIAGRAMA")
    private int ANCHOUNIDADDIAGRAMA; //10
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION; //11
    @XStreamAlias("ESTADO")
    private boolean ESTADO; //12
    @XStreamAlias("COLOR")
    public String COLOR; //13
    @XStreamOmitField
    private String SUCURSAL;
    @XStreamOmitField
    private String TIPOZONA;
    @XStreamOmitField
    private String UNIDADMEDIDA;
    @XStreamOmitField
    private boolean SELECCION;
    @XStreamOmitField
    private boolean PICKED;
    @XStreamOmitField
    private int FILA;
    @XStreamOmitField
    private int COLUMNA;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("IDPROCESO")
    private int IDPROCESO;

    public String getSUCURSAL() {
        return SUCURSAL;
    }

    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }

    /**
     * @return the IDEMPRESA
     */
    public int getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(int IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDSUCURSAL
     */
    public int getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(int IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
    }

    /**
     * @return the IDZONA
     */
    public int getIDZONA() {
        return IDZONA;
    }

    /**
     * @param IDZONA the IDZONA to set
     */
    public void setIDZONA(int IDZONA) {
        this.IDZONA = IDZONA;
    }

    /**
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    /**
     * @return the IDTIPOZONA
     */
    public int getIDTIPOZONA() {
        return IDTIPOZONA;
    }

    /**
     * @param IDTIPOZONA the IDTIPOZONA to set
     */
    public void setIDTIPOZONA(int IDTIPOZONA) {
        this.IDTIPOZONA = IDTIPOZONA;
    }

    /**
     * @return the IDUNIDADMEDIDA
     */
    public int getIDUNIDADMEDIDA() {
        return IDUNIDADMEDIDA;
    }

    /**
     * @param IDUNIDADMEDIDA the IDUNIDADMEDIDA to set
     */
    public void setIDUNIDADMEDIDA(int IDUNIDADMEDIDA) {
        this.IDUNIDADMEDIDA = IDUNIDADMEDIDA;
    }

    /**
     * @return the AREA
     */
    public double getAREA() {
        return AREA;
    }

    /**
     * @param AREA the AREA to set
     */
    public void setAREA(double AREA) {
        this.AREA = AREA;
    }

    /**
     * @return the AREAUNIDADDIAGRAMA
     */
    public int getAREAUNIDADDIAGRAMA() {
        return AREAUNIDADDIAGRAMA;
    }

    /**
     * @param AREAUNIDADDIAGRAMA the AREAUNIDADDIAGRAMA to set
     */
    public void setAREAUNIDADDIAGRAMA(int AREAUNIDADDIAGRAMA) {
        this.AREAUNIDADDIAGRAMA = AREAUNIDADDIAGRAMA;
    }

    /**
     * @return the LARGOUNIDADDIAGRAMA
     */
    public int getLARGOUNIDADDIAGRAMA() {
        return LARGOUNIDADDIAGRAMA;
    }

    /**
     * @param LARGOUNIDADDIAGRAMA the LARGOUNIDADDIAGRAMA to set
     */
    public void setLARGOUNIDADDIAGRAMA(int LARGOUNIDADDIAGRAMA) {
        this.LARGOUNIDADDIAGRAMA = LARGOUNIDADDIAGRAMA;
    }

    /**
     * @return the ANCHOUNIDADDIAGRAMA
     */
    public int getANCHOUNIDADDIAGRAMA() {
        return ANCHOUNIDADDIAGRAMA;
    }

    /**
     * @param ANCHOUNIDADDIAGRAMA the ANCHOUNIDADDIAGRAMA to set
     */
    public void setANCHOUNIDADDIAGRAMA(int ANCHOUNIDADDIAGRAMA) {
        this.ANCHOUNIDADDIAGRAMA = ANCHOUNIDADDIAGRAMA;
    }

    /**
     * @return the FECHACREACION
     */
    public String getFECHACREACION() {
        return FECHACREACION;
    }

    /**
     * @param FECHACREACION the FECHACREACION to set
     */
    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    /**
     * @return the ESTADO
     */
    public boolean isESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getTIPOZONA() {
        return TIPOZONA;
    }

    public void setTIPOZONA(String TIPOZONA) {
        this.TIPOZONA = TIPOZONA;
    }

    public String getUNIDADMEDIDA() {
        return UNIDADMEDIDA;
    }

    public void setUNIDADMEDIDA(String UNIDADMEDIDA) {
        this.UNIDADMEDIDA = UNIDADMEDIDA;
    }

    public boolean isSELECCION() {
        return SELECCION;
    }

    public void setSELECCION(boolean SELECCION) {
        this.SELECCION = SELECCION;
    }

    public boolean isPICKED() {
        return PICKED;
    }

    public void setPICKED(boolean PICKED) {
        this.PICKED = PICKED;
    }

    public int getFILA() {
        return FILA;
    }

    public void setFILA(int FILA) {
        this.FILA = FILA;
    }

    public int getCOLUMNA() {
        return COLUMNA;
    }

    public void setCOLUMNA(int COLUMNA) {
        this.COLUMNA = COLUMNA;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    /**
     * @return the COLOR
     */
    public String getCOLOR() {
        return COLOR;
    }

    /**
     * @param COLOR the COLOR to set
     */
    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    /**
     * @return the IDPROCESO
     */
    public int getIDPROCESO() {
        return IDPROCESO;
    }

    /**
     * @param IDPROCESO the IDPROCESO to set
     */
    public void setIDPROCESO(int IDPROCESO) {
        this.IDPROCESO = IDPROCESO;
    }

}
