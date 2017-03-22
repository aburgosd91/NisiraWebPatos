/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.MontacargaBusiness;
import com.nisira.core.entity.Montacarga;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class MontacargaService extends BaseService<Montacarga>{
    private MontacargaBusiness MontacargaBusiness = new MontacargaBusiness();
    public MontacargaService(){
        super.setBaseBusiness(MontacargaBusiness);
    }
    public List<Montacarga> getRecordMontacarga(String empresa) throws Exception{
        return MontacargaBusiness.getRecordMontacarga(empresa);
    }
    public String saveMontacarga(Montacarga montacarga,int tipo) throws Exception{
        return MontacargaBusiness.saveMontacarga(montacarga,tipo);
    }
    public Montacarga findById(String idempresa,String idmontacarga) throws Exception{
        return MontacargaBusiness.findById(idempresa,idmontacarga);
    }
    public String anularMontacarga(Montacarga montacarga) throws Exception{
        return MontacargaBusiness.anularMontacarga(montacarga);
    }
    public String deleteMontacarga(Montacarga montacarga) throws Exception{
        return MontacargaBusiness.deleteMontacarga(montacarga);
    }
}
