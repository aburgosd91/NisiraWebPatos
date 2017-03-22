/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DDProgramacionalmprioridad;
import com.nisira.core.entity.DprogAlmPrioridad;
import com.nisira.framework.core.dao.EntityDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DprogAlmPrioridadDao extends EntityDao<DprogAlmPrioridad>{

    @Override
    public DprogAlmPrioridad find(DprogAlmPrioridad e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogAlmPrioridad> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DprogAlmPrioridad> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DprogAlmPrioridad> findDProgPrio(int idem, int idprogalm,int idsucur) throws SQLException, Exception{
        List<DprogAlmPrioridad> list = new ArrayList<DprogAlmPrioridad>();
        try {
            String sql = "SP_DProgAlmPrio_Mostrar";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1, idem);/*GETRECORD ALMACEN(5)*/
            cl.setInt(2,idprogalm);
            cl.setInt(3, idsucur);
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogAlmPrioridad dpm = new DprogAlmPrioridad();
                dpm.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpm.setIdsucursal(rs.getInt("IDSUCURSAL"));
                dpm.setIdalmacen(rs.getInt("IDALMACEN"));
                dpm.setIdrack(rs.getInt("IDRACK"));
                dpm.setIdempresa(rs.getInt("IDEMPRESA"));
                dpm.setIdregla(rs.getInt("IDREGLA"));
                dpm.setPrioridadalmacen(rs.getInt("PRIORIDADALMACEN"));
                dpm.setPrioridadrack(rs.getInt("PRIORIDADRACK"));
                dpm.setEstado(rs.getInt("ESTADO"));
                dpm.setSincroniza(rs.getInt("SINCRONIZA"));
                DDProgramacionalmprioridad ddp = null;
                Integer idemp = (Integer) rs.getObject("DIDEMPRESA");
                if(idemp!=null){
                    ddp = new DDProgramacionalmprioridad();
                    ddp.setIdempresa(rs.getInt("DIDEMPRESA"));
                    ddp.setIdsucursal(rs.getInt("DIDSUCURSAL"));
                    ddp.setIdprogramaalm(rs.getInt("DIDPROGRAMAALM"));
                    ddp.setIdalmacen(rs.getInt("DIDALMACEN"));
                    ddp.setIdrack(rs.getInt("DIDRACK"));
                    ddp.setIdnformacionubicacion(rs.getString("DIDNFORMACIONUBICACION"));
                    ddp.setIdregla(rs.getInt("DIDREGLA"));
                    ddp.setIddistribucionpiso(rs.getInt("DIDDISTRIBUCIONPISO"));
                    dpm.setDetalle(true);
                }else{
                    dpm.setDetalle(false);
                }
                dpm.setFubicacion(ddp);
                list.add(dpm);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return list;
    }
     public List<DprogAlmPrioridad> syncDprogAlmPrio(Object ide,Object ids,Object desde,Object hasta) throws Exception{
         List<DprogAlmPrioridad> list = new ArrayList<DprogAlmPrioridad>();
        try {
            String sql = "SP_DProgAlmPrio_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2,Integer.parseInt(ids.toString()));
            cl.setString(3, desde.toString().replace("-", "").trim());
            cl.setString(4, hasta.toString().replace("-", "").trim());
            rs = cl.executeQuery();
            while (rs.next()) {
                DprogAlmPrioridad dpm = new DprogAlmPrioridad();
                dpm.setIdprogramaalm(rs.getInt("IDPROGRAMAALM"));
                dpm.setIdsucursal(rs.getInt("IDSUCURSAL"));
                dpm.setIdalmacen(rs.getInt("IDALMACEN"));
                dpm.setIdrack(rs.getInt("IDRACK"));
                dpm.setIdempresa(rs.getInt("IDEMPRESA"));
                dpm.setIdregla(rs.getInt("IDREGLA"));
                dpm.setPrioridadalmacen(rs.getInt("PRIORIDADALMACEN"));
                dpm.setPrioridadrack(rs.getInt("PRIORIDADRACK"));                
                dpm.setEstado(rs.getInt("ESTADO"));
                dpm.setSincroniza(rs.getInt("SINCRONIZA"));
                dpm.setFechacreacion(rs.getString("FECHACREACION"));
                list.add(dpm);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return list;
     }
}
