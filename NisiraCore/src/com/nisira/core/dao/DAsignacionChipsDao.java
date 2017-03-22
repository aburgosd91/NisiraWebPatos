/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.AsignacionChips;
import com.nisira.core.entity.DAsignacionChips;
import com.nisira.core.entity.DAsignacionChipsDet;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DAsignacionChipsDao extends EntityDao<DAsignacionChips> {

    @Override
    public DAsignacionChips find(DAsignacionChips e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAsignacionChips> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAsignacionChips> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DAsignacionChips> findAll(Object ide, Object ids, Object ida) throws Exception {
        List<DAsignacionChips> l = new ArrayList<DAsignacionChips>();
        try {
            String sql = "SP_DASIGNACIONCHIPS_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, ida);
            rs = cl.executeQuery();
            while (rs.next()) {
                DAsignacionChips da = new DAsignacionChips();
                da.setIdempresa(rs.getInt("IDEMPRESA"));
                da.setIdsucursal(rs.getInt("IDSUCURSAL"));
                da.setIdasignacionchips(rs.getString("IDASIGNACIONCHIPS"));
                da.setIdzona(rs.getInt("IDZONA"));
                da.setCordenadax(rs.getInt("CORDENADAX"));
                da.setCordenaday(rs.getInt("CORDENADAY"));
                da.setIdubicacion(rs.getString("IDUBICACION"));
                da.setCordenadaxt(rs.getInt("CORDENADAXT"));
                da.setCordenadayt(rs.getInt("CORDENADAYT"));
                da.setEstadoasignacion(rs.getInt("ESTADOASIGNACION"));
                da.setSeriechip(rs.getString("SERIECHIP"));
                da.setPosicion(rs.getString("POSICION"));
                da.setDesc(rs.getString("DESCRIPCION"));
                da.setProc(true);
                da.setLisdet(new ArrayList<DAsignacionChipsDet>());
                l.add(da);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public void grabar(AsignacionChips a, List<DAsignacionChips> lda) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DAsignacionChips.class);
        xmlNot = xml + xStream.toXML(lda);
        String id = "";
        try {
            String sql = "SP_DASIGNACIONCHIPS_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setObject(1, a.getIdempresa());
            cl.setObject(2, a.getIdsucursal());
            cl.setObject(3, a.getIdasignacionchips());
            cl.setObject(4, xmlNot);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public List<DAsignacionChips> gendAll(Object ide, Object ids, Object idz) throws Exception {
        List<DAsignacionChips> l = new ArrayList<DAsignacionChips>();
        try {
            String sql = "SP_DASIGNACIONCHIP_GENERA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, ids);
            cl.setObject(3, idz);
            rs = cl.executeQuery();
            while (rs.next()) {
                DAsignacionChips da = new DAsignacionChips();
                da.setIdempresa(rs.getInt("IDEMPRESA"));
                da.setIdsucursal(rs.getInt("IDSUCURSAL"));
                da.setIdasignacionchips(rs.getString("IDASIGNACIONCHIPS"));
                da.setIdzona(rs.getInt("IDZONA"));
                da.setCordenadax(rs.getInt("CORDENADAX"));
                da.setCordenaday(rs.getInt("CORDENADAY"));
                da.setIdubicacion(rs.getString("IDUBICACION"));
                da.setCordenadaxt(rs.getInt("CORDENADAXT"));
                da.setCordenadayt(rs.getInt("CORDENADAYT"));
                da.setEstadoasignacion(rs.getInt("ESTADOASIGNACION"));
                da.setSeriechip(rs.getString("SERIECHIP"));
                da.setTiporack(rs.getInt("TIPORACKS"));
                da.setLisdet(new ArrayList<DAsignacionChipsDet>());
                l.add(da);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
