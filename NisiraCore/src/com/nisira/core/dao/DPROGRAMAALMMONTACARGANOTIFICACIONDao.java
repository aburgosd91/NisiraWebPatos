/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DPROGRAMAALMMONTACARGANOTIFICACION;
import com.nisira.core.entity.Notificacion;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DPROGRAMAALMMONTACARGANOTIFICACIONDao extends EntityDao<DPROGRAMAALMMONTACARGANOTIFICACION> {

    @Override
    public DPROGRAMAALMMONTACARGANOTIFICACION find(DPROGRAMAALMMONTACARGANOTIFICACION e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DPROGRAMAALMMONTACARGANOTIFICACION> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DPROGRAMAALMMONTACARGANOTIFICACION> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertaDPROGRAMALM(List<DPROGRAMAALMMONTACARGANOTIFICACION> list) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DPROGRAMAALMMONTACARGANOTIFICACION.class);
        xmlNot = xml + xStream.toXML(list);
        try {
            Integer id = null;
            String sql = "SP_DPROGRAMAALMMONTACARGANOTIFICACION_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public List<DPROGRAMAALMMONTACARGANOTIFICACION> syncDprogMont(Object ide, Object ids, Object idn, Object desde, Object hasta) throws Exception {
        List<DPROGRAMAALMMONTACARGANOTIFICACION> list = new ArrayList<DPROGRAMAALMMONTACARGANOTIFICACION>();
        try {
            String sql = "SP_DPROGRAMAALMMONTACARGANOTIFICACION_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(3, Integer.parseInt(idn.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(4,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(5,hasta.toString().replace("-", "").trim());/*++HASTA++*/

            rs = cl.executeQuery();
            while (rs.next()) {
                DPROGRAMAALMMONTACARGANOTIFICACION d = new DPROGRAMAALMMONTACARGANOTIFICACION();
                d.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                d.setIDPROGRAMAALM(rs.getInt("IDPROGRAMAALM"));
                d.setIDMONTACARGA(rs.getInt("IDMONTACARGA"));
                d.setIDNOTIFICACION(rs.getInt("IDNOTIFICACION"));
                d.setFECHARECEPCION(rs.getString("FECHARECEPCION"));
                d.setFECHALECTURA(rs.getString("FECHALECTURA"));
                d.setESTADO(rs.getInt("ESTADO"));
                d.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                d.setFECHACREACION(rs.getString("FECHACREACION"));
                list.add(d);
            }
            return list;
        } finally {
            cerrar(cn, cl, rs);
        }

    }
}
