/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.DAlmacen_Racks;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author aburgos
 */
@XStreamAlias("TABLAALMACEN")
public class TablaAlmacen {
    @XStreamAlias("IDEMPRESA")
    private int idempresa;
    @XStreamAlias("IDSUCURSAL")
    private int idsucursal;
    @XStreamAlias("IDALMACEN")
    private String idalmacen;
    private int id;
    private String almacen;
    private int capacidad;
    private int capvista;
    private List<DAlmacen_Racks> listaRacks;
    @XStreamAlias("ESTADO")
    private int estado;
    public TablaAlmacen(int id, String idalmacen) {
        this.id = id;
        this.idalmacen = idalmacen;
    }
    public TablaAlmacen() {
        this.id = 0;
        this.idalmacen = null;
        this.almacen=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(String idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<DAlmacen_Racks> getListaRacks() {
        return listaRacks;
    }

    public void setListaRacks(List<DAlmacen_Racks> listaRacks) {
        this.listaRacks = listaRacks;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getCapvista() {
        return capvista;
    }

    public void setCapvista(int capvista) {
        this.capvista = capvista;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
