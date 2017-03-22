/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DALMACEN_DISTRIBUCIONUBICACION;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DALMACEN_DISTRIBUCIONUBICACIONDAO extends EntityDao<DALMACEN_DISTRIBUCIONUBICACION>{

    @Override
    public DALMACEN_DISTRIBUCIONUBICACION find(DALMACEN_DISTRIBUCIONUBICACION e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DALMACEN_DISTRIBUCIONUBICACION> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DALMACEN_DISTRIBUCIONUBICACION> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DALMACEN_DISTRIBUCIONUBICACION> sincronizarDal_DistUbi(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        List<DALMACEN_DISTRIBUCIONUBICACION> lista=new ArrayList<DALMACEN_DISTRIBUCIONUBICACION>();
        try {
            String sql = "SP_DALMACEN_DISTRIBUCIONUBICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DALMACEN_DISTRIBUCIONUBICACION DalmUbi = new DALMACEN_DISTRIBUCIONUBICACION();
                DalmUbi.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                DalmUbi.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                DalmUbi.setIDALMACEN(rs.getInt("IDALMACEN"));
                DalmUbi.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                DalmUbi.setFECHAINICIO(rs.getString("FECHAINICIO"));
                DalmUbi.setFECHAFIN(rs.getString("FECHAFIN"));
                DalmUbi.setESTADO(rs.getInt("ESTADO"));
                DalmUbi.setFECHACREACION(rs.getString("FECHACREACION"));
                lista.add(DalmUbi);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }
    public DALMACEN_DISTRIBUCIONUBICACION findOne(Object e1,Object e2,Object e3) throws Exception{
        DALMACEN_DISTRIBUCIONUBICACION rl = new DALMACEN_DISTRIBUCIONUBICACION();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from DALMACEN_DISTRIBUCIONUBICACION where IDEMPRESA = ? and IDSUCURSAL = ? and IDALMACEN = ? and ESTADO = 1");
            pr.setObject(1, e1);
            pr.setObject(2, e2);
            pr.setObject(3, e3);
            rs = pr.executeQuery();
            while (rs.next()) {
                rl.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                rl.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                rl.setIDALMACEN(rs.getInt("IDALMACEN"));
                rl.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                rl.setFECHAINICIO(rs.getString("FECHAINICIO"));
                rl.setFECHAFIN(rs.getString("FECHAFIN"));
                rl.setESTADO(rs.getInt("ESTADO"));
                rl.setFECHACREACION(rs.getString("FECHACREACION"));
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return rl;
    }
}
