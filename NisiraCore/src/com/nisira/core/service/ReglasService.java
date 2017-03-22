/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.ReglasBusiness;
import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Reglas;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ReglasService extends BaseService<Reglas> {

    private ReglasBusiness reglasBusiness = new ReglasBusiness();

    public ReglasService() {
        super.setBaseBusiness(reglasBusiness);
    }

    public Integer insertaReglas(int tipo, String xml, int idempresa, int idregla) throws Exception {
        return reglasBusiness.insertaReglas(tipo, xml, idempresa, idregla);
    }

    public void insertaDreglas(int tipo, String xml, int idempresa, int idregla) throws Exception {
        reglasBusiness.insertaDreglas(tipo, xml, idempresa, idregla);
    }

    public List<Reglas> findReglas(int idempresa) throws Exception {
        return reglasBusiness.findReglas(idempresa);
    }

    public List<Dreglas> findDreglas(int idempresa, int idregla) throws Exception {
        return reglasBusiness.findDreglas(idempresa, idregla);
    }
}
