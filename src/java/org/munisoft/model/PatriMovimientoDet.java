/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "Patri_Mov_Detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatriMovimientoDet.findAll", query = "SELECT p FROM PatriMovimientoDet p"),
    @NamedQuery(name = "PatriMovimientoDet.findByAnoEje", query = "SELECT p FROM PatriMovimientoDet p WHERE p.patriMovimientoDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "PatriMovimientoDet.findByTipoMov", query = "SELECT p FROM PatriMovimientoDet p WHERE p.patriMovimientoDetPK.tipoMov = :tipoMov"),
    @NamedQuery(name = "PatriMovimientoDet.findByNumMov", query = "SELECT p FROM PatriMovimientoDet p WHERE p.patriMovimientoDetPK.numMov = :numMov"),
    @NamedQuery(name = "PatriMovimientoDet.findByCodbien", query = "SELECT p FROM PatriMovimientoDet p WHERE p.patriMovimientoDetPK.codbien = :codbien"),
    @NamedQuery(name = "PatriMovimientoDet.findByCorrela", query = "SELECT p FROM PatriMovimientoDet p WHERE p.patriMovimientoDetPK.correla = :correla"),
    @NamedQuery(name = "PatriMovimientoDet.findByUbicaBien", query = "SELECT p FROM PatriMovimientoDet p WHERE p.ubicaBien = :ubicaBien")})
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
    private MBienes0 mbienes0;
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

    public MBienes0 getMbienes0() {
        return mbienes0;
    }

    public void setMbienes0(MBienes0 mbienes0) {
        this.mbienes0 = mbienes0;
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
