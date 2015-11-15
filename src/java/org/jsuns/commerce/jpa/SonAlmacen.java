package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "son_almacen")
public class SonAlmacen implements Serializable {
    @OneToMany(mappedBy = "almacen")
    private Collection<Caja> cajaCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private Integer idAlmacen;
    @Column(name = "nom_alm")
    private String nombre;
    @Column(name = "dir_alm")
    private String direccion;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "raz_soc")
    private String razon_social;
    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Lob
    @Column(name = "cuenta")
    private String cuenta;
    @Basic(optional = false)
    @Column(name = "telefono1")
    private String telefono1;
    @Basic(optional = false)
    @Column(name = "telefono2")
    private String telefono2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<Oferta> ofertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<Empleado> empleadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlmacen")
    private Collection<Kardex> kardexCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacen")
    private Collection<AlmacenArticulo> almacenArticuloCollection;


    public SonAlmacen(){}

    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nomAlm) {
        this.nombre = nomAlm;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dirAlm) {
        this.direccion = dirAlm;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRazonSocial() {
        return razon_social;
    }

    public void setRazonSocial(String razSoc) {
        this.razon_social = razSoc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Kardex> getKardexCollection() {
        return kardexCollection;
    }

    public void setKardexCollection(Collection<Kardex> kardexCollection) {
        this.kardexCollection = kardexCollection;
    }

    @XmlTransient
    public Collection<AlmacenArticulo> getAlmacenArticuloCollection() {
        return almacenArticuloCollection;
    }

    public void setAlmacenArticuloCollection(Collection<AlmacenArticulo> almacenArticuloCollection) {
        this.almacenArticuloCollection = almacenArticuloCollection;
    }

    @XmlTransient
    public Collection<Caja> getCajaCollection() {
        return cajaCollection;
    }

    public void setCajaCollection(Collection<Caja> cajaCollection) {
        this.cajaCollection = cajaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlmacen != null ? idAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SonAlmacen)) {
            return false;
        }
        SonAlmacen other = (SonAlmacen) object;
        if ((this.idAlmacen == null && other.idAlmacen != null) || (this.idAlmacen != null && !this.idAlmacen.equals(other.idAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Almacen[ idAlmacen=" + idAlmacen + " ]";
    }

    
}
