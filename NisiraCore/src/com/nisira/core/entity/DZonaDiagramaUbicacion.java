/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aburgos
 */
@XStreamAlias("DZONADIAGRAMAUBICACION")
public class DZonaDiagramaUbicacion {

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
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("IDACCESORIO")
    private String IDACCESORIO;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("COLOR")
    private String COLOR;
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
     * @return the IDUBICACION
     */
    public String getIDUBICACION() {
        return IDUBICACION;
    }

    /**
     * @param IDUBICACION the IDUBICACION to set
     */
    public void setIDUBICACION(String IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    /**
     * @return the IDACCESORIO
     */
    public String getIDACCESORIO() {
        return IDACCESORIO;
    }

    /**
     * @param IDACCESORIO the IDACCESORIO to set
     */
    public void setIDACCESORIO(String IDACCESORIO) {
        this.IDACCESORIO = IDACCESORIO;
    }

    /**
     * @return the IDALMACEN
     */
    public String getIDALMACEN() {
        return IDALMACEN;
    }

    /**
     * @param IDALMACEN the IDALMACEN to set
     */
    public void setIDALMACEN(String IDALMACEN) {
        this.IDALMACEN = IDALMACEN;
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

    public int getSINCRONIZA() {
        return SINCRONIZA;
    }

    public void setSINCRONIZA(int SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

}
