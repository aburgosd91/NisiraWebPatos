/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.NumEmisor;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Zavala
 */
public class DocumentoDao extends EntityDao<Documento> {
   
    @Override
    public Documento find(Documento e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Documento> findAll(Object e) throws Exception {
        Documento oDocumento = null;
        List<Documento> listaDocumento=new ArrayList<Documento>();
        try {
            String sql = "SP_DOCUMENTO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?)}");
            cl.setInt(1,0);
            cl.setString(2,e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oDocumento = new Documento();
                oDocumento.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDocumento.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                oDocumento.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDocumento.setFECHACREACION(rs.getString("FECHACREACION"));
                oDocumento.setESTADO(rs.getInt("ESTADO"));
                oDocumento.setVENTANA(rs.getString("VENTANA"));
                oDocumento.setIDPROCESO(rs.getInt("IDPROCESO"));
                listaDocumento.add(oDocumento);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDocumento;
    }
    @Override
    public List<Documento> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String saveDocumento(Documento documento) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(documento!=null){
                String XMLDocumento = "";
                String XMLListaNumEmisor = "";
                
                List<NumEmisor> listanumemisor = new ArrayList<NumEmisor>();
                listanumemisor = documento.getListanumemisor();
                
                
                String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream = new XStream();
                xStream.processAnnotations(Documento.class);
                XMLDocumento = xml + xStream.toXML(documento);
                xStream.processAnnotations(NumEmisor.class);
                XMLListaNumEmisor = xml + xStream.toXML(listanumemisor);
                if (listanumemisor == null)
                {
                    XMLListaNumEmisor = null;
                }
                String sql = "SP_DOCUMENTO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
                cl.setInt(i++,1);
                cl.setString(i++,documento.getIDEMPRESA());
                cl.setString(i++,documento.getIDDOCUMENTO());
                cl.setString(i++,XMLDocumento);
                cl.setString(i++,XMLListaNumEmisor);
                
                
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String anularDocumento(Documento documento) throws Exception{
        String resultado = "";
        int i=1;
            if(documento!=null){
                String sql = "SP_DOCUMENTO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,2);
                cl.setString(i++,documento.getIDEMPRESA() );
                cl.setString(i++,documento.getIDDOCUMENTO());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteDocumento(Documento documento) throws Exception{
        String resultado = "";
        int i=1;
            if(documento!=null){
                String sql = "SP_DOCUMENTO";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setInt(i++,3);
                cl.setString(i++,documento.getIDEMPRESA() );
                cl.setString(i++,documento.getIDDOCUMENTO());
               
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String grabarRegistroTempDocumentoXML(String xml) throws Exception{
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
    public Documento findById(String idempresa, String iddocumento) throws Exception {
        Documento oDocumento = null;
        try {
            String sql = "SP_DOCUMENTO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,0);
            cl.setString(2,idempresa);
            cl.setString(3,iddocumento);
            rs = cl.executeQuery();
            while (rs.next()) {
                oDocumento = new Documento();
                oDocumento.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDocumento.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                oDocumento.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDocumento.setFECHACREACION(rs.getString("FECHACREACION"));
                oDocumento.setESTADO(rs.getInt("ESTADO"));
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return oDocumento;
    }
    
    public List<Documento> sincronizarDocumento(Object e) throws Exception {
        Documento oDocumento = null;
        List<Documento> listaDocumento=new ArrayList<Documento>();
        try {
            String sql = "SP_DOCUMENTO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{ CALL " + sql + "(?,?)}");
            cl.setInt(1,0);
            cl.setString(2,e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oDocumento = new Documento();
                oDocumento.setIDEMPRESA(rs.getString("IDEMPRESA"));
                oDocumento.setIDDOCUMENTO(rs.getString("IDDOCUMENTO"));
                oDocumento.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oDocumento.setFECHACREACION(rs.getString("FECHACREACION"));
                oDocumento.setESTADO(rs.getInt("ESTADO"));
                
                listaDocumento.add(oDocumento);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaDocumento;
    }
}
