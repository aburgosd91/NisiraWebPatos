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
public class mGrupoUsuario {

    private String idgrupousuario;
    private String descripcion;
    private int  es_administrador;

    public mGrupoUsuario() {
    }

    public String getIdgrupousuario() {
        return idgrupousuario;
    }

    public void setIdgrupousuario(String idgrupousuario) {
        this.idgrupousuario = idgrupousuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEs_administrador() {
        return es_administrador;
    }

    public void setEs_administrador(int es_administrador) {
        this.es_administrador = es_administrador;
    }
    public boolean isBEs_administrador() {
        return this.getEs_administrador()== 1;
    }

    public void setBEs_administrador(boolean band) {
        this.setEs_administrador((band) ? (int) 1 : (int) 0);
    }
}
