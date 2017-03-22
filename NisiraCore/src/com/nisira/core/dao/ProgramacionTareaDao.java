/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DprogramacionTareaLlegada;
import com.nisira.core.entity.DprogramacionTareaPartida;
import com.nisira.core.entity.ProgramacionTarea;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class ProgramacionTareaDao extends EntityDao<ProgramacionTarea> {

    @Override
    public ProgramacionTarea find(ProgramacionTarea e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionTarea> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramacionTarea> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ProgramacionTarea> findAll(Object e, Object e2, Object e3) throws Exception {
        List<ProgramacionTarea> l = new ArrayList<ProgramacionTarea>();
        try {
            String sql = "SP_PROGRAMACIONTAREA_VER";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setObject(1, e);
            cl.setObject(2, e2);
            cl.setObject(3, e3);
            rs = cl.executeQuery();
            while (rs.next()) {
                ProgramacionTarea p = new ProgramacionTarea();
                p.setIdempresa(rs.getInt("IDEMPRESA"));
                p.setIdsucursal(rs.getInt("IDSUCURSAL"));
                p.setIdprogramaciontarea(rs.getString("IDPROGRAMACIONTAREA"));
                p.setIdproceso(rs.getInt("IDPROCESO"));
                p.setIddocumento("IDDOCUMENTO");
                p.setSerie(rs.getString("SERIE"));
                p.setNumero(rs.getString("NUMERO"));
                p.setTipotarea(rs.getInt("TIPOTAREA"));
                p.setGeneracion(rs.getInt("GENERACION"));
                p.setIDMONTACARGA(rs.getInt("IDMONTACARGA"));
                p.setObservacion(rs.getString("OBSERVACION"));
                p.setFechaprogramacion(rs.getTimestamp("FECHAPROGRAMACION"));
                p.setFechaejecucion(rs.getTimestamp("FECHAEJECUCION"));
                p.setFechafinalizacion(rs.getTimestamp("FECHAFINALIZACION"));
                p.setEstado(rs.getInt("ESTADO"));
                p.setUsrcreacion(rs.getString("USRCREACION"));
                l.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public String grabar(ProgramacionTarea p,List<DprogramacionTareaPartida> listPartida,
            List<DprogramacionTareaLlegada> listLlegada) throws Exception {
        List<ProgramacionTarea> ln = new ArrayList<ProgramacionTarea>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(ProgramacionTarea.class);
        xmlNot = xml + xStream.toXML(ln);
        String id = "";
        /*******************DETALLES PARTIDA->LLEGADA**********************/
        String xmlDProgramacionTareaPartida = "";
        xStream = new XStream();
        xStream.processAnnotations(DprogramacionTareaPartida.class);
        xmlDProgramacionTareaPartida = xml + xStream.toXML(listPartida);
        ///////////////////////////////////////////////////////////////////////
        String xmlDProgramacionTareaLlegada = "";
        xStream = new XStream();
        xStream.processAnnotations(DprogramacionTareaLlegada.class);
        xmlDProgramacionTareaLlegada = xml + xStream.toXML(listLlegada);
        /*********************************************************************/
        try {
            String sql = "SP_PROGRAMACIONTAREA_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?)}");
            cl.setObject(1, p.getIdempresa());
            cl.setObject(2, p.getIdsucursal());
            cl.setObject(3, p.getIdprogramaciontarea());
            cl.setObject(4, xmlNot);
            cl.setObject(5, xmlDProgramacionTareaPartida);
            cl.setObject(6, xmlDProgramacionTareaLlegada);
            rs = cl.executeQuery();
            while (rs.next()) {
                id = rs.getString("TABLA_ID");
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return id;
    }
    
    public List<Integer> recepProcesos(Object ide, Object ids) throws Exception{
        List<Integer> l = new ArrayList<Integer>();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select IDPROCESO from PROGRAMACIONTAREA where TIPOTAREA = 0 and IDEMPRESA = ? and IDSUCURSAL  = ? group by IDPROCESO");
            pr.setObject(1, ide);
            pr.setObject(2, ids);
            rs = pr.executeQuery();
            while (rs.next()) {
                Integer i = 0;
                i = rs.getInt("IDPROCESO");
                l.add(i);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        
        return l;
    }
}