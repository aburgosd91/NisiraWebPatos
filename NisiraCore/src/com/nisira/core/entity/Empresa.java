/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class Empresa implements Serializable {

    private String idbasedatos;
    private String idempresa;
    private String razon_social;
    private String direccion;
    private String descripcion;
    private String ruc;
    private String ruta_exportar;
    private String ruta_reportes;
;
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdbasedatos() {
        return idbasedatos;
    }

    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRuta_exportar() {
        return ruta_exportar;
    }

    public void setRuta_exportar(String ruta_exportar) {
        this.ruta_exportar = ruta_exportar;
    }

    public String getRuta_reportes() {
        return ruta_reportes;
    }

    public void setRuta_reportes(String ruta_reportes) {
        this.ruta_reportes = ruta_reportes;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

}
