/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "sectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectores.findAll", query = "SELECT s FROM Sectores s"),
    @NamedQuery(name = "Sectores.findByCodSect", query = "SELECT s FROM Sectores s WHERE s.codSect = :codSect"),
    @NamedQuery(name = "Sectores.findByNombres", query = "SELECT s FROM Sectores s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Sectores.findByAbrev", query = "SELECT s FROM Sectores s WHERE s.abrev = :abrev"),
    @NamedQuery(name = "Sectores.findByEstado", query = "SELECT s FROM Sectores s WHERE s.estado = :estado")})
public class Sectores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_sect")
    private String codSect;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "estado")
    private Character estado;

    public Sectores() {
    }

    public Sectores(String codSect) {
        this.codSect = codSect;
    }

    public Sectores(String codSect, String nombres, String abrev) {
        this.codSect = codSect;
        this.nombres = nombres;
        this.abrev = abrev;
    }

    public String getCodSect() {
        return codSect;
    }

    public void setCodSect(String codSect) {
        this.codSect = codSect;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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
        hash += (codSect != null ? codSect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectores)) {
            return false;
        }
        Sectores other = (Sectores) object;
        if ((this.codSect == null && other.codSect != null) || (this.codSect != null && !this.codSect.equals(other.codSect))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Sectores[ codSect=" + codSect + " ]";
    }
    
}
