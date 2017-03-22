/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Responsable;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ResponsableDao extends EntityDao<Responsable>{

    @Override
    public Responsable find(Responsable e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Responsable> findAll(Object e) throws Exception {
        List<Responsable> listresp = new ArrayList<Responsable>();
        try {
            String sql = "SP_Responsable_Mostrar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);/*GETRECORD ALMACEN(5)*/
            rs = cl.executeQuery();
            while (rs.next()) {
                Responsable re = new Responsable();
                re.setIdempresa(rs.getInt("IDEMPRESA"));
                re.setIdresponsable(rs.getInt("IDRESPONSABLE"));
                re.setIdoperario(rs.getString("IDOPERARIO"));
                re.setEstado(rs.getInt("ESTADO"));
                re.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                re.setNombre(rs.getString("NOMBRE"));
                listresp.add(re);

            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listresp;
    }

    @Override
    public List<Responsable> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void insertaRespo(Responsable re) throws Exception{
        List<Responsable> l = new ArrayList<Responsable>();
        l.add(re);

        XStream xstream = new XStream(new DomDriver());

        xstream.alias("responsable", Responsable.class);

        String xml = xstream.toXML(l);
         try {
            String sql = "SP_Responsable_Inserta";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, re.getIdempresa());
            cl.setObject(2, re.getIdresponsable());
            cl.setObject(3, xml);
            rs = cl.executeQuery();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public Responsable findRespon(int idemp,int idres) throws Exception {
        Responsable re = new Responsable();
        try {
            String sql = "SP_Responsable_Mostrar2";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setInt(1, idemp);/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, idres);
            rs = cl.executeQuery();
            while (rs.next()) {
                re.setIdempresa(rs.getInt("IDEMPRESA"));
                re.setIdresponsable(rs.getInt("IDRESPONSABLE"));
                re.setIdoperario(rs.getString("IDOPERARIO"));
                re.setEstado(rs.getInt("ESTADO"));
                re.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                re.setNombre(rs.getString("NOMBRE"));

            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return re;
    }
    
    public List<Responsable> sincronizarResponsable(Object e1,Object e2,Object e3,Object e4) throws Exception {
        List<Responsable> listresp = new ArrayList<Responsable>();
        try {
            String sql = "SP_Responsable_Mostrar2";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(1, e1);/*IDEMPRESA*/
            cl.setObject(2, e2);/*IDSUCURSAL*/
            cl.setObject(3, 1);/*TIPO*/
            cl.setObject(4, e3);/*desde*/
            cl.setObject(5, e4);/*hasta*/
            rs = cl.executeQuery();
            while (rs.next()) {
                Responsable re = new Responsable();
                re.setIdempresa(rs.getInt("IDEMPRESA"));
                re.setIdresponsable(rs.getInt("IDRESPONSABLE"));
                re.setIdoperario(rs.getString("IDOPERARIO"));
                re.setEstado(rs.getInt("ESTADO"));
                re.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                listresp.add(re);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listresp;
    }
    
}
