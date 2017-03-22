/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DDistribucionUbicacionDao;
import com.nisira.core.entity.DDistribucionUbicacion;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DDistribucionUbicacionBusiness extends BaseBusiness<DDistribucionUbicacion>{
    private DDistribucionUbicacionDao dDistribucionUbicacionDao = new  DDistribucionUbicacionDao();
    public DDistribucionUbicacionBusiness(){
        super.setBaseDao(dDistribucionUbicacionDao);
    }
    public List<DDistribucionUbicacion> getRecordDDistribucionUbicacionEmpresaActivo(String empresa,String sucursal,String almacen) throws Exception{
        return dDistribucionUbicacionDao.recordDDistribucionUbicacionEmpresaActivo(empresa,sucursal,almacen);
    }
    public String addDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionDao.addDDistribucionUbicacion(dDistribucionUbicacion);
    }
    public String editDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionDao.editDDistribucionUbicacion(dDistribucionUbicacion);
    }
    public String deleteDDistribucionUbicacion(DDistribucionUbicacion dDistribucionUbicacion) throws Exception{
        return dDistribucionUbicacionDao.deleteDDistribucionUbicacion(dDistribucionUbicacion);
    }
}
