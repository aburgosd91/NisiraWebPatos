/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DDNFormaUbicacionDao;
import com.nisira.core.entity.DDNFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDNForma_UbicacionBusiness extends BaseBusiness<DDNFormaUbicacion>{
    private DDNFormaUbicacionDao dDNForma_UbicacionDao = new DDNFormaUbicacionDao();
    public DDNForma_UbicacionBusiness(){
        super.setBaseDao(dDNForma_UbicacionDao);
    }
    public List<DDNFormaUbicacion> getRecordDDNForma_Ubicacion_idnformacionubicacion(String empresa,String sucursal,String almacen,String idnformacionubicacion,
            int filas,int columnas) throws Exception{
        return dDNForma_UbicacionDao.getRecordIDNFORMACIONUBICACION(empresa,sucursal,almacen,idnformacionubicacion,filas,columnas);
    }
    public List<DDNFormaUbicacion> getRecordDDNForma_Ubicacion(String empresa,String sucursal,String almacen,String idnformacionubicacion,
            int filas,int columnas) throws Exception{
        return dDNForma_UbicacionDao.findAll(empresa,sucursal,almacen,idnformacionubicacion,filas,columnas);
    }
    public String addDNForma_Ubicacion(DDNFormaUbicacion dDFormaUbicacion) throws Exception{
        return dDNForma_UbicacionDao.addDDNForma_Ubicacion(dDFormaUbicacion);
    }
    public String addXmlDNForma_Ubicacion(String empresa,String sucursal,String almacen,
            String idnformacionubicacion,int filas,int columnas,String xml) throws Exception{
        return dDNForma_UbicacionDao.addXmlDDNForma_Ubicacion(empresa,sucursal,almacen,
                idnformacionubicacion,filas,columnas,xml);
    }
    public String editDNForma_Ubicacion(DDNFormaUbicacion dDFormaUbicacion) throws Exception{
        return dDNForma_UbicacionDao.editDDNForma_Ubicacion(dDFormaUbicacion);
    }
    public String deleteDNForma_Ubicacion(DDNFormaUbicacion dDFormaUbicacion) throws Exception{
        return dDNForma_UbicacionDao.deleteDDNForma_Ubicacion(dDFormaUbicacion);
    }
}
