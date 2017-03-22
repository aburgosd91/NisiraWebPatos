/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
@XStreamAlias("USUARIO")
public class Usuario {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    private String IDUSUARIO;
    private String PASSWORD;
    private int ESTADO;
    private String USR_NOMBRES;
    private String USR_INICIALES;
    private String FECHACREACION;
    private int VERBARRA;
    private int ESTIPO;
    private String IDUSUARIOTIP;
    private String EMAIL;
    @XStreamOmitField
    private boolean ESADMINISTRADOR;
    @XStreamOmitField
    private String IdgrupoUsuario;
    @XStreamOmitField
    private List<Privilegios> privilegios;
    @XStreamOmitField
    private List<String[]> access;

    public Usuario() {

    }

    public Usuario(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public Usuario(String IDUSUARIO, String PASSWORD, int ESTADO,
            String EMAIL, boolean ESADMINISTRADOR, String NOMBRE, List<Privilegios> privilegios) {
        this.IDUSUARIO = IDUSUARIO;
        this.PASSWORD = PASSWORD;
        this.ESTADO = ESTADO;
        this.EMAIL = EMAIL;
        this.ESADMINISTRADOR = ESADMINISTRADOR;
        this.privilegios = privilegios;
    }

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    

    public String getUSR_NOMBRES() {
        return USR_NOMBRES;
    }

    public void setUSR_NOMBRES(String USR_NOMBRES) {
        this.USR_NOMBRES = USR_NOMBRES;
    }

    public String getUSR_INICIALES() {
        return USR_INICIALES;
    }

    public void setUSR_INICIALES(String USR_INICIALES) {
        this.USR_INICIALES = USR_INICIALES;
    }

    public String getFECHACREACION() {
        return FECHACREACION;
    }

    public void setFECHACREACION(String FECHACREACION) {
        this.FECHACREACION = FECHACREACION;
    }

    public int getVERBARRA() {
        return VERBARRA;
    }

    public void setVERBARRA(int VERBARRA) {
        this.VERBARRA = VERBARRA;
    }

    public int getESTIPO() {
        return ESTIPO;
    }

    public void setESTIPO(int ESTIPO) {
        this.ESTIPO = ESTIPO;
    }

    public String getIDUSUARIOTIP() {
        return IDUSUARIOTIP;
    }

    public void setIDUSUARIOTIP(String IDUSUARIOTIP) {
        this.IDUSUARIOTIP = IDUSUARIOTIP;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public boolean isESADMINISTRADOR() {
        return ESADMINISTRADOR;
    }

    public void setESADMINISTRADOR(boolean ESADMINISTRADOR) {
        this.ESADMINISTRADOR = ESADMINISTRADOR;
    }

    public String getIdgrupoUsuario() {
        return IdgrupoUsuario;
    }

    public void setIdgrupoUsuario(String IdgrupoUsuario) {
        this.IdgrupoUsuario = IdgrupoUsuario;
    }

    public List<Privilegios> getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(List<Privilegios> privilegios) {
        this.privilegios = privilegios;
    }

    public List<String[]> getAccess() {
        return access;
    }

    public void setAccess(List<String[]> access) {
        this.access = access;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IDUSUARIO != null ? IDUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.IDUSUARIO == null && other.IDUSUARIO != null) || (this.IDUSUARIO != null && !this.IDUSUARIO.equals(other.IDUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.activos.core.entity.Usuario[ idusuario=" + getIDUSUARIO() + " ]";
    }
}
