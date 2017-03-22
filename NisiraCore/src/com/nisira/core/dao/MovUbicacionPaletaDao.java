/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.*;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_SELECT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_SELECT;
import static com.nisira.core.util.CoreUtil.consulta;
import java.sql.Date;
import java.text.SimpleDateFormat;
import net.sourceforge.jtds.jdbc.DateTime;

/**
 *
 * @author Antenor
 */
public class MovUbicacionPaletaDao extends EntityDao<MovUbicacionPaleta> {

    @Override
    public MovUbicacionPaleta find(MovUbicacionPaleta e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

    @Override
    public List<MovUbicacionPaleta> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    
    @Override
    public MovUbicacionPaleta update(MovUbicacionPaleta e) throws Exception {
          throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<MovUbicacionPaleta> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String enviarmail(String estado, String idcompra, String serie) throws Exception {
        try {
            
            cn = obtenerConexion();
            cl = cn.prepareCall(consulta("nspEnviarEmail_S", 3));
            cl.setString(1, idcompra.toString());
            cl.setString(2, serie.toString());
            cl.setString(3, estado.toString());
            
            cl.executeUpdate();
            cerrar(cl);
        } finally {

            cerrar(cn, cl, rs);
        }
        return "";
    }
    
    public MovUbicacionPaleta findUltimoMovUbicacionPaletaByNroPaleta(String idempresa,String nropaleta) throws Exception{

        MovUbicacionPaleta movubicacionpaleta = null;
        //DataBaseConeccion db= new DataBaseConeccion(context);        
        try {
            String sql = "nsp_distcam_movil_findUltimoMovUbicacionPaletaByNroPaleta_s";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setString(1,idempresa);
            cl.setString(2,nropaleta);

            rs = cl.executeQuery();

            while (rs.next()) {

                movubicacionpaleta = new MovUbicacionPaleta();
                movubicacionpaleta.setIdempresa(idempresa);
                movubicacionpaleta.setNropaleta(rs.getString("NROPALETA"));
                movubicacionpaleta.setTipoubicacion(rs.getString("TIPOUBICACION"));
                movubicacionpaleta.setIdubicacion(rs.getString("IDUBICACION"));
                movubicacionpaleta.setIdpaleta(rs.getString("IDPALETA"));
                movubicacionpaleta.setIdcliente(rs.getString("IDCLIENTE"));
                movubicacionpaleta.setIdmotivo(rs.getString("IDMOTIVO"));
                movubicacionpaleta.setFactor(rs.getInt("FACTOR"));
                movubicacionpaleta.setIdproducto(rs.getString("IDPRODUCTO"));
                movubicacionpaleta.setCantidad(rs.getDouble("CANTIDAD"));
                movubicacionpaleta.setIdenvase(rs.getString("IDENVASE"));
                movubicacionpaleta.setIdproductor(rs.getString("IDPRODUCTOR"));
                movubicacionpaleta.setIdlotep(rs.getString("IDLOTEP"));
                movubicacionpaleta.setObservacion(rs.getString("OBSERVACION"));
                movubicacionpaleta.setDescubicacion(rs.getString("DESC_UBICACION"));
                movubicacionpaleta.setDesccliente(rs.getString("DESC_CLIENTE"));
                movubicacionpaleta.setDescvariedad(rs.getString("DESC_VARIEDAD"));
                movubicacionpaleta.setDescenvase(rs.getString("DESC_ENVASE"));
                movubicacionpaleta.setDesccategorias(rs.getString("DESC_CATEGORIAS"));
                movubicacionpaleta.setDesccalibres(rs.getString("DESC_CALIBRES"));
            }
        }

        finally {
            cerrar(cn, cl, rs);
        }
        
        return movubicacionpaleta;
    }


    public String grabarMovUbicacionByPaleta(String idempresa,String JSONMovUbicacionMovimientos,String idubicacion_actual,String idubicacion_nueva,String nropaleta) throws Exception{

        MovUbicacionPaleta movubicacionpaleta = null;
        String resultado = "";
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "GRABAR_MOVUBICACION_BYPALETA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1,idempresa);
            cl.setString(2,JSONMovUbicacionMovimientos);
            cl.setString(3,idubicacion_actual);
            cl.setString(4,idubicacion_nueva);
            cl.setString(5,nropaleta);
            //cl.registerOutParameter(6,java.sql.Types.VARCHAR);
            //cl.executeUpdate();            
            //resultado = cl.getString(6);
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));                
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
    
    public DistribucionUbicacion getDistribucionUbicacionByCamara(String idempresa,String idcamara,Date Fecha) throws Exception{
        ArrayList<Rack> lista_racks = new ArrayList<Rack>();
        ArrayList<Pisos> lista_pisos_total = new ArrayList<Pisos>();
        ArrayList<Fila> lista_filas = new ArrayList<Fila>();
        ArrayList<Fila> lista_filas_total = new ArrayList<Fila>();
        //ArrayList<Columna> lista_columnas = new ArrayList<Columna>();
        ArrayList<Columna> lista_columnas_total = new ArrayList<Columna>();
        
        DistribucionUbicacion distribucionubicacion = new DistribucionUbicacion();
        //DataBaseConeccion db= new DataBaseConeccion(context);        
        try {            
            String sql = "nsp_getRacksByCamara";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setString(1,idempresa);
            cl.setString(2,idcamara);            

            rs = cl.executeQuery();

            while (rs.next()) {

                Rack rack = new Rack();
                rack.setIdempresa(rs.getString("IDEMPRESA"));
                rack.setIdcamara(rs.getString("IDCAMARA"));
                rack.setIdrack(rs.getString("IDRACK"));
                rack.setDescripcion(rs.getString("DESCRIPCION"));
                
                lista_racks.add(rack);
            }
            
               
            sql = "nsp_getPisosByCamara";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");

            cl.setString(1,idempresa);
            cl.setString(2,idcamara);

            rs = cl.executeQuery();

            while (rs.next()) {

                Pisos piso = new Pisos();
                piso.setIdempresa(rs.getString("IDEMPRESA"));
                piso.setIdcamara(rs.getString("IDCAMARA"));
                piso.setIdrack(rs.getString("IDRACK"));
                piso.setIdpiso(rs.getString("IDPISO"));                    
                piso.setDescripcion(rs.getString("DESCRIPCION"));

                lista_pisos_total.add(piso);
            }

            
            sql = "nsp_getFilasByCamara";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");

            cl.setString(1,idempresa);
            cl.setString(2,idcamara);
            
            rs = cl.executeQuery();

            while (rs.next()) {

                Fila fila = new Fila();
                fila.setIdempresa(rs.getString("IDEMPRESA"));
                fila.setIdcamara(rs.getString("IDCAMARA"));
                fila.setIdrack(rs.getString("IDRACK"));
                fila.setIdpiso(rs.getString("IDPISO"));                    
                fila.setIdfila(rs.getString("IDFILA"));                    
                fila.setDescripcion(rs.getString("DESCRIPCION"));

                lista_filas_total.add(fila);

            }
            
            sql = "nsp_ditribucionpaletascamara";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1,idempresa);
            cl.setString(2,idcamara);
            cl.setDate(3,Fecha);

            rs = cl.executeQuery();

            while (rs.next()) {

                Columna columna = new Columna();
                columna.setIdempresa(rs.getString("IDEMPRESA")==null?"":rs.getString("IDEMPRESA"));
                columna.setIdusuario(rs.getString("IDUSUARIO")==null?"":rs.getString("IDUSUARIO"));
                columna.setIdrack(rs.getString("RACK"));
                columna.setIdpiso(rs.getString("PISO"));
                columna.setIdfila(rs.getString("FILA"));
                columna.setIdcoluma(rs.getString("COLUMNA"));
                
                columna.setDescripcion(rs.getString("DESCRIPCION")==null?"":rs.getString("DESCRIPCION"));
                columna.setNropaleta(rs.getString("NROPALETA")==null?"":rs.getString("NROPALETA"));
                columna.setTipoubicacion(rs.getString("TIPOUBICACION")==null?"":rs.getString("TIPOUBICACION"));
                columna.setIdubicacion(rs.getString("IDUBICACION")==null?"":rs.getString("IDUBICACION"));
                columna.setIdpaleta(rs.getString("IDPALETA")==null?"":rs.getString("IDPALETA"));
                columna.setIdcliente(rs.getString("IDCLIENTE")==null?"":rs.getString("IDCLIENTE"));
                columna.setIdmotivo(rs.getString("IDMOTIVO")==null?"":rs.getString("IDMOTIVO"));
                columna.setFactor( ((Integer)rs.getInt("FACTOR")) ==null?0:rs.getInt("FACTOR"));
                columna.setIdproducto(rs.getString("IDPRODUCTO") == null?"":rs.getString("IDPRODUCTO"));
                columna.setCantidad( ((Double) rs.getDouble("CANTIDAD"))==null?0.00:rs.getDouble("CANTIDAD"));
                columna.setIdenvase(rs.getString("IDENVASE")==null?"":rs.getString("IDENVASE"));
                columna.setIdproductor(rs.getString("IDPRODUCTOR")==null?"":rs.getString("IDPRODUCTOR"));
                columna.setIdlotep(rs.getString("IDLOTEP")==null?"":rs.getString("IDLOTEP"));
                columna.setObservacion(rs.getString("OBSERVACION")==null?"":rs.getString("OBSERVACION"));
                /*
                columna.setDescubicacion(rs.getString("DESC_UBICACION"));
                columna.setDesccliente(rs.getString("DESC_CLIENTE"));
                columna.setDescvariedad(rs.getString("DESC_VARIEDAD"));
                columna.setDescenvase(rs.getString("DESC_ENVASE"));
                columna.setDesccategorias(rs.getString("DESC_CATEGORIAS"));
                columna.setDesccalibres(rs.getString("DESC_CALIBRES"));
                */
                columna.setDescubicacion("");
                columna.setDesccliente("");
                columna.setDescvariedad("");
                columna.setDescenvase("");
                columna.setDesccategorias("");
                columna.setDesccalibres("");  
                
                columna.setIdcamara(idcamara);
                
                lista_columnas_total.add(columna);
            }
            
            for(Fila fila : lista_filas_total){                
                ArrayList<Columna> lst_columna = new ArrayList<Columna>();
                for(Columna columna : lista_columnas_total){                                        
                    if(columna.getIdcamara().trim().compareTo(fila.getIdcamara()) == 0
                            && columna.getIdrack().trim().compareTo(fila.getIdrack()) == 0
                            && columna.getIdpiso().trim().compareTo(fila.getIdpiso()) == 0
                            && columna.getIdfila().trim().compareTo(fila.getIdfila()) == 0
                            )
                    {
                        lst_columna.add(columna);
                    }
                    
                }
                fila.setListacolumnas(lst_columna);
            }
            
            for(Pisos piso : lista_pisos_total){                
                ArrayList<Fila> lst_fila = new ArrayList<Fila>();
                for(Fila fila : lista_filas_total){                                        
                    if(fila.getIdcamara().trim().compareTo(piso.getIdcamara()) == 0
                            && fila.getIdrack().trim().compareTo(piso.getIdrack()) == 0
                            && fila.getIdpiso().trim().compareTo(piso.getIdpiso()) == 0
                            )
                    {
                        lst_fila.add(fila);
                    }                    
                }
                piso.setListafilas(lst_fila);
            }
            
            for(Rack rack : lista_racks){                
                ArrayList<Pisos> lst_pisos = new ArrayList<Pisos>();
                for(Pisos piso : lista_pisos_total){                                        
                    if(piso.getIdcamara().trim().compareTo(rack.getIdcamara()) == 0
                            && piso.getIdrack().trim().compareTo(rack.getIdrack()) == 0
                            )
                    {
                        lst_pisos.add(piso);
                    }
                    
                }
                rack.setListapisos(lst_pisos);
            }
            
            distribucionubicacion = new DistribucionUbicacion();
            distribucionubicacion.setIdempresa(idempresa);
            distribucionubicacion.setIdcamara(idcamara);
            distribucionubicacion.setTipo("");
            distribucionubicacion.setListaracks(lista_racks);
            distribucionubicacion.setListacolumnas_total(lista_columnas_total);
            
        }

        finally {
            cerrar(cn, cl, rs);
        }
        
        return distribucionubicacion;
    }

    public ArrayList<Columna> getDistribucionCamaraByNroPaleta(String idempresa,String nropaleta,Date fecha,String tipo,String idfechacampanaanual) throws Exception{
        ArrayList<Columna> lista_columnas = new ArrayList<Columna>();
        try{
            
            String sql = "nsp_ditribucionpaletascamarabynropaleta";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1,idempresa);
            cl.setString(2,nropaleta);
            cl.setDate(3,fecha);
            cl.setString(4,tipo);
            cl.setString(5, idfechacampanaanual);

            rs = cl.executeQuery();

            while (rs.next()) {

                Columna columna = new Columna();
                columna.setIdempresa(rs.getString("IDEMPRESA")==null?"":rs.getString("IDEMPRESA"));
                columna.setIdusuario(rs.getString("IDUSUARIO")==null?"":rs.getString("IDUSUARIO"));
                columna.setIdrack(rs.getString("RACK"));
                columna.setIdpiso(rs.getString("PISO"));
                columna.setIdfila(rs.getString("FILA"));
                columna.setIdcoluma(rs.getString("COLUMNA"));
                
                columna.setDescripcion(rs.getString("DESCRIPCION")==null?"":rs.getString("DESCRIPCION"));
                //columna.setNropaleta(rs.getString("NROPALETA")==null?"  V       A       C       I       O   ":rs.getString("NROPALETA"));
                //columna.setNropaleta(rs.getString("NROPALETA")==null?"VACIO":rs.getString("NROPALETA"));
                columna.setNropaleta(rs.getString("NROPALETA")==null?"-":rs.getString("NROPALETA"));
                columna.setTipoubicacion(rs.getString("TIPOUBICACION")==null?"":rs.getString("TIPOUBICACION"));
                columna.setIdubicacion(rs.getString("IDUBICACION")==null?"":rs.getString("IDUBICACION"));
                columna.setIdpaleta(rs.getString("IDPALETA")==null?"":rs.getString("IDPALETA"));
                columna.setIdcliente(rs.getString("IDCLIENTE")==null?"":rs.getString("IDCLIENTE"));
                columna.setIdmotivo(rs.getString("IDMOTIVO")==null?"":rs.getString("IDMOTIVO"));
                columna.setFactor( ((Integer)rs.getInt("FACTOR")) ==null?0:rs.getInt("FACTOR"));
                columna.setIdproducto(rs.getString("IDPRODUCTO") == null?"":rs.getString("IDPRODUCTO"));
                columna.setCantidad( ((Double) rs.getDouble("CANTIDAD"))==null?0.00:rs.getDouble("CANTIDAD"));
                columna.setIdenvase(rs.getString("IDENVASE")==null?"":rs.getString("IDENVASE"));
                columna.setIdproductor(rs.getString("IDPRODUCTOR")==null?"":rs.getString("IDPRODUCTOR"));
                columna.setIdlotep(rs.getString("IDLOTEP")==null?"":rs.getString("IDLOTEP"));
                columna.setObservacion(rs.getString("OBSERVACION")==null?"":rs.getString("OBSERVACION"));
                
                
                columna.setDescubicacion(rs.getString("DESC_UBICACION")==null?"":rs.getString("DESC_UBICACION"));
                columna.setDesccliente(rs.getString("DESC_CLIENTE"));
                columna.setDescvariedad(rs.getString("DESC_VARIEDAD"));
                columna.setDescenvase(rs.getString("DESC_ENVASE"));
                columna.setDesccategorias(rs.getString("DESC_CATEGORIAS"));
                columna.setDesccalibres(rs.getString("DESC_CALIBRES"));
                columna.setDesccamara(rs.getString("DESC_CAMARA")== null?"":rs.getString("DESC_CAMARA"));
                
                columna.setVisible(rs.getBoolean("CABECERAVISIBLE"));
                
                
                /*
                columna.setDescubicacion("");
                columna.setDesccliente("");
                columna.setDescvariedad("");
                columna.setDescenvase("");
                columna.setDesccategorias("");
                columna.setDesccalibres("");  
                */
                columna.setIdcamara(rs.getString("IDCAMARA"));                
                columna.setNrofilas(rs.getInt("NROFILAS"));
                columna.setNrocolumnas(rs.getInt("NROCOLUMNAS"));
                columna.setFlagubicacion(rs.getString("FLAGUBICACION"));
                columna.setColor(rs.getString("COLOR"));
                columna.setCodigocliente(rs.getString("CODIGOCLIENTE"));
                
                columna.setFechaingreso(rs.getTimestamp("FECHA")== null?null:rs.getTimestamp("FECHA"));
                columna.setDescfechaingreso("");
                if (columna.getFechaingreso() != null)
                {
                    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    String descfechaingreso = ft.format(columna.getFechaingreso());                
                    columna.setDescfechaingreso(descfechaingreso);
                }
                
                lista_columnas.add(columna);
            }     
        }       
        finally {
            cerrar(cn, cl, rs);
        }        
        return lista_columnas;
    }
}
