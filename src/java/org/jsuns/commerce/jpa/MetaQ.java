package org.jsuns.commerce.jpa;

import org.jsuns.data.Q;

public class MetaQ extends Q{

    public MetaQ(){
        this.setQuery("SELECT concat(monto,'-',fecha_ini) FROM meta");
    }
    
}
