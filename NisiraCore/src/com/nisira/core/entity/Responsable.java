/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.sql.Timestamp;

/**
 *
 * @author azamora
 */
@XStreamAlias("RESPONSABLE")
public class Responsable {
    @XStreamAlias("idempresa")
    private int idempresa;
    @XStreamAlias("idresponsable")
    private int idresponsable;
    @XStreamAlias("idoperario")
    private String idoperario;
    @XStreamAlias("estado")
    private int estado;
    @XStreamAlias("fechacreacion")
    private Timestamp fechacreacion;
    private String nombre;
    public Responsable() {
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }

    public String getIdoperario() {
        return idoperario;
    }

    public void setIdoperario(String idoperario) {
        this.idoperario = idoperario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
