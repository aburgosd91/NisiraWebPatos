/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;
import com.nisira.core.dao.FormaUbicacionDao;
import com.nisira.core.entity.FormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class FormaUbicacionBusiness extends BaseBusiness<FormaUbicacion>{
    private FormaUbicacionDao formaUbicacionDao = new FormaUbicacionDao();
    public FormaUbicacionBusiness(){
        super.setBaseDao(formaUbicacionDao);
    }
    public List<FormaUbicacion> getRecordFormaUbicacion(String empresa,String sucursal,String almacen,String idparametro) throws Exception{
        return formaUbicacionDao.findAll(empresa,sucursal,almacen,idparametro);
    }
    public String addFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionDao.addFormaUbicacion(formaUbicacion);
    }
    public String addXmlFormaUbicacion(String empresa,String sucursal,String almacen,String idparametro,String xml) throws Exception{
        return formaUbicacionDao.addXmlFormaUbicacion(empresa,sucursal,almacen,idparametro,xml);
    }
    public String editFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionDao.editDFormaUbicacion(formaUbicacion);
    }
    public String deleteFormaUbicacion(FormaUbicacion formaUbicacion) throws Exception{
        return formaUbicacionDao.deleteDFormaUbicacion(formaUbicacion);
    }
}
