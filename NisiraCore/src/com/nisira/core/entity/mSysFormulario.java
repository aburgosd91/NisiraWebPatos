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
public class mSysFormulario {

    private String idformulario;
    private String clase;
    private String clasedoc;
    private String descripcion;
    private int eslista;
    private String imagen;
    private String paquete;
    private String paquetedoc;
    private String opcion;

    public mSysFormulario() {
    }

    public String getIdformulario() {
        return idformulario;
    }

    public void setIdformulario(String idformulario) {
        this.idformulario = idformulario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClasedoc() {
        return clasedoc;
    }

    public void setClasedoc(String clasedoc) {
        this.clasedoc = clasedoc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEslista() {
        return eslista;
    }

    public void setEslista(int eslista) {
        this.eslista = eslista;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getPaquetedoc() {
        return paquetedoc;
    }

    public void setPaquetedoc(String paquetedoc) {
        this.paquetedoc = paquetedoc;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public boolean isBandLista() {
        return this.getEslista()== 1;
    }

    public void setBandLista(boolean band) {
        this.setEslista((band) ? (int) 1 : (int) 0);
    }
}
