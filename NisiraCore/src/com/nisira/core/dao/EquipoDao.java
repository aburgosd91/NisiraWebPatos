/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Equipo;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Zavala <vzavala@nisira.com.pe>
 */
public class EquipoDao extends EntityDao<Equipo>{

    @Override
    public Equipo find(Equipo e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipo> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Equipo> findAll(Object e1) throws Exception {
        Equipo oEquipo = null;
        List<Equipo> listaEquipo=new ArrayList<Equipo>();
        try {
            String sql = "SP_EQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            int i=1;
            cl.setInt(i++,0);
            cl.setString(i++,e1.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oEquipo = new Equipo();
                oEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oEquipo.setIDEQUIPO(rs.getInt("IDEQUIPO"));
                oEquipo.setIDTIPOEQUIPOMONTACARGA(rs.getInt("IDTIPOEQUIPOMONTACARGA"));
                oEquipo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oEquipo.setNROSERIE(rs.getString("NROSERIE"));
                oEquipo.setESTADO(rs.getBoolean("ESTADO"));
                listaEquipo.add(oEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaEquipo;
    }
    public String saveEquipo(Equipo equipo) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(equipo!=null){
                String XMLEquipo = "";
                
                String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream = new XStream();
                xStream.processAnnotations(Equipo.class);
                XMLEquipo = xml + xStream.toXML(equipo);
                
                String sql = "SP_EQUIPO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,equipo.getIDEMPRESA());
                cl.setInt(i++,equipo.getIDEQUIPO());
                cl.setString(i++,"");
                cl.setString(i++,XMLEquipo);
                
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String anularEquipo(Equipo equipo) throws Exception{
        String resultado = "";
        int i=1;
            if(equipo!=null){
                String sql = "SP_EQUIPO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,equipo.getIDEMPRESA() );
                cl.setInt(i++,equipo.getIDEQUIPO());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteEquipo(Equipo equipo) throws Exception{
        String resultado = "";
        int i=1;
            if(equipo!=null){
                String sql = "SP_EQUIPO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,equipo.getIDEMPRESA() );
                cl.setInt(i++,equipo.getIDEQUIPO());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
   
    public Equipo findById(String idempresa, String idequipo) throws Exception {
        Equipo oEquipo = null;
        try {
            String sql = "SP_EQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            int i=1;
            cl.setInt(i++,0);
            cl.setString(i++,idempresa);
            cl.setString(i++,idequipo);
            
            rs = cl.executeQuery();
            while (rs.next()) {
                oEquipo = new Equipo();
                oEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oEquipo.setIDEQUIPO(rs.getInt("IDEQUIPO"));
                oEquipo.setIDTIPOEQUIPOMONTACARGA(rs.getInt("IDTIPOEQUIPOMONTACARGA"));
                oEquipo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oEquipo.setNROSERIE(rs.getString("NROSERIE"));
                oEquipo.setESTADO(rs.getBoolean("ESTADO"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return oEquipo;
    }
    public List<Equipo> findByFiltro(String idempresa, String filtro) throws Exception{
        Equipo oEquipo = null;
        List<Equipo> listaEquipo=new ArrayList<Equipo>();
        try {
            String sql = "SP_EQUIPO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            
            int i=1;
            cl.setInt(i++,4);
            cl.setString(i++,idempresa);
            cl.setString(i++,"");
            cl.setString(i++,filtro);
            
            rs = cl.executeQuery();
            while (rs.next()) {
                oEquipo = new Equipo();
                oEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oEquipo.setIDEQUIPO(rs.getInt("IDEQUIPO"));
                oEquipo.setIDTIPOEQUIPOMONTACARGA(rs.getInt("IDTIPOEQUIPOMONTACARGA"));
                oEquipo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oEquipo.setNROSERIE(rs.getString("NROSERIE"));
                oEquipo.setESTADO(rs.getBoolean("ESTADO"));
                listaEquipo.add(oEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaEquipo;
    }
    public void anular(String idempresa, int id) throws Exception{
        try {
            String sql = "Update equipo SET ESTADO = 2 where IDEMPRESA=? and IDEQUIPO=?";
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement(sql);
            pr.setObject(1, idempresa);
            pr.setObject(2, id);
            pr.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public List<Equipo> findByTipo(Object idempresa,int tipo) throws Exception{
        List<Equipo> listaEquipo=new ArrayList<Equipo>();
        try {
            String sql = "SP_EQUIPO_TIPOVER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            
            int i=1;
            cl.setObject(i++,idempresa);
            cl.setInt(i++,tipo);
            
            rs = cl.executeQuery();
            while (rs.next()) {
                Equipo oEquipo = new Equipo();
                oEquipo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oEquipo.setIDEQUIPO(rs.getInt("IDEQUIPO"));
                oEquipo.setIDTIPOEQUIPOMONTACARGA(rs.getInt("IDTIPOEQUIPOMONTACARGA"));
                oEquipo.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oEquipo.setNROSERIE(rs.getString("NROSERIE"));
                oEquipo.setESTADO(rs.getBoolean("ESTADO"));
                listaEquipo.add(oEquipo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaEquipo;
    }
}
