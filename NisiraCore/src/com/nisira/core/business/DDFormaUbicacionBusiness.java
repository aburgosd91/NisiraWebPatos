/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DDFormaUbicacionDao;
import com.nisira.core.entity.DDFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDFormaUbicacionBusiness extends BaseBusiness<DDFormaUbicacion>{
    private DDFormaUbicacionDao ddFormaUbicacionDao = new DDFormaUbicacionDao();
    public DDFormaUbicacionBusiness(){
        super.setBaseDao(ddFormaUbicacionDao);
    }
    public List<DDFormaUbicacion> getRecordDDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion,String idrack,String prioridad) throws Exception{
        return ddFormaUbicacionDao.findAll(empresa,sucursal,almacen,idparametro,idformacionubicacion,idrack,prioridad);
    }
    public String addDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionDao.addDDFormaUbicacion(ddFormaUbicacion);
    }
    public String addXmlDDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion,String idrack,int prioridad,String xml) throws Exception{
        return ddFormaUbicacionDao.addXmlDDFormaUbicacion(empresa,sucursal,almacen,idparametro,idformacionubicacion,idrack,prioridad,xml);
    }
    public String editDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionDao.editDDFormaUbicacion(ddFormaUbicacion);
    }
    public String deleteDDFormaUbicacion(DDFormaUbicacion ddFormaUbicacion) throws Exception{
        return ddFormaUbicacionDao.deleteDDFormaUbicacion(ddFormaUbicacion);
    }
}
