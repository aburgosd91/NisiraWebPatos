/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("DALMACEN_PISOS")
public class DAlmacen_Pisos {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION;
    @XStreamAlias("IDRACK")
    private String IDRACK;
    @XStreamAlias("IDPISO")
    private String IDPISO;
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION;
    @XStreamAlias("ITEMRACK")
    private String ITEMRACK;
    @XStreamAlias("ITEM")
    private String ITEM;
    @XStreamAlias("TIPOUBICACION")
    private String TIPOUBICACION;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("CODIGOCLIENTE")
    private String CODIGOCLIENTE;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamOmitField
    private int PRIORIDAD;
    @XStreamOmitField
    private boolean SELECCIONADO;
    @XStreamOmitField
    private List<DAlmacen_Columnas> lcolumnas;
    @XStreamOmitField
    private List<Integer> arregloTempFC;
    /**
     * @return the IDEMPRESA
     */
    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    /**
     * @param IDEMPRESA the IDEMPRESA to set
     */
    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    /**
     * @return the IDSUCURSAL
     */
    public String getIDSUCURSAL() {
        return IDSUCURSAL;
    }

    /**
     * @param IDSUCURSAL the IDSUCURSAL to set
     */
    public void setIDSUCURSAL(String IDSUCURSAL) {
        this.IDSUCURSAL = IDSUCURSAL;
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
     * @return the IDRACK
     */
    public String getIDRACK() {
        return IDRACK;
    }

    /**
     * @param IDRACK the IDRACK to set
     */
    public void setIDRACK(String IDRACK) {
        this.IDRACK = IDRACK;
    }

    /**
     * @return the IDPISO
     */
    public String getIDPISO() {
        return IDPISO;
    }

    /**
     * @param IDPISO the IDPISO to set
     */
    public void setIDPISO(String IDPISO) {
        this.IDPISO = IDPISO;
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
     * @return the ITEMRACK
     */
    public String getITEMRACK() {
        return ITEMRACK;
    }

    /**
     * @param ITEMRACK the ITEMRACK to set
     */
    public void setITEMRACK(String ITEMRACK) {
        this.ITEMRACK = ITEMRACK;
    }

    /**
     * @return the ITEM
     */
    public String getITEM() {
        return ITEM;
    }

    /**
     * @param ITEM the ITEM to set
     */
    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    /**
     * @return the TIPOUBICACION
     */
    public String getTIPOUBICACION() {
        return TIPOUBICACION;
    }

    /**
     * @param TIPOUBICACION the TIPOUBICACION to set
     */
    public void setTIPOUBICACION(String TIPOUBICACION) {
        this.TIPOUBICACION = TIPOUBICACION;
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

    /**
     * @return the CODIGOCLIENTE
     */
    public String getCODIGOCLIENTE() {
        return CODIGOCLIENTE;
    }

    /**
     * @param CODIGOCLIENTE the CODIGOCLIENTE to set
     */
    public void setCODIGOCLIENTE(String CODIGOCLIENTE) {
        this.CODIGOCLIENTE = CODIGOCLIENTE;
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

    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }

    public List<DAlmacen_Columnas> getLcolumnas() {
        return lcolumnas;
    }

    public void setLcolumnas(List<DAlmacen_Columnas> lcolumnas) {
        this.lcolumnas = lcolumnas;
    }

    public List<Integer> getArregloTempFC() {
        return arregloTempFC;
    }

    public void setArregloTempFC(List<Integer> arregloTempFC) {
        this.arregloTempFC = arregloTempFC;
    }
    
}
