package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Patri_Mov_Detalle")
public class PatriMovimientoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PatriMovimientoDetPK patriMovimientoDetPK;
    @Size(max = 13)
    @Column(name = "ubica_bien")
    private String ubicaBien;
    @JoinColumns({
        @JoinColumn(name = "codbien", referencedColumnName = "codbien", insertable = false, updatable = false),
        @JoinColumn(name = "correla", referencedColumnName = "correla", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Bien bien;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_mov", referencedColumnName = "tipo_mov", insertable = false, updatable = false),
        @JoinColumn(name = "num_mov", referencedColumnName = "num_mov", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PatriMovimiento patriMovimiento;

    public PatriMovimientoDet() {
    }

    public PatriMovimientoDet(PatriMovimientoDetPK patriMovimientoDetPK) {
        this.patriMovimientoDetPK = patriMovimientoDetPK;
    }

    public PatriMovimientoDet(String anoEje, Character tipoMov, String numMov, String codbien, String correla) {
        this.patriMovimientoDetPK = new PatriMovimientoDetPK(anoEje, tipoMov, numMov, codbien, correla);
    }

    public PatriMovimientoDetPK getPatriMovimientoDetPK() {
        return patriMovimientoDetPK;
    }

    public void setPatriMovimientoDetPK(PatriMovimientoDetPK patriMovimientoDetPK) {
        this.patriMovimientoDetPK = patriMovimientoDetPK;
    }

    public String getUbicaBien() {
        return ubicaBien;
    }

    public void setUbicaBien(String ubicaBien) {
        this.ubicaBien = ubicaBien;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public PatriMovimiento getPatriMovimiento() {
        return patriMovimiento;
    }

    public void setPatriMovimiento(PatriMovimiento patriMovimiento) {
        this.patriMovimiento = patriMovimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patriMovimientoDetPK != null ? patriMovimientoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatriMovimientoDet)) {
            return false;
        }
        PatriMovimientoDet other = (PatriMovimientoDet) object;
        if ((this.patriMovimientoDetPK == null && other.patriMovimientoDetPK != null) || (this.patriMovimientoDetPK != null && !this.patriMovimientoDetPK.equals(other.patriMovimientoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PatriMovimientoDet[ patriMovimientoDetPK=" + patriMovimientoDetPK + " ]";
    }
    
}
