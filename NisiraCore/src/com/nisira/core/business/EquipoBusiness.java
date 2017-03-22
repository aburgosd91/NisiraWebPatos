/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.EquipoDao;
import com.nisira.core.entity.Equipo;
import java.util.List;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
public class EquipoBusiness extends BaseBusiness<Equipo>{
    private EquipoDao equipoDao= new  EquipoDao();
    public EquipoBusiness(){
        super.setBaseDao(equipoDao);
    }
    public List<Equipo> getRecordEquipo(String empresa) throws Exception{
        return equipoDao.findAll(empresa);
    }
    public String saveEquipo(Equipo equipo) throws Exception{
        return equipoDao.saveEquipo(equipo);
    }
 
    public String anularEquipo(Equipo equipo) throws Exception{
        return equipoDao.anularEquipo(equipo);
    }
    public String deleteEquipo(Equipo equipo) throws Exception{
        return equipoDao.deleteEquipo(equipo);
    }
    public Equipo findById(String idempresa, String idequipo)throws Exception{
        return equipoDao.findById(idempresa,idequipo);
    }
    public List<Equipo> findByFiltro(String idempresa, String filtro) throws Exception{
        return equipoDao.findByFiltro(idempresa,filtro);
    }
}
