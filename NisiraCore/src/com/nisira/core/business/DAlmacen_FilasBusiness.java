/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DAlmacen_FilasDao;
import com.nisira.core.entity.DAlmacen_Filas;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DAlmacen_FilasBusiness extends BaseBusiness<DAlmacen_Filas>{
    private DAlmacen_FilasDao dAlmacen_FilasDao= new  DAlmacen_FilasDao();
    public DAlmacen_FilasBusiness(){
        super.setBaseDao(dAlmacen_FilasDao);
    }
    public List<DAlmacen_Filas> getRecordDAlmacen_FilasEmpresa(String empresa,String sucursal,String almacen,String distribucion,String racks,String piso) throws Exception{
        return dAlmacen_FilasDao.findAll(empresa,sucursal,almacen,distribucion,racks,piso);
    }
    public String addDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasDao.addDAlmacen_Filas(dAlmacen_Filas);
    }
    public String addXmlDAlmacen_Filas(String idempresa,String idsucursal,String idalmacen,String idditribucion,String rack,String piso,String xml) throws Exception{
        return dAlmacen_FilasDao.addDFilaXML(idempresa, idsucursal, idalmacen,idditribucion, rack, piso, xml);
    }
    public String editDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasDao.editDAlmacen_Filas(dAlmacen_Filas);
    }
    public String deleteDAlmacen_Filas(DAlmacen_Filas dAlmacen_Filas) throws Exception{
        return dAlmacen_FilasDao.deleteDAlmacen_Filas(dAlmacen_Filas);
    }
}
