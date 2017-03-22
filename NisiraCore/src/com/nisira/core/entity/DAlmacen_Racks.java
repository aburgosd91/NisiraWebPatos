package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("DALMACEN_RACKS")
public class DAlmacen_Racks {

    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA; // 1
    @XStreamAlias("IDSUCURSAL")
    private String IDSUCURSAL; //2 
    @XStreamAlias("IDALMACEN")
    private String IDALMACEN; // 3
    @XStreamAlias("IDDISTRIBUCION")
    private String IDDISTRIBUCION; //4
    @XStreamAlias("IDRACK")
    private String IDRACK; // 5
    @XStreamAlias("IDUBICACION")
    private String IDUBICACION; //6
    @XStreamAlias("IDTIPORACKS")
    private int IDTIPORACK;//  7
    @XStreamAlias("ITEM")
    private String ITEM; //8
    @XStreamAlias("TIPOUBICACION")
    private String TIPOUBICACION; //9
    @XStreamAlias("ESTADO")
    private int ESTADO; //11
    @XStreamAlias("CODIGOCLIENTE")
    private String CODIGOCLIENTE;//10
    @XStreamOmitField
    private int CAPACIDAD;
    @XStreamOmitField
    private int DISPONIBLE;
    @XStreamOmitField
    private boolean SELECCION;
    @XStreamOmitField
    private int posicion;
    @XStreamOmitField
    private int FILAS;
    @XStreamOmitField
    private int COLUMNAS;
    @XStreamOmitField
    private int PISOS;
    @XStreamOmitField
    private boolean picked;
    @XStreamOmitField
    private String TIPORACKS;
    @XStreamAlias("SINCRONIZA")
    private int SINCRONIZA; //12
    @XStreamAlias("FECHACREACION")
    private String FECHACREACION; //13
    @XStreamOmitField
    private DDProgramacionalmprioridad fubicacion;
    @XStreamOmitField
    private int PRIORIDAD;
    @XStreamOmitField
    private boolean SELECCIONADO;
    @XStreamOmitField
    private List<DAlmacen_Pisos> lpisos;
    @XStreamOmitField
    private List<Integer> arregloTempP;
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

    /**
     * @return the CAPACIDAD
     */
    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    /**
     * @param CAPACIDAD the CAPACIDAD to set
     */
    public void setCAPACIDAD(int CAPACIDAD) {
        this.CAPACIDAD = CAPACIDAD;
    }

    /**
     * @return the DISPONIBLE
     */
    public int getDISPONIBLE() {
        return DISPONIBLE;
    }

    /**
     * @param DISPONIBLE the DISPONIBLE to set
     */
    public void setDISPONIBLE(int DISPONIBLE) {
        this.DISPONIBLE = DISPONIBLE;
    }

    /**
     * @return the SELECCION
     */
    public boolean isSELECCION() {
        return SELECCION;
    }

    /**
     * @param SELECCION the SELECCION to set
     */
    public void setSELECCION(boolean SELECCION) {
        this.SELECCION = SELECCION;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the FILAS
     */
    public int getFILAS() {
        return FILAS;
    }

    /**
     * @param FILAS the FILAS to set
     */
    public void setFILAS(int FILAS) {
        this.FILAS = FILAS;
    }

    /**
     * @return the COLUMNAS
     */
    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    /**
     * @param COLUMNAS the COLUMNAS to set
     */
    public void setCOLUMNAS(int COLUMNAS) {
        this.COLUMNAS = COLUMNAS;
    }

    public int getPISOS() {
        return PISOS;
    }

    public void setPISOS(int PISOS) {
        this.PISOS = PISOS;
    }

    /**
     * @return the IDTIPORACK
     */
    public int getIDTIPORACK() {
        return IDTIPORACK;
    }

    /**
     * @param IDTIPORACK the IDTIPORACK to set
     */
    public void setIDTIPORACK(int IDTIPORACK) {
        this.IDTIPORACK = IDTIPORACK;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public String getTIPORACKS() {
        return TIPORACKS;
    }

    public void setTIPORACKS(String TIPORACKS) {
        this.TIPORACKS = TIPORACKS;
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

    public DDProgramacionalmprioridad getFubicacion() {
        return fubicacion;
    }

    public void setFubicacion(DDProgramacionalmprioridad fubicacion) {
        this.fubicacion = fubicacion;
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

    public List<DAlmacen_Pisos> getLpisos() {
        return lpisos;
    }

    public void setLpisos(List<DAlmacen_Pisos> lpisos) {
        this.lpisos = lpisos;
    }

    public List<Integer> getArregloTempP() {
        return arregloTempP;
    }

    public void setArregloTempP(List<Integer> arregloTempP) {
        this.arregloTempP = arregloTempP;
    }

}
