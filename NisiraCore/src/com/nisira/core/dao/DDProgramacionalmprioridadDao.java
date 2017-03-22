/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDProgramacionalmprioridad;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DDProgramacionalmprioridadDao extends EntityDao<DDProgramacionalmprioridad> {

    @Override
    public DDProgramacionalmprioridad find(DDProgramacionalmprioridad e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDProgramacionalmprioridad> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DDProgramacionalmprioridad> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertDDprog(List<DDProgramacionalmprioridad> list) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("ddprogramacionalmprioridad", DDProgramacionalmprioridad.class);
        String xml = xstream.toXML(list);
        try {
            String sql = "SP_DDPROGRAMACIONALMPRIORIDAD";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1,xml);
            cl.executeUpdate();
        }finally {
            cerrar(cn, cl, rs);
        }
    }
    public List<DDProgramacionalmprioridad> syncDDprog(Object ide,Object ids,Object desde,Object hasta) throws Exception{
        List<DDProgramacionalmprioridad> listaProg = new ArrayList<DDProgramacionalmprioridad>();
        try {
            String sql = "SP_DDPROGRAMACIONALMPRIORIDAD_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                DDProgramacionalmprioridad dpaj = new DDProgramacionalmprioridad();
                dpaj.setIdempresa(rs.getInt("IDEMPRESA"));
                dpaj.setIdsucursal(rs.getInt("IDSUCURSAL"));
                dpaj.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpaj.setIdalmacen(rs.getInt("IDALMACEN"));
                dpaj.setPrioridadalmacen(rs.getInt("PRIORIDADALMACEN"));
                dpaj.setPrioridadrack(rs.getInt("PRIORIDADRACK"));
                dpaj.setIdnformacionubicacion(rs.getString("IDNFORMACIONUBICACION"));
                dpaj.setIdrack(rs.getInt("IDRACK"));
                dpaj.setIddistribucionpiso(rs.getInt("IDDISTRIBUCIONPISO"));
                dpaj.setFechacreacion(rs.getString("FECHACREACION"));
                listaProg.add(dpaj);
            }
        }finally {
            cerrar(cn, cl, rs);
        }
        return listaProg;   
    }
}
