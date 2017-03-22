/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Dantena;
import com.nisira.core.entity.DesignPlant;
import com.nisira.core.entity.Dpuertocom;
import com.nisira.core.entity.Equipo;
import com.nisira.core.entity.Procesos;
import com.nisira.core.entity.Puertocom;
import com.nisira.core.entity.DesignPlant;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author azamora
 */
public class DesignPlantDao extends EntityDao<DesignPlant> {

    @Override
    public DesignPlant find(DesignPlant e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DesignPlant> findAll(Object e) throws Exception {
        List<DesignPlant> l = new ArrayList<DesignPlant>();
        int i=1;
        try {
            String sql = "SP_DESIGNPLANT";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(i++,5);
            cl.setString(i++,"");
            cl.setString(i++,"");
            cl.setObject(i++, e);
            rs = cl.executeQuery();
            while (rs.next()) {
                DesignPlant dp = new DesignPlant();
                dp.setIdempresa(rs.getInt("IDEMPRESA"));
                dp.setIdsucursal(rs.getInt("IDSUCURSAL"));
                dp.setIddesignplant(rs.getInt("IDDESIGNPLANT"));
                dp.setType(rs.getString("TYPE"));
                dp.setTypename(rs.getString("TYPENAME"));
                dp.setImgplant(ConvertirImagen(rs.getBytes("IMGPLANT"),dp.getTypename()));
                dp.setEstado(rs.getInt("ESTADO"));
                dp.setFechacreacion(rs.getString("FECHACREACION"));
                dp.setNameimg(rs.getString("NAMEIMG"));
                l.add(dp);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }
    public Image ConvertirImagen(byte[] bytes,String type) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName(type);//jpeg|png|gif
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
    @Override
    public List<DesignPlant> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void grabar(DesignPlant dsp) throws Exception {
    int i=1;
    //DataBaseConeccion db= new DataBaseConeccion(context);
        if(dsp!=null){
            //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
            String sql = "SP_DESIGNPLANT";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setInt(i++,1);
            cl.setString(i++,"");
            cl.setString(i++,"");
            cl.setInt(i++,dsp.getIdempresa());
            cl.setInt(i++,dsp.getIdsucursal());
            cl.setInt(i++,dsp.getIddesignplant());
            cl.setString(i++,dsp.getType());
//                cl.setBinaryStream(i++,dsp.getImgplant());
            cl.setInt(i++,dsp.getEstado());
            cl.setString(i++,dsp.getFechacreacion());
            cl.setString(i++,dsp.getNameimg());
            rs = cl.executeQuery();
        }
    }
}
