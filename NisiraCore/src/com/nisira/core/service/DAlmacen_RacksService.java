/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DAlmacen_RacksBusiness;
import com.nisira.core.entity.DAlmacen_Racks;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_RacksService  extends BaseService<DAlmacen_Racks>{
    private DAlmacen_RacksBusiness DAlmacen_RacksBusiness = new DAlmacen_RacksBusiness();
    public DAlmacen_RacksService(){
        super.setBaseBusiness(DAlmacen_RacksBusiness);
    }
    public List<DAlmacen_Racks> getRecordAlmacenEmpresa(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return DAlmacen_RacksBusiness.getRecordDAlmacen_RacksEmpresa(empresa,sucursal,almacen,distribucion);
    }
    public List<DAlmacen_Racks> getRecordPeriodoAlmacenSucursalEmpresa(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return DAlmacen_RacksBusiness.getRecordDAlmacen_RacksPeriodoSucursalEmpresa(empresa,sucursal,almacen,distribucion);
    }
    public List<DAlmacen_Racks> getRecordAlmacenEmpresaCapacidad(String empresa,String sucursal,String almacen,String distribucion) throws Exception{
        return DAlmacen_RacksBusiness.getRecordDAlmacen_RacksEmpresaCapacidad(empresa,sucursal,almacen,distribucion);
    }
    public String addAlmacen(DAlmacen_Racks almacen) throws Exception{
        return DAlmacen_RacksBusiness.addDAlmacen_Racks(almacen);
    }
    public String addXmlDAlmacen_Racks(String empresa,String sucursal,String almacen,String iddistribucion,String xml) throws Exception{
        return DAlmacen_RacksBusiness.addXmlDAlmacen_Racks(empresa, sucursal, almacen,iddistribucion,xml);
    }
    public String editAlmacen(DAlmacen_Racks almacen) throws Exception{
        return DAlmacen_RacksBusiness.editDAlmacen_Racks(almacen);
    }
    public String deleteAlmacen(DAlmacen_Racks almacen) throws Exception{
        return DAlmacen_RacksBusiness.deleteDAlmacen_Racks(almacen);
    }
    
}
