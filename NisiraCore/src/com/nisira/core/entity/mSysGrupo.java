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
public class mSysGrupo {

    private String descripcion;
    private String imagen;
    private String idmodulo;
    private String idgrupo;
    private String idtitulo;

    public mSysGrupo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(String idmodulo) {
        this.idmodulo = idmodulo;
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
