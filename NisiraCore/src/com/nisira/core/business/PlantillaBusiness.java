/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.PlantillaDao;
import com.nisira.core.entity.Plantilla;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class PlantillaBusiness extends BaseBusiness<Plantilla>{
    private PlantillaDao plantillaDao= new  PlantillaDao();
    public PlantillaBusiness(){
        super.setBaseDao(plantillaDao);
    }
    public List<Plantilla> getRecordPlantilla(String empresa) throws Exception{
        return plantillaDao.findAll(empresa);
    }
    public String addPlantilla(Plantilla plantilla) throws Exception{
        return plantillaDao.addPlantilla(plantilla);
    }
    public String addXmlPlantilla(String idempresa,String xml) throws Exception{
        return plantillaDao.addXmlPlantilla(idempresa,xml);
    }
    public String editPlantilla(Plantilla dPlantilla_Operario) throws Exception{
        return plantillaDao.editPlantilla(dPlantilla_Operario);
    }
    public String deletePlantilla(Plantilla plantilla) throws Exception{
        return plantillaDao.deletePlantilla(plantilla);
    }
}
