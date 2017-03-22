/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DAlmacen_PisosDao;
import com.nisira.core.entity.DAlmacen_Pisos;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_PisosBusiness extends BaseBusiness<DAlmacen_Pisos>{
    private DAlmacen_PisosDao dAlmacen_PisosDao = new  DAlmacen_PisosDao();
    public DAlmacen_PisosBusiness(){
        super.setBaseDao(dAlmacen_PisosDao);
    }
    public List<DAlmacen_Pisos> getRecordDAlmacen_PisosEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks) throws Exception{
        return dAlmacen_PisosDao.findAll(empresa,sucursal,almacen,distribucion,racks);
    }
    public String addDAlmacen_Pisos(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosDao.addDAlmacen_Pisos(dAlmacen_Pisos);
    }
    public String addXmlDAlmacen_Pisos(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String idrack,String xml) throws Exception{
        return dAlmacen_PisosDao.addDPisoXML(idempresa,idsucursal,idalmacen,iddistribucion,idrack,xml);
    }
    public String editDAlmacen_Pisos(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosDao.editDAlmacen_Pisos(dAlmacen_Pisos);
    }
    public String deleteDAlmacen_Pisos(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosDao.deleteDAlmacen_Pisos(dAlmacen_Pisos);
    }
}
