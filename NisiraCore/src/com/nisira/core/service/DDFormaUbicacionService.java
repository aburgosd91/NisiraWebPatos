/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DDFormaUbicacionBusiness;
import com.nisira.core.entity.DDFormaUbicacion;
import java.util.List;

/**
 * @author Alex Johel Burgos Dionicio
 */
public class DDFormaUbicacionService extends BaseService<DDFormaUbicacion>{
    private DDFormaUbicacionBusiness ddFormaUbicacionBusiness=new DDFormaUbicacionBusiness();
    public DDFormaUbicacionService(){
        super.setBaseBusiness(ddFormaUbicacionBusiness);
    }
    public List<DDFormaUbicacion> getRecordDDFormaUbicacion(String empresa,String sucursal,
            String almacen,String idparametro,String idformacionubicacion,String idrack,String prioridad) throws Exception{
        return ddFormaUbicacionBusiness.getRecordDDFormaUbicacion(empresa,sucursal,almacen,idparametro,idformacionubicacion,
                idrack,prioridad);
    }
    public String addFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionBusiness.addDDFormaUbicacion(ddFormaUbicacion);
    }
    public String addXmlDDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion,String idrack,int prioridad,String xml) throws Exception{
        return ddFormaUbicacionBusiness.addXmlDDFormaUbicacion(empresa,sucursal,almacen,idparametro,
                idformacionubicacion,idrack,prioridad,xml);
    }
    public String editDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionBusiness.editDDFormaUbicacion(ddFormaUbicacion);
    }
    public String deleteDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionBusiness.deleteDDFormaUbicacion(ddFormaUbicacion);
    }
}
