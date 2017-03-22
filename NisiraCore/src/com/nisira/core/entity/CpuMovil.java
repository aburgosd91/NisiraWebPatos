/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 *
 * @author aburgos
 */
@XStreamAlias("CPUMOVIL")
public class CpuMovil {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDCPUMOVIL")
    private int idcpumovil;
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @XStreamAlias("MODELO")
    private String modelo;
    @XStreamAlias("MARCA")
    private String marca;
    @XStreamAlias("PROCESADOR")
    private int procesador;
    @XStreamAlias("RAM")
    private int ram;
    @XStreamAlias("SO")
    private String so;
    @XStreamAlias("ESTADO")
    private int estado;
    @XStreamAlias("FECHACREACION")
    private String fechacreacion;

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
     * @return the idcpumovil
     */
    public int getIdcpumovil() {
        return idcpumovil;
    }

    /**
     * @param idcpumovil the idcpumovil to set
     */
    public void setIdcpumovil(int idcpumovil) {
        this.idcpumovil = idcpumovil;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the procesador
     */
    public int getProcesador() {
        return procesador;
    }

    /**
     * @param procesador the procesador to set
     */
    public void setProcesador(int procesador) {
        this.procesador = procesador;
    }

    /**
     * @return the ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * @return the so
     */
    public String getSo() {
        return so;
    }

    /**
     * @param so the so to set
     */
    public void setSo(String so) {
        this.so = so;
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
    
    
}
