/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "archivador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivador.findAll", query = "SELECT a FROM Archivador a"),
    @NamedQuery(name = "Archivador.findByAnoEje", query = "SELECT a FROM Archivador a WHERE a.archivadorPK.anoEje = :anoEje"),
    @NamedQuery(name = "Archivador.findByNArchivador", query = "SELECT a FROM Archivador a WHERE a.archivadorPK.nArchivador = :nArchivador"),
    @NamedQuery(name = "Archivador.findByNPiso", query = "SELECT a FROM Archivador a WHERE a.nPiso = :nPiso"),
    @NamedQuery(name = "Archivador.findBySecFunc", query = "SELECT a FROM Archivador a WHERE a.secFunc = :secFunc"),
    @NamedQuery(name = "Archivador.findByEstado", query = "SELECT a FROM Archivador a WHERE a.estado = :estado")})
public class Archivador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArchivadorPK archivadorPK;
    @Column(name = "n_piso")
    private Integer nPiso;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "n_estante", referencedColumnName = "n_estante")
    @ManyToOne
    private Estante nEstante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "archivador")
    private Collection<ArchiDetalle> archiDetalleCollection;

    public Archivador() {
    }

    public Archivador(ArchivadorPK archivadorPK) {
        this.archivadorPK = archivadorPK;
    }

    public Archivador(String anoEje, int nArchivador) {
        this.archivadorPK = new ArchivadorPK(anoEje, nArchivador);
    }

    public ArchivadorPK getArchivadorPK() {
        return archivadorPK;
    }

    public void setArchivadorPK(ArchivadorPK archivadorPK) {
        this.archivadorPK = archivadorPK;
    }

    public Integer getNPiso() {
        return nPiso;
    }

    public void setNPiso(Integer nPiso) {
        this.nPiso = nPiso;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Estante getNEstante() {
        return nEstante;
    }

    public void setNEstante(Estante nEstante) {
        this.nEstante = nEstante;
    }

    @XmlTransient
    public Collection<ArchiDetalle> getArchiDetalleCollection() {
        return archiDetalleCollection;
    }

    public void setArchiDetalleCollection(Collection<ArchiDetalle> archiDetalleCollection) {
        this.archiDetalleCollection = archiDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archivadorPK != null ? archivadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivador)) {
            return false;
        }
        Archivador other = (Archivador) object;
        if ((this.archivadorPK == null && other.archivadorPK != null) || (this.archivadorPK != null && !this.archivadorPK.equals(other.archivadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Archivador[ archivadorPK=" + archivadorPK + " ]";
    }
    
}
