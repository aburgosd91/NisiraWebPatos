/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.DGeneracionCodigoBusiness;
import com.nisira.core.entity.DGeneracionCodigo;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DGeneracionCodigoService extends BaseService<DGeneracionCodigo>{
    private DGeneracionCodigoBusiness dgeneracionCodigoBusiness = new DGeneracionCodigoBusiness();
    public DGeneracionCodigoService(){
        super.setBaseBusiness(dgeneracionCodigoBusiness);
    }
    public List<DGeneracionCodigo> getRecordGeneracionCodigo(Object empresa,Object idgeneracion) throws Exception{
        return dgeneracionCodigoBusiness.getRecordGeneracionCodigo(empresa,idgeneracion);
    }
    public String addGeneracionCodigo(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoBusiness.addDGeneracionCodigo(dgeneracionCodigo);
    }
    public String addXmlGeneracionCodigo(String idempresa,int idgeneracion,String xml) throws Exception{
        return dgeneracionCodigoBusiness.addXmlDGeneracionCodigo(idempresa,idgeneracion, xml);
    }
    public String editAlmacen(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoBusiness.editDGeneracionCodigo(dgeneracionCodigo);
    }
    public String deleteGeneracionCodigo(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoBusiness.deleteDGeneracionCodigo(dgeneracionCodigo);
    }
}
