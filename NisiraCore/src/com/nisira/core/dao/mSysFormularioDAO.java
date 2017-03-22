/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.mSysFormulario;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class mSysFormularioDAO extends EntityDao<mSysFormulario> {

    @Override
    public mSysFormulario find(mSysFormulario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mSysFormulario> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<mSysFormulario> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<mSysFormulario> findAllFrm() throws Exception {
        List<mSysFormulario> lfrm = new ArrayList<mSysFormulario>();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from SysFormulario (nolock)");
            rs = pr.executeQuery();
            while (rs.next()) {
                mSysFormulario form = new mSysFormulario();
                form.setIdformulario(rs.getString("IdFormulario"));
                form.setClase(rs.getString("Clase"));
                form.setClasedoc(rs.getString("ClaseDoc"));
                form.setDescripcion(rs.getString("Descripcion"));
                form.setEslista(rs.getInt("EsLista"));
                form.setImagen(rs.getString("Imagen"));
                form.setPaquete(rs.getString("Paquete"));
                form.setPaquetedoc(rs.getString("PaqueteDoc"));
                form.setOpcion(rs.getString("Opcion"));
                lfrm.add(form);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return lfrm;
    }

    public void grabarSysFrm(int tipo,mSysFormulario form) throws Exception {
        List<mSysFormulario> l = new ArrayList<mSysFormulario>();
        l.add(form);
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("nsysform", mSysFormulario.class);
        String xml = xstream.toXML(l);
        String sql = "SP_nSysFormulario";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
        cl.setInt(1, tipo);
        cl.setString(2, xml);
        cl.setString(3, form.getIdformulario());
        cl.executeUpdate();
    }
}
