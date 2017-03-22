/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

/**
 * @author aburgos
 */
public class Regiones {
    private int IDEMPRESA;//0
    private int IDPLANTILLA;//1
    private int IDREGION;//2
    private int JERARQUIA;//3
    private int PRIORIDAD;//4
    private int CX;//5
    private int CY;//6
    private int LARGO;//7
    private int ANCHO;//8
    private int IDGENERACION;//9
    private boolean ESTADO;//10
    private String PLANTILLA;//11
    private String GENERACION;//12
    private int  IDTIPO;//13
    private String TIPO;//14
    public Regiones(){
        this.IDEMPRESA=0;
        this.IDPLANTILLA=0;
        this.IDREGION=0;
        this.JERARQUIA=0;
        this.PRIORIDAD=0;
        this.CX=0;
        this.CY=0;
        this.LARGO=0;//7
        this.ANCHO=0;//8
        this.IDGENERACION=0;//9
        this.ESTADO=true;//10
        this.PLANTILLA="";//11
        this.GENERACION="";//12
        this.TIPO="";
    }
    public Regiones(int empresa,int idregion,int jerarquia,int cx,int cy, int largo,int ancho,int idtipo){
        this.IDEMPRESA=empresa;
        this.IDPLANTILLA=0;
        this.IDREGION=idregion;
        this.JERARQUIA=jerarquia;
        this.PRIORIDAD=0;
        this.CX=cx;
        this.CY=cy;
        this.LARGO=largo;//7
        this.ANCHO=ancho;//8
        this.IDGENERACION=0;//9
        this.ESTADO=true;//10
        this.PLANTILLA="";//11
        this.GENERACION="";//12
        this.IDTIPO=idtipo;
    }
    public Regiones(int IDEMPRESA,int IDPLANTILLA,int IDREGION,int JERARQUIA,int PRIORIDAD,
                    int CX,int CY,int LARGO,int ANCHO,int IDGENERACION,boolean ESTADO,int idtipo,
                    String PLANTILLA,String GENERACION){
        this.IDEMPRESA=IDEMPRESA;
        this.IDPLANTILLA=IDPLANTILLA;
        this.IDREGION=IDREGION;
        this.JERARQUIA=JERARQUIA;
        this.PRIORIDAD=PRIORIDAD;
        this.CX=CX;
        this.CY=CY;
        this.LARGO=LARGO;//7
        this.ANCHO=ANCHO;//8
        this.IDGENERACION=IDGENERACION;//9
        this.ESTADO=ESTADO;//10
        this.PLANTILLA=PLANTILLA;//11
        this.GENERACION=GENERACION;//12
        this.IDTIPO=idtipo;
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
     * @return the IDPLANTILLA
     */
    public int getIDPLANTILLA() {
        return IDPLANTILLA;
    }

    /**
     * @param IDPLANTILLA the IDPLANTILLA to set
     */
    public void setIDPLANTILLA(int IDPLANTILLA) {
        this.IDPLANTILLA = IDPLANTILLA;
    }

    /**
     * @return the IDREGION
     */
    public int getIDREGION() {
        return IDREGION;
    }

    /**
     * @param IDREGION the IDREGION to set
     */
    public void setIDREGION(int IDREGION) {
        this.IDREGION = IDREGION;
    }

    /**
     * @return the JERARQUIA
     */
    public int getJERARQUIA() {
        return JERARQUIA;
    }

    /**
     * @param JERARQUIA the JERARQUIA to set
     */
    public void setJERARQUIA(int JERARQUIA) {
        this.JERARQUIA = JERARQUIA;
    }

    /**
     * @return the PRIORIDAD
     */
    public int getPRIORIDAD() {
        return PRIORIDAD;
    }

    /**
     * @param PRIORIDAD the PRIORIDAD to set
     */
    public void setPRIORIDAD(int PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    /**
     * @return the CX
     */
    public int getCX() {
        return CX;
    }

    /**
     * @param CX the CX to set
     */
    public void setCX(int CX) {
        this.CX = CX;
    }

    /**
     * @return the CY
     */
    public int getCY() {
        return CY;
    }

    /**
     * @param CY the CY to set
     */
    public void setCY(int CY) {
        this.CY = CY;
    }

    /**
     * @return the LARGO
     */
    public int getLargo() {
        return LARGO;
    }

    /**
     * @param LARGO the LARGO to set
     */
    public void setLargo(int LARGO) {
        this.LARGO = LARGO;
    }

    /**
     * @return the ANCHO
     */
    public int getAncho() {
        return ANCHO;
    }

    /**
     * @param ANCHO the ANCHO to set
     */
    public void setAncho(int ANCHO) {
        this.ANCHO = ANCHO;
    }

    /**
     * @return the ESTADO
     */
    public boolean isEstado() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setEstado(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the PLANTILLA
     */
    public String getPLANTILLA() {
        return PLANTILLA;
    }

    /**
     * @param PLANTILLA the PLANTILLA to set
     */
    public void setPLANTILLA(String PLANTILLA) {
        this.PLANTILLA = PLANTILLA;
    }

    /**
     * @return the IDGENERACION
     */
    public int getIDGENERACION() {
        return IDGENERACION;
    }

    /**
     * @param IDGENERACION the IDGENERACION to set
     */
    public void setIDGENERACION(int IDGENERACION) {
        this.IDGENERACION = IDGENERACION;
    }

    /**
     * @return the GENERACION
     */
    public String getGENERACION() {
        return GENERACION;
    }

    /**
     * @param GENERACION the GENERACION to set
     */
    public void setGENERACION(String GENERACION) {
        this.GENERACION = GENERACION;
    }

    /**
     * @return the TIPO
     */
    public String getTIPO() {
        return TIPO;
    }

    /**
     * @param TIPO the TIPO to set
     */
    public void setTIPO(int TIPO) {
        this.setTIPO(TIPO);
    }

    /**
     * @param TIPO the TIPO to set
     */
    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    /**
     * @return the IDTIPO
     */
    public int getIDTIPO() {
        return IDTIPO;
    }

    /**
     * @param IDTIPO the IDTIPO to set
     */
    public void setIDTIPO(int IDTIPO) {
        this.IDTIPO = IDTIPO;
    }
}
