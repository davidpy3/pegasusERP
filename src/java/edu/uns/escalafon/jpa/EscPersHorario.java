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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_pers_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscPersHorario.findAll", query = "SELECT e FROM EscPersHorario e"),
    @NamedQuery(name = "EscPersHorario.findByIdEsc", query = "SELECT e FROM EscPersHorario e WHERE e.escPersHorarioPK.idEsc = :idEsc"),
    @NamedQuery(name = "EscPersHorario.findByDia", query = "SELECT e FROM EscPersHorario e WHERE e.escPersHorarioPK.dia = :dia"),
    @NamedQuery(name = "EscPersHorario.findByHoraIn", query = "SELECT e FROM EscPersHorario e WHERE e.horaIn = :horaIn"),
    @NamedQuery(name = "EscPersHorario.findByHoraOut", query = "SELECT e FROM EscPersHorario e WHERE e.horaOut = :horaOut"),
    @NamedQuery(name = "EscPersHorario.findByJornada", query = "SELECT e FROM EscPersHorario e WHERE e.escPersHorarioPK.jornada = :jornada")})
public class EscPersHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscPersHorarioPK escPersHorarioPK;
    @Basic(optional = false)
    @Column(name = "hora_in")
    @Temporal(TemporalType.TIME)
    private Date horaIn;
    @Basic(optional = false)
    @Column(name = "hora_out")
    @Temporal(TemporalType.TIME)
    private Date horaOut;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EscPersonal escPersonal;
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")
    @ManyToOne(optional = false)
    private EscTurno idTurno;

    public EscPersHorario() {
    }

    public EscPersHorario(EscPersHorarioPK escPersHorarioPK) {
        this.escPersHorarioPK = escPersHorarioPK;
    }

    public EscPersHorario(EscPersHorarioPK escPersHorarioPK, Date horaIn, Date horaOut) {
        this.escPersHorarioPK = escPersHorarioPK;
        this.horaIn = horaIn;
        this.horaOut = horaOut;
    }

    public EscPersHorario(int idEsc, short dia, short jornada) {
        this.escPersHorarioPK = new EscPersHorarioPK(idEsc, dia, jornada);
    }

    public EscPersHorarioPK getEscPersHorarioPK() {
        return escPersHorarioPK;
    }

    public void setEscPersHorarioPK(EscPersHorarioPK escPersHorarioPK) {
        this.escPersHorarioPK = escPersHorarioPK;
    }

    public Date getHoraIn() {
        return horaIn;
    }

    public void setHoraIn(Date horaIn) {
        this.horaIn = horaIn;
    }

    public Date getHoraOut() {
        return horaOut;
    }

    public void setHoraOut(Date horaOut) {
        this.horaOut = horaOut;
    }

    public EscPersonal getEscPersonal() {
        return escPersonal;
    }

    public void setEscPersonal(EscPersonal escPersonal) {
        this.escPersonal = escPersonal;
    }

    public EscTurno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(EscTurno idTurno) {
        this.idTurno = idTurno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escPersHorarioPK != null ? escPersHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPersHorario)) {
            return false;
        }
        EscPersHorario other = (EscPersHorario) object;
        if ((this.escPersHorarioPK == null && other.escPersHorarioPK != null) || (this.escPersHorarioPK != null && !this.escPersHorarioPK.equals(other.escPersHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscPersHorario[ escPersHorarioPK=" + escPersHorarioPK + " ]";
    }
    
}
