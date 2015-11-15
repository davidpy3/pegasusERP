/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Calendario_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioDet.findAll", query = "SELECT c FROM CalendarioDet c"),
    @NamedQuery(name = "CalendarioDet.findByAnoEje", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "CalendarioDet.findByMesEje", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.mesEje = :mesEje"),
    @NamedQuery(name = "CalendarioDet.findByFuenteFinanc", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.fuenteFinanc = :fuenteFinanc"),
    @NamedQuery(name = "CalendarioDet.findByTipoCalendario", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.tipoCalendario = :tipoCalendario"),
    @NamedQuery(name = "CalendarioDet.findBySecFun", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.secFun = :secFun"),
    @NamedQuery(name = "CalendarioDet.findByMeta", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.meta = :meta"),
    @NamedQuery(name = "CalendarioDet.findByTipoTransaccion", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "CalendarioDet.findByGenerica", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.generica = :generica"),
    @NamedQuery(name = "CalendarioDet.findBySubgenerica", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.subgenerica = :subgenerica"),
    @NamedQuery(name = "CalendarioDet.findBySubgenericaDet", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.subgenericaDet = :subgenericaDet"),
    @NamedQuery(name = "CalendarioDet.findByEspecifica", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.especifica = :especifica"),
    @NamedQuery(name = "CalendarioDet.findByEspecificaDet", query = "SELECT c FROM CalendarioDet c WHERE c.calendarioDetPK.especificaDet = :especificaDet"),
    @NamedQuery(name = "CalendarioDet.findByMonto", query = "SELECT c FROM CalendarioDet c WHERE c.monto = :monto")})
public class CalendarioDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarioDetPK calendarioDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private long monto;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "mes_eje", referencedColumnName = "mes_eje", insertable = false, updatable = false),
        @JoinColumn(name = "fuente_financ", referencedColumnName = "fuente_financ", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_calendario", referencedColumnName = "tipo_calendario", insertable = false, updatable = false),
        @JoinColumn(name = "sec_fun", referencedColumnName = "sec_fun", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Calendario calendario;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_transaccion", referencedColumnName = "tipo_transaccion", insertable = false, updatable = false),
        @JoinColumn(name = "generica", referencedColumnName = "generica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica", referencedColumnName = "subgenerica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica_det", referencedColumnName = "subgenerica_det", insertable = false, updatable = false),
        @JoinColumn(name = "especifica", referencedColumnName = "especifica", insertable = false, updatable = false),
        @JoinColumn(name = "especifica_det", referencedColumnName = "especifica_det", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EspecificaDet especificaDet1;

    public CalendarioDet() {
    }

    public CalendarioDet(CalendarioDetPK calendarioDetPK) {
        this.calendarioDetPK = calendarioDetPK;
    }

    public CalendarioDet(CalendarioDetPK calendarioDetPK, long monto) {
        this.calendarioDetPK = calendarioDetPK;
        this.monto = monto;
    }

    public CalendarioDet(String anoEje, String mesEje, String fuenteFinanc, Character tipoCalendario, String secFun, String meta, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet, String especifica, String especificaDet) {
        this.calendarioDetPK = new CalendarioDetPK(anoEje, mesEje, fuenteFinanc, tipoCalendario, secFun, meta, tipoTransaccion, generica, subgenerica, subgenericaDet, especifica, especificaDet);
    }

    public CalendarioDetPK getCalendarioDetPK() {
        return calendarioDetPK;
    }

    public void setCalendarioDetPK(CalendarioDetPK calendarioDetPK) {
        this.calendarioDetPK = calendarioDetPK;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public EspecificaDet getEspecificaDet1() {
        return especificaDet1;
    }

    public void setEspecificaDet1(EspecificaDet especificaDet1) {
        this.especificaDet1 = especificaDet1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendarioDetPK != null ? calendarioDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioDet)) {
            return false;
        }
        CalendarioDet other = (CalendarioDet) object;
        if ((this.calendarioDetPK == null && other.calendarioDetPK != null) || (this.calendarioDetPK != null && !this.calendarioDetPK.equals(other.calendarioDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CalendarioDet[ calendarioDetPK=" + calendarioDetPK + " ]";
    }
    
}
