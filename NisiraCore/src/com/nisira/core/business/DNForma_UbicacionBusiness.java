/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DNForma_UbicacionDao;
import com.nisira.core.entity.DNFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DNForma_UbicacionBusiness extends BaseBusiness<DNFormaUbicacion>{
    private DNForma_UbicacionDao dNForma_UbicacionDao = new DNForma_UbicacionDao();
    public DNForma_UbicacionBusiness(){
        super.setBaseDao(dNForma_UbicacionDao);
    }
    public List<DNFormaUbicacion> getRecordDNForma_Ubicacion(String empresa,String sucursal,String almacen) throws Exception{
        return dNForma_UbicacionDao.findAll(empresa,sucursal,almacen,"");
    }
    public String addDNForma_Ubicacion(DNFormaUbicacion dFormaUbicacion) throws Exception{
        return dNForma_UbicacionDao.addDNForma_Ubicacion(dFormaUbicacion);
    }
    public String addXmlDNForma_Ubicacion(String empresa,String sucursal,String almacen,String xml) throws Exception{
        return dNForma_UbicacionDao.addXmlDNForma_Ubicacion(empresa,sucursal,almacen,"",xml);
    }
    public String editDNForma_Ubicacion(DNFormaUbicacion dFormaUbicacion) throws Exception{
        return dNForma_UbicacionDao.editDNForma_Ubicacion(dFormaUbicacion);
    }
    public String deleteDNForma_Ubicacion(DNFormaUbicacion dFormaUbicacion) throws Exception{
        return dNForma_UbicacionDao.deleteDNForma_Ubicacion(dFormaUbicacion);
    }
}
