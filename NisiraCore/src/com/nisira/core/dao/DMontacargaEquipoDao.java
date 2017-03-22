/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DMontacargaEquipo;
import com.nisira.core.entity.DMontacargaOperario;
import com.nisira.core.entity.Montacarga;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
public class DMontacargaEquipoDao extends EntityDao<DMontacargaEquipo>{

    @Override
    public DMontacargaEquipo find(DMontacargaEquipo e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DMontacargaEquipo> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DMontacargaEquipo> findAll(Object e1) throws Exception {
        DMontacargaEquipo oDMontacargaEquipo = null;
        List<DMontacargaEquipo> listaMontacarga=new ArrayList<DMontacargaEquipo>();
        try {
            String sql = "SP_DMONTACARGAEQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaEquipo = new DMontacargaEquipo();
                oDMontacargaEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaEquipo.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaEquipo.setIDEQUIPO(rs.getString("DESCRIPCION"));
                oDMontacargaEquipo.setESTADO(rs.getInt("ESTADO"));
                
                listaMontacarga.add(oDMontacargaEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
 
    public List<DMontacargaEquipo> findByMontacarga(String idempresa, String idmontacarga) throws Exception {
        
        DMontacargaEquipo oDMontacargaEquipo = null;
        List<DMontacargaEquipo> listaequipos =new ArrayList<DMontacargaEquipo>();
        try {
            String sql = "SP_DMONTACARGAEQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa);
            cl.setString(3,idmontacarga);
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaEquipo = new DMontacargaEquipo();
                oDMontacargaEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaEquipo.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaEquipo.setIDEQUIPO(rs.getString("IDEQUIPO"));
                oDMontacargaEquipo.setESTADO(rs.getInt("ESTADO"));
                listaequipos.add(oDMontacargaEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaequipos;
    }
    
    public List<DMontacargaEquipo> sincronizarDMontaCargaEquipo(Object idempresa) throws Exception {
        
        DMontacargaEquipo oDMontacargaEquipo = null;
        List<DMontacargaEquipo> listaequipos =new ArrayList<DMontacargaEquipo>();
        try {
            String sql = "SP_DMONTACARGAEQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1,10);
            cl.setString(2,idempresa.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaEquipo = new DMontacargaEquipo();
                oDMontacargaEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaEquipo.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaEquipo.setIDEQUIPO(rs.getString("IDEQUIPO"));
                oDMontacargaEquipo.setESTADO(rs.getInt("ESTADO"));
                oDMontacargaEquipo.setFECHACREACION(rs.getString("IDEQUIPO"));
                oDMontacargaEquipo.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                listaequipos.add(oDMontacargaEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaequipos;
    }
}
