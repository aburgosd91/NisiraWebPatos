/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.business.BaseBusiness;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.entity.NumEmisor;
import java.util.List;

/**
 *
 * @author Victor Zavala Llanos
 */
public class NumEmisorBusiness extends BaseBusiness<NumEmisor>{
    private NumEmisorDao numemisordao = new  NumEmisorDao();
    public NumEmisorBusiness(){
        super.setBaseDao(numemisordao);
    }
    public List<NumEmisor> findByDocumento(String empresa,String iddocumento) throws Exception{
        return numemisordao.findByDocumento(empresa,iddocumento);
    }

}
