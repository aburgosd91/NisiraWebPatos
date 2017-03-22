/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.GeneracionCodigoDao;
import com.nisira.core.entity.GeneracionCodigo;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class GeneracionCodigoBusiness extends BaseBusiness<GeneracionCodigo>{
    private GeneracionCodigoDao generacionCodigoDao= new  GeneracionCodigoDao();
    public GeneracionCodigoBusiness(){
        super.setBaseDao(generacionCodigoDao);
    }
    public List<GeneracionCodigo> getRecordGeneracionCodigo(String empresa) throws Exception{
        return generacionCodigoDao.findAll(empresa);
    }
    public String addGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoDao.addGeneracionCodigo(generacionCodigo);
    }
    public int addXmlGeneracionCodigo(int tipo,int idempresa,int idgen, String xml) throws Exception{
        return generacionCodigoDao.addXmlGeneracionCodigo(tipo, idempresa, idgen, xml);
    }
    public String editGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoDao.editGeneracionCodigo(generacionCodigo);
    }
    public String deleteGeneracionCodigo(GeneracionCodigo generacionCodigo) throws Exception{
        return generacionCodigoDao.deleteGeneracionCodigo(generacionCodigo);
    }
}
