/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DAlmacen_FilasBusiness;
import com.nisira.core.entity.DAlmacen_Filas;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_FilasService extends BaseService<DAlmacen_Filas>{
    private DAlmacen_FilasBusiness dAlmacen_FilasBusiness = new DAlmacen_FilasBusiness();
    public DAlmacen_FilasService(){
        super.setBaseBusiness(dAlmacen_FilasBusiness);
    }
    public List<DAlmacen_Filas> getRecordDAlmacen_FilasEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks,String piso) throws Exception{
        return dAlmacen_FilasBusiness.getRecordDAlmacen_FilasEmpresa(empresa,sucursal,almacen,distribucion,racks,piso);
    }
    public String addDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasBusiness.addDAlmacen_Filas(dAlmacen_Filas);
    }
    public String addXmlDAlmacen_Filas(String idempresa,String idsucursal,String idalmacen,String iddistribucion,String rack,String piso,String xml) throws Exception{
        return dAlmacen_FilasBusiness.addXmlDAlmacen_Filas(idempresa, idsucursal, idalmacen,iddistribucion,rack, piso, xml);
    }
    public String editDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasBusiness.editDAlmacen_Filas(dAlmacen_Filas);
    }
    public String deleteDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasBusiness.deleteDAlmacen_Filas(dAlmacen_Filas);
    }
}
