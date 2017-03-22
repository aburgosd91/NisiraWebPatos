/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.EnvioNotificacion;
import com.nisira.core.entity.Notificacion;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class NotificacionDao  extends EntityDao<Notificacion> {

    @Override
    public Notificacion find(Notificacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notificacion> findAll(Object e) throws Exception {
        List<Notificacion> l = new ArrayList<Notificacion>();
        try {
            String sql = "SP_NOTIFIACIONENVIO";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(i++, 4);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Notificacion a = new Notificacion();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdnotificacion(rs.getInt("IDNOTIFICACION"));
                a.setMensaje(rs.getString("MENSAJE"));
                a.setToquen(rs.getString("TOQUEN"));
                a.setFechacreacion(CoreUtil.fechaHoraEspaniol(rs.getString("FECHACREACION")));
                a.setPrioridad(rs.getInt("PRIORIDAD"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setModo((rs.getString("MODO")));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public List<EnvioNotificacion> findAllDetalle(Object e) throws Exception {
        Notificacion e_=(Notificacion)e;
        List<EnvioNotificacion> l = new ArrayList<EnvioNotificacion>();
        try {
            String sql = "SP_NOTIFIACIONENVIO";
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setObject(i++, 5);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, e_.getIdempresa());
            cl.setObject(i++, "");
            cl.setObject(i++, "");
            cl.setObject(i++, e_.getIdnotificacion());
            rs = cl.executeQuery();
            while (rs.next()) {
                EnvioNotificacion a = new EnvioNotificacion();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdenvionotificacion(rs.getInt("IDENVIONOTIFICACION"));
                a.setIdnotifiacion(rs.getInt("IDNOTIFICACION"));
                a.setIdmontacarga(rs.getString("IDMONTACARGA"));
                a.setFechaenvio(CoreUtil.fechaHoraEspaniol(rs.getString("FECHAENVIO")));
                a.setFecharecepcion(CoreUtil.fechaHoraEspaniol(rs.getString("FECHARECEPCION")));
                a.setMontacarga(rs.getString("MONTACARGA"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    @Override
    public List<Notificacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String grabar(Notificacion notificacion,List<EnvioNotificacion> listEnvioNotificacion) throws Exception {
        int i=1;
        String resultado="";
        String xmlNotificaciones="";
        String xmlEnvioNotificacion="";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (notificacion != null) {

            String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Notificacion.class);
            xmlNotificaciones = xml + xStream.toXML(notificacion);
            if(listEnvioNotificacion!=null){
                if(listEnvioNotificacion.size()>0){
                    xStream.processAnnotations(EnvioNotificacion.class);
                    xmlEnvioNotificacion = xml + xStream.toXML(listEnvioNotificacion);
                }
                String sql = "SP_NOTIFIACIONENVIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++, 1);
                cl.setString(i++, "");
                cl.setInt(i++, notificacion.getIdempresa());
                cl.setString(i++, xmlNotificaciones);
                cl.setString(i++, xmlEnvioNotificacion);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        }
        return resultado;
    }
    
    public String actualizar(Notificacion notificacion,List<EnvioNotificacion> listEnvioNotificacion) throws Exception {
        int i=1;
        String resultado="";
        String xmlNotificaciones="";
        String xmlEnvioNotificacion="";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (notificacion != null) {

            String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Notificacion.class);
            xmlNotificaciones = xml + xStream.toXML(notificacion);
            if(listEnvioNotificacion!=null){
                if(listEnvioNotificacion.size()>0){
                    xStream.processAnnotations(EnvioNotificacion.class);
                    xmlEnvioNotificacion = xml + xStream.toXML(listEnvioNotificacion);
                }
                String sql = "SP_NOTIFIACIONENVIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++, 2);
                cl.setString(i++, "");
                cl.setInt(i++, notificacion.getIdempresa());
                cl.setString(i++, xmlNotificaciones);
                cl.setString(i++, xmlEnvioNotificacion);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        }
        return resultado;
    }
    public String anular(Notificacion a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_NOTIFIACIONENVIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setObject(i++, 3);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, "");
            cl.setObject(i++, "");
            cl.setObject(i++, a.getIdnotificacion());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String eliminar(Notificacion a) throws Exception{
        String resultado="";
        try {
            int i=1;
            String sql = "SP_NOTIFIACIONENVIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setObject(i++, 6);/*tipo*/
            cl.setObject(i++, "");/*QUERY*/
            cl.setObject(i++, a.getIdempresa());
            cl.setObject(i++, "");
            cl.setObject(i++, "");
            cl.setObject(i++, a.getIdnotificacion());
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    
    public String grabarXTareas(Notificacion notificacion,EnvioNotificacion envioNotificacion) throws Exception {
        int i=1;
        String resultado="";
        String xmlNotificaciones="";
        String xmlEnvioNotificacion="";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        if (notificacion != null) {

            String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Notificacion.class);
            xmlNotificaciones = xml + xStream.toXML(notificacion);
            if(envioNotificacion!=null){
                xStream.processAnnotations(EnvioNotificacion.class);
                xmlEnvioNotificacion = xml + xStream.toXML(envioNotificacion);
            
                String sql = "SP_NOTIFIACIONENVIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++, 20);
                cl.setString(i++, "");
                cl.setInt(i++, notificacion.getIdempresa());
                cl.setString(i++, xmlNotificaciones);
                cl.setString(i++, xmlEnvioNotificacion);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        }
        return resultado;
    }
    
}
