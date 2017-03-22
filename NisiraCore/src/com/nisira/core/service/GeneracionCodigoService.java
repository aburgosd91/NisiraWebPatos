/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.GeneracionCodigoBusiness;
import com.nisira.core.entity.GeneracionCodigo;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class GeneracionCodigoService extends BaseService<GeneracionCodigo>{
    private GeneracionCodigoBusiness generacionCodigoBusiness = new GeneracionCodigoBusiness();
    public GeneracionCodigoService(){
        super.setBaseBusiness(generacionCodigoBusiness);
    }
    public List<GeneracionCodigo> getRecordGeneracionCodigo(String empresa) throws Exception{
        return generacionCodigoBusiness.getRecordGeneracionCodigo(empresa);
    }
    public String addGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoBusiness.addGeneracionCodigo(generacionCodigo);
    }
    public int addXmlGeneracionCodigo(int tipo,int idempresa,int idgen, String xml) throws Exception{
        return generacionCodigoBusiness.addXmlGeneracionCodigo(tipo, idempresa, idgen, xml);
    }
    public String editGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoBusiness.editGeneracionCodigo(generacionCodigo);
    }
    public String deleteGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoBusiness.deleteGeneracionCodigo(generacionCodigo);
    }
}
