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
@Table(name = "esc_nombramientos_doc")
public class EscNombramientosDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nomd")
    private Integer idNomd;
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
    @Column(name = "horas")
    private Short horas;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCapDocente escCapDocente;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;

    public EscNombramientosDoc() {
    }

    public EscNombramientosDoc(Integer idNomd) {
        this.idNomd = idNomd;
    }

    public EscNombramientosDoc(Integer idNomd, Date fechaNomb, String idDtra) {
        this.idNomd = idNomd;
        this.fechaNomb = fechaNomb;
        this.idDtra = idDtra;
    }

    public Integer getIdNomd() {
        return idNomd;
    }

    public void setIdNomd(Integer idNomd) {
        this.idNomd = idNomd;
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

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public EscCapDocente getEscCapDocente() {
        return escCapDocente;
    }

    public void setEscCapDocente(EscCapDocente escCapDocente) {
        this.escCapDocente = escCapDocente;
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
        hash += (idNomd != null ? idNomd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscNombramientosDoc)) {
            return false;
        }
        EscNombramientosDoc other = (EscNombramientosDoc) object;
        if ((this.idNomd == null && other.idNomd != null) || (this.idNomd != null && !this.idNomd.equals(other.idNomd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscNombramientosDoc[ idNomd=" + idNomd + " ]";
    }
    
}
