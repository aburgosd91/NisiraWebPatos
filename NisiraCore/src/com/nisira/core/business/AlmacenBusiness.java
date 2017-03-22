/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.entity.Almacen;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AlmacenBusiness extends BaseBusiness<Almacen>{
    private AlmacenDao almacendao = new  AlmacenDao();
    public AlmacenBusiness(){
        super.setBaseDao(almacendao);
    }
    public List<Almacen> getRecordAlmacenEmpresa(String empresa,String almacen) throws Exception{
        return almacendao.findAll(empresa,almacen);
    }
    public List<Almacen> getRecordAlmacenEmpresaActivo(String empresa,String sucursal) throws Exception{
        return almacendao.recordAlmacenEmpresaActivo(empresa,sucursal);
    }
    public String addAlmacen(Almacen almacen) throws Exception{
        return almacendao.addAlmacen(almacen);
    }
    public String editAlmacen(Almacen almacen) throws Exception{
        return almacendao.editAlmacen(almacen);
    }
    public String deleteAlmacen(Almacen almacen) throws Exception{
        return almacendao.deleteAlmacen(almacen);
    }
    public List<Almacen> getAllByEmpresa(String idempresa) throws Exception{
        return almacendao.getAllByEmpresa(idempresa);
    }
    
}
