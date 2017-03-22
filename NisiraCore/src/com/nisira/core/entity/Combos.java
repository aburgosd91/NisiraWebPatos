/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class Combos implements Serializable{
    private int ID;
    private String DESCRIPCION;
    private int FILAS;
    private int COLUMNAS;
    private boolean ESTADO;//TRUE-> LLENO 

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
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
     * @return the filas
     */
    public int getFilas() {
        return FILAS;
    }

    /**
     * @param filas the filas to set
     */
    public void setFilas(int filas) {
        this.FILAS = filas;
    }

    /**
     * @return the columnas
     */
    public int getColumnas() {
        return COLUMNAS;
    }

    /**
     * @param columnas the columnas to set
     */
    public void setColumnas(int columnas) {
        this.COLUMNAS = columnas;
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
}
