/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.PaletaDao;
import com.nisira.core.entity.Dpaleta;
import com.nisira.core.entity.Paleta;
import com.nisira.core.entity.Privilegios;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PaletaBusiness extends BaseBusiness<Paleta>{
    private PaletaDao paletadao  = new  PaletaDao();

    public PaletaBusiness() {
        super.setBaseDao(paletadao);
    }
    
    public Paleta findByNroPaleta(String idempresa,String nropaleta) throws Exception {
         return paletadao.findByNroPaleta(idempresa,nropaleta);
    }
    public List<Paleta> findByTotalPaleta(String idempresa,String campania) throws Exception {
         return paletadao.findByTotalPaleta(idempresa,campania);
    }
    public List<Paleta> findByTotalPaletaCampana(String idempresa,String campania) throws Exception {
         return paletadao.findByTotalPaletaCampana(idempresa,campania);
    }
    public String grabarByTotalPaletaXml(String xml) throws Exception {
         return paletadao.grabarRegistroTempPaletaXML(xml);
    }
    public String grabarxmlPaleta(Paleta entity, List<Dpaleta> dpaleta) throws Exception {
        return paletadao.grabarxmlPaleta(entity,dpaleta);
    }
    public boolean valiPale(Paleta pale) throws Exception{
        return paletadao.valiPale(pale);
    }
    public boolean valiDPale(Dpaleta dpale) throws Exception{
        return paletadao.valiDPale(dpale);
    }
}
