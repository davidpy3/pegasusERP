/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "tmp_ricardo")
@NamedQueries({
    @NamedQuery(name = "TmpRicardo.findAll", query = "SELECT t FROM TmpRicardo t")})
public class TmpRicardo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Column(name = "afp")
    private String afp;
    @Column(name = "afp1")
    private String afp1;

    public TmpRicardo() {
    }

    public TmpRicardo(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getAfp1() {
        return afp1;
    }

    public void setAfp1(String afp1) {
        this.afp1 = afp1;
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
        if (!(object instanceof TmpRicardo)) {
            return false;
        }
        TmpRicardo other = (TmpRicardo) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TmpRicardo[ dni=" + dni + " ]";
    }
    
}
