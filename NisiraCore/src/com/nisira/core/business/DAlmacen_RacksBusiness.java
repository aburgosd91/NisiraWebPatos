/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DAlmacen_RacksDao;
import com.nisira.core.entity.DAlmacen_Racks;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_RacksBusiness extends BaseBusiness<DAlmacen_Racks>{
    private DAlmacen_RacksDao dAlmacen_RacksDao = new  DAlmacen_RacksDao();
    public DAlmacen_RacksBusiness(){
        super.setBaseDao(dAlmacen_RacksDao);
    }
    public List<DAlmacen_Racks> getRecordDAlmacen_RacksEmpresa(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return dAlmacen_RacksDao.findAll(empresa,sucursal,almacen,distribucion);
    }
    public List<DAlmacen_Racks> getRecordDAlmacen_RacksPeriodoSucursalEmpresa(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return dAlmacen_RacksDao.findAllPeriodo(empresa,sucursal,almacen,distribucion);
    }
    public List<DAlmacen_Racks> getRecordDAlmacen_RacksEmpresaCapacidad(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return dAlmacen_RacksDao.findAllCapacidad(empresa,sucursal,almacen,distribucion);
    }
    public String addDAlmacen_Racks(DAlmacen_Racks dAlmacen_Racks) throws Exception{
        return dAlmacen_RacksDao.addDAlmacen_Racks(dAlmacen_Racks);
    }
    public String addXmlDAlmacen_Racks(String empresa,String sucursal,String almacen,String iddistribucion,String xml) throws Exception{
        return dAlmacen_RacksDao.addDRackXML(empresa,sucursal,almacen,iddistribucion,xml);
    }
    public String editDAlmacen_Racks(DAlmacen_Racks dAlmacen_Racks) throws Exception{
        return dAlmacen_RacksDao.editDAlmacen_Racks(dAlmacen_Racks);
    }
    public String deleteDAlmacen_Racks(DAlmacen_Racks dAlmacen_Racks) throws Exception{
        return dAlmacen_RacksDao.deleteDAlmacen_Racks(dAlmacen_Racks);
    }
}
