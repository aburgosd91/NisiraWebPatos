/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.PlantillaBusiness;
import com.nisira.core.entity.Plantilla;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class PlantillaService extends BaseService<Plantilla>{
    private PlantillaBusiness PlantillaBusiness = new PlantillaBusiness();
    public PlantillaService(){
        super.setBaseBusiness(PlantillaBusiness);
    }
    public List<Plantilla> getRecordPlantilla(String empresa) throws Exception{
        return PlantillaBusiness.getRecordPlantilla(empresa);
    }
    public String addPlantilla(Plantilla montacarga) throws Exception{
        return PlantillaBusiness.addPlantilla(montacarga);
    }
    public String addXmlPlantilla(String empresa,String xml) throws Exception{
        return PlantillaBusiness.addXmlPlantilla(empresa,xml);
    }
    public String editPlantilla(Plantilla montacarga) throws Exception{
        return PlantillaBusiness.editPlantilla(montacarga);
    }
    public String deletePlantilla(Plantilla montacarga) throws Exception{
        return PlantillaBusiness.deletePlantilla(montacarga);
    }
}
