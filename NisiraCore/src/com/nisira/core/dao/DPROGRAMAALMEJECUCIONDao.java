/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DPROGRAMAALMEJECUCION;
import com.nisira.core.entity.ProgramaAlm;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DPROGRAMAALMEJECUCIONDao extends EntityDao<DPROGRAMAALMEJECUCION>{

    @Override
    public DPROGRAMAALMEJECUCION find(DPROGRAMAALMEJECUCION e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DPROGRAMAALMEJECUCION> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DPROGRAMAALMEJECUCION> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //[SP_DPROGRAMAALMEJECUCION_Sync] To change body of generated methods, choose Tools | Templates.
    }
    public List<DPROGRAMAALMEJECUCION> syncDprogalmejec(Object ide,Object ids,Object desde,Object hasta) throws Exception{
        List<DPROGRAMAALMEJECUCION> listaProg = new ArrayList<DPROGRAMAALMEJECUCION>();
        try {
            String sql = "SP_DPROGRAMAALMEJECUCION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DPROGRAMAALMEJECUCION dpaj = new DPROGRAMAALMEJECUCION();
                dpaj.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                dpaj.setIDPROGRAMAALM(rs.getInt("IDPROGRAMAALM"));
                dpaj.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                dpaj.setIDALMACEN(rs.getInt("IDALMACEN"));
                dpaj.setIDRACK(rs.getString("IDRACK"));
                dpaj.setIDFORMAUBICACION(rs.getString("IDFORMAUBICACION"));
                dpaj.setIDDISTRIBUCION(rs.getString("IDDISTRIBUCION"));
                dpaj.setIDPISO(rs.getInt("IDPISO"));
                dpaj.setIDFILA(rs.getInt("IDFILA"));
                dpaj.setIDCOLUMNA(rs.getInt("IDCOLUMNA"));
                dpaj.setIDUBICACION(rs.getString("IDUBICACION"));
                dpaj.setPRIORIDAD(rs.getInt("PRIORIDAD"));
                dpaj.setIDPALETAPROGRAMADA(rs.getString("IDPALETAPROGRAMADA"));
                dpaj.setNROPALETAPROGRAMA(rs.getString("NROPALETAPROGRAMA"));
                dpaj.setIDPALETAREGISTRADA(rs.getString("IDPALETAREGISTRADA"));
                dpaj.setNROPALETAREGISTRADA(rs.getString("NROPALETAREGISTRADA"));
                dpaj.setIDCAMPANA(rs.getString("IDCAMPANA"));
                dpaj.setFECHAPROGRAMACION(rs.getString("FECHAPROGRAMACION"));
                dpaj.setIDMONTACARGA(rs.getInt("IDMONTACARGA"));
                dpaj.setESTADO(rs.getString("ESTADO"));
                dpaj.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                dpaj.setFECHACREACION(rs.getString("FECHACREACION"));
                listaProg.add(dpaj);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return listaProg;   
    }
}
