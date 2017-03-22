/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.MovUbicacionPaletaDao;
import com.nisira.core.entity.DistribucionUbicacion;
import com.nisira.core.entity.MovUbicacionPaleta;
import com.nisira.core.entity.Privilegios;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class MovUbicacionPaletaBusiness extends BaseBusiness<MovUbicacionPaleta>{
    private MovUbicacionPaletaDao movubicacionpaletaDao  = new  MovUbicacionPaletaDao();

    public MovUbicacionPaletaBusiness() {
        super.setBaseDao(movubicacionpaletaDao);
    }
    
    public String enviarmail(String idestado, String idcompra, String serie) throws Exception {
         return movubicacionpaletaDao.enviarmail(idestado, idcompra, serie);
    }
    public String grabarMovUbicacionByPaleta(String idempresa,String JSONMovUbicacionMovimientos,String idubicacion_actual,String idubicacion_nueva,String nropaleta) throws Exception {
         return movubicacionpaletaDao.grabarMovUbicacionByPaleta(idempresa, JSONMovUbicacionMovimientos,idubicacion_actual, idubicacion_nueva, nropaleta);
    }
    public MovUbicacionPaleta findUltimoMovUbicacionPaletaByNroPaleta(String idempresa,String nropaleta) throws Exception {
         return movubicacionpaletaDao.findUltimoMovUbicacionPaletaByNroPaleta(idempresa, nropaleta);
    }
    public DistribucionUbicacion getDistribucionUbicacionByCamara(String idempresa,String idcamara,Date fecha) throws Exception {
         return movubicacionpaletaDao.getDistribucionUbicacionByCamara(idempresa, idcamara,fecha);
    }
    
    
}
