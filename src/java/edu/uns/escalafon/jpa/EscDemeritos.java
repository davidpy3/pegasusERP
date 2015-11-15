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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "esc_demeritos")
public class EscDemeritos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Column(name = "dias_sancion")
    private Short diasSancion;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "fecha_dem")
    @Temporal(TemporalType.DATE)
    private Date fechaDem;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<EscReposiciones> escReposicionesList;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_tf", referencedColumnName = "id_tf")
    @ManyToOne(optional = false)
    private EscTipoFalta idTf;
    @JoinColumn(name = "id_ts", referencedColumnName = "id_ts")
    @ManyToOne(optional = false)
    private EscTipoSancion idTs;

    public EscDemeritos() {
    }

    public EscDemeritos(Integer id) {
        this.id = id;
    }

    public EscDemeritos(Integer id, String idDtra, Date fechaDem, boolean activo) {
        this.id = id;
        this.idDtra = idDtra;
        this.fechaDem = fechaDem;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public Short getDiasSancion() {
        return diasSancion;
    }

    public void setDiasSancion(Short diasSancion) {
        this.diasSancion = diasSancion;
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

    public Date getFechaDem() {
        return fechaDem;
    }

    public void setFechaDem(Date fechaDem) {
        this.fechaDem = fechaDem;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<EscReposiciones> getEscReposicionesList() {
        return escReposicionesList;
    }

    public void setEscReposicionesList(List<EscReposiciones> escReposicionesList) {
        this.escReposicionesList = escReposicionesList;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipoFalta getIdTf() {
        return idTf;
    }

    public void setIdTf(EscTipoFalta idTf) {
        this.idTf = idTf;
    }

    public EscTipoSancion getIdTs() {
        return idTs;
    }

    public void setIdTs(EscTipoSancion idTs) {
        this.idTs = idTs;
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
        if (!(object instanceof EscDemeritos)) {
            return false;
        }
        EscDemeritos other = (EscDemeritos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDemeritos[ id=" + id + " ]";
    }
    
}
