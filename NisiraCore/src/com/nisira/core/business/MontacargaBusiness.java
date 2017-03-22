/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.MontacargaDao;
import com.nisira.core.entity.Montacarga;
import java.util.List;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
public class MontacargaBusiness extends BaseBusiness<Montacarga>{
    private MontacargaDao montacargaDao= new  MontacargaDao();
    public MontacargaBusiness(){
        super.setBaseDao(montacargaDao);
    }
    public List<Montacarga> getRecordMontacarga(String empresa) throws Exception{
        return montacargaDao.findAll(empresa);
    }
    public String saveMontacarga(Montacarga montacarga,int tipo) throws Exception{
        return montacargaDao.saveMontacarga(montacarga,tipo);
    }
 
    public String anularMontacarga(Montacarga montacarga) throws Exception{
        return montacargaDao.anularMontacarga(montacarga);
    }
    public String deleteMontacarga(Montacarga montacarga) throws Exception{
        return montacargaDao.deleteMontacarga(montacarga);
    }
    public Montacarga findById(String idempresa, String idmontacarga)throws Exception{
        return montacargaDao.findById(idempresa,idmontacarga);
    }
}
