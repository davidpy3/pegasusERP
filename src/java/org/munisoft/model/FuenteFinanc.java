/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "fuente_financ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuenteFinanc.findAll", query = "SELECT f FROM FuenteFinanc f"),
    @NamedQuery(name = "FuenteFinanc.findByAnoEje", query = "SELECT f FROM FuenteFinanc f WHERE f.fuenteFinancPK.anoEje = :anoEje"),
    @NamedQuery(name = "FuenteFinanc.findByFuenteFinanc", query = "SELECT f FROM FuenteFinanc f WHERE f.fuenteFinancPK.fuenteFinanc = :fuenteFinanc"),
    @NamedQuery(name = "FuenteFinanc.findByNombre", query = "SELECT f FROM FuenteFinanc f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FuenteFinanc.findByAbrev", query = "SELECT f FROM FuenteFinanc f WHERE f.abrev = :abrev"),
    @NamedQuery(name = "FuenteFinanc.findByEstado", query = "SELECT f FROM FuenteFinanc f WHERE f.estado = :estado")})
public class FuenteFinanc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuenteFinancPK fuenteFinancPK;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "estado")
    private Character estado;

    public FuenteFinanc() {
    }

    public FuenteFinanc(FuenteFinancPK fuenteFinancPK) {
        this.fuenteFinancPK = fuenteFinancPK;
    }

    public FuenteFinanc(String anoEje, String fuenteFinanc) {
        this.fuenteFinancPK = new FuenteFinancPK(anoEje, fuenteFinanc);
    }

    public FuenteFinancPK getFuenteFinancPK() {
        return fuenteFinancPK;
    }

    public void setFuenteFinancPK(FuenteFinancPK fuenteFinancPK) {
        this.fuenteFinancPK = fuenteFinancPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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
        hash += (fuenteFinancPK != null ? fuenteFinancPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuenteFinanc)) {
            return false;
        }
        FuenteFinanc other = (FuenteFinanc) object;
        if ((this.fuenteFinancPK == null && other.fuenteFinancPK != null) || (this.fuenteFinancPK != null && !this.fuenteFinancPK.equals(other.fuenteFinancPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.FuenteFinanc[ fuenteFinancPK=" + fuenteFinancPK + " ]";
    }
    
}
