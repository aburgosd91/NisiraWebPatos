/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class FilasDistribucion implements Serializable{
    private Integer nrofilas;
    private Integer nrocolumnas;
    private String desccamara;
    private String descrack;
    private String descpiso;
    ArrayList<Columna> lista_columnas;

    public ArrayList<Columna> getLista_columnas() {
        return lista_columnas;
    }

    public void setLista_columnas(ArrayList<Columna> lista_columnas) {
        this.lista_columnas = lista_columnas;
    }

    public Integer getNrocolumnas() {
        return nrocolumnas;
    }

    public void setNrocolumnas(Integer nrocolumnas) {
        this.nrocolumnas = nrocolumnas;
    }

    public Integer getNrofilas() {
        return nrofilas;
    }

    public void setNrofilas(Integer nrofilas) {
        this.nrofilas = nrofilas;
    }

    public String getDesccamara() {
        return desccamara;
    }

    public void setDesccamara(String desccamara) {
        this.desccamara = desccamara;
    }

    public String getDescpiso() {
        return descpiso;
    }

    public void setDescpiso(String descpiso) {
        this.descpiso = descpiso;
    }

    public String getDescrack() {
        return descrack;
    }

    public void setDescrack(String descrack) {
        this.descrack = descrack;
    }
    
         
}

