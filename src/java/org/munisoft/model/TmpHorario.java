/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "tmp_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpHorario.findAll", query = "SELECT t FROM TmpHorario t"),
    @NamedQuery(name = "TmpHorario.findByDni", query = "SELECT t FROM TmpHorario t WHERE t.dni = :dni"),
    @NamedQuery(name = "TmpHorario.findByDia01", query = "SELECT t FROM TmpHorario t WHERE t.dia01 = :dia01"),
    @NamedQuery(name = "TmpHorario.findByDia02", query = "SELECT t FROM TmpHorario t WHERE t.dia02 = :dia02"),
    @NamedQuery(name = "TmpHorario.findByDia03", query = "SELECT t FROM TmpHorario t WHERE t.dia03 = :dia03"),
    @NamedQuery(name = "TmpHorario.findByDia04", query = "SELECT t FROM TmpHorario t WHERE t.dia04 = :dia04"),
    @NamedQuery(name = "TmpHorario.findByDia05", query = "SELECT t FROM TmpHorario t WHERE t.dia05 = :dia05"),
    @NamedQuery(name = "TmpHorario.findByDia06", query = "SELECT t FROM TmpHorario t WHERE t.dia06 = :dia06"),
    @NamedQuery(name = "TmpHorario.findByDia07", query = "SELECT t FROM TmpHorario t WHERE t.dia07 = :dia07"),
    @NamedQuery(name = "TmpHorario.findByDia08", query = "SELECT t FROM TmpHorario t WHERE t.dia08 = :dia08"),
    @NamedQuery(name = "TmpHorario.findByDia09", query = "SELECT t FROM TmpHorario t WHERE t.dia09 = :dia09"),
    @NamedQuery(name = "TmpHorario.findByDia10", query = "SELECT t FROM TmpHorario t WHERE t.dia10 = :dia10"),
    @NamedQuery(name = "TmpHorario.findByDia11", query = "SELECT t FROM TmpHorario t WHERE t.dia11 = :dia11"),
    @NamedQuery(name = "TmpHorario.findByDia12", query = "SELECT t FROM TmpHorario t WHERE t.dia12 = :dia12"),
    @NamedQuery(name = "TmpHorario.findByDia13", query = "SELECT t FROM TmpHorario t WHERE t.dia13 = :dia13"),
    @NamedQuery(name = "TmpHorario.findByDia14", query = "SELECT t FROM TmpHorario t WHERE t.dia14 = :dia14"),
    @NamedQuery(name = "TmpHorario.findByDia15", query = "SELECT t FROM TmpHorario t WHERE t.dia15 = :dia15"),
    @NamedQuery(name = "TmpHorario.findByDia16", query = "SELECT t FROM TmpHorario t WHERE t.dia16 = :dia16"),
    @NamedQuery(name = "TmpHorario.findByDia17", query = "SELECT t FROM TmpHorario t WHERE t.dia17 = :dia17"),
    @NamedQuery(name = "TmpHorario.findByDia18", query = "SELECT t FROM TmpHorario t WHERE t.dia18 = :dia18"),
    @NamedQuery(name = "TmpHorario.findByDia19", query = "SELECT t FROM TmpHorario t WHERE t.dia19 = :dia19"),
    @NamedQuery(name = "TmpHorario.findByDia20", query = "SELECT t FROM TmpHorario t WHERE t.dia20 = :dia20"),
    @NamedQuery(name = "TmpHorario.findByDia21", query = "SELECT t FROM TmpHorario t WHERE t.dia21 = :dia21"),
    @NamedQuery(name = "TmpHorario.findByDia22", query = "SELECT t FROM TmpHorario t WHERE t.dia22 = :dia22"),
    @NamedQuery(name = "TmpHorario.findByDia23", query = "SELECT t FROM TmpHorario t WHERE t.dia23 = :dia23"),
    @NamedQuery(name = "TmpHorario.findByDia24", query = "SELECT t FROM TmpHorario t WHERE t.dia24 = :dia24"),
    @NamedQuery(name = "TmpHorario.findByDia25", query = "SELECT t FROM TmpHorario t WHERE t.dia25 = :dia25"),
    @NamedQuery(name = "TmpHorario.findByDia26", query = "SELECT t FROM TmpHorario t WHERE t.dia26 = :dia26"),
    @NamedQuery(name = "TmpHorario.findByDia27", query = "SELECT t FROM TmpHorario t WHERE t.dia27 = :dia27"),
    @NamedQuery(name = "TmpHorario.findByDia28", query = "SELECT t FROM TmpHorario t WHERE t.dia28 = :dia28"),
    @NamedQuery(name = "TmpHorario.findByDia29", query = "SELECT t FROM TmpHorario t WHERE t.dia29 = :dia29"),
    @NamedQuery(name = "TmpHorario.findByDia30", query = "SELECT t FROM TmpHorario t WHERE t.dia30 = :dia30"),
    @NamedQuery(name = "TmpHorario.findByDia31", query = "SELECT t FROM TmpHorario t WHERE t.dia31 = :dia31")})
public class TmpHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
    @Column(name = "dia01")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia01;
    @Column(name = "dia02")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia02;
    @Column(name = "dia03")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia03;
    @Column(name = "dia04")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia04;
    @Column(name = "dia05")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia05;
    @Column(name = "dia06")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia06;
    @Column(name = "dia07")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia07;
    @Column(name = "dia08")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia08;
    @Column(name = "dia09")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia09;
    @Column(name = "dia10")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia10;
    @Column(name = "dia11")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia11;
    @Column(name = "dia12")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia12;
    @Column(name = "dia13")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia13;
    @Column(name = "dia14")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia14;
    @Column(name = "dia15")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia15;
    @Column(name = "dia16")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia16;
    @Column(name = "dia17")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia17;
    @Column(name = "dia18")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia18;
    @Column(name = "dia19")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia19;
    @Column(name = "dia20")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia20;
    @Column(name = "dia21")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia21;
    @Column(name = "dia22")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia22;
    @Column(name = "dia23")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia23;
    @Column(name = "dia24")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia24;
    @Column(name = "dia25")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia25;
    @Column(name = "dia26")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia26;
    @Column(name = "dia27")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia27;
    @Column(name = "dia28")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia28;
    @Column(name = "dia29")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia29;
    @Column(name = "dia30")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia30;
    @Column(name = "dia31")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dia31;

    public TmpHorario() {
    }

    public TmpHorario(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getDia01() {
        return dia01;
    }

    public void setDia01(Date dia01) {
        this.dia01 = dia01;
    }

    public Date getDia02() {
        return dia02;
    }

    public void setDia02(Date dia02) {
        this.dia02 = dia02;
    }

    public Date getDia03() {
        return dia03;
    }

    public void setDia03(Date dia03) {
        this.dia03 = dia03;
    }

    public Date getDia04() {
        return dia04;
    }

    public void setDia04(Date dia04) {
        this.dia04 = dia04;
    }

    public Date getDia05() {
        return dia05;
    }

    public void setDia05(Date dia05) {
        this.dia05 = dia05;
    }

    public Date getDia06() {
        return dia06;
    }

    public void setDia06(Date dia06) {
        this.dia06 = dia06;
    }

    public Date getDia07() {
        return dia07;
    }

    public void setDia07(Date dia07) {
        this.dia07 = dia07;
    }

    public Date getDia08() {
        return dia08;
    }

    public void setDia08(Date dia08) {
        this.dia08 = dia08;
    }

    public Date getDia09() {
        return dia09;
    }

    public void setDia09(Date dia09) {
        this.dia09 = dia09;
    }

    public Date getDia10() {
        return dia10;
    }

    public void setDia10(Date dia10) {
        this.dia10 = dia10;
    }

    public Date getDia11() {
        return dia11;
    }

    public void setDia11(Date dia11) {
        this.dia11 = dia11;
    }

    public Date getDia12() {
        return dia12;
    }

    public void setDia12(Date dia12) {
        this.dia12 = dia12;
    }

    public Date getDia13() {
        return dia13;
    }

    public void setDia13(Date dia13) {
        this.dia13 = dia13;
    }

    public Date getDia14() {
        return dia14;
    }

    public void setDia14(Date dia14) {
        this.dia14 = dia14;
    }

    public Date getDia15() {
        return dia15;
    }

    public void setDia15(Date dia15) {
        this.dia15 = dia15;
    }

    public Date getDia16() {
        return dia16;
    }

    public void setDia16(Date dia16) {
        this.dia16 = dia16;
    }

    public Date getDia17() {
        return dia17;
    }

    public void setDia17(Date dia17) {
        this.dia17 = dia17;
    }

    public Date getDia18() {
        return dia18;
    }

    public void setDia18(Date dia18) {
        this.dia18 = dia18;
    }

    public Date getDia19() {
        return dia19;
    }

    public void setDia19(Date dia19) {
        this.dia19 = dia19;
    }

    public Date getDia20() {
        return dia20;
    }

    public void setDia20(Date dia20) {
        this.dia20 = dia20;
    }

    public Date getDia21() {
        return dia21;
    }

    public void setDia21(Date dia21) {
        this.dia21 = dia21;
    }

    public Date getDia22() {
        return dia22;
    }

    public void setDia22(Date dia22) {
        this.dia22 = dia22;
    }

    public Date getDia23() {
        return dia23;
    }

    public void setDia23(Date dia23) {
        this.dia23 = dia23;
    }

    public Date getDia24() {
        return dia24;
    }

    public void setDia24(Date dia24) {
        this.dia24 = dia24;
    }

    public Date getDia25() {
        return dia25;
    }

    public void setDia25(Date dia25) {
        this.dia25 = dia25;
    }

    public Date getDia26() {
        return dia26;
    }

    public void setDia26(Date dia26) {
        this.dia26 = dia26;
    }

    public Date getDia27() {
        return dia27;
    }

    public void setDia27(Date dia27) {
        this.dia27 = dia27;
    }

    public Date getDia28() {
        return dia28;
    }

    public void setDia28(Date dia28) {
        this.dia28 = dia28;
    }

    public Date getDia29() {
        return dia29;
    }

    public void setDia29(Date dia29) {
        this.dia29 = dia29;
    }

    public Date getDia30() {
        return dia30;
    }

    public void setDia30(Date dia30) {
        this.dia30 = dia30;
    }

    public Date getDia31() {
        return dia31;
    }

    public void setDia31(Date dia31) {
        this.dia31 = dia31;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpHorario)) {
            return false;
        }
        TmpHorario other = (TmpHorario) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TmpHorario[ dni=" + dni + " ]";
    }

}
