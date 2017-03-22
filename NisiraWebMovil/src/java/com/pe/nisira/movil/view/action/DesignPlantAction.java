/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DesignPlantDao;
import com.nisira.core.dao.TipoEstanteriaDao;
import com.nisira.core.entity.DesignPlant;
import com.nisira.core.entity.TipoEstanteria;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.imageio.ImageIO;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
@ManagedBean(name = "designPlantAction")
@SessionScoped
public class DesignPlantAction  extends AbstactListAction<DesignPlant> implements Serializable {
    private UsuarioBean user;
    private DesignPlantDao designPlantDao;
    private List<TipoEstanteria> listTipoEstanteria;
    private TipoEstanteriaDao tipoEstanteriaDao;
    private TipoEstanteria selectTipoEstanteria;
    private UploadedFile file;
    private boolean edic;
    /**
     * Creates a new instance of DesignPlant
     */
    public DesignPlantAction() {
        designPlantDao = new DesignPlantDao();
        listTipoEstanteria = new ArrayList<>();
        tipoEstanteriaDao = new  TipoEstanteriaDao();
        selectTipoEstanteria = new TipoEstanteria();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_DesignPlant");
    }
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        //String local = event.getFile().getFileName() ;
        try {
            this.file = event.getFile();            
            if(file != null) {
                byte[] data  = event.getFile().getContents();
                InputStream input= new BufferedInputStream(new ByteArrayInputStream(data));
                Image img = ImageIO.read(input);
                BufferedImage bimg = WebUtil.imageToBufferedImage(img);
                getDatoEdicion().setImgplant(img);
                getDatoEdicion().setNameimg(this.file.getFileName());
                getDatoEdicion().setType(this.file.getContentType());
                getDatoEdicion().setHeight(bimg.getHeight());
                getDatoEdicion().setWidth(bimg.getWidth());
                RequestContext.getCurrentInstance().update("datos");
                
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void getActionAbrirShow() {
        RequestContext.getCurrentInstance().execute("PF('dlg_uploadPlant').show()");
        return;
    }
    public void findTipoEstanteria(){
        try {
            setListTipoEstanteria(getTipoEstanteriaDao().findAll());
            RequestContext.getCurrentInstance().update("datos:tipoEstanteria");
        } catch (Exception ex) {
            Logger.getLogger(RfidreaderAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void buscarTodo() {
        try {
            setListaDatos(designPlantDao.findAll(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(ConfInicioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doNuevo() throws IOException {        
        nuevo();
        pag_acceso(getEdt_name());
        setLadd(1);
    }
    @Override
    public void doEditar() {
        setLadd(2);
        edic = false;
    }
    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            setDatoEdicion(getDatoSeleccionado());
            pag_acceso(getEdt_name());
            setLadd(1);
            edic = false;
        }
    }
    @Override
    public String getIniciar() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_DesignPlant");
        return "";
    }
    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new DesignPlant());
            getDatoEdicion().setEstado(1);
//            RequestContext.getCurrentInstance().update("datos:listaPend");
        } catch (Exception ex) {
            Logger.getLogger(DesignPlantAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void grabar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEdic() {
        return edic;
    }

    public void setEdic(boolean edic) {
        this.edic = edic;
    }

    /**
     * @return the listTipoEstanteria
     */
    public List<TipoEstanteria> getListTipoEstanteria() {
        return listTipoEstanteria;
    }

    /**
     * @param listTipoEstanteria the listTipoEstanteria to set
     */
    public void setListTipoEstanteria(List<TipoEstanteria> listTipoEstanteria) {
        this.listTipoEstanteria = listTipoEstanteria;
    }

    /**
     * @return the tipoEstanteriaDao
     */
    public TipoEstanteriaDao getTipoEstanteriaDao() {
        return tipoEstanteriaDao;
    }

    /**
     * @param tipoEstanteriaDao the tipoEstanteriaDao to set
     */
    public void setTipoEstanteriaDao(TipoEstanteriaDao tipoEstanteriaDao) {
        this.tipoEstanteriaDao = tipoEstanteriaDao;
    }

    /**
     * @return the selectTipoEstanteria
     */
    public TipoEstanteria getSelectTipoEstanteria() {
        return selectTipoEstanteria;
    }

    /**
     * @param selectTipoEstanteria the selectTipoEstanteria to set
     */
    public void setSelectTipoEstanteria(TipoEstanteria selectTipoEstanteria) {
        this.selectTipoEstanteria = selectTipoEstanteria;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
}
