/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.entity.Sucursal;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class SucursalDao extends EntityDao<Sucursal> {
    /*TIPOS DE CONSULTA A PROCEDURE SP_SUCURSAL
        - INSERT(1)
        - UPDATE(2)
        - DELETE(3)->inactivo
        - SELECT-TOTAL(4)
        - SELECT-EMPRESA(5)
        - FILTRO ->EMPRESA<DESCRIPCION,DIRECCION>(6)
    */
    @Override
    public Sucursal find(Sucursal e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Sucursal> findAll(Object e) throws Exception {
        Sucursal oSucursal = null;
        List<Sucursal> listaSucursal=new ArrayList<Sucursal>();
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?)}");
            cl.setInt(1,5);/*GETRECORD SUCURSAL(5)*/
            cl.setString(2,"");
            cl.setString(3,e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
                listaSucursal.add(oSucursal);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaSucursal;
    }
    @Override
    public List<Sucursal> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String addSucursal(Sucursal sucursal) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(sucursal!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_SUCURSAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,"");
                cl.setString(i++,sucursal.getIDEMPRESA());
                cl.setString(i++,sucursal.getIDSUCURSAL());
                cl.setString(i++,sucursal.getDISTRIBUIR());
                cl.setString(i++,sucursal.getE_MAIL());
                cl.setString(i++,sucursal.getDIRECCION());
                cl.setString(i++,sucursal.getDESCRIPCION());
                cl.setInt(i++,Integer.parseInt((sucursal.isESTADO()?"1":"0")));
                cl.setString(i++,sucursal.getSINCRONIZA());
                cl.setString(i++,sucursal.getFECHACREACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String editSucursal(Sucursal sucursal) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(sucursal!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_SUCURSAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,"");
                cl.setString(i++,sucursal.getIDEMPRESA());
                cl.setString(i++,sucursal.getIDSUCURSAL());
                cl.setString(i++,sucursal.getDISTRIBUIR());
                cl.setString(i++,sucursal.getE_MAIL());
                cl.setString(i++,sucursal.getDIRECCION());
                cl.setString(i++,sucursal.getDESCRIPCION());
                cl.setInt(i++,Integer.parseInt((sucursal.isESTADO()?"1":"0")));
                cl.setString(i++,sucursal.getSINCRONIZA());
                cl.setString(i++,sucursal.getFECHACREACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteSucursal(Sucursal sucursal) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(sucursal!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_SUCURSAL";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,"");
                cl.setString(i++,sucursal.getIDEMPRESA());
                cl.setString(i++,sucursal.getIDSUCURSAL());
                cl.setString(i++,sucursal.getDISTRIBUIR());
                cl.setString(i++,sucursal.getE_MAIL());
                cl.setString(i++,sucursal.getDIRECCION());
                cl.setString(i++,sucursal.getDESCRIPCION());
                cl.setInt(i++,Integer.parseInt((sucursal.isESTADO()==true?"1":"0")));
                cl.setString(i++,sucursal.getSINCRONIZA());
                cl.setString(i++,sucursal.getFECHACREACION());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempSucursalXML(String xml) throws Exception{
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SINCR_TEMP_PALETA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setString(1,"");
                cl.setString(2,"");
                cl.setString(3,xml);/*XML*/
                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);
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
    public List<Sucursal> findAllActivo(Object e) throws Exception {
        Sucursal oSucursal = null;
        List<Sucursal> listaSucursal=new ArrayList<Sucursal>();
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,7);/*GETRECORD SUCURSAL(5)*/
            cl.setString(2,"");
            cl.setString(3,e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
                listaSucursal.add(oSucursal);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaSucursal;
    }
    
    public Sucursal findById(String idempresa, String idsucursal) throws Exception {
        Sucursal oSucursal = null;
        
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,8);/*GETRECORD SUCURSAL(5)*/
            cl.setString(2,"");
            cl.setString(3,idempresa);
            cl.setString(4,idsucursal);
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return oSucursal;
    }
    public List<Sucursal> findByFiltro(String idempresa, String filtro) throws Exception {
        Sucursal oSucursal = null;
        List<Sucursal> listaSucursal=new ArrayList<Sucursal>();        
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?)}");
            cl.setInt(1,6);/*GETRECORD SUCURSAL(5)*/
            cl.setString(2,filtro);
            cl.setString(3,idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
                listaSucursal.add(oSucursal);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaSucursal;
    }
    
    public List<Sucursal> sincronizarSucursal(Object idempresa, Object desde,Object hasta) throws Exception {
        Sucursal oSucursal = null;
        List<Sucursal> listaSucursal=new ArrayList<Sucursal>();        
        try {
            String sql = "SP_SUCURSAL";
            cn = obtenerConexionJTDS();
            int i=1;
            cl = cn.prepareCall("{ CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++,9);/*GETRECORD SUCURSAL(5)*/
            cl.setString(i++,"");//query
            cl.setString(i++,idempresa.toString());//idempresa
            cl.setString(i++,"");//idsucursal
            cl.setString(i++,"");//distribucion
            cl.setString(i++,"");//email
            cl.setString(i++,"");//direccion
            cl.setString(i++,"");//descripcion
            cl.setString(i++,"");//estado
            cl.setString(i++,"");//sincroniza
            cl.setString(i++,"");//fechacreacion
            cl.setString(i++,desde.toString());//desde
            cl.setString(i++,hasta.toString());//hasta
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
                listaSucursal.add(oSucursal);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaSucursal;
    }
    public List<Sucursal> findbyEmpresa(String idempresa) throws Exception{
        Sucursal oSucursal = null;
        List<Sucursal> listaSucursal=new ArrayList<Sucursal>();        
        try {
            String sql = "SP_SUCURSAL_Empresa";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?)}");
            cl.setString(1,idempresa);/*GETRECORD SUCURSAL(5)*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oSucursal = new Sucursal();
                oSucursal.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oSucursal.setIDSUCURSAL(rs.getString("IDSUCURSAL"));
                oSucursal.setDISTRIBUIR(rs.getString("DISTRIBUIR"));
                oSucursal.setE_MAIL(rs.getString("E_MAIL"));
                oSucursal.setDIRECCION(rs.getString("DIRECCION"));
                oSucursal.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oSucursal.setESTADO(rs.getBoolean("ESTADO"));
                oSucursal.setSINCRONIZA(rs.getString("SINCRONIZA"));
                oSucursal.setFECHACREACION(rs.getString("FECHACREACION"));
                listaSucursal.add(oSucursal);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaSucursal;
    }
     public void anular(String idempresa, String id) throws Exception{
        try {
            String sql = "SP_SUCURSAL_DELETE";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, idempresa);
            cl.setObject(2, id);
            cl.executeUpdate();            
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
