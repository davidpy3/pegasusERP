/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "inventario_detalle")
public class InventarioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioDetallePK inventarioDetallePK;
    @Column(name = "flg_verificado")
    private Character flgVerificado;
    @Size(max = 20)
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "fecha_verifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVerifica;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "num_inv", referencedColumnName = "num_inv", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Inventario inventario;
//    
//    @JoinColumns({
//        @JoinColumn(name = "codbien", referencedColumnName = "codbien", insertable = false, updatable = false
//                ,foreignKey=@ForeignKey(value=ConstraintMode.NO_CONSTRAINT)
//        ),
//        @JoinColumn(name = "correla", referencedColumnName = "correla", insertable = false, updatable = false
//                ,foreignKey=@ForeignKey(value=ConstraintMode.NO_CONSTRAINT)
//        )}
//    )
//    @ManyToOne(optional = true)
////    @NotFound()
    @Transient
    private Bien bien;

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }
//    
    public InventarioDetalle() {
    }

    public InventarioDetalle(InventarioDetallePK inventarioDetallePK) {
        this.inventarioDetallePK = inventarioDetallePK;
    }

    public InventarioDetalle(String anoEje, String numInv, String codbien, String correla) {
        this.inventarioDetallePK = new InventarioDetallePK(anoEje, numInv, codbien, correla);
    }

    public InventarioDetallePK getInventarioDetallePK() {
        return inventarioDetallePK;
    }

    public void setInventarioDetallePK(InventarioDetallePK inventarioDetallePK) {
        this.inventarioDetallePK = inventarioDetallePK;
    }

    public Character getFlgVerificado() {
        return flgVerificado;
    }

    public void setFlgVerificado(Character flgVerificado) {
        this.flgVerificado = flgVerificado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFechaVerifica() {
        return fechaVerifica;
    }

    public void setFechaVerifica(Date fechaVerifica) {
        this.fechaVerifica = fechaVerifica;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioDetallePK != null ? inventarioDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDetalle)) {
            return false;
        }
        InventarioDetalle other = (InventarioDetalle) object;
        if ((this.inventarioDetallePK == null && other.inventarioDetallePK != null) || (this.inventarioDetallePK != null && !this.inventarioDetallePK.equals(other.inventarioDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.InventarioDetalle[ inventarioDetallePK=" + inventarioDetallePK + " ]";
    }
    
}
