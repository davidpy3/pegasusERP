/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "sgc_autoevaluacion_ref")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAutoevaluacionRef.findAll", query = "SELECT s FROM SgcAutoevaluacionRef s"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByIdAutref", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.idAutref = :idAutref"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByIdAutoevaluacion", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByIdFuente", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.idFuente = :idFuente"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByFase", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.fase = :fase"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByIdDir", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByEstado", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.estado = :estado"),
    @NamedQuery(name = "SgcAutoevaluacionRef.findByFechaReg", query = "SELECT s FROM SgcAutoevaluacionRef s WHERE s.fechaReg = :fechaReg")})
public class SgcAutoevaluacionRef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_autref")
    private Integer idAutref;
    @Basic(optional = false)
    @Column(name = "id_autoevaluacion")
    private int idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private int idFuente;
    @Basic(optional = false)
    @Column(name = "fase")
    private Character fase;
    @Lob
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;

    public SgcAutoevaluacionRef() {
    }

    public SgcAutoevaluacionRef(Integer idAutref) {
        this.idAutref = idAutref;
    }

    public SgcAutoevaluacionRef(Integer idAutref, int idAutoevaluacion, int idFuente, Character fase, int idDir, Character estado, Date fechaReg) {
        this.idAutref = idAutref;
        this.idAutoevaluacion = idAutoevaluacion;
        this.idFuente = idFuente;
        this.fase = fase;
        this.idDir = idDir;
        this.estado = estado;
        this.fechaReg = fechaReg;
    }

    public Integer getIdAutref() {
        return idAutref;
    }

    public void setIdAutref(Integer idAutref) {
        this.idAutref = idAutref;
    }

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(int idFuente) {
        this.idFuente = idFuente;
    }

    public Character getFase() {
        return fase;
    }

    public void setFase(Character fase) {
        this.fase = fase;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutref != null ? idAutref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAutoevaluacionRef)) {
            return false;
        }
        SgcAutoevaluacionRef other = (SgcAutoevaluacionRef) object;
        if ((this.idAutref == null && other.idAutref != null) || (this.idAutref != null && !this.idAutref.equals(other.idAutref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAutoevaluacionRef[ idAutref=" + idAutref + " ]";
    }
    
}
