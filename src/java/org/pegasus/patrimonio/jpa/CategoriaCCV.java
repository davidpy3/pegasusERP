package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria_CCV")
public class CategoriaCCV implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriaCCVPK categoriaCCVPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "porcen")
    private BigDecimal porcen;

    public CategoriaCCV() {
    }

    public CategoriaCCV(CategoriaCCVPK categoriaCCVPK) {
        this.categoriaCCVPK = categoriaCCVPK;
    }

    public CategoriaCCV(String categoria, String codigo) {
        this.categoriaCCVPK = new CategoriaCCVPK(categoria, codigo);
    }

    public CategoriaCCVPK getCategoriaCCVPK() {
        return categoriaCCVPK;
    }

    public void setCategoriaCCVPK(CategoriaCCVPK categoriaCCVPK) {
        this.categoriaCCVPK = categoriaCCVPK;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPorcen() {
        return porcen;
    }

    public void setPorcen(BigDecimal porcen) {
        this.porcen = porcen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaCCVPK != null ? categoriaCCVPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaCCV)) {
            return false;
        }
        CategoriaCCV other = (CategoriaCCV) object;
        if ((this.categoriaCCVPK == null && other.categoriaCCVPK != null) || (this.categoriaCCVPK != null && !this.categoriaCCVPK.equals(other.categoriaCCVPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CategoriaCCV[ categoriaCCVPK=" + categoriaCCVPK + " ]";
    }
    
}
