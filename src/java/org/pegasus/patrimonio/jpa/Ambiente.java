/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "ambientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambiente.findAll", query = "SELECT a FROM Ambiente a"),
    @NamedQuery(name = "Ambiente.findByCodlocal", query = "SELECT a FROM Ambiente a WHERE a.ambientePK.codlocal = :codlocal"),
    @NamedQuery(name = "Ambiente.findByCodambiente", query = "SELECT a FROM Ambiente a WHERE a.ambientePK.codambiente = :codambiente"),
    @NamedQuery(name = "Ambiente.findByAmbiente", query = "SELECT a FROM Ambiente a WHERE a.ambiente = :ambiente"),
    @NamedQuery(name = "Ambiente.findByEstado", query = "SELECT a FROM Ambiente a WHERE a.estado = :estado")})
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AmbientePK ambientePK;
    @Size(max = 75)
    @Column(name = "ambiente")
    private String ambiente;
    @Column(name = "estado")
    private Character estado;

    public Ambiente() {
    }

    public Ambiente(AmbientePK ambientePK) {
        this.ambientePK = ambientePK;
    }

    public Ambiente(String codlocal, String codambiente) {
        this.ambientePK = new AmbientePK(codlocal, codambiente);
    }

    public AmbientePK getAmbientePK() {
        return ambientePK;
    }

    public void setAmbientePK(AmbientePK ambientePK) {
        this.ambientePK = ambientePK;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
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
        hash += (ambientePK != null ? ambientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.ambientePK == null && other.ambientePK != null) || (this.ambientePK != null && !this.ambientePK.equals(other.ambientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Ambiente[ ambientePK=" + ambientePK + " ]";
    }
    
}
