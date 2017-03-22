/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.ReglasDao;
import com.nisira.core.entity.Dreglas;
import com.nisira.core.entity.Reglas;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ReglasBusiness extends BaseBusiness<Reglas> {

    private ReglasDao reglasDao = new ReglasDao();

    public ReglasBusiness() {
        super.setBaseDao(reglasDao);
    }

    public Integer insertaReglas(int tipo,String xml,int idempresa, int idregla) throws Exception {
        return reglasDao.insertaReglas(tipo, xml, idempresa, idregla);
    }
    public void insertaDreglas(int tipo,String xml,int idempresa, int idregla) throws Exception{
        reglasDao.insertaDreglas(tipo, xml, idempresa, idregla);
    }
    public List<Reglas> findReglas(int idempresa) throws Exception {
        return reglasDao.findReglas(idempresa);
    }

    public List<Dreglas> findDreglas(int idempresa, int idregla) throws Exception {
        return reglasDao.findDreglas(idempresa, idregla);
    }
}
