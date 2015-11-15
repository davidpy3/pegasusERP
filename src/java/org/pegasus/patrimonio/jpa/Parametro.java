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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p"),
    @NamedQuery(name = "Parametro.findByIdParam", query = "SELECT p FROM Parametro p WHERE p.parametroPK.idParam = :idParam"),
    @NamedQuery(name = "Parametro.findByNombre", query = "SELECT p FROM Parametro p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parametro.findByAbrev", query = "SELECT p FROM Parametro p WHERE p.abrev = :abrev"),
    @NamedQuery(name = "Parametro.findByFechaIni", query = "SELECT p FROM Parametro p WHERE p.parametroPK.fechaIni = :fechaIni"),
    @NamedQuery(name = "Parametro.findByFechaFin", query = "SELECT p FROM Parametro p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Parametro.findByValor", query = "SELECT p FROM Parametro p WHERE p.valor = :valor")})
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParametroPK parametroPK;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 20)
    @Column(name = "valor")
    private String valor;

    public Parametro() {
    }

    public Parametro(ParametroPK parametroPK) {
        this.parametroPK = parametroPK;
    }

    public Parametro(int idParam, Date fechaIni) {
        this.parametroPK = new ParametroPK(idParam, fechaIni);
    }

    public ParametroPK getParametroPK() {
        return parametroPK;
    }

    public void setParametroPK(ParametroPK parametroPK) {
        this.parametroPK = parametroPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametroPK != null ? parametroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.parametroPK == null && other.parametroPK != null) || (this.parametroPK != null && !this.parametroPK.equals(other.parametroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Parametro[ parametroPK=" + parametroPK + " ]";
    }
    
}
