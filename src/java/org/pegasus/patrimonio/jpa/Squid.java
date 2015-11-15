/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "squid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Squid.findAll", query = "SELECT s FROM Squid s"),
    @NamedQuery(name = "Squid.findByIp", query = "SELECT s FROM Squid s WHERE s.squidPK.ip = :ip"),
    @NamedQuery(name = "Squid.findByPagina", query = "SELECT s FROM Squid s WHERE s.squidPK.pagina = :pagina"),
    @NamedQuery(name = "Squid.findByFecha", query = "SELECT s FROM Squid s WHERE s.squidPK.fecha = :fecha"),
    @NamedQuery(name = "Squid.findByEstado", query = "SELECT s FROM Squid s WHERE s.estado = :estado")})
public class Squid implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SquidPK squidPK;
    @Size(max = 3)
    @Column(name = "estado")
    private String estado;

    public Squid() {
    }

    public Squid(SquidPK squidPK) {
        this.squidPK = squidPK;
    }

    public Squid(String ip, String pagina, Date fecha) {
        this.squidPK = new SquidPK(ip, pagina, fecha);
    }

    public SquidPK getSquidPK() {
        return squidPK;
    }

    public void setSquidPK(SquidPK squidPK) {
        this.squidPK = squidPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (squidPK != null ? squidPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Squid)) {
            return false;
        }
        Squid other = (Squid) object;
        if ((this.squidPK == null && other.squidPK != null) || (this.squidPK != null && !this.squidPK.equals(other.squidPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Squid[ squidPK=" + squidPK + " ]";
    }
    
}
