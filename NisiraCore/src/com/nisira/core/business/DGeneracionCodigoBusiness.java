/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.DGeneracionCodigoDao;
import com.nisira.core.entity.DGeneracionCodigo;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DGeneracionCodigoBusiness extends BaseBusiness<DGeneracionCodigo>{
    private DGeneracionCodigoDao dgeneracionCodigoDao= new  DGeneracionCodigoDao();
    public DGeneracionCodigoBusiness(){
        super.setBaseDao(dgeneracionCodigoDao);
    }
    public List<DGeneracionCodigo> getRecordGeneracionCodigo(Object empresa,Object idgeneracion) throws Exception{
        return dgeneracionCodigoDao.findAll(empresa,idgeneracion);
    }
    public String addDGeneracionCodigo(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoDao.addDGeneracionCodigo(dgeneracionCodigo);
    }
    public String addXmlDGeneracionCodigo(String idempresa,int idgeneracion,String xml) throws Exception{
        return dgeneracionCodigoDao.addXmlDGeneracionCodigo(idempresa,idgeneracion,xml);
    }
    public String editDGeneracionCodigo(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoDao.editDGeneracionCodigo(dgeneracionCodigo);
    }
    public String deleteDGeneracionCodigo(DGeneracionCodigo dgeneracionCodigo) throws Exception{
        return dgeneracionCodigoDao.deleteDGeneracionCodigo(dgeneracionCodigo);
    }
}
