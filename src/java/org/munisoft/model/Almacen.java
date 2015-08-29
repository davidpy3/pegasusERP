/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a"),
    @NamedQuery(name = "Almacen.findByCodAlmacen", query = "SELECT a FROM Almacen a WHERE a.codAlmacen = :codAlmacen"),
    @NamedQuery(name = "Almacen.findByNombAlmacen", query = "SELECT a FROM Almacen a WHERE a.nombAlmacen = :nombAlmacen"),
    @NamedQuery(name = "Almacen.findByAbrevAlmacen", query = "SELECT a FROM Almacen a WHERE a.abrevAlmacen = :abrevAlmacen"),
    @NamedQuery(name = "Almacen.findByDireccion", query = "SELECT a FROM Almacen a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Almacen.findByTelefono", query = "SELECT a FROM Almacen a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Almacen.findByUbigeo", query = "SELECT a FROM Almacen a WHERE a.ubigeo = :ubigeo"),
    @NamedQuery(name = "Almacen.findByReferencia", query = "SELECT a FROM Almacen a WHERE a.referencia = :referencia"),
    @NamedQuery(name = "Almacen.findByEstado", query = "SELECT a FROM Almacen a WHERE a.estado = :estado")})
public class Almacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_almacen")
    private String codAlmacen;
    @Size(max = 50)
    @Column(name = "nomb_almacen")
    private String nombAlmacen;
    @Size(max = 15)
    @Column(name = "abrev_almacen")
    private String abrevAlmacen;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 6)
    @Column(name = "ubigeo")
    private String ubigeo;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<AlmMovimientoDetalle> almMovimientoDetalleCollection;

    public Almacen() {
    }

    public Almacen(String codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public String getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(String codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public String getNombAlmacen() {
        return nombAlmacen;
    }

    public void setNombAlmacen(String nombAlmacen) {
        this.nombAlmacen = nombAlmacen;
    }

    public String getAbrevAlmacen() {
        return abrevAlmacen;
    }

    public void setAbrevAlmacen(String abrevAlmacen) {
        this.abrevAlmacen = abrevAlmacen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<AlmMovimientoDetalle> getAlmMovimientoDetalleCollection() {
        return almMovimientoDetalleCollection;
    }

    public void setAlmMovimientoDetalleCollection(Collection<AlmMovimientoDetalle> almMovimientoDetalleCollection) {
        this.almMovimientoDetalleCollection = almMovimientoDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlmacen != null ? codAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.codAlmacen == null && other.codAlmacen != null) || (this.codAlmacen != null && !this.codAlmacen.equals(other.codAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Almacen[ codAlmacen=" + codAlmacen + " ]";
    }
    
}
