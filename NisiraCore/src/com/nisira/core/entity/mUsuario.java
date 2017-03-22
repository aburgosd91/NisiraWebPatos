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
public class mUsuario {
    private String idusuario;
    private String clave;
    private int estado;
    private String nombres;
    private String idgrupousuario;
    private String idoperario;
    public mUsuario() {
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdgrupousuario() {
        return idgrupousuario;
    }

    public void setIdgrupousuario(String idgrupousuario) {
        this.idgrupousuario = idgrupousuario;
    }

    public String getIdoperario() {
        return idoperario;
    }

    public void setIdoperario(String idoperario) {
        this.idoperario = idoperario;
    }
    
    public boolean isBEstado() {
        return this.getEstado()== 1;
    }

    public void setBEstado(boolean band) {
        this.setEstado((band) ? (int) 1 : (int) 0);
    }
}
