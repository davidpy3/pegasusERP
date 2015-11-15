/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class DocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_expediente")
    private long nExpediente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_doc")
    private int tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_doc")
    private int nDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cod_oficina")
    private String codOficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cargo")
    private int idCargo;

    public DocumentoPK() {
    }

    public DocumentoPK(String anoEje, long nExpediente, int tipoDoc, int nDoc, String codOficina, String dni, int idCargo) {
        this.anoEje = anoEje;
        this.nExpediente = nExpediente;
        this.tipoDoc = tipoDoc;
        this.nDoc = nDoc;
        this.codOficina = codOficina;
        this.dni = dni;
        this.idCargo = idCargo;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public long getNExpediente() {
        return nExpediente;
    }

    public void setNExpediente(long nExpediente) {
        this.nExpediente = nExpediente;
    }

    public int getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(int tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNDoc() {
        return nDoc;
    }

    public void setNDoc(int nDoc) {
        this.nDoc = nDoc;
    }

    public String getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(String codOficina) {
        this.codOficina = codOficina;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (int) nExpediente;
        hash += (int) tipoDoc;
        hash += (int) nDoc;
        hash += (codOficina != null ? codOficina.hashCode() : 0);
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (int) idCargo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPK)) {
            return false;
        }
        DocumentoPK other = (DocumentoPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nExpediente != other.nExpediente) {
            return false;
        }
        if (this.tipoDoc != other.tipoDoc) {
            return false;
        }
        if (this.nDoc != other.nDoc) {
            return false;
        }
        if ((this.codOficina == null && other.codOficina != null) || (this.codOficina != null && !this.codOficina.equals(other.codOficina))) {
            return false;
        }
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if (this.idCargo != other.idCargo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.DocumentoPK[ anoEje=" + anoEje + ", nExpediente=" + nExpediente + ", tipoDoc=" + tipoDoc + ", nDoc=" + nDoc + ", codOficina=" + codOficina + ", dni=" + dni + ", idCargo=" + idCargo + " ]";
    }
    
}
