/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.Encryption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.pe.nisira.utilitarios.UtilWeb;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;

/**
 *
 * @author Antenor
 */
public class UsuarioDao extends EntityDao<Usuario> {

    @Override
    public List<Usuario> findAll() throws Exception {
        List<Usuario> lu = new ArrayList<Usuario>();
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement("Select * from USUARIO");
        rs = pr.executeQuery();
        while (rs.next()) {
               Usuario u = new Usuario();
               u.setIDUSUARIO(rs.getString("IDUSUARIO"));
               u.setPASSWORD(Encryption.decrypt(rs.getString("PASSWORD")));
               u.setESTADO(rs.getInt("ESTADO"));
               u.setUSR_NOMBRES(rs.getString("USR_NOMBRES"));
               u.setUSR_INICIALES(rs.getString("USR_INICIALES"));
               u.setFECHACREACION(rs.getString("FECHACREACION"));
               u.setVERBARRA(rs.getInt("VERBARRA"));
               u.setESTIPO(rs.getInt("ESTIPO"));
               u.setIDUSUARIOTIP(rs.getString("IDUSUARIOTIPO"));
               u.setEMAIL(rs.getString("EMAIL"));
               lu.add(u);
        }
        return lu;
    }

    public Usuario validarInicioSesion(String idusuario, String password) throws Exception {

        Usuario u = null;
        try {
            System.out.println("validarInicioSesion");
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL [nspmov_verificar_usuario](?,?)}");
            cl.setString(1, idusuario);
//            cl.setString(2, Clave.Encriptar(password));
            cl.setString(2, Encryption.encrypt(password));
            rs = cl.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setIDUSUARIO(rs.getString("IDUSUARIO"));
                u.setPASSWORD(rs.getString("PASSWORD"));
                u.setESTADO(rs.getInt("ESTADO"));
                u.setEMAIL(rs.getString("EMAIL"));
                u.setESADMINISTRADOR(rs.getString("IDUSUARIO").equalsIgnoreCase("ADMINISTRADOR")?true:false);
                break;
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return u;
    }
    
    public Usuario validarInicioSesionHttp(String idusuario, String password) throws Exception {

        Usuario u = null;
        try {
            System.out.println("validarInicioSesion");
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL [nspmov_verificar_usuario](?,?)}");
            cl.setString(1, idusuario);
//            cl.setString(2, Clave.Encriptar(password));
            cl.setString(2, password);
            rs = cl.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setIDUSUARIO(rs.getString("IDUSUARIO"));
                u.setPASSWORD(rs.getString("PASSWORD"));
                u.setESTADO(rs.getInt("ESTADO"));
                u.setEMAIL(rs.getString("EMAIL"));
                u.setESADMINISTRADOR(rs.getString("IDUSUARIO").equalsIgnoreCase("ADMINISTRADOR")?true:false);
                break;
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return u;
    }
    @Override
    public Usuario find(Usuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean ValidarLicenciasDisponibles() throws Exception {

        int numeroActivos = 0;
        int numeroLicencias = 0;
        String id = "";
        String limite = "";

        try {

            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL [nspContarOnline_S]}");
            rs = cl.executeQuery();
            while (rs.next()) {
                numeroActivos = rs.getInt("numero");
            }
            cerrar(cl);
            cerrar(rs);
            cl = cn.prepareCall("{CALL [nspLicencia_S]}");
            rs = cl.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID").trim();
                limite = rs.getString("LIMITE").trim();

            }

//            String limitee = "\\X{UWˆdSs–^srfqnm„\\\\WyV"; //DONFERMIN
            String limitee = "\\X{UW‰dZs^mrgqmm…]\\W{["; //CHAPI
         //      String limitee = "\\X{UW‰dZs^mrgqmm…]\\W{["; //CHAPI   
            
//            String limitee = "\\X{UW‹dSs‘^prgqrm„]\\Vy]"; //FILMPACK

            String l = Clave.desencripta_licencia(limitee);

            numeroLicencias = Integer.parseInt(l.replaceAll(id, ""));

//             numeroActivos=6; // filnpack
            if (numeroActivos < numeroLicencias) {
                return true;
            }
            return false;

        } finally {
            cerrar(cn, cl, rs);
        }

    }

    public String insertarMonitor(String idusuario, String idsesion) throws Exception {

        boolean rollback = true;
        String fecha = "";
        Date fec = new Date();



        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            fecha = myFormat.format(fec);
            System.out.println("Inserta en el monitor");

            String sql = "nspInsertarMonitor_I";
            cn = obtenerConexion();
            System.out.println("termina el inser EL INSERTAR");
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?)}");
            cl.setString(1, idusuario);
            cl.setString(2, idsesion);
            cl.setString(3, ConstantesBD.BDCONECCION);
            cl.setString(4, fecha);
            cl.setTimestamp(5, UtilWeb.convertirDateTimestamp(fec));
            cl.executeUpdate();
//            cerrar(cl);
            cn.commit();
            rollback = false;
            System.out.println("termina el inser EL INSERTAR");
        } finally {
            if (rollback) {
                rollback(cn);
            }
            cerrar(cn, cl);
        }
        System.out.println("TERMINA EL INSERTAR");
        return "";
    }

    public String eliminarMonitor(String idsesion) throws Exception {
        System.out.println("Eliminar monitor ");

        boolean rollback = true;

        try {

            String sql = "nspEliminarMonitor_D";
            cn = obtenerConexion();

            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setString(1, idsesion);
            cl.executeUpdate();
            cerrar(cl);
            cn.commit();
            rollback = false;
        } finally {
            if (rollback) {
                rollback(cn);
            }
            cerrar(cn, cl);
        }
        return "";
    }

    public boolean validarMonitor(String idsesion) throws Exception {
        int contador = 0; //para saber si no ha sido votado por el monitor
        try {
            //System.out.println("EN EL MONITOR DAOOOOOOOOOOOOOOOOOOOOOOO");
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL [nspValidarMonitor_S](?)}");
            cl.setString(1, idsesion);
            rs = cl.executeQuery();
            while (rs.next()) {
                contador++;
            }

        } finally {
            cerrar(cn, cl, rs);
        }

        if (contador == 0) {
            return false;
        } else {
            return true;
        }
    }
    public void grabar(Usuario u) throws Exception{
        try {

            String resultado = "";
            List<Usuario> l = new ArrayList<Usuario>();
            l.add(u);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("USUARIO", Usuario.class);
            String xml = xstream.toXML(l);
            
            String sql = "SP_USUARIO_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setString(1, u.getIDUSUARIO());
            cl.setString(2, xml);
            rs = cl.executeQuery();
            while (rs.next()) {
                resultado = (rs.getString("mensaje"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
