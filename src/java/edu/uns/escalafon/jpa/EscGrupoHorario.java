/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "esc_grupo_horario")
public class EscGrupoHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @Column(name = "hora_in")
    @Temporal(TemporalType.TIME)
    private Date horaIn;
    @Basic(optional = false)
    @Column(name = "hora_out")
    @Temporal(TemporalType.TIME)
    private Date horaOut;
    @Column(name = "hora_refrigerio")
    @Temporal(TemporalType.TIME)
    private Date horaRefrigerio;
    @Column(name = "hora_retorno")
    @Temporal(TemporalType.TIME)
    private Date horaRetorno;
    @Column(name = "tolerancia_refrigerio")
    private Short toleranciaRefrigerio;
    @Basic(optional = false)
    @Column(name = "lunes")
    private boolean lunes;
    @Basic(optional = false)
    @Column(name = "martes")
    private boolean martes;
    @Basic(optional = false)
    @Column(name = "miercoles")
    private boolean miercoles;
    @Basic(optional = false)
    @Column(name = "jueves")
    private boolean jueves;
    @Basic(optional = false)
    @Column(name = "viernes")
    private boolean viernes;
    @Basic(optional = false)
    @Column(name = "sabado")
    private boolean sabado;
    @Basic(optional = false)
    @Column(name = "domingo")
    private boolean domingo;
    @Column(name = "id_dep")
    private Integer idDep;
    @JoinTable(name = "esc_horario_pers", joinColumns = {
        @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")}, inverseJoinColumns = {
        @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")})
    @ManyToMany
    private List<EscPersonal> escPersonalList;
    @JoinColumn(name = "id_turno", referencedColumnName = "id_turno")
    @ManyToOne(optional = false)
    private EscTurno idTurno;

    public EscGrupoHorario() {
    }

    public EscGrupoHorario(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public EscGrupoHorario(Integer idGrupo, Date horaIn, Date horaOut, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
        this.idGrupo = idGrupo;
        this.horaIn = horaIn;
        this.horaOut = horaOut;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
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

    public Date getHoraRefrigerio() {
        return horaRefrigerio;
    }

    public void setHoraRefrigerio(Date horaRefrigerio) {
        this.horaRefrigerio = horaRefrigerio;
    }

    public Date getHoraRetorno() {
        return horaRetorno;
    }

    public void setHoraRetorno(Date horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    public Short getToleranciaRefrigerio() {
        return toleranciaRefrigerio;
    }

    public void setToleranciaRefrigerio(Short toleranciaRefrigerio) {
        this.toleranciaRefrigerio = toleranciaRefrigerio;
    }

    public boolean getLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean getMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean getJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean getViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean getSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    @XmlTransient
    public List<EscPersonal> getEscPersonalList() {
        return escPersonalList;
    }

    public void setEscPersonalList(List<EscPersonal> escPersonalList) {
        this.escPersonalList = escPersonalList;
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
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscGrupoHorario)) {
            return false;
        }
        EscGrupoHorario other = (EscGrupoHorario) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscGrupoHorario[ idGrupo=" + idGrupo + " ]";
    }
    
}
