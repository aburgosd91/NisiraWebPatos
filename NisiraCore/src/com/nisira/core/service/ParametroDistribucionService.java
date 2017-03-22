/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.ParametroDistribucionBusiness;
import com.nisira.core.entity.ParametroDistribucion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class ParametroDistribucionService extends BaseService<ParametroDistribucion>{
    private ParametroDistribucionBusiness parametroDistribucionBusiness=new ParametroDistribucionBusiness();
    public ParametroDistribucionService(){
        super.setBaseBusiness(parametroDistribucionBusiness);
    }
    public List<ParametroDistribucion> getRecordParametroDistribucion(String empresa) throws Exception{
        return parametroDistribucionBusiness.getRecordParametroDistribucion(empresa);
    }
    public List<ParametroDistribucion> getRecordParametroDistribucionTipoParametro(String empresa,String tipoParametro) throws Exception{
        return parametroDistribucionBusiness.getRecordParametroDistribucionTipoParametro(empresa,tipoParametro);
    }
    public String addParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        return parametroDistribucionBusiness.addParametroDistribucion(parametroDistribucion);
    }
    public String addXmlParametroDistribucion(String empresa,String sucursal,String almacen,String idparametro,String xml) throws Exception{
        return parametroDistribucionBusiness.addXmlParametroDistribucion(empresa,sucursal,almacen,idparametro,xml);
    }
    public String editParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        return parametroDistribucionBusiness.editParametroDistribucion(parametroDistribucion);
    }
    public String deleteParametroDistribucion(ParametroDistribucion parametroDistribucion) throws Exception{
        return parametroDistribucionBusiness.deleteParametroDistribucion(parametroDistribucion);
    }
}
