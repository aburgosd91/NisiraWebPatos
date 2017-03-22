/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.CONFINICIO;
import com.nisira.core.util.Encryption;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class CONFINICIODao extends EntityDao<CONFINICIO> {

    @Override
    public CONFINICIO find(CONFINICIO e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CONFINICIO> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CONFINICIO> findAll() throws Exception {
        ArrayList<CONFINICIO> l = new ArrayList<CONFINICIO>();
        try {
            String sql = "SP_CONFINICIO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                CONFINICIO c = new CONFINICIO();
                c.setIDEMPRESA(rs.getString("IDEMPRESA"));
                c.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                c.setIDCONFIG(rs.getInt("IDCONFIG"));
                c.setGESTOR(rs.getString("GESTOR"));
                c.setSERVIDOR(rs.getString("SERVIDOR"));
                c.setINSTANCIA(rs.getString("INSTANCIA"));
                c.setUSUARIO(Encryption.decrypt(rs.getString("USUARIO")));
                c.setCLAVE(Encryption.decrypt(rs.getString("CLAVE")));
                c.setBASEDATOS(rs.getString("BASEDATOS"));
                c.setURL(rs.getString("URL"));
                c.setRUTPRO(rs.getString("RUTPRO"));
                c.setPARAMINI(rs.getString("PARAMINI"));
                c.setPARAMFIN(rs.getString("PARAMFIN"));
                c.setPARAMERRINI(rs.getString("PARAMERRINI"));
                c.setPARAMERRFIN(rs.getString("PARAMERRFIN"));
                c.setTIPO(rs.getString("TIPO"));
                c.setIDMONTACARGA(rs.getString("IDMONTACARGA"));
                c.setPUERTOCM(rs.getString("PUERTOCM"));
                c.setMAC(rs.getString("MAC"));
                c.setFECHACREACION(rs.getString("FECHACREACION"));
                c.setDESCRIPCION(rs.getString("DESCRIPCION"));
                l.add(c);
            }
        } catch (Exception e) {

        } finally {
            cerrar(cn, cl, rs);
        }

        return l;
    }

    public void grabar(CONFINICIO conf) throws Exception {
        List<CONFINICIO> l = new ArrayList<CONFINICIO>();
        l.add(conf);
        String resultado = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(CONFINICIO.class);
        String xmlNot = xml + xStream.toXML(l);
        try {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_CONFINI_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.valueOf(conf.getIDEMPRESA()));
            cl.setInt(2, Integer.valueOf(conf.getIDSUCURSAL()));
            cl.setInt(3, conf.getIDCONFIG());
            cl.setString(4, xmlNot);//IDSUCURSAL
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
