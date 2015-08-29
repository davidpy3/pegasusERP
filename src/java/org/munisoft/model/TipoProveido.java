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
@Table(name = "tipo_proveido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProveido.findAll", query = "SELECT t FROM TipoProveido t"),
    @NamedQuery(name = "TipoProveido.findByCodProveido", query = "SELECT t FROM TipoProveido t WHERE t.codProveido = :codProveido"),
    @NamedQuery(name = "TipoProveido.findByNombre", query = "SELECT t FROM TipoProveido t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoProveido.findByEstado", query = "SELECT t FROM TipoProveido t WHERE t.estado = :estado")})
public class TipoProveido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_proveido")
    private Integer codProveido;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;

    public TipoProveido() {
    }

    public TipoProveido(Integer codProveido) {
        this.codProveido = codProveido;
    }

    public Integer getCodProveido() {
        return codProveido;
    }

    public void setCodProveido(Integer codProveido) {
        this.codProveido = codProveido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (codProveido != null ? codProveido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProveido)) {
            return false;
        }
        TipoProveido other = (TipoProveido) object;
        if ((this.codProveido == null && other.codProveido != null) || (this.codProveido != null && !this.codProveido.equals(other.codProveido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoProveido[ codProveido=" + codProveido + " ]";
    }
    
}
