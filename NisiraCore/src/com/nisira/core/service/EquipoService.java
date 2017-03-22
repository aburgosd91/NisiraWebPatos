/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.EquipoBusiness;
import com.nisira.core.entity.Equipo;
import java.util.List;

/**
 *
  * @author Victor Zavala <vzavala@nisira.com.pe>
 */
public class EquipoService extends BaseService<Equipo>{
    private EquipoBusiness EquipoBusiness = new EquipoBusiness();
    public EquipoService(){
        super.setBaseBusiness(EquipoBusiness);
    }
    public List<Equipo> getRecordEquipo(String empresa) throws Exception{
        return EquipoBusiness.getRecordEquipo(empresa);
    }
    public String saveEquipo(Equipo montacarga) throws Exception{
        return EquipoBusiness.saveEquipo(montacarga);
    }
    public Equipo findById(String idempresa,String idmontacarga) throws Exception{
        return EquipoBusiness.findById(idempresa,idmontacarga);
    }
    public String anularEquipo(Equipo montacarga) throws Exception{
        return EquipoBusiness.anularEquipo(montacarga);
    }
    public String deleteEquipo(Equipo montacarga) throws Exception{
        return EquipoBusiness.deleteEquipo(montacarga);
    }
    public List<Equipo> findByFiltro(String idempresa, String filtro) throws Exception{
        return EquipoBusiness.findByFiltro(idempresa,filtro);
    }
    
}
