/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DFormaUbicacionDao;
import com.nisira.core.entity.DFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DFormaUbicacionBusiness extends BaseBusiness<DFormaUbicacion>{
    private DFormaUbicacionDao dFormaUbicacionDao = new DFormaUbicacionDao();
    public DFormaUbicacionBusiness(){
        super.setBaseDao(dFormaUbicacionDao);
    }
    public List<DFormaUbicacion> getRecordDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion) throws Exception{
        return dFormaUbicacionDao.findAll(empresa,sucursal,almacen,idparametro,idformacionubicacion);
    }
    public String addDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionDao.addDFormaUbicacion(dFormaUbicacion);
    }
    public String addXmlDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idparametro,String idformacionubicacion,String xml) throws Exception{
        return dFormaUbicacionDao.addXmlDFormaUbicacion(empresa,sucursal,almacen,idparametro,idformacionubicacion,xml);
    }
    public String editDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionDao.editDFormaUbicacion(dFormaUbicacion);
    }
    public String deleteDFormaUbicacion(DFormaUbicacion dFormaUbicacion) throws Exception{
        return dFormaUbicacionDao.deleteDFormaUbicacion(dFormaUbicacion);
    }
}
