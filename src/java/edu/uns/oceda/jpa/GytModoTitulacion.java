/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "gyt_modo_titulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GytModoTitulacion.findAll", query = "SELECT g FROM GytModoTitulacion g"),
    @NamedQuery(name = "GytModoTitulacion.findByIdModtit", query = "SELECT g FROM GytModoTitulacion g WHERE g.idModtit = :idModtit"),
    @NamedQuery(name = "GytModoTitulacion.findByModoTitulacion", query = "SELECT g FROM GytModoTitulacion g WHERE g.modoTitulacion = :modoTitulacion")})
public class GytModoTitulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_modtit")
    private String idModtit;
    @Basic(optional = false)
    @Column(name = "modo_titulacion")
    private String modoTitulacion;

    public GytModoTitulacion() {
    }

    public GytModoTitulacion(String idModtit) {
        this.idModtit = idModtit;
    }

    public GytModoTitulacion(String idModtit, String modoTitulacion) {
        this.idModtit = idModtit;
        this.modoTitulacion = modoTitulacion;
    }

    public String getIdModtit() {
        return idModtit;
    }

    public void setIdModtit(String idModtit) {
        this.idModtit = idModtit;
    }

    public String getModoTitulacion() {
        return modoTitulacion;
    }

    public void setModoTitulacion(String modoTitulacion) {
        this.modoTitulacion = modoTitulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModtit != null ? idModtit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GytModoTitulacion)) {
            return false;
        }
        GytModoTitulacion other = (GytModoTitulacion) object;
        if ((this.idModtit == null && other.idModtit != null) || (this.idModtit != null && !this.idModtit.equals(other.idModtit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.model.GytModoTitulacion[ idModtit=" + idModtit + " ]";
    }
    
}
