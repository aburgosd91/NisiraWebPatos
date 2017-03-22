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
public class mGrupoUsuarioPrivilegio {

    private int crear;
    private int eliminar;
    private int modificar;
    private int ver;
    private String idgrupousuario;
    private String idformulario;

    public mGrupoUsuarioPrivilegio() {
    }

    public int getCrear() {
        return crear;
    }

    public void setCrear(int crear) {
        this.crear = crear;
    }

    public int getEliminar() {
        return eliminar;
    }

    public void setEliminar(int eliminar) {
        this.eliminar = eliminar;
    }

    public int getModificar() {
        return modificar;
    }

    public void setModificar(int modificar) {
        this.modificar = modificar;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public String getIdgrupousuario() {
        return idgrupousuario;
    }

    public void setIdgrupousuario(String idgrupousuario) {
        this.idgrupousuario = idgrupousuario;
    }

    public String getIdformulario() {
        return idformulario;
    }

    public void setIdformulario(String idformulario) {
        this.idformulario = idformulario;
    }

    
    
    public boolean isBcrear() {
        return this.getCrear()== 1;
    }

    public void setBcrear(boolean band) {
        this.setCrear((band) ? (int) 1 : (int) 0);
    }
    
    public boolean isBeliminar() {
        return this.getEliminar()== 1;
    }

    public void setBeliminar(boolean band) {
        this.setEliminar((band) ? (int) 1 : (int) 0);
    }
    
    public boolean isBmodificar() {
        return this.getCrear()== 1;
    }

    public void setBmodificar(boolean band) {
        this.setModificar((band) ? (int) 1 : (int) 0);
    }
    
    public boolean isBver() {
        return this.getVer()== 1;
    }

    public void setBver(boolean band) {
        this.setVer((band) ? (int) 1 : (int) 0);
    }
}
