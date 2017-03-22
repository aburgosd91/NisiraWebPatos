/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.FacesException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CaptureEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean
@ApplicationScoped
public class CapturaCodigoBarras implements Serializable{
    private String filename;
    public String codigoBarra;
    public CapturaCodigoBarras() {
        codigoBarra="";
    } 
    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);
         
        return String.valueOf(i);
    }
 
    public String getFilename(){
        return filename;
    }
    
    public void sendPhoto(CaptureEvent captureEvent) {
        filename = getRandomImageName();
        byte[] data = captureEvent.getData();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "archivo" + 
                File.separator + "codigobarra" + File.separator + filename + ".jpeg";
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            RequestContext.getCurrentInstance().execute("codigoBarra("+filename+")");
        } catch (IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
 
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish("/codigobarra", "/showcase/javax.faces.archivo/codigobarra/" + filename + ".jpeg.xhtml");
 
    }
    
//    public void oncapture(CaptureEvent captureEvent) {
//        filename = getRandomImageName();
//        byte[] data = captureEvent.getData();
//         
//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        String newFileName = servletContext.getRealPath("") + File.separator + "archivo" + File.separator + "codigobarra" + File.separator + filename + ".jpeg";
//        FileImageOutputStream imageOutput;
//        try {
//            imageOutput = new FileImageOutputStream(new File(newFileName));
//            imageOutput.write(data, 0, data.length);
//            imageOutput.close();
////            filename.substring(filename.indexOf("/"),filename.length()-filename.indexOf("/"));
//            RequestContext.getCurrentInstance().execute("codigoBarra("+filename+")");
//        }
//        catch(IOException e) {
//            throw new FacesException("Error in writing captured image.", e);
//        }
//    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    
    
}
