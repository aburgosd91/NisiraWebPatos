/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.FechaCampanaAnualDao;
import com.nisira.core.entity.DistribucionUbicacion;
import com.nisira.core.entity.FechaCampanaAnual;
import com.nisira.core.entity.Privilegios;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class FechaCampanaAnualBusiness extends BaseBusiness<FechaCampanaAnual>{
    private FechaCampanaAnualDao FechaCampanaAnualDao  = new  FechaCampanaAnualDao();

    public FechaCampanaAnualBusiness() {
        super.setBaseDao(FechaCampanaAnualDao);
    }    
    
    public ArrayList<FechaCampanaAnual> findByEmpresa(String idempresa) throws Exception {
         return FechaCampanaAnualDao.findByEmpresa(idempresa);
    }    
}
