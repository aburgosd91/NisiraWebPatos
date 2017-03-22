/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.ParametroDistribucionDao;
import com.nisira.core.entity.ParametroDistribucion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class ParametroDistribucionBusiness extends BaseBusiness<ParametroDistribucion>{
    private ParametroDistribucionDao parametroDistribucionDao = new ParametroDistribucionDao();
    public ParametroDistribucionBusiness(){
        super.setBaseDao(parametroDistribucionDao);
    }
    public List<ParametroDistribucion> getRecordParametroDistribucion(String empresa) throws Exception{
        return parametroDistribucionDao.findAll(empresa);
    }
    public List<ParametroDistribucion> getRecordParametroDistribucionTipoParametro(String empresa,String tipoParametro) throws Exception{
        return parametroDistribucionDao.findAllTipoParametro(empresa,tipoParametro);
    }
    public String addParametroDistribucion(ParametroDistribucion formaUbicacion) throws Exception{
        return parametroDistribucionDao.addParametroDistribucion(formaUbicacion);
    }
    public String addXmlParametroDistribucion(String empresa,String sucursal,String almacen,String idparametro,String xml) throws Exception{
        return parametroDistribucionDao.addXmlParametroDistribucion(empresa,sucursal,almacen,idparametro,xml);
    }
    public String editParametroDistribucion(ParametroDistribucion formaUbicacion) throws Exception{
        return parametroDistribucionDao.editDParametroDistribucion(formaUbicacion);
    }
    public String deleteParametroDistribucion(ParametroDistribucion formaUbicacion) throws Exception{
        return parametroDistribucionDao.deleteDParametroDistribucion(formaUbicacion);
    }
}
