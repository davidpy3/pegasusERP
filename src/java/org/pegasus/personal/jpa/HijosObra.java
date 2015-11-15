/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Hijos_Obra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HijosObra.findAll", query = "SELECT h FROM HijosObra h"),
    @NamedQuery(name = "HijosObra.findByDocuiden", query = "SELECT h FROM HijosObra h WHERE h.hijosObraPK.docuiden = :docuiden"),
    @NamedQuery(name = "HijosObra.findByNhijo", query = "SELECT h FROM HijosObra h WHERE h.hijosObraPK.nhijo = :nhijo"),
    @NamedQuery(name = "HijosObra.findByApat", query = "SELECT h FROM HijosObra h WHERE h.apat = :apat"),
    @NamedQuery(name = "HijosObra.findByAmat", query = "SELECT h FROM HijosObra h WHERE h.amat = :amat"),
    @NamedQuery(name = "HijosObra.findByNombres", query = "SELECT h FROM HijosObra h WHERE h.nombres = :nombres"),
    @NamedQuery(name = "HijosObra.findByFechanac", query = "SELECT h FROM HijosObra h WHERE h.fechanac = :fechanac"),
    @NamedQuery(name = "HijosObra.findByNPartida", query = "SELECT h FROM HijosObra h WHERE h.nPartida = :nPartida"),
    @NamedQuery(name = "HijosObra.findByCentroEstudios", query = "SELECT h FROM HijosObra h WHERE h.centroEstudios = :centroEstudios"),
    @NamedQuery(name = "HijosObra.findByEstado", query = "SELECT h FROM HijosObra h WHERE h.estado = :estado")})
public class HijosObra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HijosObraPK hijosObraPK;
    @Size(max = 20)
    @Column(name = "apat")
    private String apat;
    @Size(max = 20)
    @Column(name = "amat")
    private String amat;
    @Size(max = 20)
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "fechanac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanac;
    @Size(max = 50)
    @Column(name = "n_partida")
    private String nPartida;
    @Size(max = 80)
    @Column(name = "centro_estudios")
    private String centroEstudios;
    @Column(name = "estado")
    private Character estado;

    public HijosObra() {
    }

    public HijosObra(HijosObraPK hijosObraPK) {
        this.hijosObraPK = hijosObraPK;
    }

    public HijosObra(String docuiden, int nhijo) {
        this.hijosObraPK = new HijosObraPK(docuiden, nhijo);
    }

    public HijosObraPK getHijosObraPK() {
        return hijosObraPK;
    }

    public void setHijosObraPK(HijosObraPK hijosObraPK) {
        this.hijosObraPK = hijosObraPK;
    }

    public String getApat() {
        return apat;
    }

    public void setApat(String apat) {
        this.apat = apat;
    }

    public String getAmat() {
        return amat;
    }

    public void setAmat(String amat) {
        this.amat = amat;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getNPartida() {
        return nPartida;
    }

    public void setNPartida(String nPartida) {
        this.nPartida = nPartida;
    }

    public String getCentroEstudios() {
        return centroEstudios;
    }

    public void setCentroEstudios(String centroEstudios) {
        this.centroEstudios = centroEstudios;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hijosObraPK != null ? hijosObraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HijosObra)) {
            return false;
        }
        HijosObra other = (HijosObra) object;
        if ((this.hijosObraPK == null && other.hijosObraPK != null) || (this.hijosObraPK != null && !this.hijosObraPK.equals(other.hijosObraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.HijosObra[ hijosObraPK=" + hijosObraPK + " ]";
    }
    
}
