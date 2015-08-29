/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "estante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estante.findAll", query = "SELECT e FROM Estante e"),
    @NamedQuery(name = "Estante.findByNEstante", query = "SELECT e FROM Estante e WHERE e.nEstante = :nEstante"),
    @NamedQuery(name = "Estante.findByCodBien", query = "SELECT e FROM Estante e WHERE e.codBien = :codBien"),
    @NamedQuery(name = "Estante.findByCorrela", query = "SELECT e FROM Estante e WHERE e.correla = :correla"),
    @NamedQuery(name = "Estante.findByNPisos", query = "SELECT e FROM Estante e WHERE e.nPisos = :nPisos"),
    @NamedQuery(name = "Estante.findByEstado", query = "SELECT e FROM Estante e WHERE e.estado = :estado"),
    @NamedQuery(name = "Estante.findByObservaciones", query = "SELECT e FROM Estante e WHERE e.observaciones = :observaciones")})
public class Estante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_estante")
    private Integer nEstante;
    @Size(max = 8)
    @Column(name = "cod_bien")
    private String codBien;
    @Size(max = 4)
    @Column(name = "correla")
    private String correla;
    @Column(name = "n_pisos")
    private Integer nPisos;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "nEstante")
    private Collection<Archivador> archivadorCollection;

    public Estante() {
    }

    public Estante(Integer nEstante) {
        this.nEstante = nEstante;
    }

    public Integer getNEstante() {
        return nEstante;
    }

    public void setNEstante(Integer nEstante) {
        this.nEstante = nEstante;
    }

    public String getCodBien() {
        return codBien;
    }

    public void setCodBien(String codBien) {
        this.codBien = codBien;
    }

    public String getCorrela() {
        return correla;
    }

    public void setCorrela(String correla) {
        this.correla = correla;
    }

    public Integer getNPisos() {
        return nPisos;
    }

    public void setNPisos(Integer nPisos) {
        this.nPisos = nPisos;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Archivador> getArchivadorCollection() {
        return archivadorCollection;
    }

    public void setArchivadorCollection(Collection<Archivador> archivadorCollection) {
        this.archivadorCollection = archivadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nEstante != null ? nEstante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estante)) {
            return false;
        }
        Estante other = (Estante) object;
        if ((this.nEstante == null && other.nEstante != null) || (this.nEstante != null && !this.nEstante.equals(other.nEstante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Estante[ nEstante=" + nEstante + " ]";
    }
    
}
