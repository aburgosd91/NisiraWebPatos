/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DprogAlmMontacarga;
import com.nisira.core.entity.DprogAlmPrioridad;
import com.nisira.core.entity.ProgramaAlm;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ProgramaAlmDao extends EntityDao<ProgramaAlm> {

    @Override
    public ProgramaAlm find(ProgramaAlm e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramaAlm> findAll(Object e) throws Exception {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramaAlm> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<ProgramaAlm> findAllEmpSuc(int idem) throws Exception{
         List<ProgramaAlm> listaProg = new ArrayList<ProgramaAlm>();
        try {
            String sql = "SP_ProgAlm_Mostrr";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setInt(1, idem);/*GETRECORD ALMACEN(5)*/
            rs = cl.executeQuery();
            while (rs.next()) {
                ProgramaAlm pa = new ProgramaAlm();
                pa.setIdempresa(rs.getInt("IDEMPRESA"));
                pa.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                pa.setIdsucursal(rs.getInt("IDSUCURSAL"));
                pa.setIdtipoalmacen(rs.getInt("IDTIPOALMACEN"));
                pa.setIddocumento(rs.getString("IDDOCUMENTO"));
                pa.setSerie(rs.getString("SERIE"));
                pa.setNumero(rs.getString("NUMERO"));
                pa.setIdestado(rs.getString("IDESTADO"));
                pa.setIdresponsable(rs.getInt("IDRESPONSABLE"));
                pa.setFechaprogramacion(rs.getTimestamp("FECHAPROGRAMACION"));
                pa.setFechaejecucion(rs.getTimestamp("FECHAEJECUCION"));
                pa.setFechafinalizacion(rs.getTimestamp("FECHAFINALIZACION"));
                pa.setVentana(rs.getString("VENTANA"));
                listaProg.add(pa);

            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return listaProg;
    }
    public void insertaProgamaAlmacen(ProgramaAlm progalm,List<DprogAlmMontacarga> dpm, List<DprogAlmPrioridad> dprio) throws Exception {
        List<ProgramaAlm> l = new ArrayList<ProgramaAlm>();
        l.add(progalm);

        XStream xstream = new XStream(new DomDriver());

        xstream.alias("programalm", ProgramaAlm.class);

        String xml = xstream.toXML(l);
        
        xstream = new XStream(new DomDriver());
        xstream.alias("dprogalmmont", DprogAlmMontacarga.class);
        String xmlpm = xstream.toXML(dpm);
        
        xstream = new XStream(new DomDriver());
        xstream.alias("dprogalmprio", DprogAlmPrioridad.class);
        String xmldp = xstream.toXML(dprio);
        try {
            String sql = "SP_ProgAlm_Grabar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setObject(1, progalm.getIdempresa());
            cl.setObject(2, progalm.getIdprogramaalm());
            cl.setObject(3, xml);
            cl.setObject(4, xmlpm);
            cl.setObject(5, xmldp);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
    public List<ProgramaAlm> syncProgalm(Object ide,Object ids,Object desde,Object hasta) throws Exception{
         List<ProgramaAlm> listaProg = new ArrayList<ProgramaAlm>();
        try {
            String sql = "SP_ProgAlm_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                ProgramaAlm pa = new ProgramaAlm();
                pa.setIdempresa(rs.getInt("IDEMPRESA"));
                pa.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                pa.setIdsucursal(rs.getInt("IDSUCURSAL"));
                pa.setIdtipoalmacen(rs.getInt("IDTIPOALMACEN"));
                pa.setIddocumento(rs.getString("IDDOCUMENTO"));
                pa.setSerie(rs.getString("SERIE"));
                pa.setNumero(rs.getString("NUMERO"));
                pa.setIdestado(rs.getString("IDESTADO"));
                pa.setIdresponsable(rs.getInt("IDRESPONSABLE"));
                pa.setFechaprogramacion(rs.getTimestamp("FECHAPROGRAMACION"));
                pa.setFechaejecucion(rs.getTimestamp("FECHAEJECUCION"));
                pa.setFechafinalizacion(rs.getTimestamp("FECHAFINALIZACION"));
                pa.setVentana(rs.getString("VENTANA"));
                pa.setFechacreacion(rs.getString("FECHACREACION"));
                listaProg.add(pa);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return listaProg;        
    }
}
