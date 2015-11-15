/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;

/**
 *
 * @author TOSHIBA
 */
public class RequerimientoPK implements Serializable {
    private String anoEje;
    private char clasificador;
    private int numero;

    public RequerimientoPK() {
    }

    public RequerimientoPK(String anoEje, char clasificador, int numero) {
        this.anoEje = anoEje;
        this.clasificador = clasificador;
        this.numero = numero;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public char getClasificador() {
        return clasificador;
    }

    public void setClasificador(char clasificador) {
        this.clasificador = clasificador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
