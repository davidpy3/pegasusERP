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
@Table(name = "esc_turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTurno.findAll", query = "SELECT e FROM EscTurno e"),
    @NamedQuery(name = "EscTurno.findByIdTurno", query = "SELECT e FROM EscTurno e WHERE e.idTurno = :idTurno"),
    @NamedQuery(name = "EscTurno.findByTurno", query = "SELECT e FROM EscTurno e WHERE e.turno = :turno"),
    @NamedQuery(name = "EscTurno.findByTolerancia", query = "SELECT e FROM EscTurno e WHERE e.tolerancia = :tolerancia")})
public class EscTurno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_turno")
    private Short idTurno;
    @Basic(optional = false)
    @Column(name = "turno")
    private String turno;
    @Column(name = "tolerancia")
    private Short tolerancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private List<EscGrupoHorario> escGrupoHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private List<EscPersHorario> escPersHorarioList;

    public EscTurno() {
    }

    public EscTurno(Short idTurno) {
        this.idTurno = idTurno;
    }

    public EscTurno(Short idTurno, String turno) {
        this.idTurno = idTurno;
        this.turno = turno;
    }

    public Short getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Short idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Short getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Short tolerancia) {
        this.tolerancia = tolerancia;
    }

    @XmlTransient
    public List<EscGrupoHorario> getEscGrupoHorarioList() {
        return escGrupoHorarioList;
    }

    public void setEscGrupoHorarioList(List<EscGrupoHorario> escGrupoHorarioList) {
        this.escGrupoHorarioList = escGrupoHorarioList;
    }

    @XmlTransient
    public List<EscPersHorario> getEscPersHorarioList() {
        return escPersHorarioList;
    }

    public void setEscPersHorarioList(List<EscPersHorario> escPersHorarioList) {
        this.escPersHorarioList = escPersHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurno != null ? idTurno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTurno)) {
            return false;
        }
        EscTurno other = (EscTurno) object;
        if ((this.idTurno == null && other.idTurno != null) || (this.idTurno != null && !this.idTurno.equals(other.idTurno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTurno[ idTurno=" + idTurno + " ]";
    }
    
}
