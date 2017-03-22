/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.RegionesBusiness;
import com.nisira.core.entity.Regiones;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class RegionesService extends BaseService<Regiones>{
    private RegionesBusiness RegionesBusiness = new RegionesBusiness();
    public RegionesService(){
        super.setBaseBusiness(RegionesBusiness);
    }
    public List<Regiones> getRecordRegiones(String empresa,String idplantilla) throws Exception{
        return RegionesBusiness.getRecordRegiones(empresa,idplantilla);
    }
    public Regiones getRegiones(String empresa,String idplantilla,String idregiones) throws Exception{
        return RegionesBusiness.getRegiones(empresa,idplantilla,idregiones);
    }
    public String addRegiones(Regiones montacarga) throws Exception{
        return RegionesBusiness.addRegiones(montacarga);
    }
    public String addXmlRegiones(String empresa,String idplantilla,String xml) throws Exception{
        return RegionesBusiness.addXmlRegiones(empresa,idplantilla,xml);
    }
    public String editRegiones(Regiones montacarga) throws Exception{
        return RegionesBusiness.editRegiones(montacarga);
    }
    public String deleteRegiones(Regiones montacarga) throws Exception{
        return RegionesBusiness.deleteRegiones(montacarga);
    }
}
