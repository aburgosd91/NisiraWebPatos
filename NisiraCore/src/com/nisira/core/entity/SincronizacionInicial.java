/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author aburgos
 */
@XStreamAlias("SincronizacionInicial")
public class SincronizacionInicial {
/******************************** TABLAS A SINCRONIZAR **************************************/
    private String GeneracionCodigoEncode;
    private String DGeneracionCodigoEncode;
/********************************************************************************************/    
    public String getGeneracionCodigoEncode() {
        return GeneracionCodigoEncode;
    }

    public void setGeneracionCodigoEncode(String GeneracionCodigoEncode) {
        this.GeneracionCodigoEncode = GeneracionCodigoEncode;
    }

    public String getDGeneracionCodigoEncode() {
        return DGeneracionCodigoEncode;
    }

    public void setDGeneracionCodigoEncode(String DGeneracionCodigoEncode) {
        this.DGeneracionCodigoEncode = DGeneracionCodigoEncode;
    }

    
}
