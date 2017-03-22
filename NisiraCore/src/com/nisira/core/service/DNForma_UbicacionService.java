/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DNForma_UbicacionBusiness;
import com.nisira.core.entity.DNFormaUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DNForma_UbicacionService extends BaseService<DNFormaUbicacion>{
    private DNForma_UbicacionBusiness dNFormaUbicacionBusiness=new DNForma_UbicacionBusiness();
    public DNForma_UbicacionService(){
        super.setBaseBusiness(dNFormaUbicacionBusiness);
    }
    public List<DNFormaUbicacion> getRecordNForma_Ubicacion(String empresa,String sucursal,
            String almacen) throws Exception{
        return dNFormaUbicacionBusiness.getRecordDNForma_Ubicacion(empresa, sucursal, almacen);
    }
    public String addFormaUbicacion(DNFormaUbicacion dDForma_Ubicacion) throws Exception{
        return dNFormaUbicacionBusiness.addDNForma_Ubicacion(dDForma_Ubicacion);
    }
    public String addXmlDFormaUbicacion(String empresa,String sucursal,String almacen,String xml) throws Exception{
        return dNFormaUbicacionBusiness.addXmlDNForma_Ubicacion(empresa, sucursal, almacen, xml);
    }
    public String editDFormaUbicacion(DNFormaUbicacion dNForma_Ubicacion) throws Exception{
        return dNFormaUbicacionBusiness.editDNForma_Ubicacion(dNForma_Ubicacion);
    }
    public String deleteDFormaUbicacion(DNFormaUbicacion dNForma_Ubicacion) throws Exception{
        return dNFormaUbicacionBusiness.deleteDNForma_Ubicacion(dNForma_Ubicacion);
    }
}
