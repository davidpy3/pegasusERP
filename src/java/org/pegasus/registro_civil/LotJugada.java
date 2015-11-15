/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "lot_jugada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LotJugada.findAll", query = "SELECT l FROM LotJugada l"),
    @NamedQuery(name = "LotJugada.findBySorteo", query = "SELECT l FROM LotJugada l WHERE l.sorteo = :sorteo"),
    @NamedQuery(name = "LotJugada.findByFecha", query = "SELECT l FROM LotJugada l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LotJugada.findByJugadaO", query = "SELECT l FROM LotJugada l WHERE l.jugadaO = :jugadaO"),
    @NamedQuery(name = "LotJugada.findByJugada", query = "SELECT l FROM LotJugada l WHERE l.jugada = :jugada")})
public class LotJugada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sorteo")
    private Integer sorteo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jugada_o")
    private String jugadaO;
    @Size(max = 20)
    @Column(name = "jugada")
    private String jugada;

    public LotJugada() {
    }

    public LotJugada(Integer sorteo) {
        this.sorteo = sorteo;
    }

    public LotJugada(Integer sorteo, Date fecha, String jugadaO) {
        this.sorteo = sorteo;
        this.fecha = fecha;
        this.jugadaO = jugadaO;
    }

    public Integer getSorteo() {
        return sorteo;
    }

    public void setSorteo(Integer sorteo) {
        this.sorteo = sorteo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getJugadaO() {
        return jugadaO;
    }

    public void setJugadaO(String jugadaO) {
        this.jugadaO = jugadaO;
    }

    public String getJugada() {
        return jugada;
    }

    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sorteo != null ? sorteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LotJugada)) {
            return false;
        }
        LotJugada other = (LotJugada) object;
        if ((this.sorteo == null && other.sorteo != null) || (this.sorteo != null && !this.sorteo.equals(other.sorteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.registro_civil.LotJugada[ sorteo=" + sorteo + " ]";
    }
    
}
