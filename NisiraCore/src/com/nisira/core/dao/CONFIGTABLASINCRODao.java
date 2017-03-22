/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.CONFIGTABLASINCRO;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class CONFIGTABLASINCRODao extends EntityDao<CONFIGTABLASINCRO> {

    @Override
    public CONFIGTABLASINCRO find(CONFIGTABLASINCRO e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CONFIGTABLASINCRO> findAll(Object e) throws Exception {
        List<CONFIGTABLASINCRO> l = new ArrayList<CONFIGTABLASINCRO>();
        try {
            String sql = "SP_CONFIGTABLASINCRO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1,e);
            rs = cl.executeQuery();
            while (rs.next()) {
                CONFIGTABLASINCRO c = new CONFIGTABLASINCRO();
                c.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                c.setIDTABLASINCRO(rs.getInt("IDTABLASINCRO"));
                c.setTABLA(rs.getString("TABLA"));
                c.setTIPOSINCRO(rs.getInt("TIPOSINCRO"));
                c.setUPDOWN(rs.getInt("UPDOWN"));
                c.setFECHACREACION(rs.getString("FECHACREACION"));
                c.setESTADO(rs.getInt("ESTADO"));
                l.add(c);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<CONFIGTABLASINCRO> findAll() throws Exception {
        List<CONFIGTABLASINCRO> l = new ArrayList<CONFIGTABLASINCRO>();
        try {
            String sql = "SP_TABLAS_DISP";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                CONFIGTABLASINCRO c = new CONFIGTABLASINCRO();
                c.setIDTABLASINCRO(rs.getInt("ID"));
                c.setTABLA(rs.getString("TABLA"));
                l.add(c);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public void grabar(List<CONFIGTABLASINCRO> lda,Object idempresa) throws Exception{
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(CONFIGTABLASINCRO.class);
        xmlNot = xml + xStream.toXML(lda);
        String id = "";
        try {
            String sql = "SP_CONFIGTABLASINCRO_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, idempresa);
            cl.setObject(2, xmlNot);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
