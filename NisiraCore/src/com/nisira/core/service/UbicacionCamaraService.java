/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.UbicacionCamaraBusiness;
import com.nisira.core.entity.UbicacionCamara;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class UbicacionCamaraService extends BaseService<UbicacionCamara> {

    private UbicacionCamaraBusiness UbicacionCamaraBusiness = new UbicacionCamaraBusiness();

    public UbicacionCamaraService() {
        super.setBaseBusiness(UbicacionCamaraBusiness);
    }
    public UbicacionCamara findByIdUbicacionCamara(String idempresa,String idubicacion) throws Exception {
         return UbicacionCamaraBusiness.findByIdUbicacionCamara(idempresa, idubicacion);
    }
}
