/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
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
@Table(name = "catalogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c"),
    @NamedQuery(name = "Catalogo.findByCodigo", query = "SELECT c FROM Catalogo c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Catalogo.findByDenominaci", query = "SELECT c FROM Catalogo c WHERE c.denominaci = :denominaci"),
    @NamedQuery(name = "Catalogo.findByNroResolu", query = "SELECT c FROM Catalogo c WHERE c.nroResolu = :nroResolu")})
public class Catalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "denominaci")
    private String denominaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nro_resolu")
    private String nroResolu;

    public Catalogo() {
    }

    public Catalogo(String codigo) {
        this.codigo = codigo;
    }

    public Catalogo(String codigo, String denominaci, String nroResolu) {
        this.codigo = codigo;
        this.denominaci = denominaci;
        this.nroResolu = nroResolu;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominaci() {
        return denominaci;
    }

    public void setDenominaci(String denominaci) {
        this.denominaci = denominaci;
    }

    public String getNroResolu() {
        return nroResolu;
    }

    public void setNroResolu(String nroResolu) {
        this.nroResolu = nroResolu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Catalogo[ codigo=" + codigo + " ]";
    }
    
}
