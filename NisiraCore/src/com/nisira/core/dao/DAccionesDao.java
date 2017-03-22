/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAcciones;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class DAccionesDao extends EntityDao<DAcciones>{

    @Override
    public DAcciones find(DAcciones e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAcciones> findAll(Object e) throws Exception {
        DAcciones e_=(DAcciones)e;
        List<DAcciones> l = new ArrayList<DAcciones>();
        try {
            String sql = "SP_DACCIONES";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, "");/*XML_ACCION */
            cl.setObject(i++, e_.getIdempresa());
            cl.setObject(i++, e_.getIdaccion());
            rs = cl.executeQuery();
            while (rs.next()) {
                DAcciones a = new DAcciones();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdaccion(rs.getInt("IDACCION"));
                a.setIdactividades(rs.getInt("IDACTIVIDADES"));
                a.setDatos(rs.getInt("DATOS"));
                a.setOrden((rs.getInt("ORDEN")));
                a.setAccion(rs.getString("ACCION"));
                a.setActividades((rs.getString("ACTIVIDADES")));
                a.setMETHODAUT(rs.getString("METHODAUT"));
                a.setMETHODMAN(rs.getString("METHODMAN"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<DAcciones> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String grabar(List<DAcciones> listDAcciones) throws Exception{
        int i=1;
        String resultado="";
        String xmldactividades="";
        try{
            if(listDAcciones!=null){
                if(listDAcciones.size()>0){
                    String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                    XStream xStream = new XStream();
                    xStream.processAnnotations(DAcciones.class);
                    xmldactividades = xml + xStream.toXML(listDAcciones);

                    String sql ="SP_DACCIONES";
                    cn = obtenerConexionJTDS();
                    cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                    cl.setInt(i++,1);
                    cl.setString(i++,"");
                    cl.setString(i++,xmldactividades);
                    cl.setInt(i++,listDAcciones.get(0).getIdempresa());
                    cl.setInt(i++,listDAcciones.get(0).getIdaccion());
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
    public String actualizar(List<DAcciones> listDAcciones) throws Exception{
        int i=1;
        String xmldactividades="";
        String resultado="";
        try{
            if(listDAcciones!=null){
                if(listDAcciones.size()>0){
                    String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                    XStream xStream = new XStream();
                    xStream.processAnnotations(DAcciones.class);
                    xmldactividades = xml + xStream.toXML(listDAcciones);

                    String sql ="SP_DACCIONES";
                    cn = obtenerConexionJTDS();
                    cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                    cl.setInt(i++,2);
                    cl.setString(i++,"");
                    cl.setString(i++,xmldactividades);
                    cl.setInt(i++,listDAcciones.get(0).getIdempresa());
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

}
