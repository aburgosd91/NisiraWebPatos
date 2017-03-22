/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dantena;
import com.nisira.core.entity.Dpuertocom;
import com.nisira.core.entity.Equipo;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.Puertocom;
import com.nisira.core.entity.Rfidreader;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class RfidreaderDao extends EntityDao<Rfidreader> {

    @Override
    public Rfidreader find(Rfidreader e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rfidreader> findAll(Object e) throws Exception {
        List<Rfidreader> l = new ArrayList<Rfidreader>();
        try {
            String sql = "SP_RFIDREADER_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                Rfidreader a = new Rfidreader();
                a.setIdempresa(rs.getInt("IDEMPRESA"));
                a.setIdequiporeader(rs.getInt("IDEQUIPOREADER"));
                a.setIdcpumovil(rs.getInt("IDCPUMOVIL"));
                a.setNroserie(rs.getString("NROSERIE"));
                a.setObservacion(rs.getString("OBSERVACION"));
                a.setEstado(rs.getInt("ESTADO"));
                a.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                l.add(a);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Rfidreader> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void grabar(Rfidreader rfid, List<Dpuertocom> ldport, List<Dantena> ldant) throws Exception {
        List<Rfidreader> ln = new ArrayList<Rfidreader>();
        String resultado;
        ln.add(rfid);
        String xmlRFID = "";
        String xmlDPORT = "";
        String xmlDANT = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        
        XStream xStream = new XStream();
        xStream.processAnnotations(Rfidreader.class);
        xmlRFID = xml + xStream.toXML(ln);
        
        xStream = new XStream();
        xStream.processAnnotations(Dpuertocom.class);
        xmlDPORT = xml + xStream.toXML(ldport);
        
        xStream = new XStream();
        xStream.processAnnotations(Dantena.class);
        xmlDANT = xml + xStream.toXML(ldant);
        String sql = "SP_REFIDREADER_GRABAR";
        cn = obtenerConexionJTDS();
        cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
        cl.setInt(1,rfid.getIdempresa()) ;
        cl.setInt(2, rfid.getIdequiporeader());
        cl.setString(3, xmlRFID);
        cl.setString(4, xmlDPORT);
        cl.setString(5, xmlDANT);

        rs = cl.executeQuery();
        while (rs.next()) {
            resultado = (rs.getString("mensaje"));
        }
    }
    public List<Dantena> findDAntenas(Object ide,Object idre) throws Exception{
        List<Dantena> l = new ArrayList<Dantena>();
        try {
            String sql = "SP_DANTENA_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, idre);
            rs = cl.executeQuery();
            while (rs.next()) {
                Dantena p = new Dantena();
                p.setIdempresa(rs.getInt("IDEMPRESA"));
                p.setIdequiporeader(rs.getInt("IDEQUIPOREADER"));
                p.setIdequipoantena(rs.getInt("IDANTENA"));
                p.setOrden(rs.getInt("ORDEN"));
                p.setActivo(rs.getInt("ACTIVO"));
                p.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                p.setDescripcion(rs.getString("DESCRIPCION"));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public  List<Dpuertocom> findDpuertos(Object ide,Object idre) throws Exception{
        List<Dpuertocom> l = new ArrayList<Dpuertocom>();
        try {
            String sql = "SP_DPUERTO_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, ide);
            cl.setObject(2, idre);
            rs = cl.executeQuery();
            while (rs.next()) {
                Dpuertocom p = new Dpuertocom();
                p.setIdempresa(rs.getInt("IDEMPRESA"));
                p.setIdequiporeader(rs.getInt("IDEQUIPOREADER"));
                p.setIdpuertocom(rs.getInt("IDPUERTOCOM"));
                p.setOrden(rs.getInt("ORDEN"));
                p.setActivo(rs.getInt("ACTIVO"));
                p.setFechacreacion(rs.getTimestamp("FECHACREACION"));
                p.setDescripcion(rs.getString("DESCRIPCION"));
                
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
}
