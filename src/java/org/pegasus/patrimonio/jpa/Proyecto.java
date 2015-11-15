/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProy", query = "SELECT p FROM Proyecto p WHERE p.idProy = :idProy"),
    @NamedQuery(name = "Proyecto.findByActProy", query = "SELECT p FROM Proyecto p WHERE p.actProy = :actProy"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findBySnip", query = "SELECT p FROM Proyecto p WHERE p.snip = :snip"),
    @NamedQuery(name = "Proyecto.findByMonto", query = "SELECT p FROM Proyecto p WHERE p.monto = :monto")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proy")
    private Integer idProy;
    @Size(max = 7)
    @Column(name = "act_proy")
    private String actProy;
    @Size(max = 256)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 6)
    @Column(name = "snip")
    private String snip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;

    public Proyecto() {
    }

    public Proyecto(Integer idProy) {
        this.idProy = idProy;
    }

    public Integer getIdProy() {
        return idProy;
    }

    public void setIdProy(Integer idProy) {
        this.idProy = idProy;
    }

    public String getActProy() {
        return actProy;
    }

    public void setActProy(String actProy) {
        this.actProy = actProy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSnip() {
        return snip;
    }

    public void setSnip(String snip) {
        this.snip = snip;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProy != null ? idProy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProy == null && other.idProy != null) || (this.idProy != null && !this.idProy.equals(other.idProy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Proyecto[ idProy=" + idProy + " ]";
    }
    
}
