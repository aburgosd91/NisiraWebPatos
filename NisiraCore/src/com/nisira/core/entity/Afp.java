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
public class Afp implements Serializable{
    private String idafp;
    private String descripcion;
    private int idregimen;
    private boolean estado;
    private char sicroniza;
    private String fechaCreacion;
    /**
     * @return the idafp
     */
    public String getIdafp() {
        return idafp;
    }

    /**
     * @param idafp the idafp to set
     */
    public void setIdafp(String idafp) {
        this.idafp = idafp;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idregimen
     */
    public int getIdregimen() {
        return idregimen;
    }

    /**
     * @param idregimen the idregimen to set
     */
    public void setIdregimen(int idregimen) {
        this.idregimen = idregimen;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the sicroniza
     */
    public char getSicroniza() {
        return sicroniza;
    }

    /**
     * @param sicroniza the sicroniza to set
     */
    public void setSicroniza(char sicroniza) {
        this.sicroniza = sicroniza;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
