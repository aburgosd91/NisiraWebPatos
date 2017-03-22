/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

/**
 *
 * @author azamora
 */
public class mSysOpcion {

    private int prioridad;
    private String idmodulo;
    private String idformulario;
    private String idgrupo;
    private String idtitulo;

    public mSysOpcion() {
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(String idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getIdformulario() {
        return idformulario;
    }

    public void setIdformulario(String idformulario) {
        this.idformulario = idformulario;
    }

    public String getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(String idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(String idtitulo) {
        this.idtitulo = idtitulo;
    }

}
