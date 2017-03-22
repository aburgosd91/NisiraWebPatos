/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DMontacargaOperarioDao;
import com.nisira.core.entity.DMontacargaOperario;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DMontacargaOperarioBusiness extends BaseBusiness<DMontacargaOperario>{
    private DMontacargaOperarioDao dMontacargaOperarioDao= new  DMontacargaOperarioDao();
    public DMontacargaOperarioBusiness(){
        super.setBaseDao(dMontacargaOperarioDao);
    }
   
    public List<DMontacargaOperario> findByMontacarga(String idempresa,String idmontacarga) throws Exception{
        return dMontacargaOperarioDao.findByMontacarga(idempresa,idmontacarga);
    }
}
