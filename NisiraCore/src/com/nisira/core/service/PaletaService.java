/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.MovUbicacionPaletaBusiness;
import com.nisira.core.business.PaletaBusiness;
import com.nisira.core.entity.Dpaleta;
import com.nisira.core.entity.MovUbicacionPaleta;
import com.nisira.core.entity.Paleta;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PaletaService extends BaseService<Paleta> {

    private PaletaBusiness paletabusiness = new PaletaBusiness();

    public PaletaService() {
        super.setBaseBusiness(paletabusiness);
    }

    public Paleta findByNroPaleta(String idempresa, String nropaleta) throws Exception {
        return paletabusiness.findByNroPaleta(idempresa, nropaleta);
    }

    public List<Paleta> findByTotalPaleta(String idempresa, String campania) throws Exception {
        return paletabusiness.findByTotalPaleta(idempresa, campania);
    }

    public List<Paleta> findByTotalPaletaCampana(String idempresa, String campania) throws Exception {
        return paletabusiness.findByTotalPaletaCampana(idempresa, campania);
    }

    public String grabarByTotalPaletaXml(String xml) throws Exception {
        return paletabusiness.grabarByTotalPaletaXml(xml);
    }

    public String grabarxmlPaleta(Paleta entity, List<Dpaleta> dpaleta) throws Exception {
        return paletabusiness.grabarxmlPaleta(entity, dpaleta);
    }

    public boolean valiPale(Paleta pale) throws Exception {
        return paletabusiness.valiPale(pale);
    }

    public boolean valiDPale(Dpaleta dpale) throws Exception {
        return paletabusiness.valiDPale(dpale);
    }
}
