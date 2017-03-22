/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.AlmacenBusiness;
import com.nisira.core.entity.Almacen;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AlmacenService extends BaseService<Almacen>{
    private AlmacenBusiness AlmacenBusiness = new AlmacenBusiness();
    public AlmacenService(){
        super.setBaseBusiness(AlmacenBusiness);
    }
    public List<Almacen> getRecordAlmacenEmpresaActivo(String empresa,String sucursal) throws Exception{
        return AlmacenBusiness.getRecordAlmacenEmpresaActivo(empresa,sucursal);
    }
    public List<Almacen> getRecordAlmacenEmpresa(String empresa,String sucursal) throws Exception{
        return AlmacenBusiness.getRecordAlmacenEmpresa(empresa,sucursal);
    }
    public String addAlmacen(Almacen almacen) throws Exception{
        return AlmacenBusiness.addAlmacen(almacen);
    }
    public String editAlmacen(Almacen almacen) throws Exception{
        return AlmacenBusiness.editAlmacen(almacen);
    }
    public String deleteAlmacen(Almacen almacen) throws Exception{
        return AlmacenBusiness.deleteAlmacen(almacen);
    }
     public List<Almacen> getAllByEmpresa(String idempresa) throws Exception{
        return AlmacenBusiness.getAllByEmpresa(idempresa);
    }
}
