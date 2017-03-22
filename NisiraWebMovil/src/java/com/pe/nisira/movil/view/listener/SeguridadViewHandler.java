/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.listener;

import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.Encryption;
import com.pe.nisira.movil.view.util.Constantes;
import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antenor
 */
public class SeguridadViewHandler extends ViewHandlerWrapper {
    private ViewHandler parent;

    public SeguridadViewHandler(ViewHandler parent) {
        this.parent = parent;
    }

    @Override
    public ViewHandler getWrapped() {
        return parent;
    }

    //En este metodo es donde podemos validar acceso a los menus de opciones
    @Override
    public UIViewRoot createView(FacesContext context, String viewId) {
        log.info(":::::::::::::::::: CREANDO LA VISTA ::::::::::::::::::");
        this.validaVista(context, viewId);
        return super.createView(context, viewId);
    }

    private void validaVista(FacesContext context, String viewId) {
       HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String vista = viewId.substring(1, viewId.lastIndexOf("."));
        log.info("Vista: " + vista);
        if (!vista.equalsIgnoreCase("index") && !vista.equalsIgnoreCase("sistema/Expulsado")&& !vista.equalsIgnoreCase("indexm")) {
            if(vista.indexOf("http")!=-1){
                try {
                    /*SINCRONIZACION POR URL*/
                    Map<String,String> params = context.getExternalContext().getRequestParameterMap();
                    String usuario=Encryption.decrypt(params.get("usuario")!=null?params.get("usuario"):"");
                    String pass=(params.get("password")!=null?params.get("password"):"");
                    Usuario user=(new UsuarioDao()).validarInicioSesionHttp(usuario,pass);
                    if(user==null)
                        sendRedirect(context, "index.xhtml");
                } catch (Exception ex) {
                    Logger.getLogger(SeguridadViewHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if (session == null || session.getAttribute(Constantes.SESION_USUARIO) == null) {
                    sendRedirect(context, "index.xhtml");
                }  else {
                    if(!vista.equalsIgnoreCase("index") || !vista.equalsIgnoreCase("sistema/CerrarSesion") || !vista.equalsIgnoreCase("sistema/Expulsado") || !vista.equalsIgnoreCase("indexm")){
    //                    Boolean monitorvalidado  =ValidarMonitor();
    //                    monitorvalidado = true;
    //                    if(monitorvalidado){
    //                        System.out.println("EN EL SEGURIDAD HEANDER " +ValidarMonitor());
    //                    }else{
    //                    session.invalidate();
    //                    System.out.println("EN EL SEGURIDAD HEANDER negativo " +ValidarMonitor());
    //                    sendRedirect(context, "sistema/Expulsado.xhtml");
    //                    }
                    }
                    if (vista.equalsIgnoreCase("sistema/CerrarSesion")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");

                    }
                /*
                //UsuarioBean usuarioLogueadoBean = (UsuarioBean) session.getAttribute(Constantes.SESION_USUARIO);
                //String nivelacceso = usuarioLogueadoBean.getcNivel_acceso();
                  //  if (nivelacceso.equalsIgnoreCase("4")) {
                        if (vista.equalsIgnoreCase("welcomePrimefaces")
                               || vista.equalsIgnoreCase("sistema/regModulo")
                                || vista.equalsIgnoreCase("sistema/regCargo")
                                || vista.equalsIgnoreCase("sistema/regError")
                                || vista.equalsIgnoreCase("sistema/regFase")
                                || vista.equalsIgnoreCase("sistema/regGrupo")
                                || vista.equalsIgnoreCase("sistema/regIncidencia")
                                || vista.equalsIgnoreCase("sistema/regIncidenciaxCliente")
                                || vista.equalsIgnoreCase("sistema/regNota")
                                || vista.equalsIgnoreCase("sistema/regNoticias")
                                || vista.equalsIgnoreCase("sistema/regOrganizacion")
                                || vista.equalsIgnoreCase("sistema/regProyecto")
                                || vista.equalsIgnoreCase("sistema/regUsuarios")
                                || vista.equalsIgnoreCase("sistema/regActividades")

                                || vista.equalsIgnoreCase("sistema/mntCargo")
                                || vista.equalsIgnoreCase("sistema/mntError")
                                || vista.equalsIgnoreCase("sistema/mntFase")
                                || vista.equalsIgnoreCase("sistema/mntGrupo")
                                || vista.equalsIgnoreCase("sistema/mntIncidencia")
                                || vista.equalsIgnoreCase("sistema/mntModulo")
                                || vista.equalsIgnoreCase("sistema/mntNota")
                                || vista.equalsIgnoreCase("sistema/mntOrganizacion")
                                 || vista.equalsIgnoreCase("sistema/mntPersonal")
                                || vista.equalsIgnoreCase("sistema/mntProyecto")
                                || vista.equalsIgnoreCase("sistema/mntUsuarios")

                                 || vista.equalsIgnoreCase("sistema/lstIncidencias")
                                || vista.equalsIgnoreCase("sistema/lstIncidenciasPersonal")
                                || vista.equalsIgnoreCase("sistema/lstIncidenciasPersonalRep")
                                || vista.equalsIgnoreCase("sistema/lstIncidenciasSoporte")


                                || vista.equalsIgnoreCase("sistema/actIncidencia")
                                || vista.equalsIgnoreCase("sistema/actIncidenciaPersonal")
                                || vista.equalsIgnoreCase("sistema/actModulo")
                                || vista.equalsIgnoreCase("sistema/actOrganizacion")
                                || vista.equalsIgnoreCase("sistema/actPersonal")
                                || vista.equalsIgnoreCase("sistema/actProyecto")
                                 || vista.equalsIgnoreCase("sistema/actUsuarios")

                              ) {
                            sendRedirect(context, "index.xhtml");

                        } 
                   // }

                    if (vista.equalsIgnoreCase("sistema/CerrarSesion")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");
                    }
                    if (vista.equalsIgnoreCase("sistema/menu1")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");
                    }
                    if (vista.equalsIgnoreCase("sistema/menu2")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");
                    }
                    if (vista.equalsIgnoreCase("sistema/menu3")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");
                    }
                    if (vista.equalsIgnoreCase("sistema/menu4")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");
                    }

                */
                }
            }
            
        }
        
    }

    public boolean ValidarMonitor(){
        boolean validar=false;
        try {
           
            validar = new UsuarioDao().validarMonitor(Constantes.getIDSESION());
           
        } catch (Exception ex) {
            log.error(ex, ex);
        }
        return validar;
    }
    
    private void sendRedirect(FacesContext context, String ruta) {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            context.responseComplete();
            log.info(context.getExternalContext().getRequestContextPath() + "/faces/" + ruta);
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "/faces/" + ruta);
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }
}
