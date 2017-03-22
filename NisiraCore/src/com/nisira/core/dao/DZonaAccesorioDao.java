/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DZonaAccesorio;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aburgos
 */
public class DZonaAccesorioDao  extends EntityDao<DZonaAccesorio> {

    @Override
    public DZonaAccesorio find(DZonaAccesorio e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaAccesorio> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DZonaAccesorio> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<DZonaAccesorio> findAll(Object e1,Object e2,Object e3) throws Exception {
        DZonaAccesorio oDZonaAccesorio = null;
        List<DZonaAccesorio> listaZona=new ArrayList<DZonaAccesorio>();
        try {
            String sql = "SP_DZONAACCESORIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDZONA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaAccesorio = new DZonaAccesorio();
                oDZonaAccesorio.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaAccesorio.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaAccesorio.setIDZONA(rs.getInt("IDZONA"));
                oDZonaAccesorio.setIDACCESORIO(rs.getInt("IDACCESORIO"));
                oDZonaAccesorio.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDZonaAccesorio.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaAccesorio.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaAccesorio.setESTADO(rs.getBoolean("ESTADO"));
                oDZonaAccesorio.setIDTIPOACCESORIO(rs.getInt("IDTIPOACCESORIO"));
                listaZona.add(oDZonaAccesorio);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }public List<DZonaAccesorio> findAllTipoContainer(Object e1,Object e2,Object e3) throws Exception {
        DZonaAccesorio oDZonaAccesorio = null;
        List<DZonaAccesorio> listaZona=new ArrayList<DZonaAccesorio>();
        try {
            String sql = "SP_DZONAACCESORIO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setInt(1,7);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDSUCURSAL++*/
            cl.setString(5,e3.toString());/*++IDZONA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaAccesorio = new DZonaAccesorio();
                oDZonaAccesorio.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaAccesorio.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaAccesorio.setIDZONA(rs.getInt("IDZONA"));
                oDZonaAccesorio.setIDACCESORIO(rs.getInt("IDACCESORIO"));
                oDZonaAccesorio.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDZonaAccesorio.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaAccesorio.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaAccesorio.setESTADO(rs.getBoolean("ESTADO"));
                oDZonaAccesorio.setIDTIPOACCESORIO(rs.getInt("IDTIPOACCESORIO"));
                listaZona.add(oDZonaAccesorio);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }
    public String addZona(DZonaAccesorio oDZonaAccesorio) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(oDZonaAccesorio!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAACCESORIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setInt(i++,oDZonaAccesorio.getIDEMPRESA());
                cl.setInt(i++,oDZonaAccesorio.getIDSUCURSAL());
                cl.setInt(i++,oDZonaAccesorio.getIDZONA());
                cl.setInt(i++,oDZonaAccesorio.getIDACCESORIO());
                cl.setString(i++,oDZonaAccesorio.getDESCRIPCION());
                cl.setString(i++,oDZonaAccesorio.getIDUBICACION());
                cl.setString(i++,oDZonaAccesorio.getFECHACREACION());
                cl.setBoolean(i++,oDZonaAccesorio.isESTADO());
                cl.setInt(i++,oDZonaAccesorio.getIDTIPOACCESORIO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("IDZONA"));                
                }
            }
        return resultado;
    }
    public String addXmlZona(String idempresa,String idsucursal,String idaccesorio,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DZONAACCESORIO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);
                cl.setString(i++,idsucursal);
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        }
        catch (Exception e)
        {
            resultado = e.toString();
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    
    public List<DZonaAccesorio> sincronizarDZonaAccesorio(Object ide,Object ids,Object desde,Object hasta) throws Exception {
        DZonaAccesorio oDZonaAccesorio = null;
        List<DZonaAccesorio> listaZona=new ArrayList<DZonaAccesorio>();
        try {
            String sql = "SP_DZONAACCESORIO_Sync";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1, Integer.parseInt(ide.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setInt(2, Integer.parseInt(ids.toString()));/*GETRECORD ALMACEN(5)*/
            cl.setString(3,desde.toString().replace("-", "").trim());/*++HASTA++*/
            cl.setString(4,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDZonaAccesorio = new DZonaAccesorio();
                oDZonaAccesorio.setIDEMPRESA(rs.getInt("IDEMPRESA"));
                oDZonaAccesorio.setIDSUCURSAL(rs.getInt("IDSUCURSAL"));
                oDZonaAccesorio.setIDZONA(rs.getInt("IDZONA"));
                oDZonaAccesorio.setIDACCESORIO(rs.getInt("IDACCESORIO"));
                oDZonaAccesorio.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDZonaAccesorio.setIDUBICACION(rs.getString("IDUBICACION"));
                oDZonaAccesorio.setFECHACREACION(rs.getString("FECHACREACION"));
                oDZonaAccesorio.setESTADO(rs.getBoolean("ESTADO"));
                oDZonaAccesorio.setSINCRONIZA(rs.getInt("SINCRONIZA"));
                oDZonaAccesorio.setIDTIPOACCESORIO(rs.getInt("IDTIPOACCESORIO"));
                listaZona.add(oDZonaAccesorio);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaZona;
    }
}
