/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("TipoEquipoMontacarga")
public class TipoEquipoMontacarga {
    @XStreamAlias("IDEMPRESA")
    private String IDEMPRESA;
    @XStreamAlias("IDTIPOEQUIPOMONTACARGA")
    private String IDTIPOEQUIPOMONTACARGA;
    @XStreamAlias("DESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("ESTADO")
    private boolean ESTADO;

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public String getIDTIPOEQUIPOMONTACARGA() {
        return IDTIPOEQUIPOMONTACARGA;
    }

    public void setIDTIPOEQUIPOMONTACARGA(String IDTIPOEQUIPOMONTACARGA) {
        this.IDTIPOEQUIPOMONTACARGA = IDTIPOEQUIPOMONTACARGA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public boolean isESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }
    
    
}
