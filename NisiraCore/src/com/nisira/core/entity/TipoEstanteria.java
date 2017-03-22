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
@XStreamAlias("TIPOESTANTERIA")
public class TipoEstanteria {
    @XStreamAlias("IDTIPOESTANTERIA")
    private int idtipoestanteria;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("FECHA")
    private String fecha;
    @XStreamAlias("ESTADO")
    private int estado;

    /**
     * @return the idtipoestanteria
     */
    public int getIdtipoestanteria() {
        return idtipoestanteria;
    }

    /**
     * @param idtipoestanteria the idtipoestanteria to set
     */
    public void setIdtipoestanteria(int idtipoestanteria) {
        this.idtipoestanteria = idtipoestanteria;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    
}
