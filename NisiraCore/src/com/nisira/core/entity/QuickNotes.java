/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class QuickNotes {
    @XStreamAlias("IDEMPRESA")
    private int idempresa	    ;
    @XStreamAlias("IDNOTES")
    private String idnotes	    ;
    @XStreamAlias("MENSAJE")
    private String mensaje	    ;
    @XStreamAlias("FECHACREACION")
    private String fechacreacion    ;
    @XStreamAlias("ESTADO")
    private int estado	    ;

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
     * @return the idnotes
     */
    public String getIdnotes() {
        return idnotes;
    }

    /**
     * @param idnotes the idnotes to set
     */
    public void setIdnotes(String idnotes) {
        this.idnotes = idnotes;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
