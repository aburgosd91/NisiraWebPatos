/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class TablaDistribucion implements Serializable{
    private int numRacks;
    private int numPisos;
    private int numFilas;
    private int numColumnas;
    private int idtiporacks;

    /**
     * @return the numRacks
     */
    public int getNumRacks() {
        return numRacks;
    }

    /**
     * @param numRacks the numRacks to set
     */
    public void setNumRacks(int numRacks) {
        this.numRacks = numRacks;
    }

    /**
     * @return the numPisos
     */
    public int getNumPisos() {
        return numPisos;
    }

    /**
     * @param numPisos the numPisos to set
     */
    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    /**
     * @return the numFilas
     */
    public int getNumFilas() {
        return numFilas;
    }

    /**
     * @param numFilas the numFilas to set
     */
    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    /**
     * @return the numColumnas
     */
    public int getNumColumnas() {
        return numColumnas;
    }

    /**
     * @param numColumnas the numColumnas to set
     */
    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public int getIdtiporacks() {
        return idtiporacks;
    }

    public void setIdtiporacks(int idtiporacks) {
        this.idtiporacks = idtiporacks;
    }
}
