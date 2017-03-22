/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.CONFIGTABLASINCRO;
import com.nisira.core.entity.SINCRONIZA;
import com.nisira.core.entity.TablaSincroniza;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class SincronizaDao  extends EntityDao<SINCRONIZA> {

    @Override
    public SINCRONIZA find(SINCRONIZA e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SINCRONIZA> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SINCRONIZA> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<CONFIGTABLASINCRO> getEstructura(String inicio, String fin,Object idempresa)  throws Exception {
        CONFIGTABLASINCRO oTablaSincroniza = null;
        List<CONFIGTABLASINCRO> listaTablaSincroniza=new ArrayList<CONFIGTABLASINCRO>();
        try {
            String sql = "SP_SICRONIZAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,3);/*GETRECORD SINCRONIZA(6)*/
            cl.setString(2,CoreUtil.fechaConvert112(inicio));
            cl.setString(3,CoreUtil.fechaConvert112(fin));
            cl.setString(4,"");
            cl.setObject(5,idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                oTablaSincroniza = new CONFIGTABLASINCRO();
                oTablaSincroniza.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                        oTablaSincroniza.setIDTABLASINCRO(rs.getInt("IDTABLASINCRO"));
                        oTablaSincroniza.setTABLA(rs.getString("TABLA"));
                        oTablaSincroniza.setTIPOSINCRO(rs.getInt("TIPOSINCRO"));
                        oTablaSincroniza.setUPDOWN(rs.getInt("UPDOWN"));
                        oTablaSincroniza.setFECHACREACION(rs.getString("FECHACREACION"));
                        oTablaSincroniza.setESTADO(rs.getInt("ESTADO"));
                listaTablaSincroniza.add(oTablaSincroniza);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaTablaSincroniza;
    }
    public String getEstructura(String tabla,String inicio, String fin,int idempresa,int idsucursal)  throws Exception {
        String respuesta="";
        try {
            String sql = "SP_SICRONIZAR";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setInt(i++,2);/*GETRECORD SINCRONIZA(6)-> IDOPERACION */
            cl.setString(i++,CoreUtil.fechaConvert112(inicio));
            cl.setString(i++,CoreUtil.fechaConvert112(fin));
            cl.setString(i++,tabla);
            cl.setInt(i++,idempresa);
            cl.setInt(i++,idsucursal);
            rs = cl.executeQuery();
            while (rs.next()) {
                respuesta = rs.getString("file");
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return respuesta;
    }
}
