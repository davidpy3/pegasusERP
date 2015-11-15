package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "tipoBien")
public class TipoBien implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBien")
    private Collection<Bien> mBienes0Collection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codbien")
    private String codbien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcio")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correla")
    private int correla;
    @Column(name = "tipo")
    private Character tipo;
    
    public TipoBien() {
    }

    public String getCodbien() {
        return codbien;
    }

    public void setCodbien(String codbien) {
        this.codbien = codbien;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCorrela() {
        return correla;
    }

    public void setCorrela(int correla) {
        this.correla = correla;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Bien> getMbienes0Collection() {
        return mBienes0Collection;
    }

    public void setMbienes0Collection(Collection<Bien> mBienes0Collection) {
        this.mBienes0Collection = mBienes0Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbien != null ? codbien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoBien)) {
            return false;
        }
        TipoBien other = (TipoBien) object;
        if ((this.codbien == null && other.codbien != null) || (this.codbien != null && !this.codbien.equals(other.codbien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Tipobien[ codbien=" + codbien + " ]";
    }

    @XmlTransient
    public Collection<Bien> getMBienes0Collection() {
        return mBienes0Collection;
    }

    public void setMBienes0Collection(Collection<Bien> mBienes0Collection) {
        this.mBienes0Collection = mBienes0Collection;
    }
    
}
