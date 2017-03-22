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
@XStreamAlias("DZONADIAGRAMA")
public class DZonaDiagrama {
    @XStreamAlias("IDEMPRESA")
    private int IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private int IDSUCURSAL;
    @XStreamAlias("IDZONA")
    private int IDZONA;
    @XStreamAlias("CORDENADAX")
    private int CORDENADAX;
    @XStreamAlias("CORDENADAY")
    private int CORDENADAY;
    @XStreamAlias("IDACCESORIO")
    private Integer IDACCESORIO;
    @XStreamAlias("IDALMACEN")
    private Integer IDALMACEN;
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("COLORHEXADECIMAL")
    private String COLOR;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamOmitField
    private boolean SELECCIONADO;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;

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
     * @return the CORDENADAX
     */
    public int getCORDENADAX() {
        return CORDENADAX;
    }

    /**
     * @param CORDENADAX the CORDENADAX to set
     */
    public void setCORDENADAX(int CORDENADAX) {
        this.CORDENADAX = CORDENADAX;
    }

    /**
     * @return the CORDENADAY
     */
    public int getCORDENADAY() {
        return CORDENADAY;
    }

    /**
     * @param CORDENADAY the CORDENADAY to set
     */
    public void setCORDENADAY(int CORDENADAY) {
        this.CORDENADAY = CORDENADAY;
    }

    /**
     * @return the IDACCESORIO
     */
    public Integer getIDACCESORIO() {
        return IDACCESORIO;
    }

    /**
     * @param IDACCESORIO the IDACCESORIO to set
     */
    public void setIDACCESORIO(Integer IDACCESORIO) {
        this.IDACCESORIO = IDACCESORIO;
    }

    /**
     * @return the IDALMACEN
     */
    public Integer getIDALMACEN() {
        return IDALMACEN;
    }

    /**
     * @param IDALMACEN the IDALMACEN to set
     */
    public void setIDALMACEN(Integer IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
    }

    /**
     * @return the IDDISTRIBUCION
     */
    public String getIDDISTRIBUCION() {
        return IDDISTRIBUCION;
    }

    /**
     * @param IDDISTRIBUCION the IDDISTRIBUCION to set
     */
    public void setIDDISTRIBUCION(String IDDISTRIBUCION) {
        this.IDDISTRIBUCION = IDDISTRIBUCION;
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
    public int getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }
    
}
