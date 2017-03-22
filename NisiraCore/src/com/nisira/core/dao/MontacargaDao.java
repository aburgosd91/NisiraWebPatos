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
public class MontacargaDao extends EntityDao<Montacarga>{

    @Override
    public Montacarga find(Montacarga e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Montacarga> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Montacarga> findAll(Object e1) throws Exception {
        Montacarga oMontacarga = null;
        List<Montacarga> listaMontacarga=new ArrayList<Montacarga>();
        try {
            String sql = "SP_MONTACARGA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            int i=1;
            cl.setInt(i++,0);
            cl.setString(i++,e1.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oMontacarga = new Montacarga();
                oMontacarga.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oMontacarga.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oMontacarga.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oMontacarga.setESTADO(rs.getInt("ESTADO"));
                listaMontacarga.add(oMontacarga);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
    public String saveMontacarga(Montacarga montacarga, int estado) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(montacarga!=null){
                String XMLMontacarga = "";
                String XMLMontacargaCpuMovil = "";
                List<DMontacargaCpuMovil> listaequipos = new ArrayList<DMontacargaCpuMovil>();
                listaequipos = montacarga.getListaCpuMovil();
                
                
                String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream = new XStream();
                xStream.processAnnotations(Montacarga.class);
                XMLMontacarga = xml + xStream.toXML(montacarga);
      
                xStream.processAnnotations(DMontacargaCpuMovil.class);
                XMLMontacargaCpuMovil = xml + xStream.toXML(listaequipos);
                if (listaequipos == null)
                {
                    XMLMontacargaCpuMovil = null;
                }
                
                String sql = "SP_MONTACARGA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,estado);
                cl.setString(i++,montacarga.getIDEMPRESA());
                cl.setString(i++,montacarga.getIDMONTACARGA());
                cl.setString(i++,XMLMontacarga);
                cl.setString(i++,XMLMontacargaCpuMovil);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String anularMontacarga(Montacarga montacarga) throws Exception{
        String resultado = "";
        int i=1;
            if(montacarga!=null){
                String sql = "SP_MONTACARGA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,montacarga.getIDEMPRESA() );
                cl.setString(i++,montacarga.getIDMONTACARGA());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteMontacarga(Montacarga montacarga) throws Exception{
        String resultado = "";
        int i=1;
            if(montacarga!=null){
                String sql = "SP_MONTACARGA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,montacarga.getIDEMPRESA() );
                cl.setString(i++,montacarga.getIDMONTACARGA());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public Montacarga findById(String idempresa, String idmontacarga) throws Exception {
        Montacarga oMontacarga = null;
        try {
            String sql = "SP_MONTACARGA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa);
            cl.setString(3,idmontacarga);
            rs = cl.executeQuery();
            while (rs.next()) {
                oMontacarga = new Montacarga();
                oMontacarga.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oMontacarga.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oMontacarga.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oMontacarga.setESTADO(rs.getInt("ESTADO"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return oMontacarga;
    }
    public List<Montacarga> sincronizarMontacarga(Object e1) throws Exception {
        Montacarga oMontacarga = null;
        List<Montacarga> listaMontacarga=new ArrayList<Montacarga>();
        try {
            String sql = "SP_MONTACARGA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            int i=1;
            cl.setInt(i++,0);
            cl.setString(i++,e1.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oMontacarga = new Montacarga();
                oMontacarga.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oMontacarga.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                oMontacarga.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oMontacarga.setFECHACREACION(rs.getString("FECHACREACION"));
                oMontacarga.setESTADO(rs.getInt("ESTADO"));
                oMontacarga.setCODIGOEQUIVALENTE(rs.getString("CODIGOEQUIVALENTE"));
                oMontacarga.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaMontacarga.add(oMontacarga);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMontacarga;
    }
}
