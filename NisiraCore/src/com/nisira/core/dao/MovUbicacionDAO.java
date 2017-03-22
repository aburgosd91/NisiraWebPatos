/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.MovUbicacion;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azamora
 */
public class MovUbicacionDAO extends EntityDao<MovUbicacion> {

    @Override
    public MovUbicacion find(MovUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MovUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MovUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void execGeneracion(int idempresa,int idsucursal,String idprogllenado,int idcampana) throws Exception{
        try {
            String sql = "SP_GENERARPROGUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1, "");
            cl.setInt(2, idempresa);
            cl.setInt(3, idsucursal);
            cl.setString(4, idprogllenado);
            cl.setObject(5, null);
            cl.executeQuery();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public List<MovUbicacion> findAll(Object ide, Object ids, Object idz) throws Exception {
        List<MovUbicacion> lu = new ArrayList<MovUbicacion>();
        try {
            String sql = "SP_MOVUBICACION_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idz);
            rs = cl.executeQuery();
            while (rs.next()) {
                MovUbicacion m = new MovUbicacion();
                m.setIDMOVUBICACION(rs.getInt("IDMOVUBICACION"));
                m.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                m.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                m.setIDZONA(rs.getInt("IDZONA"));
                m.setIDALMACEN(rs.getInt("IDALMACEN"));
                m.setIDPALETA(rs.getString("IDPALETA"));
                m.setNROPALETA(rs.getString("NROPALETA"));
                m.setIDUBICACION(rs.getString("IDUBICACION"));
                m.setFACTOR(rs.getInt("FACTOR"));
                m.setIDPROGRAMACIONTAREA(rs.getString("IDPROGRAMACIONTAREA"));
                m.setFECHACREACION(rs.getString("FECHACREACION"));
                lu.add(m);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lu;
    }
}
