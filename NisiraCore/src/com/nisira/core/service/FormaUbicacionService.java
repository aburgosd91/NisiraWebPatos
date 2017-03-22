/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.FormaUbicacionBusiness;
import com.nisira.core.entity.FormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class FormaUbicacionService extends BaseService<FormaUbicacion>{
    private FormaUbicacionBusiness formaUbicacionBusiness=new FormaUbicacionBusiness();
    public FormaUbicacionService(){
        super.setBaseBusiness(formaUbicacionBusiness);
    }
    public List<FormaUbicacion> getRecordFormaUbicacion(String empresa,String sucursal,
            String almacen,String idparametro) throws Exception{
        return formaUbicacionBusiness.getRecordFormaUbicacion(empresa,sucursal,almacen,idparametro);
    }
    public String addFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionBusiness.addFormaUbicacion(formaUbicacion);
    }
    public String addXmlFormaUbicacion(String empresa,String sucursal,String almacen,String idparametro,String xml) throws Exception{
        return formaUbicacionBusiness.addXmlFormaUbicacion(empresa,sucursal,almacen,idparametro,xml);
    }
    public String editFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionBusiness.editFormaUbicacion(formaUbicacion);
    }
    public String deleteFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionBusiness.deleteFormaUbicacion(formaUbicacion);
    }
}
