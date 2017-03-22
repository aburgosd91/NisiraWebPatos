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
@XStreamAlias("ALMACEN")
public class Almacen {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN;
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL;
    @XStreamAlias("SUCURSAL")
    private String SUCURSAL;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("DIRECCION")
    private String DIRECCION;
    @XStreamAlias("IDTIPOALMACEN")
    private int IDTIPOALMACEN;
    @XStreamAlias("ESTADO")
    private int ESTADO;
    @XStreamAlias("SINCRONIZA")
    private String SINCRONIZA;
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION;
    @XStreamAlias("NOMBRE_CORTO")
    private String NOMBRE_CORTO;
    private String DESCRIPCIONSUCURSAL;
    @XStreamOmitField
    private boolean SELECCIONADO;
    @XStreamOmitField
    private int PRIORIDAD;
    @XStreamOmitField
    private List<DAlmacen_Racks> lracks;
    @XStreamOmitField
    private List<Integer> arregloTempR;
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
     * @return the DIRECCION
     */
    public String getDIRECCION() {
        return DIRECCION;
    }

    /**
     * @param DIRECCION the DIRECCION to set
     */
    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    /**
     * @return the IDTIPOALMACEN
     */
    public int getIDTIPOALMACEN() {
        return IDTIPOALMACEN;
    }

    /**
     * @param IDTIPOALMACEN the IDTIPOALMACEN to set
     */
    public void setIDTIPOALMACEN(int IDTIPOALMACEN) {
        this.IDTIPOALMACEN = IDTIPOALMACEN;
    }
    /**
     * @return the SINCRONIZA
     */
    public String getSINCRONIZA() {
        return SINCRONIZA;
    }

    /**
     * @param SINCRONIZA the SINCRONIZA to set
     */
    public void setSINCRONIZA(String SINCRONIZA) {
        this.SINCRONIZA = SINCRONIZA;
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
     * @return the NOMBRE_CORTO
     */
    public String getNOMBRE_CORTO() {
        return NOMBRE_CORTO;
    }

    /**
     * @param NOMBRE_CORTO the NOMBRE_CORTO to set
     */
    public void setNOMBRE_CORTO(String NOMBRE_CORTO) {
        this.NOMBRE_CORTO = NOMBRE_CORTO;
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

    public String getDESCRIPCIONSUCURSAL() {
        return DESCRIPCIONSUCURSAL;
    }

    public void setDESCRIPCIONSUCURSAL(String DESCRIPCIONSUCURSAL) {
        this.DESCRIPCIONSUCURSAL = DESCRIPCIONSUCURSAL;
    }

    /**
     * @return the SUCURSAL
     */
    public String getSUCURSAL() {
        return SUCURSAL;
    }

    /**
     * @param SUCURSAL the SUCURSAL to set
     */
    public void setSUCURSAL(String SUCURSAL) {
        this.SUCURSAL = SUCURSAL;
    }

    public boolean isSELECCIONADO() {
        return SELECCIONADO;
    }

    public void setSELECCIONADO(boolean SELECCIONADO) {
        this.SELECCIONADO = SELECCIONADO;
    }

    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    public List<DAlmacen_Racks> getLracks() {
        return lracks;
    }

    public void setLracks(List<DAlmacen_Racks> lracks) {
        this.lracks = lracks;
    }

    public List<Integer> getArregloTempR() {
        return arregloTempR;
    }

    public void setArregloTempR(List<Integer> arregloTempR) {
        this.arregloTempR = arregloTempR;
    }
    
}
