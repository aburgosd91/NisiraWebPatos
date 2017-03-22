/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;
import com.nisira.core.business.NumEmisorBusiness;
import com.nisira.core.entity.NumEmisor;
import java.util.List;
/**
 *
 * @author Victor Zavala Llanos
 */
public class NumEmisorService extends BaseService<NumEmisor>{
    private NumEmisorBusiness NumEmisorBusiness = new NumEmisorBusiness();
    public NumEmisorService(){
        super.setBaseBusiness(NumEmisorBusiness);
    }
    public List<NumEmisor> findByDocumento(String empresa,String iddocumento) throws Exception{
        return NumEmisorBusiness.findByDocumento(empresa,iddocumento);
    }
    
}
