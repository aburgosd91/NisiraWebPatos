package com.nisira.core.service;

import com.nisira.core.business.AleatorioBusiness;
import com.nisira.core.entity.Aleatorio;
import java.util.List;

/**
 *
 * @author jcuzco
 *         
 */
public class AleatorioService extends BaseService<Aleatorio>{
    private AleatorioBusiness AleatorioBusiness = new AleatorioBusiness();
    
    public AleatorioService(){
        super.setBaseBusiness(AleatorioBusiness);
        
    }

}
