/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.AfpBusiness;
import com.nisira.core.entity.Afp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class AfpService extends BaseService<Afp>{
    private AfpBusiness afpBusiness =new AfpBusiness();
    public AfpService(){
        super.setBaseBusiness(afpBusiness);
    }
    public List<Afp> findByBaseDatos(){
        try {
            return afpBusiness.findByBaseDatos();
        } catch (Exception ex) {
            return null;
        }
    }
    public List<Afp> findByBaseDatosFiltro(String parametro){
        try {
            return afpBusiness.findByBaseDatosFiltro(parametro);
        } catch (Exception ex) {
            return null;
        }
    }
}
