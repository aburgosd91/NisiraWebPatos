/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.BaseBusiness;
import com.nisira.core.business.DAlmacen_PisosBusiness;
import com.nisira.core.entity.DAlmacen_Pisos;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_PisosService extends BaseService<DAlmacen_Pisos>{
    private DAlmacen_PisosBusiness dAlmacen_PisosBusiness = new DAlmacen_PisosBusiness();
    public DAlmacen_PisosService(){
        super.setBaseBusiness(dAlmacen_PisosBusiness);
    }
    public List<DAlmacen_Pisos> getRecordAlmacenEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks) throws Exception{
        return dAlmacen_PisosBusiness.getRecordDAlmacen_PisosEmpresa(empresa,sucursal,almacen,distribucion,racks);
    }
    public String addAlmacen(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosBusiness.addDAlmacen_Pisos(dAlmacen_Pisos);
    }
    public String addXmlDAlmacen_Pisos(String empresa,String sucursal,String almacen,String iddistribucion,String rack,String xml) throws Exception{
        return dAlmacen_PisosBusiness.addXmlDAlmacen_Pisos(empresa, sucursal, almacen,iddistribucion,rack,xml);
    }
    public String editAlmacen(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosBusiness.editDAlmacen_Pisos(dAlmacen_Pisos);
    }
    public String deleteAlmacen(DAlmacen_Pisos dAlmacen_Pisos) throws Exception{
        return dAlmacen_PisosBusiness.deleteDAlmacen_Pisos(dAlmacen_Pisos);
    }
}
