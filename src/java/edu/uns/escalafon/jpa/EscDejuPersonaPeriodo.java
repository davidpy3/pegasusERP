/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_deju_persona_periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscDejuPersonaPeriodo.findAll", query = "SELECT e FROM EscDejuPersonaPeriodo e"),
    @NamedQuery(name = "EscDejuPersonaPeriodo.findByIdEsc", query = "SELECT e FROM EscDejuPersonaPeriodo e WHERE e.escDejuPersonaPeriodoPK.idEsc = :idEsc"),
    @NamedQuery(name = "EscDejuPersonaPeriodo.findByIdPeriodo", query = "SELECT e FROM EscDejuPersonaPeriodo e WHERE e.escDejuPersonaPeriodoPK.idPeriodo = :idPeriodo")})
public class EscDejuPersonaPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscDejuPersonaPeriodoPK escDejuPersonaPeriodoPK;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EscDejuPeriodo escDejuPeriodo;

    public EscDejuPersonaPeriodo() {
    }

    public EscDejuPersonaPeriodo(EscDejuPersonaPeriodoPK escDejuPersonaPeriodoPK) {
        this.escDejuPersonaPeriodoPK = escDejuPersonaPeriodoPK;
    }

    public EscDejuPersonaPeriodo(int idEsc, int idPeriodo) {
        this.escDejuPersonaPeriodoPK = new EscDejuPersonaPeriodoPK(idEsc, idPeriodo);
    }

    public EscDejuPersonaPeriodoPK getEscDejuPersonaPeriodoPK() {
        return escDejuPersonaPeriodoPK;
    }

    public void setEscDejuPersonaPeriodoPK(EscDejuPersonaPeriodoPK escDejuPersonaPeriodoPK) {
        this.escDejuPersonaPeriodoPK = escDejuPersonaPeriodoPK;
    }

    public EscDejuPeriodo getEscDejuPeriodo() {
        return escDejuPeriodo;
    }

    public void setEscDejuPeriodo(EscDejuPeriodo escDejuPeriodo) {
        this.escDejuPeriodo = escDejuPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escDejuPersonaPeriodoPK != null ? escDejuPersonaPeriodoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscDejuPersonaPeriodo)) {
            return false;
        }
        EscDejuPersonaPeriodo other = (EscDejuPersonaPeriodo) object;
        if ((this.escDejuPersonaPeriodoPK == null && other.escDejuPersonaPeriodoPK != null) || (this.escDejuPersonaPeriodoPK != null && !this.escDejuPersonaPeriodoPK.equals(other.escDejuPersonaPeriodoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDejuPersonaPeriodo[ escDejuPersonaPeriodoPK=" + escDejuPersonaPeriodoPK + " ]";
    }
    
}
