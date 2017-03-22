/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;


import com.nisira.core.dao.AfpDao;
import com.nisira.core.entity.Afp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AfpBusiness extends BaseBusiness<Afp>{
    private AfpDao afp= new AfpDao();
    public AfpBusiness(){
        super.setBaseDao(afp);
    }
    public List<Afp> findByBaseDatos() throws Exception {
         return afp.findAll();
    }
    public List<Afp> findByBaseDatosFiltro(String parametro) throws Exception {
         return afp.findAllFiltro(parametro);
    }
}
