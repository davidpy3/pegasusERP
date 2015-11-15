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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "esc_capacitacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCapacitacion.findAll", query = "SELECT e FROM EscCapacitacion e"),
    @NamedQuery(name = "EscCapacitacion.findById", query = "SELECT e FROM EscCapacitacion e WHERE e.id = :id"),
    @NamedQuery(name = "EscCapacitacion.findByCapacitacion", query = "SELECT e FROM EscCapacitacion e WHERE e.capacitacion = :capacitacion"),
    @NamedQuery(name = "EscCapacitacion.findByFechaIni", query = "SELECT e FROM EscCapacitacion e WHERE e.fechaIni = :fechaIni"),
    @NamedQuery(name = "EscCapacitacion.findByFechaFin", query = "SELECT e FROM EscCapacitacion e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EscCapacitacion.findByHoras", query = "SELECT e FROM EscCapacitacion e WHERE e.horas = :horas"),
    @NamedQuery(name = "EscCapacitacion.findByHorasText", query = "SELECT e FROM EscCapacitacion e WHERE e.horasText = :horasText"),
    @NamedQuery(name = "EscCapacitacion.findByMencion", query = "SELECT e FROM EscCapacitacion e WHERE e.mencion = :mencion")})
public class EscCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "capacitacion")
    private String capacitacion;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "horas")
    private Short horas;
    @Column(name = "horas_text")
    private String horasText;
    @Column(name = "mencion")
    private String mencion;
    @JoinColumn(name = "id_cc", referencedColumnName = "id_cc")
    @ManyToOne(optional = false)
    private EscCondicionCap idCc;
    @JoinColumn(name = "id_inst", referencedColumnName = "id_inst")
    @ManyToOne(optional = false)
    private EscInstituciones idInst;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal escPersonal;
    @JoinColumn(name = "id_tc", referencedColumnName = "id_tc")
    @ManyToOne(optional = false)
    private EscTipoCap idTc;

    public EscCapacitacion() {
    }

    public EscCapacitacion(Integer id) {
        this.id = id;
    }

    public EscCapacitacion(Integer id, String capacitacion, Date fechaIni) {
        this.id = id;
        this.capacitacion = capacitacion;
        this.fechaIni = fechaIni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(String capacitacion) {
        this.capacitacion = capacitacion;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public String getHorasText() {
        return horasText;
    }

    public void setHorasText(String horasText) {
        this.horasText = horasText;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public EscCondicionCap getIdCc() {
        return idCc;
    }

    public void setIdCc(EscCondicionCap idCc) {
        this.idCc = idCc;
    }

    public EscInstituciones getIdInst() {
        return idInst;
    }

    public void setIdInst(EscInstituciones idInst) {
        this.idInst = idInst;
    }

    public EscPersonal getIdEsc() {
        return escPersonal;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.escPersonal = idEsc;
    }

    public EscTipoCap getIdTc() {
        return idTc;
    }

    public void setIdTc(EscTipoCap idTc) {
        this.idTc = idTc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCapacitacion)) {
            return false;
        }
        EscCapacitacion other = (EscCapacitacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCapacitacion[ id=" + id + " ]";
    }
    
}
