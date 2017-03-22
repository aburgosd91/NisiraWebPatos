/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Documento;
import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.Notificacion;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DProgAlmMontacargaDao extends EntityDao<DprogAlmMontacarga> {

    @Override
    public DprogAlmMontacarga find(DprogAlmMontacarga e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogAlmMontacarga> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogAlmMontacarga> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DprogAlmMontacarga> findallDprogM(int idem, int idprogalm) throws Exception {
        List<DprogAlmMontacarga> listaDProg = new ArrayList<DprogAlmMontacarga>();
        try {
            String sql = "SP_DProgAlmMont_Mostrar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, idem);/*GETRECORD ALMACEN(5)*/

            cl.setInt(2, idprogalm);
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogAlmMontacarga dpm = new DprogAlmMontacarga();
                dpm.setIdempresa(rs.getInt("IDEMPRESA"));
                dpm.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpm.setIdmontacarga(rs.getString("IDMONTACARGA"));
                dpm.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                dpm.setNotificado(rs.getInt("NOTIFICADO"));
                dpm.setEstado(rs.getInt("ESTADO"));
                dpm.setSincroniza(rs.getInt("SINCRONIZA"));
                listaDProg.add(dpm);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDProg;
    }

    public void generarNotificacion() {

    }

    public List<DprogAlmMontacarga> sincronizarDProgAlmMontacarga(Object idem) throws Exception {
        List<DprogAlmMontacarga> listaDProg = new ArrayList<DprogAlmMontacarga>();
        try {
            String sql = "SP_DProgAlmMont_Mostrar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, idem.toString());/*GETRECORD ALMACEN(5)*/

            cl.setInt(2, 0);
            cl.setInt(3, 1);
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogAlmMontacarga dpm = new DprogAlmMontacarga();
                dpm.setIdempresa(rs.getInt("IDEMPRESA"));
                dpm.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpm.setIdmontacarga(rs.getString("IDMONTACARGA"));
                dpm.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                dpm.setNotificado(rs.getInt("NOTIFICADO"));
                dpm.setEstado(rs.getInt("ESTADO"));
                dpm.setSincroniza(rs.getInt("SINCRONIZA"));
                listaDProg.add(dpm);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDProg;
    }

    public List<DprogAlmMontacarga> SyncDprogAlmMont(Object ide, Object desde, Object hasta) throws Exception {
        List<DprogAlmMontacarga> listaDProg = new ArrayList<DprogAlmMontacarga>();
        try {
            String sql = "SP_DProgAlmMont_Syncro";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/

            cl.setString(2, desde.toString().replace("-", "").trim());
            cl.setString(3, hasta.toString().replace("-", "").trim());
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogAlmMontacarga dpm = new DprogAlmMontacarga();
                dpm.setIdempresa(rs.getInt("IDEMPRESA"));
                dpm.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpm.setIdmontacarga(rs.getString("IDMONTACARGA"));
                dpm.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                dpm.setNotificado(rs.getInt("NOTIFICADO"));
                dpm.setEstado(rs.getInt("ESTADO"));
                dpm.setSincroniza(rs.getInt("SINCRONIZA"));
                listaDProg.add(dpm);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaDProg;
    }

    public Integer insertaNotificaciones(Notificacion dpm, Object e, Object s) throws SQLException, Exception {
        List<Notificacion> ln = new ArrayList<Notificacion>();
        ln.add(dpm);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Notificacion.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "SP_NOTIFICACION_GRABA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, xmlNot);
            cl.setObject(2, e);
            cl.setObject(3, s);
            rs = cl.executeQuery();
            while (rs.next()) {
                id = rs.getInt("TABLA_ID");
            }
            return id;
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public Notificacion verNotif(Object e, Object p, Object n) throws Exception {
        Notificacion no = new Notificacion();
        try {
            String sql = "SP_Notificacion_Ver";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e);/*GETRECORD ALMACEN(5)*/

            cl.setObject(2, p);
            cl.setObject(3, n);
            rs = cl.executeQuery();
            while (rs.next()) {
                no.setIdempresa(rs.getInt("IDEMPRESA"));
                no.setIdnotificacion(rs.getInt("IDNOTIFICACION"));
                no.setMensaje(rs.getString("MENSAJE"));
                no.setFechacreacion(rs.getString("FECHACREACION"));
                no.setPrioridad(rs.getInt("PRIORIDAD"));
                no.setEstado(rs.getBoolean("ESTADO") ? 1 : 0);
            }
            return no;
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public List<Notificacion> syncNotificacion(Object ide, Object desde, Object hasta) throws SQLException, Exception {
        List<Notificacion> no = new ArrayList<Notificacion>();
        try {
            String sql = "SP_NOTIFICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/

            cl.setString(2, desde.toString().replace("-", "").trim());/*++HASTA++*/

            cl.setString(3, hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                Notificacion not = new Notificacion();
                not.setIdempresa(rs.getInt("IDEMPRESA"));
                not.setIdnotificacion(rs.getInt("IDNOTIFICACION"));
                not.setMensaje(rs.getString("MENSAJE"));
                not.setFechacreacion(rs.getString("FECHACREACION"));
                not.setPrioridad(rs.getInt("PRIORIDAD"));
                not.setEstado(rs.getBoolean("ESTADO") ? 1 : 0);
                no.add(not);
            }
            return no;
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
