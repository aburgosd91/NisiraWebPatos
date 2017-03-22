/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.UbicacionCamaraDao;
import com.nisira.core.entity.UbicacionCamara;
import com.nisira.core.entity.Privilegios;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class UbicacionCamaraBusiness extends BaseBusiness<UbicacionCamara>{
    private UbicacionCamaraDao UbicacionCamaraDao  = new  UbicacionCamaraDao();

    public UbicacionCamaraBusiness() {
        super.setBaseDao(UbicacionCamaraDao);
    }
    
    public UbicacionCamara findByIdUbicacionCamara(String idempresa,String idubicacion) throws Exception {
         return UbicacionCamaraDao.findByIdUbicacionCamara(idempresa, idubicacion);
    }
}
