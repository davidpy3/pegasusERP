/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c"),
    @NamedQuery(name = "Calendario.findByAnoEje", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.anoEje = :anoEje"),
    @NamedQuery(name = "Calendario.findByMesEje", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.mesEje = :mesEje"),
    @NamedQuery(name = "Calendario.findByFuenteFinanc", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.fuenteFinanc = :fuenteFinanc"),
    @NamedQuery(name = "Calendario.findByTipoCalendario", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.tipoCalendario = :tipoCalendario"),
    @NamedQuery(name = "Calendario.findBySecFun", query = "SELECT c FROM Calendario c WHERE c.calendarioPK.secFun = :secFun"),
    @NamedQuery(name = "Calendario.findByMeta", query = "SELECT c FROM Calendario c WHERE c.meta = :meta"),
    @NamedQuery(name = "Calendario.findByTotalMeta", query = "SELECT c FROM Calendario c WHERE c.totalMeta = :totalMeta")})
public class Calendario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarioPK calendarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "meta")
    private String meta;
    @Column(name = "total_meta")
    private Long totalMeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendario")
    private Collection<CalendarioDet> calendarioDetCollection;

    public Calendario() {
    }

    public Calendario(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    public Calendario(CalendarioPK calendarioPK, String meta) {
        this.calendarioPK = calendarioPK;
        this.meta = meta;
    }

    public Calendario(String anoEje, String mesEje, String fuenteFinanc, Character tipoCalendario, String secFun) {
        this.calendarioPK = new CalendarioPK(anoEje, mesEje, fuenteFinanc, tipoCalendario, secFun);
    }

    public CalendarioPK getCalendarioPK() {
        return calendarioPK;
    }

    public void setCalendarioPK(CalendarioPK calendarioPK) {
        this.calendarioPK = calendarioPK;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Long getTotalMeta() {
        return totalMeta;
    }

    public void setTotalMeta(Long totalMeta) {
        this.totalMeta = totalMeta;
    }

    @XmlTransient
    public Collection<CalendarioDet> getCalendarioDetCollection() {
        return calendarioDetCollection;
    }

    public void setCalendarioDetCollection(Collection<CalendarioDet> calendarioDetCollection) {
        this.calendarioDetCollection = calendarioDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarioPK != null ? calendarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.calendarioPK == null && other.calendarioPK != null) || (this.calendarioPK != null && !this.calendarioPK.equals(other.calendarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Calendario[ calendarioPK=" + calendarioPK + " ]";
    }
    
}
