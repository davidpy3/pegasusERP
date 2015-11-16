package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "com_operacion_venta")
public class ComOperacionVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Column(name = "id_dir_vendedor")
    private Integer idDirVendedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir_cliente")
    private int idDirCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa_impuesto")
    private float tasaImpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private float subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private float impuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pagado")
    private Float pagado;

    public ComOperacionVenta() {
    }

    public ComOperacionVenta(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ComOperacionVenta(Integer idOperacion, int idDirCliente, float tasaImpuesto, float subTotal, float impuesto, float total) {
        this.idOperacion = idOperacion;
        this.idDirCliente = idDirCliente;
        this.tasaImpuesto = tasaImpuesto;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdDirVendedor() {
        return idDirVendedor;
    }

    public void setIdDirVendedor(Integer idDirVendedor) {
        this.idDirVendedor = idDirVendedor;
    }

    public int getIdDirCliente() {
        return idDirCliente;
    }

    public void setIdDirCliente(int idDirCliente) {
        this.idDirCliente = idDirCliente;
    }

    public float getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(float tasaImpuesto) {
        this.tasaImpuesto = tasaImpuesto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Float getPagado() {
        return pagado;
    }

    public void setPagado(Float pagado) {
        this.pagado = pagado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOperacionVenta)) {
            return false;
        }
        ComOperacionVenta other = (ComOperacionVenta) object;
        if ((this.idOperacion == null && other.idOperacion != null) || 
                (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacionVenta[ idOperacion=" + idOperacion + " ]";
    }
    
}
