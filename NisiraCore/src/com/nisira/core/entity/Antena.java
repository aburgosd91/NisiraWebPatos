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
 * @author aburgos
 */
@XStreamAlias("ANTENA")
public class Antena {

    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDANTENA")
    private int idantena;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("NROSERIE")
    private String nroserie;
    @XStreamAlias("MODELO")
    private String modelo;
    @XStreamAlias("MARCA")
    private String marca;
    @XStreamAlias("FRECUENCIA")
    private String frecuencia;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("FECHACREACION")
    private String fechacreacion;

    /**
     * @return the idempresa
     */
    public int getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the idantena
     */
    public int getIdantena() {
        return idantena;
    }

    /**
     * @param idantena the idantena to set
     */
    public void setIdantena(int idantena) {
        this.idantena = idantena;
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
     * @return the nroserie
     */
    public String getNroserie() {
        return nroserie;
    }

    /**
     * @param nroserie the nroserie to set
     */
    public void setNroserie(String nroserie) {
        this.nroserie = nroserie;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the frecuencia
     */
    public String getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the fechacreacion
     */
    public String getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
}
