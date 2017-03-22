/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DDNForma_UbicacionBusiness;
import com.nisira.core.entity.DDNFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDNForma_UbicacionService extends BaseService<DDNFormaUbicacion>{
    private DDNForma_UbicacionBusiness dDNFormaUbicacionBusiness=new DDNForma_UbicacionBusiness();
    public DDNForma_UbicacionService(){
        super.setBaseBusiness(dDNFormaUbicacionBusiness);
    }
    public List<DDNFormaUbicacion> getRecordDForma_Ubicacion_idnformacionubicacion(String empresa,String sucursal,
            String almacen,String idnformacionubicacion,int filas,int columnas) throws Exception{
        return dDNFormaUbicacionBusiness.getRecordDDNForma_Ubicacion_idnformacionubicacion(empresa,sucursal,almacen,idnformacionubicacion,
                filas,columnas);
    }
    public List<DDNFormaUbicacion> getRecordDForma_Ubicacion(String empresa,String sucursal,
            String almacen,String idnformacionubicacion,int filas,int columnas) throws Exception{
        return dDNFormaUbicacionBusiness.getRecordDDNForma_Ubicacion(empresa,sucursal,almacen,idnformacionubicacion,
                filas,columnas);
    }
    public String addFormaUbicacion(DDNFormaUbicacion dDNFormaUbicacion) throws Exception{
        return dDNFormaUbicacionBusiness.addDNForma_Ubicacion(dDNFormaUbicacion);
    }
    public String addXmlDFormaUbicacion(String empresa,String sucursal,String almacen,
            String idnformacionubicacion,int filas,int columnas,String xml) throws Exception{
        return dDNFormaUbicacionBusiness.addXmlDNForma_Ubicacion(empresa,sucursal,almacen,idnformacionubicacion,
                filas,columnas,xml);
    }
    public String editDFormaUbicacion(DDNFormaUbicacion dDNFormaUbicacion) throws Exception{
        return dDNFormaUbicacionBusiness.editDNForma_Ubicacion(dDNFormaUbicacion);
    }
    public String deleteDFormaUbicacion(DDNFormaUbicacion dDNFormaUbicacion) throws Exception{
        return dDNFormaUbicacionBusiness.deleteDNForma_Ubicacion(dDNFormaUbicacion);
    }
}
