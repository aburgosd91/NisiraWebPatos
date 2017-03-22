/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.FechaCampanaAnualBusiness;
import com.nisira.core.entity.DistribucionUbicacion;
import com.nisira.core.entity.FechaCampanaAnual;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class FechaCampanaAnualService extends BaseService<FechaCampanaAnual> {

    private FechaCampanaAnualBusiness FechaCampanaAnualBusiness = new FechaCampanaAnualBusiness();

    public FechaCampanaAnualService() {
        super.setBaseBusiness(FechaCampanaAnualBusiness);
    }

    public ArrayList<FechaCampanaAnual> findByEmpresa(String idempresa) throws Exception {
         return FechaCampanaAnualBusiness.findByEmpresa(idempresa);
    }
}
