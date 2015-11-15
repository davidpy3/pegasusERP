package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "hcc")
@NamedQueries({
    @NamedQuery(name = "Hcc.findAll", query = "SELECT h FROM Hcc h")})
public class Hcc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HccPK hccPK;
    @Column(name = "mes")
    private String mes;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "cod_doc")
    private String codDoc;
    @Column(name = "num_doc")
    private String numDoc;
    @Column(name = "ruc")
    private String ruc;
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Column(name = "sec_func")
    private String secFunc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "n_reg_siaf")
    private Integer nRegSiaf;
    @Column(name = "estado")
    private Character estado;

    public Hcc() {
    }

    public Hcc(HccPK hccPK) {
        this.hccPK = hccPK;
    }

    public Hcc(String anoEje, int nHcc) {
        this.hccPK = new HccPK(anoEje, nHcc);
    }

    public HccPK getHccPK() {
        return hccPK;
    }

    public void setHccPK(HccPK hccPK) {
        this.hccPK = hccPK;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getNRegSiaf() {
        return nRegSiaf;
    }

    public void setNRegSiaf(Integer nRegSiaf) {
        this.nRegSiaf = nRegSiaf;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hccPK != null ? hccPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hcc)) {
            return false;
        }
        Hcc other = (Hcc) object;
        if ((this.hccPK == null && other.hccPK != null) || (this.hccPK != null && !this.hccPK.equals(other.hccPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Hcc[ hccPK=" + hccPK + " ]";
    }
    
}
