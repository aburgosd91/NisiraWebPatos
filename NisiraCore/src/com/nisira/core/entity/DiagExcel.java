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
public class DiagExcel {

    private String color;
    private String layer;
    private Double PositionX;
    private Double PositionY;
    private Double value;
    private String zona;
    private String tipo;
    private String Proceso;
    private Double nX;
    private Double nY;
    private String Punto;
    private Integer Pisos;
    private Integer Filas;
    private Integer Columnas;
    private Integer TipoZona;
    private boolean checked;
    public DiagExcel() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Double getPositionX() {
        return PositionX;
    }

    public void setPositionX(Double PositionX) {
        this.PositionX = PositionX;
    }

    public Double getPositionY() {
        return PositionY;
    }

    public void setPositionY(Double PositionY) {
        this.PositionY = PositionY;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProceso() {
        return Proceso;
    }

    public void setProceso(String Proceso) {
        this.Proceso = Proceso;
    }

    public Double getnX() {
        return nX;
    }

    public void setnX(Double nX) {
        this.nX = nX;
    }

    public Double getnY() {
        return nY;
    }

    public void setnY(Double nY) {
        this.nY = nY;
    }

    public String getPunto() {
        return Punto;
    }

    public void setPunto(String Punto) {
        this.Punto = Punto;
    }

    public Integer getPisos() {
        return Pisos;
    }

    public void setPisos(Integer Pisos) {
        this.Pisos = Pisos;
    }

    public Integer getFilas() {
        return Filas;
    }

    public void setFilas(Integer Filas) {
        this.Filas = Filas;
    }

    public Integer getColumnas() {
        return Columnas;
    }

    public void setColumnas(Integer Columnas) {
        this.Columnas = Columnas;
    }

    public boolean isChecked() {
        return checked;
    }

    public Integer getTipoZona() {
        return TipoZona;
    }

    public void setTipoZona(Integer TipoZona) {
        this.TipoZona = TipoZona;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
