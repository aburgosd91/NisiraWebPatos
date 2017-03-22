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
@XStreamAlias("ACTIVIDADES")
public class Actividades {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDACTIVIDADES")
    private int idactividades;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("FECHA")
    private String fecha;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("ICONO")
    private String icono;

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
     * @return the idactividades
     */
    public int getIdactividades() {
        return idactividades;
    }

    /**
     * @param idactividades the idactividades to set
     */
    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
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

    /**
     * @return the icono
     */
    public String getIcono() {
        return icono;
    }

    /**
     * @param icono the icono to set
     */
    public void setIcono(String icono) {
        this.icono = icono;
    }
}
