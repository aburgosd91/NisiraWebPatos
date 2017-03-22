/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DMontacargaOperarioBusiness;
import com.nisira.core.entity.DMontacargaOperario;
import com.nisira.core.entity.Montacarga;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DMontacargaOperarioService extends BaseService<DMontacargaOperario>{
    private DMontacargaOperarioBusiness DMontacargaOperarioBusiness = new DMontacargaOperarioBusiness();
    public DMontacargaOperarioService(){
        super.setBaseBusiness(DMontacargaOperarioBusiness);
    }
  
    public List<DMontacargaOperario> findByMontacarga(String idempresa,String idmontacarga) throws Exception{
        return DMontacargaOperarioBusiness.findByMontacarga(idempresa,idmontacarga);
    }
}
