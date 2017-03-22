/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DMontacargaEquipoDao;
import com.nisira.core.dao.DMontacargaOperarioDao;
import com.nisira.core.entity.DMontacargaEquipo;
import com.nisira.core.entity.DMontacargaOperario;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DMontacargaEquipoBusiness extends BaseBusiness<DMontacargaEquipo>{
    private DMontacargaEquipoDao dMontacargaEquipoDao= new  DMontacargaEquipoDao();
    public DMontacargaEquipoBusiness(){
        super.setBaseDao(dMontacargaEquipoDao);
    }
    
     public List<DMontacargaEquipo> findByMontacarga(String idempresa,String idmontacarga) throws Exception{
        return dMontacargaEquipoDao.findByMontacarga(idempresa,idmontacarga);
    }
}
