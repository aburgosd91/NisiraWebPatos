/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.mUsuario;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class mUsuarioDAO extends EntityDao<mUsuario>{

    @Override
    public mUsuario find(mUsuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mUsuario> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mUsuario> findAll() throws Exception {
        List<mUsuario> lu = new ArrayList<mUsuario>();
        try {
            String sql = "SP_mUsuario";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                mUsuario u = new mUsuario();
                u.setIdusuario(rs.getString("idUsuario"));
                u.setClave(rs.getString("Clave"));
                u.setBEstado(rs.getBoolean("Estado"));
                u.setNombres(rs.getString("Nombres"));
                u.setIdgrupousuario(rs.getString("idgrupoUsuario"));
                u.setIdoperario(rs.getString("idoperario"));
                lu.add(u);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lu;
    }
    public void grabarMusuario(mUsuario mu) throws Exception{
        try {

            String resultado = "";
            List<mUsuario> l = new ArrayList<mUsuario>();
            l.add(mu);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("musuario", mUsuario.class);
            String xml = xstream.toXML(l);
            
            String sql = "SP_mUsuarioGrabar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setString(1, mu.getIdusuario());
            cl.setString(2, xml);
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
