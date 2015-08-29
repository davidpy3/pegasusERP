/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;

/**
 *
 * @author TOSHIBA
 */
public class PlanillaPK implements Serializable {
    private int expediente;
    private int anioEje;

    public PlanillaPK(int expediente, int anioEje) {
        this.expediente = expediente;
        this.anioEje = anioEje;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public int getAnioEje() {
        return anioEje;
    }

    public void setAnioEje(int anioEje) {
        this.anioEje = anioEje;
    }
    
    
}
