package org.jsuns.commerce.jpa;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNroDoc", query = "SELECT c FROM Cliente c WHERE c.nroDoc = :nroDoc"),
    @NamedQuery(name = "Cliente.findByTipoDoc", query = "SELECT c FROM Cliente c WHERE c.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Cliente.findByNomPer", query = "SELECT c FROM Cliente c WHERE c.nomPer = :nomPer"),
    @NamedQuery(name = "Cliente.findByDirPer", query = "SELECT c FROM Cliente c WHERE c.dirPer = :dirPer"),
    @NamedQuery(name = "Cliente.findByTelPer", query = "SELECT c FROM Cliente c WHERE c.telPer = :telPer"),
    @NamedQuery(name = "Cliente.findByTel2Per", query = "SELECT c FROM Cliente c WHERE c.tel2Per = :tel2Per"),
    @NamedQuery(name = "Cliente.findByEstPer", query = "SELECT c FROM Cliente c WHERE c.estPer = :estPer")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nro_doc")
    private String nroDoc;
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Column(name = "nom_per")
    private String nomPer;
    @Column(name = "dir_per")
    private String dirPer;
    @Column(name = "tel_per")
    private String telPer;
    @Column(name = "tel2_per")
    private String tel2Per;
    @Column(name = "est_per")
    private Character estPer;
    @OneToMany(mappedBy = "cliDoc")
    private Collection<Pedido> pedidoCollection;

    public Cliente() {
    }

    public Cliente(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNombreCompleto() {
        return nomPer;
    }

    public void setNombreCompleto(String nomPer) {
        this.nomPer = nomPer;
    }

    public String getDirPer() {
        return dirPer;
    }

    public void setDireccion(String dirPer) {
        this.dirPer = dirPer;
    }

    public String getTelPer() {
        return telPer;
    }

    public void setTelefono(String telPer) {
        this.telPer = telPer;
    }

    public String getTelefono2() {
        return tel2Per;
    }

    public void setTelefono2(String tel2Per) {
        this.tel2Per = tel2Per;
    }

    public Character getEstPer() {
        return estPer;
    }

    public void setEstPer(Character estPer) {
        this.estPer = estPer;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDoc != null ? nroDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.nroDoc == null && other.nroDoc != null) || (this.nroDoc != null && !this.nroDoc.equals(other.nroDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Cliente[ nroDoc=" + nroDoc + " ]";
    }
    
}
