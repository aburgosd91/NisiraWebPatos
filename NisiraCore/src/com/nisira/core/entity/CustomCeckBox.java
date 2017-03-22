/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.List;

/**
 *
 * @author azamora
 */
public class CustomCeckBox {
    private String header;
    private List<String> Seleccion;
    private List<Caracteristicas_Producto> boxes;

    public CustomCeckBox() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getSeleccion() {
        return Seleccion;
    }

    public void setSeleccion(List<String> Seleccion) {
        this.Seleccion = Seleccion;
    }

    public List<Caracteristicas_Producto> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Caracteristicas_Producto> boxes) {
        this.boxes = boxes;
    }
    
}
