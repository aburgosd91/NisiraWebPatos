/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dpaleta;
import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Paleta;
import java.util.ArrayList;
import java.util.List;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;
import com.nisira.core.entity.Privilegios;
import static com.nisira.core.util.CoreUtil.consulta;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author Antenor
 */
public class PaletaDao extends EntityDao<Paleta> {

    @Override
    public Paleta find(Paleta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Paleta> findAll() throws Exception {
        List<Paleta> lp = new ArrayList<Paleta>();
        try {
            String sql ="Select_RecPale";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}" );
           // cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while(rs.next()){
                Paleta p = new Paleta();
                p.setIdempresa(rs.getString("IDEMPRESA"));
                p.setIdregistropaleta(rs.getString("IDREGISTROPALETA"));
                p.setNropaleta(rs.getString("NROPALETA"));
                p.setIdoperacion(rs.getString("IDOPERACION"));
                p.setNumoperacion(rs.getString("NUMOPERACION"));
                p.setIddocumento(rs.getString("IDDOCUMENTO"));
                p.setFecha((rs.getString("FECHA")));
                p.setIdclieprov(rs.getString("IDCLIEPROV"));
                p.setIdsucursal(rs.getString("IDSUCURSAL"));
                p.setIdalmacen(rs.getString("IDALMACEN"));
                p.setIdembalaje(rs.getString("IDEMBALAJE"));
                p.setIdcultivo(rs.getString("IDCULTIVO"));
                p.setIdvariedad(rs.getString("IDVARIEDAD"));
                p.setCantidad(rs.getString("CANTIDAD"));
                p.setCerrado(rs.getString("CERRADO"));
                lp.add(p);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return lp;

    }

    @Override
    public Paleta update(Paleta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Paleta> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean valiPale(Paleta pale) throws Exception{
        boolean res = false;
        try{
            String sql ="valiRegPale";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}" );
            cl.setString(1, pale.getIdempresa());
            cl.setString(2, pale.getIdregistropaleta());
            cl.setString(3, pale.getSerie());
            cl.setString(4, pale.getNumero());
           // cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while(rs.next()){
                res=true;
            }
        }catch (Exception e) {
            String mensaje = e.toString();

        } finally {
            cerrar(cn, cl, rs);
        }
        return res;
    }
    public boolean valiDPale(Dpaleta dpale) throws Exception{
        boolean res = false;
        try{
            String sql ="valiDRegPale";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}" );
           // cl.setString(1, e.toString());
            cl.setInt(1, dpale.getIdempresa());
            cl.setString(2, dpale.getIdregistropaleta());
            cl.setString(3, dpale.getItem());
            rs = cl.executeQuery();
            while(rs.next()){
                res=true;
            }
        }catch (Exception e) {
            String mensaje = e.toString();

        } finally {
            cerrar(cn, cl, rs);
        }
        return res;
    }
    public Paleta findByNroPaleta(String idempresa, String nropaleta) throws Exception {
        Paleta oPaleta = null;
        try {
            String sql = "GETRECORD_RETURNSALDO_PALETA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, idempresa);
            cl.setString(2, nropaleta);
            cl.setString(3, "");

            rs = cl.executeQuery();
            while (rs.next()) {
                oPaleta = new Paleta();
                oPaleta.setIdempresa(idempresa);
                oPaleta.setIdregistropaleta(rs.getString("IDREFERENCIA"));
                oPaleta.setIdproducto(rs.getString("IDPRODUCTO"));
                oPaleta.setDescproducto(rs.getString("DESCRIPCION"));
                oPaleta.setIdmedida(rs.getString("IDMEDIDA"));
                oPaleta.setCantidad(rs.getString("CANTIDAD"));
                oPaleta.setPeso(rs.getDouble("PESO"));
                oPaleta.setNropaleta(rs.getString("NROPALETA"));
                oPaleta.setIdlotep(rs.getString("IDLOTEP"));
                oPaleta.setIdcliente(rs.getString("IDCLIENTE"));
                oPaleta.setIdclieprov(rs.getString("IDCLIEPROV_CLI"));
                oPaleta.setIdenvase(rs.getString("IDENVASE"));
                oPaleta.setDescenvase(rs.getString("DESC_ENVASE"));
                oPaleta.setCerrado(rs.getString("CERRADO"));
                oPaleta.setNromanual(rs.getString("NROMANUAL"));
            }
        } catch (Exception e) {
            String mensaje = e.toString();

        } finally {
            cerrar(cn, cl, rs);
        }

        return oPaleta;
    }

    public String grabarxmlPaleta(Paleta entity, List<Dpaleta> dpaleta) throws Exception {
        String resultado = "";
        String t = null;
        String td = null;
        try {

            List<Paleta> l = new ArrayList<Paleta>();
            l.add(entity);
            String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream_rack = new XStream();
            xStream_rack.processAnnotations(Paleta.class);
            String xml = Inicio.concat(xStream_rack.toXML(l));
            t = xml;
            xStream_rack = new XStream();
            xStream_rack.processAnnotations(Dpaleta.class);
            String xmlDet = Inicio.concat(xStream_rack.toXML(dpaleta));
            td = xmlDet;
            String sql = "SINCR_TEMP_PALETA_WEB";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setString(1, "");
            cl.setString(2, "");
            cl.setString(3, xml);/*XML*/

            cl.setString(4, xmlDet);

            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } catch (Exception e) {
            resultado = e.toString();
            System.out.println(t);
            System.out.println(td);
        } finally {
            cerrar(cn, cl, rs);
        }

        return resultado;
    }

    public String grabarRegistroTempPaletaXML(String xml) throws Exception {
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if (xml != null) {
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SINCR_TEMP_PALETA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
                cl.setString(1, "");
                cl.setString(2, "");
                cl.setString(3, xml);/*XML*/

                //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
                //cl.executeUpdate();            
                //resultado = cl.getString(6);

                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));
                }
            }
        } catch (Exception e) {
            resultado = e.toString();
        } finally {
            cerrar(cn, cl, rs);
        }

        return resultado;
    }

    public List<Paleta> findByTotalPaleta(String idempresa, String idcompania) throws Exception {
        Paleta oPaleta = null;
        List<Paleta> listaPaleta = new ArrayList<Paleta>();
        try {
            String sql = "GETRECORD_RETURNTOTAL_PALETA_";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, idempresa);
            cl.setString(2, idcompania);
            cl.setString(3, "");
            rs = cl.executeQuery();
            while (rs.next()) {
                oPaleta = new Paleta();
                oPaleta.setIdempresa(rs.getString("IDEMPRESA"));
                oPaleta.setIdregistropaleta(rs.getString("IDREFERENCIA"));
                oPaleta.setIdproducto(rs.getString("IDPRODUCTO"));
                oPaleta.setDescproducto(rs.getString("DESCRIPCION"));
                oPaleta.setIdmedida(rs.getString("IDMEDIDA"));
                oPaleta.setCantidad(rs.getString("CANTIDAD"));
                oPaleta.setPeso(rs.getDouble("PESO"));
                oPaleta.setNropaleta(rs.getString("NROPALETA"));
                oPaleta.setIdlotep(rs.getString("IDLOTEP"));
                oPaleta.setIdcliente(rs.getString("IDCLIENTE"));
                oPaleta.setIdclieprov(rs.getString("IDCLIEPROV_CLI"));
                oPaleta.setIdenvase(rs.getString("IDENVASE"));
                oPaleta.setDescenvase(rs.getString("DESC_ENVASE"));
                oPaleta.setCerrado(rs.getString("CERRADO"));
                oPaleta.setNromanual(rs.getString("NROMANUAL"));
                listaPaleta.add(oPaleta);
            }
        } catch (Exception e) {
            String mensaje = e.toString();
            listaPaleta = null;

        } finally {
            cerrar(cn, cl, rs);
        }
        return listaPaleta;
    }

    public List<Paleta> findByTotalPaletaCampana(String idempresa, String idcompania) throws Exception {
        Paleta oPaleta = null;
        List<Paleta> listaPaleta = new ArrayList<Paleta>();
        try {
            String sql = "GETRECORD_RETURNTOTAL_PALETA_CAMPANA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, idempresa);
            cl.setString(2, idcompania);
            cl.setString(3, "");
            rs = cl.executeQuery();
            while (rs.next()) {
                oPaleta = new Paleta();
                oPaleta.setIdempresa(rs.getString("IDEMPRESA"));
                oPaleta.setIdregistropaleta(rs.getString("IDREFERENCIA"));
                oPaleta.setIdproducto(rs.getString("IDPRODUCTO"));
                oPaleta.setDescproducto(rs.getString("DESCRIPCION"));
                oPaleta.setIdmedida(rs.getString("IDMEDIDA"));
                oPaleta.setCantidad(rs.getString("CANTIDAD"));
                oPaleta.setPeso(rs.getDouble("PESO"));
                oPaleta.setNropaleta(rs.getString("NROPALETA"));
                oPaleta.setIdlotep(rs.getString("IDLOTEP"));
                oPaleta.setIdcliente(rs.getString("IDCLIENTE"));
                oPaleta.setIdclieprov(rs.getString("IDCLIEPROV_CLI"));
                oPaleta.setIdproductor(rs.getString("IDPRODUCTOR"));
                oPaleta.setIdclieprov_pro(rs.getString("IDCLIEPROV_PRO"));
                oPaleta.setFechaproc(rs.getString("FECHAPROC"));
                oPaleta.setFechaorigen(rs.getString("FECHAORIGEN"));
                oPaleta.setIdenvase(rs.getString("IDENVASE"));
                oPaleta.setDescenvase(rs.getString("DESC_ENVASE"));
                oPaleta.setCerrado(rs.getString("CERRADO"));
                oPaleta.setNromanual(rs.getString("NROMANUAL"));
                listaPaleta.add(oPaleta);
            }
        } catch (Exception e) {
            String mensaje = e.toString();
            listaPaleta = null;

        } finally {
            cerrar(cn, cl, rs);
        }
        return listaPaleta;
    }
    
    public List<Paleta> sincronizarRegistroPaleta(Object idempresa,Object idsucursal, Object desde,Object hasta) throws Exception {
        Paleta oPaleta = null;
        List<Paleta> listaPaleta = new ArrayList<Paleta>();
        try {
            String sql = "SP_PALETA_SINCRO";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setString(1, idempresa.toString());
            cl.setString(2, idsucursal.toString());
            cl.setString(3, desde.toString());
            cl.setString(4, hasta.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                oPaleta = new Paleta();
                oPaleta.setIdempresa(rs.getString("IDEMPRESA"));
                oPaleta.setIdemisor(rs.getString("IDEMISOR"));
                oPaleta.setIdoperacion(rs.getString("IDOPERACION"));
                oPaleta.setNumoperacion(rs.getString("NUMOPERACION"));
                oPaleta.setIdmotivopaleta(rs.getString("IDMOTIVOPALETA"));
                oPaleta.setSerie(rs.getString("SERIE"));
                oPaleta.setNumero(rs.getString("NUMERO"));
                oPaleta.setFecha(rs.getString("FECHA"));
                oPaleta.setPeriodo(rs.getString("PERIODO"));
                oPaleta.setIdestado(rs.getString("IDESTADO"));
                oPaleta.setIdclieprov(rs.getString("IDCLIEPROV"));
                oPaleta.setNropaleta(rs.getString("NROPALETA"));
                oPaleta.setIdenvase(rs.getString("IDENVASE"));
                oPaleta.setIdsucursal(rs.getString("IDSUCURSAL"));
                oPaleta.setIdalmacen(rs.getString("IDALMACEN"));
                oPaleta.setIdembalaje(rs.getString("IDEMBALAJE"));
                oPaleta.setIdvariedad(rs.getString("IDVARIEDAD"));
                oPaleta.setObservaciones(rs.getString("OBSERVACIONES"));
                oPaleta.setFechacreacion(rs.getString("FECHACREACION"));
                listaPaleta.add(oPaleta);
            }
        } catch (Exception e) {
            String mensaje = e.toString();
            listaPaleta = null;

        } finally {
            cerrar(cn, cl, rs);
        }
        return listaPaleta;
    } 

}
