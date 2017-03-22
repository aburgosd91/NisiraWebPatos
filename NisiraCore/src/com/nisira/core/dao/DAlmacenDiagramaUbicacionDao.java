/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DAlmacenDiagrama;
import com.nisira.core.entity.DAlmacenDiagramaUbicacion;
import com.nisira.core.entity.DZonaDiagramaUbicacion;
import com.nisira.core.entity.Leyenda;
import com.nisira.core.entity.ZonaAlmacen;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azamora
 */
public class DAlmacenDiagramaUbicacionDao extends EntityDao<DAlmacenDiagramaUbicacion>{
    @Override
    public DAlmacenDiagramaUbicacion find(DAlmacenDiagramaUbicacion e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacenDiagramaUbicacion> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DAlmacenDiagramaUbicacion> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DAlmacenDiagramaUbicacion> sincronizarDAlmacenDiagramaUbicacion(Object e1,Object e2) throws Exception {
        DAlmacenDiagramaUbicacion oDAlmacenDiagramaUbicacion = null;
        List<DAlmacenDiagramaUbicacion> listaDZonaDiagramaUbicacion=new ArrayList<DAlmacenDiagramaUbicacion>();
        try {
            String sql = "SP_DALMACENDIAGRAMAUBICACIONUBICACION";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDAlmacenDiagramaUbicacion = new DAlmacenDiagramaUbicacion();
                oDAlmacenDiagramaUbicacion.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDAlmacenDiagramaUbicacion.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDAlmacenDiagramaUbicacion.setIDALMACEN(rs.getInt("IDALMACEN"));
                oDAlmacenDiagramaUbicacion.setCORDENADAX(rs.getInt("CORDENADAX"));
                oDAlmacenDiagramaUbicacion.setCORDENADAY(rs.getInt("CORDENADAY"));
                oDAlmacenDiagramaUbicacion.setFECHACREACION(rs.getString("FECHACREACION"));
                oDAlmacenDiagramaUbicacion.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                listaDZonaDiagramaUbicacion.add(oDAlmacenDiagramaUbicacion);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDZonaDiagramaUbicacion;
    }

    
    
    
    
}
