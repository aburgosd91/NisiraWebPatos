/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import com.nisira.core.entity.DZonaAccesorio;

/**
 *
 * @author aburgos
 */
public class TablaAccesorio {
    private int id;
    private DZonaAccesorio zonaAccesorio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DZonaAccesorio getZonaAccesorio() {
        return zonaAccesorio;
    }

    public void setZonaAccesorio(DZonaAccesorio zonaAccesorio) {
        this.zonaAccesorio = zonaAccesorio;
    }
}
