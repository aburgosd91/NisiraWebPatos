/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DMontacargaOperario;
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
public class DMontacargaOperarioDao extends EntityDao<DMontacargaOperario>{

    @Override
    public DMontacargaOperario find(DMontacargaOperario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DMontacargaOperario> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DMontacargaOperario> findAll(Object e1) throws Exception {
        DMontacargaOperario oDMontacargaOperario = null;
        List<DMontacargaOperario> listaMontacarga=new ArrayList<DMontacargaOperario>();
        try {
            String sql = "SP_DMONTACARGAOPERARIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaOperario = new DMontacargaOperario();
                oDMontacargaOperario.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaOperario.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaOperario.setIDOPERARIO(rs.getString("IDOPERARIO"));
                oDMontacargaOperario.setESTADO(rs.getInt("ESTADO"));
                listaMontacarga.add(oDMontacargaOperario);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
 
    public List<DMontacargaOperario> findByMontacarga(String idempresa, String idmontacarga) throws Exception {
        
        DMontacargaOperario oDMontacargaOperario = null;
        List<DMontacargaOperario> listaoperarios = new ArrayList<DMontacargaOperario>();
        try {
            String sql = "SP_DMONTACARGAOPERARIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa);
            cl.setString(3,idmontacarga);
            rs = cl.executeQuery();
            
            while (rs.next()) {
                oDMontacargaOperario = new DMontacargaOperario();
                oDMontacargaOperario.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaOperario.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaOperario.setIDOPERARIO(rs.getString("IDOPERARIO"));
                oDMontacargaOperario.setESTADO(rs.getInt("ESTADO"));
                listaoperarios.add(oDMontacargaOperario);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaoperarios;
    }
    
    public List<DMontacargaOperario> sincronizarDMontaCargaOperario(Object idempresa) throws Exception {
        
        DMontacargaOperario oDMontacargaOperario = null;
        List<DMontacargaOperario> listaoperarios = new ArrayList<DMontacargaOperario>();
        try {
            String sql = "SP_DMONTACARGAOPERARIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa.toString());
            rs = cl.executeQuery();
            
            while (rs.next()) {
                oDMontacargaOperario = new DMontacargaOperario();
                oDMontacargaOperario.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaOperario.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaOperario.setIDOPERARIO(rs.getString("IDOPERARIO"));
                oDMontacargaOperario.setESTADO(rs.getInt("ESTADO"));
                oDMontacargaOperario.setFECHACREACION(rs.getString("FECHACREACION"));
                listaoperarios.add(oDMontacargaOperario);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaoperarios;
    }
}
