/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.MovUbicacionPaletaBusiness;
import com.nisira.core.entity.DistribucionUbicacion;
import com.nisira.core.entity.MovUbicacionPaleta;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class MovUbicacionPaletaService extends BaseService<MovUbicacionPaleta> {

    private MovUbicacionPaletaBusiness movubicacionpaletaBusiness = new MovUbicacionPaletaBusiness();

    public MovUbicacionPaletaService() {
        super.setBaseBusiness(movubicacionpaletaBusiness);
    }

    public String enviarmail(String idestado, String idcompra, String serie) throws Exception {
        return movubicacionpaletaBusiness.enviarmail(idestado, idcompra, serie);
    }
    public String grabarMovUbicacionByPaleta(String idempresa,String JSONMovUbicacionMovimientos,String idubicacion_actual,String idubicacion_nueva,String nropaleta) throws Exception {
         return movubicacionpaletaBusiness.grabarMovUbicacionByPaleta(idempresa, JSONMovUbicacionMovimientos,idubicacion_actual, idubicacion_nueva, nropaleta);
    }
    public MovUbicacionPaleta findUltimoMovUbicacionPaletaByNroPaleta(String idempresa,String nropaleta) throws Exception {
         return movubicacionpaletaBusiness.findUltimoMovUbicacionPaletaByNroPaleta(idempresa, nropaleta);
    }
    
    public DistribucionUbicacion getDistribucionUbicacionByCamara(String idempresa,String idcamara,Date fecha) throws Exception {
         return movubicacionpaletaBusiness.getDistribucionUbicacionByCamara(idempresa, idcamara,fecha);
    }
}
