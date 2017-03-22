/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DZonaGeneral;
import com.nisira.core.entity.mGrupoUsuario;
import com.nisira.core.entity.mGrupoUsuarioPrivilegio;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class mGrupoUsuarioDAO extends EntityDao<mGrupoUsuario> {

    @Override
    public mGrupoUsuario find(mGrupoUsuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mGrupoUsuario> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mGrupoUsuario> findAll() throws Exception {
        List<mGrupoUsuario> lgu = new ArrayList<mGrupoUsuario>();
        try {
            String sql = "SP_mGrupoUsuariosVer";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                mGrupoUsuario gu = new mGrupoUsuario();
                gu.setDescripcion(rs.getString("descripcion"));
                gu.setBEs_administrador(rs.getBoolean("es_administrador"));
                gu.setIdgrupousuario(rs.getString("idgrupousuario"));
                lgu.add(gu);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lgu;
    }

    public List<mGrupoUsuarioPrivilegio> findbyGrupoUsuario(String id) throws Exception {
        List<mGrupoUsuarioPrivilegio> lmgup = new ArrayList<mGrupoUsuarioPrivilegio>();
        try {
            String sql = "mGrupoUsuarioPrivVer";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setString(1, id);
            rs = cl.executeQuery();
            while (rs.next()) {
                mGrupoUsuarioPrivilegio mgup = new mGrupoUsuarioPrivilegio();
                mgup.setCrear(rs.getInt("Crear"));
                mgup.setEliminar(rs.getInt("Eliminar"));
                mgup.setModificar(rs.getInt("Modificar"));
                mgup.setVer(rs.getInt("Ver"));
                mgup.setIdgrupousuario(rs.getString("idgrupousuario"));
                mgup.setIdformulario(rs.getString("IdFormulario"));
                lmgup.add(mgup);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lmgup;
    }

    public void grabarGrupos(mGrupoUsuario gu, List<mGrupoUsuarioPrivilegio> lgup) throws Exception {
        try {

            String resultado = "";
            List<mGrupoUsuario> l = new ArrayList<mGrupoUsuario>();
            l.add(gu);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("grupousuario", mGrupoUsuario.class);
            String xml = xstream.toXML(l);
            xstream = new XStream(new DomDriver());
            xstream.alias("grupousuariopriv", mGrupoUsuarioPrivilegio.class);
            String xmlGrupoUsuarioPriv = xstream.toXML(lgup);
            String sql = "SP_GrupoUsuarioGrabae";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, gu.getIdgrupousuario());
            cl.setString(2, xml);
            cl.setString(3, xmlGrupoUsuarioPriv);
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
