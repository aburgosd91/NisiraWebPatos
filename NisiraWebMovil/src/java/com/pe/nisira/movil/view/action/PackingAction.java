/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DocumentoDao;
import com.nisira.core.dao.MotivoDao;
import com.nisira.core.dao.NumEmisorDao;
import com.nisira.core.dao.PackingDao;
import com.nisira.core.dao.ParametrosDao;
import com.nisira.core.dao.PuertoDestinoDao;
import com.nisira.core.dao.ResponsableDao;
import com.nisira.core.entity.Documento;
import com.nisira.core.entity.Dpacking;
import com.nisira.core.entity.Motivo;
import com.nisira.core.entity.NumEmisor;
import com.nisira.core.entity.Packing;
import com.nisira.core.entity.Parametros;
import com.nisira.core.entity.PuertoDestino;
import com.nisira.core.entity.Responsable;
import com.nisira.core.util.Parametro;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "PackingAction")
@SessionScoped
public class PackingAction extends AbstactListAction<Packing> implements Serializable {

    private List<Motivo> lstmotivo;
    private Motivo mot;
    private List<PuertoDestino> lstpuerto;
    private PuertoDestino puerto;
    private Dpacking dpaking;
    private List<Dpacking> ldpacking;
    private PackingDao packingDao;
    private List<Documento> lstdocs;
    private DocumentoDao docDao;
    private List<NumEmisor> lstnume;
    private NumEmisorDao numemiDao;
    private UsuarioBean user;
    private String numero;
    private Responsable op;
    private ResponsableDao respdao;
    private boolean nuevoD;
    private String mensaje;
    private NumEmisor nuevaSerie;

    public PackingAction() {
        lstmotivo = new ArrayList<Motivo>();
        mot = new Motivo();
        lstpuerto = new ArrayList<PuertoDestino>();
        puerto = new PuertoDestino();
        dpaking = new Dpacking();
        ldpacking = new ArrayList<Dpacking>();
        packingDao = new PackingDao();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        op = new Responsable();
        respdao = new ResponsableDao();
        nuevoD = false;
        mensaje = "";
        nuevaSerie = new NumEmisor();
        actualiza_ventana("wMnt_Packing");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(packingDao.findAll(user.getIDEMPRESA(), Constantes.getIDSUCURSALGENERAL()));
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstmotivo = new ArrayList<Motivo>();
        mot = new Motivo();
        lstpuerto = new ArrayList<PuertoDestino>();
        puerto = new PuertoDestino();
        dpaking = new Dpacking();
        ldpacking = new ArrayList<Dpacking>();
        packingDao = new PackingDao();
        lstdocs = new ArrayList<Documento>();
        docDao = new DocumentoDao();
        lstnume = new ArrayList<NumEmisor>();
        numemiDao = new NumEmisorDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);;
        numero = "";
        op = new Responsable();
        respdao = new ResponsableDao();
        nuevoD = false;
        mensaje = "";
        nuevaSerie = new NumEmisor();
        actualiza_ventana("wMnt_Packing");
        return null;
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Packing());
        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
        getDatoEdicion().setESTADO(1);
        getDatoEdicion().setIDSUCURSAL(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
        nuevoD = true;
    }

    @Override
    public void grabar() {
        try {
            getDatoEdicion().setIDRESPONSABLE(op.getIdresponsable());
            getDatoEdicion().setNUMERO(numero);
            packingDao.grabar(getDatoEdicion());
            if (nuevoD) {
                String Inicio = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream_rack = new XStream();
                xStream_rack = new XStream();
                xStream_rack.processAnnotations(NumEmisor.class);
                List<NumEmisor> nn = new ArrayList<NumEmisor>();
                for (NumEmisor nw : lstnume) {
                    if (nw.getIDDOCUMENTO().equalsIgnoreCase(getDatoEdicion().getIDDOCUMENTO()) && nw.getSERIE().equalsIgnoreCase(getDatoEdicion().getSERIE())) {
                        nuevaSerie = nw;
                        nuevaSerie.setNUMERO(numero);
                        nn.add(nw);
                    }
                }
                String xmlDet = Inicio.concat(xStream_rack.toXML(nn));
                numemiDao.insertFromProg(xmlDet);
            }
        } catch (Exception ex) {
            Logger.getLogger(PackingAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setESTADO(0);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setESTADO(2);
            }
            packingDao.grabar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(PackingAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findDetalles() throws Exception {
        lstmotivo = (new MotivoDao()).findAll(getDatoEdicion().getIDEMPRESA());
        lstpuerto = (new PuertoDestinoDao()).findAll(getDatoEdicion().getIDEMPRESA());
        lstdocs = docDao.findAll(user.getIDEMPRESA());
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), lstdocs.get(0).getIDDOCUMENTO());
        if (nuevoD) {
            if (!lstnume.get(0).getNUMERO().equalsIgnoreCase("0000001")) {
                numero = WebUtil.cerosIzquierda(Integer.parseInt(lstnume.get(0).getNUMERO()) + 1, 7);
            } else {
                numero = lstnume.get(0).getNUMERO();
            }
        } else {
            numero = getDatoEdicion().getNUMERO();
        }
        if (getLadd() != 1) {
            op = respdao.findRespon(Integer.parseInt(user.getIDEMPRESA()), getDatoEdicion().getIDRESPONSABLE());
            ldpacking = packingDao.findDpacking(getDatoEdicion());
            mot = (new MotivoDao()).find(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDMOTIVO());
            puerto = (new PuertoDestinoDao()).find(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDMOTIVO());

        }

    }

    public void oncDocChange() throws Exception {
        lstnume = numemiDao.findByDocumento(user.getIDEMPRESA(), getDatoEdicion().getIDDOCUMENTO());
        numero = null;
        if (!lstnume.isEmpty()) {
            int i = 0;
            for (NumEmisor n : lstnume) {
                if (n.getIDDOCUMENTO().equalsIgnoreCase(getDatoEdicion().getIDDOCUMENTO())) {
                    if (Integer.parseInt(n.getNUMERO()) >= 1) {
                        i = Integer.parseInt(n.getNUMERO()) + 1;
                    } else {
                        i = Integer.parseInt(n.getNUMERO());
                    }

                }
            }
            numero = WebUtil.cerosIzquierda(i, 7);
        }

    }

    public void verCntResponsable() {
        RequestContext.getCurrentInstance().openDialog("cntResponsable", modalOptions, null);
    }

    public void llenarResponsable(SelectEvent event) {
        this.op = (Responsable) event.getObject();
    }

    public void llenarMotivo() {
        getDatoEdicion().setIDMOTIVO(mot.getIDMOTIVO());
        RequestContext.getCurrentInstance().update("datos:cntMotivo");
        RequestContext.getCurrentInstance().execute("PF('diagMot').hide()");
    }

    public void llenarPuerto() {
        getDatoEdicion().setIDPUERTODESTINO(puerto.getIDPUERTODESTINO());
        RequestContext.getCurrentInstance().update("datos:cntPuerto");
        RequestContext.getCurrentInstance().execute("PF('diagPuert').hide()");
    }

    public Responsable getOp() {
        return op;
    }

    public void setOp(Responsable op) {
        this.op = op;
    }

    public List<Motivo> getLstmotivo() {
        return lstmotivo;
    }

    public void setLstmotivo(List<Motivo> lstmotivo) {
        this.lstmotivo = lstmotivo;
    }

    public Motivo getMot() {
        return mot;
    }

    public void setMot(Motivo mot) {
        this.mot = mot;
    }

    public List<PuertoDestino> getLstpuerto() {
        return lstpuerto;
    }

    public void setLstpuerto(List<PuertoDestino> lstpuerto) {
        this.lstpuerto = lstpuerto;
    }

    public PuertoDestino getPuerto() {
        return puerto;
    }

    public void setPuerto(PuertoDestino puerto) {
        this.puerto = puerto;
    }

    public Dpacking getDpaking() {
        return dpaking;
    }

    public void setDpaking(Dpacking dpaking) {
        this.dpaking = dpaking;
    }

    public List<Dpacking> getLdpacking() {
        return ldpacking;
    }

    public void setLdpacking(List<Dpacking> ldpacking) {
        this.ldpacking = ldpacking;
    }

    public List<Documento> getLstdocs() {
        return lstdocs;
    }

    public void setLstdocs(List<Documento> lstdocs) {
        this.lstdocs = lstdocs;
    }

    public List<NumEmisor> getLstnume() {
        return lstnume;
    }

    public void setLstnume(List<NumEmisor> lstnume) {
        this.lstnume = lstnume;
    }

    public NumEmisorDao getNumemiDao() {
        return numemiDao;
    }

    public void setNumemiDao(NumEmisorDao numemiDao) {
        this.numemiDao = numemiDao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isNuevoD() {
        return nuevoD;
    }

    public void setNuevoD(boolean nuevoD) {
        this.nuevoD = nuevoD;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
