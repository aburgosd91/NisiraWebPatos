
package com.nisira.core.business;
 
import com.nisira.core.dao.AleatorioDAO;
import com.nisira.core.entity.Aleatorio;
import java.util.List;

/**
 *
 * @author jcuzco
 */
public class AleatorioBusiness extends BaseBusiness<Aleatorio> {

     private AleatorioDAO AleatorioDAO = new AleatorioDAO();
    
    public AleatorioBusiness(){
        super.setBaseDao(AleatorioDAO);
    }
    
}
