/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DGeneracionCodigo;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class DGeneracionCodigoDao extends EntityDao<DGeneracionCodigo>{

    public String addDGeneracionCodigo(DGeneracionCodigo dGeneracionCodigo) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dGeneracionCodigo!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DGENERACION_CODIGOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,dGeneracionCodigo.getIDEMPRESA());
                cl.setString(i++,dGeneracionCodigo.getIDGENERACION());
                cl.setString(i++,dGeneracionCodigo.getIDREGISTROCODIGO());
                cl.setInt(i++,dGeneracionCodigo.getIDPARAMETRO());
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITO());
                
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITOTOTAL());
                cl.setInt(i++,dGeneracionCodigo.getSINCRONIZADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String addXmlDGeneracionCodigo(String idempresa,int idgeneracion,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DGENERACION_CODIGOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setString(i++,xml);/*XML*/
                cl.setString(i++,idempresa);/*IDEMPRESA*/
                cl.setInt(i++,idgeneracion);/*IDGENERACION*/
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
    public String editDGeneracionCodigo(DGeneracionCodigo dGeneracionCodigo) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dGeneracionCodigo!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DGENERACION_CODIGOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,dGeneracionCodigo.getIDEMPRESA());
                cl.setString(i++,dGeneracionCodigo.getIDGENERACION());
                cl.setString(i++,dGeneracionCodigo.getIDREGISTROCODIGO());
                cl.setInt(i++,dGeneracionCodigo.getIDPARAMETRO());
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITO());
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITOTOTAL());
                cl.setInt(i++,dGeneracionCodigo.getSINCRONIZADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDGeneracionCodigo(DGeneracionCodigo dGeneracionCodigo) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(dGeneracionCodigo!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_DGENERACION_CODIGOS";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,dGeneracionCodigo.getIDEMPRESA());
                cl.setString(i++,dGeneracionCodigo.getIDGENERACION());
                cl.setString(i++,dGeneracionCodigo.getIDREGISTROCODIGO());
                cl.setInt(i++,dGeneracionCodigo.getIDPARAMETRO());
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITO());
                cl.setInt(i++,dGeneracionCodigo.getNUMDIGITOTOTAL());
                cl.setInt(i++,dGeneracionCodigo.getSINCRONIZADO());
                
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public List<DGeneracionCodigo> findAll(Object e1,Object e2) throws Exception {
        DGeneracionCodigo oDGeneracionCodigo = null;
        List<DGeneracionCodigo> listaDGeneracionCodigo=new ArrayList<DGeneracionCodigo>();
        try {
            String sql = "SP_DGENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,4);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++IDGENERACION++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDGeneracionCodigo = new DGeneracionCodigo();
                oDGeneracionCodigo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDGeneracionCodigo.setIDGENERACION(rs.getString("IDGENERACION"));
                oDGeneracionCodigo.setIDREGISTROCODIGO(rs.getString("IDREGISTROCODIGO"));
                oDGeneracionCodigo.setIDPARAMETRO(rs.getInt("IDPARAMETRO"));
                oDGeneracionCodigo.setNUMDIGITO(rs.getInt("NUMDIGITO"));
                oDGeneracionCodigo.setNUMDIGITOTOTAL(rs.getInt("NUMDIGITOTOTAL"));
                oDGeneracionCodigo.setSINCRONIZADO(rs.getInt("SINCRONIZADO"));
                oDGeneracionCodigo.setPARAMETRO(rs.getString("PARAMETRO"));
                listaDGeneracionCodigo.add(oDGeneracionCodigo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDGeneracionCodigo;
    }

    @Override
    public DGeneracionCodigo find(DGeneracionCodigo e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<DGeneracionCodigo> SincDgencodigo(Object e,Object desde, Object hasta) throws Exception {
        DGeneracionCodigo oDGeneracionCodigo = null;
        List<DGeneracionCodigo> listaDGeneracionCodigo=new ArrayList<DGeneracionCodigo>();
        try {
            String sql = "SP_DGENERACION_CODIGOS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(1,6);/*GETRECORD ALMACEN(5)*/
            cl.setString(2,"");
            cl.setInt(3,Integer.valueOf(e.toString()));/*++IDEMRPESA++*/
            cl.setInt(4,0);/*++IDGENERACION++*/
            cl.setString(5,"");/*++IDREGISTROCODIGO++*/
            cl.setInt(6,0);/*++IDPARAMETRO++*/
            cl.setInt(7,0);/*++NUMDIGITO++*/
            cl.setInt(8,0);/*++NUMDIGITOTOTAL++*/
            cl.setInt(9,0);/*++SINCRONIZADO++*/
            cl.setString(10,"");/*++PARAMETRO++*/
            cl.setString(11,desde.toString().replace("-", "").trim());/*++DESDE++*/
            cl.setString(12,hasta.toString().replace("-", "").trim());/*++HASTA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oDGeneracionCodigo = new DGeneracionCodigo();
                oDGeneracionCodigo.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDGeneracionCodigo.setIDGENERACION(rs.getString("IDGENERACION"));
                oDGeneracionCodigo.setIDREGISTROCODIGO(rs.getString("IDREGISTROCODIGO"));
                oDGeneracionCodigo.setIDPARAMETRO(rs.getInt("IDPARAMETRO"));
                oDGeneracionCodigo.setNUMDIGITO(rs.getInt("NUMDIGITO"));
                oDGeneracionCodigo.setNUMDIGITOTOTAL(rs.getInt("NUMDIGITOTOTAL"));
                oDGeneracionCodigo.setSINCRONIZADO(rs.getInt("SINCRONIZADO"));
                oDGeneracionCodigo.setPARAMETRO(rs.getString("PARAMETRO"));
                oDGeneracionCodigo.setFECHACREACION(rs.getString("FECHACREACION"));
                oDGeneracionCodigo.setTIPOVALOR(rs.getInt("TIPOVALOR"));
                listaDGeneracionCodigo.add(oDGeneracionCodigo);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDGeneracionCodigo;
    }

    @Override
    public List<DGeneracionCodigo> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DGeneracionCodigo> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
