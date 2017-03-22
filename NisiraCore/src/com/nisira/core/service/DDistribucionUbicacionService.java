/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DDistribucionUbicacionBusiness;
import com.nisira.core.entity.DDistribucionUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDistribucionUbicacionService extends BaseService<DDistribucionUbicacion>{
    private DDistribucionUbicacionBusiness dDistribucionUbicacionBusiness = new  DDistribucionUbicacionBusiness();
    public DDistribucionUbicacionService(){
        super.setBaseBusiness(dDistribucionUbicacionBusiness);
    }
    public String addDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionBusiness.addDDistribucionUbicacion(dDistribucionUbicacion);
    }
    public String editDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionBusiness.editDDistribucionUbicacion(dDistribucionUbicacion);
    }
    public String deleteDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionBusiness.deleteDDistribucionUbicacion(dDistribucionUbicacion);
    }
    public List<DDistribucionUbicacion> getRecordDDistribucionUbicacionEmpresaActivo(String empresa,String sucursal,String almacen) throws Exception{
        return dDistribucionUbicacionBusiness.getRecordDDistribucionUbicacionEmpresaActivo(empresa,sucursal,almacen);
    }
}
