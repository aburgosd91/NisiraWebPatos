/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.RegionesDao;
import com.nisira.core.entity.Regiones;
import java.util.List;


/**
 *
 * @author aburgos
 */
public class RegionesBusiness extends BaseBusiness<Regiones>{
    private RegionesDao regionesDao= new  RegionesDao();
    public RegionesBusiness(){
        super.setBaseDao(regionesDao);
    }
    public List<Regiones> getRecordRegiones(String empresa,String idplantilla) throws Exception{
        return regionesDao.findAll(empresa,idplantilla);
    }
    public Regiones getRegiones(String empresa,String idplantilla,String idregion) throws Exception{
        return regionesDao.findOne(empresa,idplantilla,idregion);
    }
    public String addRegiones(Regiones regiones) throws Exception{
        return regionesDao.addRegiones(regiones);
    }
    public String addXmlRegiones(String idempresa,String idplantilla,String xml) throws Exception{
        return regionesDao.addXmlRegiones(idempresa,idplantilla,xml);
    }
    public String editRegiones(Regiones dRegiones_Operario) throws Exception{
        return regionesDao.editRegiones(dRegiones_Operario);
    }
    public String deleteRegiones(Regiones regiones) throws Exception{
        return regionesDao.deleteRegiones(regiones);
    }
}
