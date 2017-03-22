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
@XStreamAlias("DZONAGENERAL")
public class DZonaGeneral {

    private int IDEMPRESA;
    private int IDSUCURSAL;
    private int IDZONAGENERAL;
    private int IDZONA;
    private int CORDENADAX;
    private int CORDENADAY;
    private Integer DCORDENADAX;
    private Integer DCORDENADAY;
    private String COLOR;
    private String IDUBICACION;
    private String FECHACREACION;
    private int SINCRONIZA;
    private Integer PUERTA;
    private boolean SELECCIONADO;

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

    public int getIDZONAGENERAL() {
        return IDZONAGENERAL;
    }

    public void setIDZONAGENERAL(int IDZONAGENERAL) {
        this.IDZONAGENERAL = IDZONAGENERAL;
    }

    public int getIDZONA() {
        return IDZONA;
    }

    public void setIDZONA(int IDZONA) {
        this.IDZONA = IDZONA;
    }

    public int getCORDENADAX() {
        return CORDENADAX;
    }

    public void setCORDENADAX(int CORDENADAX) {
        this.CORDENADAX = CORDENADAX;
    }

    public int getCORDENADAY() {
        return CORDENADAY;
    }

    public void setCORDENADAY(int CORDENADAY) {
        this.CORDENADAY = CORDENADAY;
    }

    public Integer getDCORDENADAX() {
        return DCORDENADAX;
    }

    public void setDCORDENADAX(Integer DCORDENADAX) {
        this.DCORDENADAX = DCORDENADAX;
    }

    public Integer getDCORDENADAY() {
        return DCORDENADAY;
    }

    public void setDCORDENADAY(Integer DCORDENADAY) {
        this.DCORDENADAY = DCORDENADAY;
    }

    public String getIDUBICACION() {
        return IDUBICACION;
    }

    public void setIDUBICACION(String IDUBICACION) {
        this.IDUBICACION = IDUBICACION;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

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

    public Integer getPUERTA() {
        return PUERTA;
    }

    public void setPUERTA(Integer PUERTA) {
        this.PUERTA = PUERTA;
    }

    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }
}
