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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "oficinas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o"),
    @NamedQuery(name = "Oficina.findByCodarea", query = "SELECT o FROM Oficina o WHERE o.oficinaPK.codarea = :codarea"),
    @NamedQuery(name = "Oficina.findByCodoficina", query = "SELECT o FROM Oficina o WHERE o.oficinaPK.codoficina = :codoficina"),
    @NamedQuery(name = "Oficina.findByCodlocal", query = "SELECT o FROM Oficina o WHERE o.codlocal = :codlocal"),
    @NamedQuery(name = "Oficina.findByOficina", query = "SELECT o FROM Oficina o WHERE o.oficina = :oficina"),
    @NamedQuery(name = "Oficina.findByAbrev", query = "SELECT o FROM Oficina o WHERE o.abrev = :abrev")})
public class Oficina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OficinaPK oficinaPK;
    @Size(max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Size(max = 100)
    @Column(name = "oficina")
    private String oficina;
    @Size(max = 10)
    @Column(name = "abrev")
    private String abrev;
    @JoinColumn(name = "codarea", referencedColumnName = "codarea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;

    public Oficina() {
    }

    public Oficina(OficinaPK oficinaPK) {
        this.oficinaPK = oficinaPK;
    }

    public Oficina(String codarea, String codoficina) {
        this.oficinaPK = new OficinaPK(codarea, codoficina);
    }

    public OficinaPK getOficinaPK() {
        return oficinaPK;
    }

    public void setOficinaPK(OficinaPK oficinaPK) {
        this.oficinaPK = oficinaPK;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oficinaPK != null ? oficinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.oficinaPK == null && other.oficinaPK != null) || (this.oficinaPK != null && !this.oficinaPK.equals(other.oficinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Oficina[ oficinaPK=" + oficinaPK + " ]";
    }
    
}
