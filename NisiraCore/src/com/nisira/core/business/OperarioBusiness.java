/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.OperarioDao;
import com.nisira.core.entity.Operario;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class OperarioBusiness extends BaseBusiness<Operario>{
    private OperarioDao operarioDao= new  OperarioDao();
    public OperarioBusiness(){
        super.setBaseDao(operarioDao);
    }
    public List<Operario> getRecordOperario(String empresa) throws Exception{
        return operarioDao.findAll(empresa);
    }
    public String addOperario(Operario operario) throws Exception{
        return operarioDao.addOperario(operario);
    }
    public String addXmlOperario(String idempresa,String xml) throws Exception{
        return operarioDao.addXmlOperario(idempresa,xml);
    }
    public String editOperario(Operario dOperario_Operario) throws Exception{
        return operarioDao.editOperario(dOperario_Operario);
    }
    public String deleteOperario(Operario operario) throws Exception{
        return operarioDao.deleteOperario(operario);
    }
    public List<Operario> findByFiltro(String idempresa, String filtro) throws Exception{
        return operarioDao.findByFiltro(idempresa,filtro);
    }
    
}
