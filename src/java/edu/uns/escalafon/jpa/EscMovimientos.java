/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscMovimientos.findAll", query = "SELECT e FROM EscMovimientos e"),
    @NamedQuery(name = "EscMovimientos.findByIdMov", query = "SELECT e FROM EscMovimientos e WHERE e.idMov = :idMov"),
    @NamedQuery(name = "EscMovimientos.findByMovimiento", query = "SELECT e FROM EscMovimientos e WHERE e.movimiento = :movimiento"),
    @NamedQuery(name = "EscMovimientos.findByAbrev", query = "SELECT e FROM EscMovimientos e WHERE e.abrev = :abrev")})
public class EscMovimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mov")
    private Short idMov;
    @Basic(optional = false)
    @Column(name = "movimiento")
    private String movimiento;
    @Basic(optional = false)
    @Column(name = "abrev")
    private String abrev;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMov")
    private List<EscCarreraLaboral> escCarreraLaboralList;

    public EscMovimientos() {
    }

    public EscMovimientos(Short idMov) {
        this.idMov = idMov;
    }

    public EscMovimientos(Short idMov, String movimiento, String abrev) {
        this.idMov = idMov;
        this.movimiento = movimiento;
        this.abrev = abrev;
    }

    public Short getIdMov() {
        return idMov;
    }

    public void setIdMov(Short idMov) {
        this.idMov = idMov;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMov != null ? idMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscMovimientos)) {
            return false;
        }
        EscMovimientos other = (EscMovimientos) object;
        if ((this.idMov == null && other.idMov != null) || (this.idMov != null && !this.idMov.equals(other.idMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscMovimientos[ idMov=" + idMov + " ]";
    }
    
}
