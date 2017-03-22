/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DMontacargaEquipoBusiness;
import com.nisira.core.entity.DMontacargaEquipo;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DMontacargaEquipoService extends BaseService<DMontacargaEquipo>{
    private DMontacargaEquipoBusiness DMontacargaEquipoBusiness = new DMontacargaEquipoBusiness();
    public DMontacargaEquipoService(){
        super.setBaseBusiness(DMontacargaEquipoBusiness);
    }
    public List<DMontacargaEquipo> findByMontacarga(String idempresa,String idmontacarga) throws Exception{
        return DMontacargaEquipoBusiness.findByMontacarga(idempresa,idmontacarga);
    }
}
