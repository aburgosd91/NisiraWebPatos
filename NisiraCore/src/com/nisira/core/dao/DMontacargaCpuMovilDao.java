/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DMontacargaCpuMovil;
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
public class DMontacargaCpuMovilDao extends EntityDao<DMontacargaCpuMovil>{

    @Override
    public DMontacargaCpuMovil find(DMontacargaCpuMovil e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DMontacargaCpuMovil> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<DMontacargaCpuMovil> findAll(Object e1) throws Exception {
        DMontacargaCpuMovil oDMontacargaCpuMovil = null;
        List<DMontacargaCpuMovil> listaMontacarga=new ArrayList<DMontacargaCpuMovil>();
        try {
            String sql = "SP_DMONTACARGACPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaCpuMovil = new DMontacargaCpuMovil();
                oDMontacargaCpuMovil.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaCpuMovil.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaCpuMovil.setIDCPUMOVIL(rs.getString("IDCPUMOVIL"));
                oDMontacargaCpuMovil.setESTADO(rs.getInt("ESTADO"));
                oDMontacargaCpuMovil.setIDCPUMOVIL(rs.getString("IDCPUMOVIL"));
                listaMontacarga.add(oDMontacargaCpuMovil);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
 
    public List<DMontacargaCpuMovil> findByMontacarga(String idempresa, String idmontacarga) throws Exception {
        
        DMontacargaCpuMovil oDMontacargaCpuMovil = null;
        List<DMontacargaCpuMovil> listaMontacarga =new ArrayList<DMontacargaCpuMovil>();
        try {
            String sql = "SP_DMONTACARGACPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa);
            cl.setString(3,idmontacarga);
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaCpuMovil = new DMontacargaCpuMovil();
                oDMontacargaCpuMovil.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaCpuMovil.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaCpuMovil.setIDCPUMOVIL(rs.getString("IDCPUMOVIL"));
                oDMontacargaCpuMovil.setESTADO(rs.getInt("ESTADO"));
                oDMontacargaCpuMovil.setCPUMOVILDESCRIPCION(rs.getString("CPUMOVIL"));
                listaMontacarga.add(oDMontacargaCpuMovil);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
    
    public List<DMontacargaCpuMovil> sincronizarDMontaCargaEquipo(Object idempresa) throws Exception {
        
        DMontacargaCpuMovil oDMontacargaCpuMovil = null;
        List<DMontacargaCpuMovil> listaMontacarga =new ArrayList<DMontacargaCpuMovil>();
        try {
            String sql = "SP_DMONTACARGACPUMOVIL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1,10);
            cl.setString(2,idempresa.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oDMontacargaCpuMovil = new DMontacargaCpuMovil();
                oDMontacargaCpuMovil.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDMontacargaCpuMovil.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oDMontacargaCpuMovil.setIDCPUMOVIL(rs.getString("IDCPUMOVIL"));
                oDMontacargaCpuMovil.setESTADO(rs.getInt("ESTADO"));
                oDMontacargaCpuMovil.setIDCPUMOVIL(rs.getString("IDCPUMOVIL"));
                listaMontacarga.add(oDMontacargaCpuMovil);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
}
