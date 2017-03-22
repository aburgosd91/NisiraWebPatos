/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.BaseBusiness;
import com.nisira.core.business.DFormaUbicacionBusiness;
import com.nisira.core.entity.DFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DFormaUbicacionService extends BaseService<DFormaUbicacion>{
    private DFormaUbicacionBusiness dFormaUbicacionBusiness=new DFormaUbicacionBusiness();
    public DFormaUbicacionService(){
        super.setBaseBusiness(dFormaUbicacionBusiness);
    }
    public List<DFormaUbicacion> getRecordFormaUbicacion(String empresa,String sucursal,
            String almacen,String idparametro,String idformacionubicacion) throws Exception{
        return dFormaUbicacionBusiness.getRecordDFormaUbicacion(empresa,sucursal,almacen,idparametro,idformacionubicacion);
    }
    public String addFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionBusiness.addDFormaUbicacion(dFormaUbicacion);
    }
    public String addXmlDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion,String xml) throws Exception{
        return dFormaUbicacionBusiness.addXmlDFormaUbicacion(empresa,sucursal,almacen,idparametro,
                idformacionubicacion,xml);
    }
    public String editDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionBusiness.editDFormaUbicacion(dFormaUbicacion);
    }
    public String deleteDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionBusiness.deleteDFormaUbicacion(dFormaUbicacion);
    }
}
