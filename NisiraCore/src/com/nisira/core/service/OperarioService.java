/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.OperarioBusiness;
import com.nisira.core.entity.Operario;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class OperarioService extends BaseService<Operario>{
    private OperarioBusiness OperarioBusiness = new OperarioBusiness();
    public OperarioService(){
        super.setBaseBusiness(OperarioBusiness);
    }
    public List<Operario> getRecordOperario(String empresa) throws Exception{
        return OperarioBusiness.getRecordOperario(empresa);
    }
    public String addOperario(Operario operario) throws Exception{
        return OperarioBusiness.addOperario(operario);
    }
    public String addXmlOperario(String empresa,String xml) throws Exception{
        return OperarioBusiness.addXmlOperario(empresa,xml);
    }
    public String editOperario(Operario operario) throws Exception{
        return OperarioBusiness.editOperario(operario);
    }
    public String deleteOperario(Operario operario) throws Exception{
        return OperarioBusiness.deleteOperario(operario);
    }
    public List<Operario> findByFiltro(String idempresa,String filtro) throws Exception{
        return OperarioBusiness.findByFiltro(idempresa,filtro);
    }
    
}
