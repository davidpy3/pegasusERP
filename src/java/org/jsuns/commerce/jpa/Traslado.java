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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.jsuns.app.User;

@Entity
@Table(name = "son_traslado")
public class Traslado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_traslado")
    private Integer idTraslado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "origen")
    private String origen;
    @Column(name = "destino")
    private String destino;
    @Column(name = "ruc_dest")
    private Integer rucDest;
    @Column(name = "raz_soc_dest")
    private String razSocDest;
    @Column(name = "nro_doc")
    private Integer nroDoc;
    @Column(name = "ser_doc")
    private Integer serDoc;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @Column(name = "ruc_trans")
    private String rucTrans;
    @Basic(optional = false)
    @Column(name = "raz_trans")
    private String razTrans;
    @Basic(optional = false)
    @Column(name = "marca_veh")
    private String marcaVeh;
    @Basic(optional = false)
    @Column(name = "placa_veh")
    private String placaVeh;
    @Basic(optional = false)
    @Column(name = "brevete")
    private String brevete;
    @Basic(optional = false)
    @Column(name = "constancia")
    private String constancia;
    @Basic(optional = false)
    @Column(name = "chofer")
    private String chofer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traslado")
    private Collection<TrasladoArticulo> trasladoArticuloCollection;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User nick;

    public Traslado() {
    }

    public Integer getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Integer idTraslado) {
        this.idTraslado = idTraslado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getRucDest() {
        return rucDest;
    }

    public void setRucDest(Integer rucDest) {
        this.rucDest = rucDest;
    }

    public String getRazSocDest() {
        return razSocDest;
    }

    public void setRazSocDest(String razSocDest) {
        this.razSocDest = razSocDest;
    }

    public Integer getNumero() {
        return nroDoc;
    }

    public void setNumero(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public Integer getSerie() {
        return serDoc;
    }

    public void setSerie(Integer serDoc) {
        this.serDoc = serDoc;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRucTrans() {
        return rucTrans;
    }

    public void setRucTrans(String rucTrans) {
        this.rucTrans = rucTrans;
    }

    public String getRazTrans() {
        return razTrans;
    }

    public void setRazTrans(String razTrans) {
        this.razTrans = razTrans;
    }

    public String getMarcaVeh() {
        return marcaVeh;
    }

    public void setMarcaVeh(String marcaVeh) {
        this.marcaVeh = marcaVeh;
    }

    public String getPlacaVeh() {
        return placaVeh;
    }

    public void setPlacaVeh(String placaVeh) {
        this.placaVeh = placaVeh;
    }

    public String getBrevete() {
        return brevete;
    }

    public void setBrevete(String brevete) {
        this.brevete = brevete;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    @XmlTransient
    public Collection<TrasladoArticulo> getTrasladoArticuloCollection() {
        return trasladoArticuloCollection;
    }

    public void setTrasladoArticuloCollection(Collection<TrasladoArticulo> trasladoArticuloCollection) {
        this.trasladoArticuloCollection = trasladoArticuloCollection;
    }

    public User getNick() {
        return nick;
    }

    public void setNick(User nick) {
        this.nick = nick;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTraslado != null ? idTraslado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traslado)) {
            return false;
        }
        Traslado other = (Traslado) object;
        if ((this.idTraslado == null && other.idTraslado != null) || (this.idTraslado != null && !this.idTraslado.equals(other.idTraslado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Traslado[ idTraslado=" + idTraslado + " ]";
    }
    
}
