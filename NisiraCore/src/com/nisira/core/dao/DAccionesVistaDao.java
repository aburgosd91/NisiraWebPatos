/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAccionesVista;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class DAccionesVistaDao  extends EntityDao<DAccionesVista>{

    @Override
    public DAccionesVista find(DAccionesVista e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DAccionesVista> findAll(Object e1,Object e2) throws Exception {
//        DAccionesVista e_=(DAccionesVista)e;
        List<DAccionesVista> l = new ArrayList<DAccionesVista>();
        try {
            String sql = "SP_DACCIONESVISTA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setObject(i++, 6);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e1.toString());/*IDEMPRESA*/
            cl.setObject(i++, "");/*@IDACCION */
            cl.setObject(i++, e2.toString());/*@VISTA*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DAccionesVista a = new DAccionesVista();
                a.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                a.setIDACCION(rs.getInt("IDACCION"));
                a.setVISTA(rs.getString("VISTA"));
                a.setORDEN(rs.getInt("ORDEN"));
                a.setACCIONES(rs.getString("ACCIONES"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<DAccionesVista> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String grabar(List<DAccionesVista> listDAccionesVista) throws Exception{
        int i=1;
        String resultado="";
        String xmldactividades="";
        try{
            if(listDAccionesVista!=null){
                if(listDAccionesVista.size()>0){
                    String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                    XStream xStream = new XStream();
                    xStream.processAnnotations(DAccionesVista.class);
                    xmldactividades = xml + xStream.toXML(listDAccionesVista);

                    String sql ="SP_DACCIONESVISTA";
                    cn = obtenerConexionJTDS();
                    cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
                    cl.setInt(i++,1);
                    cl.setString(i++,"");
                    cl.setString(i++,xmldactividades);
                    cl.setInt(i++,listDAccionesVista.get(0).getIDEMPRESA());
                    cl.setInt(i++,0);
                    cl.setString(i++,listDAccionesVista.get(0).getVISTA());
                    rs = cl.executeQuery();
                    while (rs.next()) {
                        resultado = (rs.getString("mensaje"));                
                    }
                }
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        
        return resultado;
    }
    public String actualizar(List<DAccionesVista> listDAccionesVista) throws Exception{
        int i=1;
        String xmldactividades="";
        String resultado="";
        try{
            if(listDAccionesVista!=null){
                if(listDAccionesVista.size()>0){
                    String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                    XStream xStream = new XStream();
                    xStream.processAnnotations(DAccionesVista.class);
                    xmldactividades = xml + xStream.toXML(listDAccionesVista);

                    String sql ="SP_DACCIONESVISTA";
                    cn = obtenerConexionJTDS();
                    cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                    cl.setInt(i++,2);
                    cl.setString(i++,"");
                    cl.setString(i++,xmldactividades);
                    cl.setInt(i++,listDAccionesVista.get(0).getIDEMPRESA());
                    rs = cl.executeQuery();
                    while (rs.next()) {
                        resultado = (rs.getString("mensaje"));                
                    }
                }
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String delete(Object e1,Object e2) throws Exception{
        int i=1;
        String resultado="";
        try{
            if(e2!=null){
                String sql ="SP_DACCIONESVISTA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,"");
                cl.setObject(i++,e1.toString());/*IDEMPRESA*/
                cl.setString(i++,"");
                cl.setObject(i++,e2.toString());/*VISTA*/
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    @Override
    public List<DAccionesVista> findAll(Object e) throws Exception {
        List<DAccionesVista> l = new ArrayList<DAccionesVista>();
        try {
            String sql = "SP_DACCIONESVISTA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e.toString());/*IDEMPRESA*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DAccionesVista a = new DAccionesVista();
//                a.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                a.setIDACCION(rs.getInt("IDACCION"));
                a.setVISTA(rs.getString("VISTA"));
//                a.setORDEN(rs.getInt("ORDEN"));
//                a.setACCIONES(rs.getString("ACCIONES"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    
    public List<DAccionesVista> findAllxVista(Object e1,Object e2) throws Exception {
//        DAccionesVista e_=(DAccionesVista)e;
        List<DAccionesVista> l = new ArrayList<DAccionesVista>();
        try {
            String sql = "SP_DACCIONESVISTA";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 6);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e1.toString());/*IDEMPRESA*/
            cl.setObject(i++, e2.toString());/*VISTA*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DAccionesVista a = new DAccionesVista();
                a.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                a.setIDACCION(rs.getInt("IDACCION"));
                a.setVISTA(rs.getString("VISTA"));
                a.setORDEN(rs.getInt("ORDEN"));
                a.setACCIONES(rs.getString("ACCIONES"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    
}
