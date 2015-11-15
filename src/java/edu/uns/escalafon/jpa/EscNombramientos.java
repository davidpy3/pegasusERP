/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esc_nombramientos")
public class EscNombramientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nom")
    private Integer idNom;
    @Basic(optional = false)
    @Column(name = "fecha_nomb")
    @Temporal(TemporalType.DATE)
    private Date fechaNomb;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCap escCap;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;

    public EscNombramientos() {
    }

    public EscNombramientos(Integer idNom) {
        this.idNom = idNom;
    }

    public EscNombramientos(Integer idNom, Date fechaNomb, String idDtra) {
        this.idNom = idNom;
        this.fechaNomb = fechaNomb;
        this.idDtra = idDtra;
    }

    public Integer getIdNom() {
        return idNom;
    }

    public void setIdNom(Integer idNom) {
        this.idNom = idNom;
    }

    public Date getFechaNomb() {
        return fechaNomb;
    }

    public void setFechaNomb(Date fechaNomb) {
        this.fechaNomb = fechaNomb;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EscCap getEscCap() {
        return escCap;
    }

    public void setEscCap(EscCap escCap) {
        this.escCap = escCap;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNom != null ? idNom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscNombramientos)) {
            return false;
        }
        EscNombramientos other = (EscNombramientos) object;
        if ((this.idNom == null && other.idNom != null) || (this.idNom != null && !this.idNom.equals(other.idNom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscNombramientos[ idNom=" + idNom + " ]";
    }
    
}
