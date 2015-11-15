/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "tipo_papeleta")
@NamedQueries({
    @NamedQuery(name = "TipoPapeleta.findAll", query = "SELECT t FROM TipoPapeleta t")})
public class TipoPapeleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_pape")
    private String tipoPape;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;

    public TipoPapeleta() {
    }

    public TipoPapeleta(String tipoPape) {
        this.tipoPape = tipoPape;
    }

    public String getTipoPape() {
        return tipoPape;
    }

    public void setTipoPape(String tipoPape) {
        this.tipoPape = tipoPape;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPape != null ? tipoPape.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPapeleta)) {
            return false;
        }
        TipoPapeleta other = (TipoPapeleta) object;
        if ((this.tipoPape == null && other.tipoPape != null) || (this.tipoPape != null && !this.tipoPape.equals(other.tipoPape))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TipoPapeleta[ tipoPape=" + tipoPape + " ]";
    }
    
}
