/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.util;


import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public final class CoreUtil {

    /**
     * Obtiene una lista de parametros con el tipo de dato que es
     * @param obj La clase 
     * @return Una lista de parametros con la informacion del objeto
     */
    public static List<Parametro> listaParametros(Object obj) {
        List<Parametro> listaParametros = new ArrayList<Parametro>();
        Field[] campos = obj.getClass().getDeclaredFields();
        String nombreClase = obj.getClass().getName();
        nombreClase = nombreClase.substring(nombreClase.lastIndexOf(".") + 1);
        for (Field c : campos) {
            String tipo = c.getType().getName();
            tipo = tipo.substring(tipo.lastIndexOf(".") + 1);
            listaParametros.add(new Parametro(nombreClase, c.getName(), tipo));
        }
        return listaParametros;
    }
    
    /**
     * Obtiene el nombre dela clase
     * @param obj La clase
     * @return Un tipo String con el nombre de la clase
     */
    public static String nombreClase(Object obj){
        String nombreClase = obj.getClass().getName();
	nombreClase = nombreClase.substring(nombreClase.lastIndexOf(".") + 1);
        return nombreClase;
    }
    
    public static String consulta(String procedureName, int cantidad) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{CALL ").append(procedureName).append("(");
        for (int i = 0; i < cantidad; i++) {
            if (i <= cantidad - 2) {
                sb.append("?,");
            } else {
                sb.append("?");
            }
        }
        sb.append(")}");
        return sb.toString();
    }
     public static ArrayList<String> valoresBase() {
        File f = new File(Constantes.RUTA_BASE);
        BufferedReader entrada;
        //String[] prop = new String[5];
        ArrayList<String> prop = new ArrayList<String>();
        try {
            entrada = new BufferedReader(new FileReader(f));
            String linea;
            int pos = 0;
            while (entrada.ready()) {
                linea = entrada.readLine();
                linea.trim();
                //prop[pos] = linea.substring(linea.indexOf("=") + 1, linea.length());
                String valor = linea.substring(linea.indexOf("=") + 1, linea.length());
                prop.add(valor);
                pos++;
            }
            entrada.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    public static String isNull(String variable,String mostrar){
        return variable==null?mostrar:variable;
    }
    public static int xCien(int dato){
        return (int)(dato/100);
    }
    public static String fechaEspaniol(String fecha){
        if(fecha!=null && !fecha.equals("")){
            fecha=fecha.substring(0,10);
            String anio=fecha.substring(0,4);
            String dia=fecha.substring(8,10);
            return dia+'-'+fecha.substring(5,7)+'-'+anio;
        }else
            return fecha;
        
    }
    public static String fechaHoraEspaniol(String fecha){
        if(fecha!=null && !fecha.equals("")){
            String anio = fecha.substring(0,4);
            String mes = fecha.substring(5,7);
            String dia = fecha.substring(8,10);
            String hora=fecha.substring(11,19);
            return anio+'-'+mes+'-'+dia+' '+hora;
        }else
            return fecha;
    }
    public static String fechaConvert112(String fecha){
        if(fecha!=null && !fecha.equals("")){
            fecha=fecha.substring(0,10);
            String anio=fecha.substring(0,4);
            String mes=fecha.substring(5,7);
            String dia=fecha.substring(8,10);
            return anio+mes+dia;
        }else{
            return fecha;
        }
        
    }
    public static String XmlToString(String clase,Object objecto) throws ClassNotFoundException{
        Class oClase =  Class.forName(clase);
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream= new XStream();
        xStream.processAnnotations(oClase);
//        return xml + xStream.toXML(objecto);
        return xml+xStream.toXML(objecto);
    }
    public void crearXML(String clase,Object objecto, String ruta) throws FileNotFoundException, ClassNotFoundException{
        Class oClase =  Class.forName(clase);
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream= new XStream();
        xStream.processAnnotations(oClase);
        xStream.toXML(objecto, new FileOutputStream(ruta));
    }
}
