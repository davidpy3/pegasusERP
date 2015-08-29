/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "locales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l"),
    @NamedQuery(name = "Locales.findByCodlocal", query = "SELECT l FROM Locales l WHERE l.codlocal = :codlocal"),
    @NamedQuery(name = "Locales.findByNombreLocal", query = "SELECT l FROM Locales l WHERE l.nombreLocal = :nombreLocal"),
    @NamedQuery(name = "Locales.findByDireccion", query = "SELECT l FROM Locales l WHERE l.direccion = :direccion"),
    @NamedQuery(name = "Locales.findByNumMun", query = "SELECT l FROM Locales l WHERE l.numMun = :numMun"),
    @NamedQuery(name = "Locales.findByDscMz", query = "SELECT l FROM Locales l WHERE l.dscMz = :dscMz"),
    @NamedQuery(name = "Locales.findByDscLote", query = "SELECT l FROM Locales l WHERE l.dscLote = :dscLote"),
    @NamedQuery(name = "Locales.findByCtdArea", query = "SELECT l FROM Locales l WHERE l.ctdArea = :ctdArea"),
    @NamedQuery(name = "Locales.findByFlgUm", query = "SELECT l FROM Locales l WHERE l.flgUm = :flgUm"),
    @NamedQuery(name = "Locales.findByFlgTiporeg", query = "SELECT l FROM Locales l WHERE l.flgTiporeg = :flgTiporeg"),
    @NamedQuery(name = "Locales.findByDscAsiento", query = "SELECT l FROM Locales l WHERE l.dscAsiento = :dscAsiento"),
    @NamedQuery(name = "Locales.findByDscFojas", query = "SELECT l FROM Locales l WHERE l.dscFojas = :dscFojas"),
    @NamedQuery(name = "Locales.findByDscTomo", query = "SELECT l FROM Locales l WHERE l.dscTomo = :dscTomo"),
    @NamedQuery(name = "Locales.findByDscPelectro", query = "SELECT l FROM Locales l WHERE l.dscPelectro = :dscPelectro"),
    @NamedQuery(name = "Locales.findByCodPredio", query = "SELECT l FROM Locales l WHERE l.codPredio = :codPredio"),
    @NamedQuery(name = "Locales.findByDscBeneficiario", query = "SELECT l FROM Locales l WHERE l.dscBeneficiario = :dscBeneficiario"),
    @NamedQuery(name = "Locales.findByDscPropietario", query = "SELECT l FROM Locales l WHERE l.dscPropietario = :dscPropietario"),
    @NamedQuery(name = "Locales.findByDscCtactble", query = "SELECT l FROM Locales l WHERE l.dscCtactble = :dscCtactble"),
    @NamedQuery(name = "Locales.findByFlgTipomoneda", query = "SELECT l FROM Locales l WHERE l.flgTipomoneda = :flgTipomoneda"),
    @NamedQuery(name = "Locales.findByCtdValor", query = "SELECT l FROM Locales l WHERE l.ctdValor = :ctdValor"),
    @NamedQuery(name = "Locales.findByFlgPropiedad", query = "SELECT l FROM Locales l WHERE l.flgPropiedad = :flgPropiedad"),
    @NamedQuery(name = "Locales.findByDscAsinabip", query = "SELECT l FROM Locales l WHERE l.dscAsinabip = :dscAsinabip")})
public class Locales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_local")
    private String nombreLocal;
    @Size(max = 40)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "num_mun")
    private String numMun;
    @Size(max = 10)
    @Column(name = "dsc_mz")
    private String dscMz;
    @Size(max = 10)
    @Column(name = "dsc_lote")
    private String dscLote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ctd_area")
    private BigDecimal ctdArea;
    @Size(max = 10)
    @Column(name = "flg_um")
    private String flgUm;
    @Size(max = 20)
    @Column(name = "flg_tiporeg")
    private String flgTiporeg;
    @Size(max = 10)
    @Column(name = "dsc_asiento")
    private String dscAsiento;
    @Size(max = 10)
    @Column(name = "dsc_fojas")
    private String dscFojas;
    @Size(max = 10)
    @Column(name = "dsc_tomo")
    private String dscTomo;
    @Size(max = 10)
    @Column(name = "dsc_pelectro")
    private String dscPelectro;
    @Size(max = 10)
    @Column(name = "cod_predio")
    private String codPredio;
    @Size(max = 20)
    @Column(name = "dsc_beneficiario")
    private String dscBeneficiario;
    @Size(max = 20)
    @Column(name = "dsc_propietario")
    private String dscPropietario;
    @Size(max = 11)
    @Column(name = "dsc_ctactble")
    private String dscCtactble;
    @Size(max = 10)
    @Column(name = "flg_tipomoneda")
    private String flgTipomoneda;
    @Column(name = "ctd_valor")
    private BigDecimal ctdValor;
    @Size(max = 10)
    @Column(name = "flg_propiedad")
    private String flgPropiedad;
    @Column(name = "dsc_asinabip")
    private Integer dscAsinabip;
    @OneToMany(mappedBy = "codlocal")
    private Collection<Personal> personalCollection;
    @JoinColumn(name = "codinst", referencedColumnName = "codinst")
    @ManyToOne
    private Entidad codinst;
    @JoinColumn(name = "tipovia", referencedColumnName = "tipovia")
    @ManyToOne
    private TipoVia tipovia;
    @JoinColumn(name = "codubigeo", referencedColumnName = "codubigeo")
    @ManyToOne
    private Ubigeo codubigeo;

    public Locales() {
    }

    public Locales(String codlocal) {
        this.codlocal = codlocal;
    }

    public Locales(String codlocal, String nombreLocal) {
        this.codlocal = codlocal;
        this.nombreLocal = nombreLocal;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumMun() {
        return numMun;
    }

    public void setNumMun(String numMun) {
        this.numMun = numMun;
    }

    public String getDscMz() {
        return dscMz;
    }

    public void setDscMz(String dscMz) {
        this.dscMz = dscMz;
    }

    public String getDscLote() {
        return dscLote;
    }

    public void setDscLote(String dscLote) {
        this.dscLote = dscLote;
    }

    public BigDecimal getCtdArea() {
        return ctdArea;
    }

    public void setCtdArea(BigDecimal ctdArea) {
        this.ctdArea = ctdArea;
    }

    public String getFlgUm() {
        return flgUm;
    }

    public void setFlgUm(String flgUm) {
        this.flgUm = flgUm;
    }

    public String getFlgTiporeg() {
        return flgTiporeg;
    }

    public void setFlgTiporeg(String flgTiporeg) {
        this.flgTiporeg = flgTiporeg;
    }

    public String getDscAsiento() {
        return dscAsiento;
    }

    public void setDscAsiento(String dscAsiento) {
        this.dscAsiento = dscAsiento;
    }

    public String getDscFojas() {
        return dscFojas;
    }

    public void setDscFojas(String dscFojas) {
        this.dscFojas = dscFojas;
    }

    public String getDscTomo() {
        return dscTomo;
    }

    public void setDscTomo(String dscTomo) {
        this.dscTomo = dscTomo;
    }

    public String getDscPelectro() {
        return dscPelectro;
    }

    public void setDscPelectro(String dscPelectro) {
        this.dscPelectro = dscPelectro;
    }

    public String getCodPredio() {
        return codPredio;
    }

    public void setCodPredio(String codPredio) {
        this.codPredio = codPredio;
    }

    public String getDscBeneficiario() {
        return dscBeneficiario;
    }

    public void setDscBeneficiario(String dscBeneficiario) {
        this.dscBeneficiario = dscBeneficiario;
    }

    public String getDscPropietario() {
        return dscPropietario;
    }

    public void setDscPropietario(String dscPropietario) {
        this.dscPropietario = dscPropietario;
    }

    public String getDscCtactble() {
        return dscCtactble;
    }

    public void setDscCtactble(String dscCtactble) {
        this.dscCtactble = dscCtactble;
    }

    public String getFlgTipomoneda() {
        return flgTipomoneda;
    }

    public void setFlgTipomoneda(String flgTipomoneda) {
        this.flgTipomoneda = flgTipomoneda;
    }

    public BigDecimal getCtdValor() {
        return ctdValor;
    }

    public void setCtdValor(BigDecimal ctdValor) {
        this.ctdValor = ctdValor;
    }

    public String getFlgPropiedad() {
        return flgPropiedad;
    }

    public void setFlgPropiedad(String flgPropiedad) {
        this.flgPropiedad = flgPropiedad;
    }

    public Integer getDscAsinabip() {
        return dscAsinabip;
    }

    public void setDscAsinabip(Integer dscAsinabip) {
        this.dscAsinabip = dscAsinabip;
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }

    public Entidad getCodinst() {
        return codinst;
    }

    public void setCodinst(Entidad codinst) {
        this.codinst = codinst;
    }

    public TipoVia getTipovia() {
        return tipovia;
    }

    public void setTipovia(TipoVia tipovia) {
        this.tipovia = tipovia;
    }

    public Ubigeo getCodubigeo() {
        return codubigeo;
    }

    public void setCodubigeo(Ubigeo codubigeo) {
        this.codubigeo = codubigeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlocal != null ? codlocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locales)) {
            return false;
        }
        Locales other = (Locales) object;
        if ((this.codlocal == null && other.codlocal != null) || (this.codlocal != null && !this.codlocal.equals(other.codlocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Locales[ codlocal=" + codlocal + " ]";
    }
    
}
