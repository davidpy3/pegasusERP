package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Oferta.findByNomOfer", query = "SELECT o FROM Oferta o WHERE o.nomOfer = :nomOfer"),
    @NamedQuery(name = "Oferta.findByFechaOfer", query = "SELECT o FROM Oferta o WHERE o.fechaOfer = :fechaOfer"),
    @NamedQuery(name = "Oferta.findByFechaVenc", query = "SELECT o FROM Oferta o WHERE o.fechaVenc = :fechaVenc"),
    @NamedQuery(name = "Oferta.findByEstado", query = "SELECT o FROM Oferta o WHERE o.estado = :estado")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private Integer idOferta;
    @Column(name = "nom_ofer")
    private String nomOfer;
    @Column(name = "fecha_ofer")
    @Temporal(TemporalType.DATE)
    private Date fechaOfer;
    @Column(name = "fecha_venc")
    @Temporal(TemporalType.DATE)
    private Date fechaVenc;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private Collection<OfertaDetalle> ofertaDetalleCollection;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne(optional = false)
    private SonAlmacen idAlmacen;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getNomOfer() {
        return nomOfer;
    }

    public void setNomOfer(String nomOfer) {
        this.nomOfer = nomOfer;
    }

    public Date getFechaOfer() {
        return fechaOfer;
    }

    public void setFechaOfer(Date fechaOfer) {
        this.fechaOfer = fechaOfer;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<OfertaDetalle> getOfertaDetalleCollection() {
        return ofertaDetalleCollection;
    }

    public void setOfertaDetalleCollection(Collection<OfertaDetalle> ofertaDetalleCollection) {
        this.ofertaDetalleCollection = ofertaDetalleCollection;
    }

    public SonAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SonAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
