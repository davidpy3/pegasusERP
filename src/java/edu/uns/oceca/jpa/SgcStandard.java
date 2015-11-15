package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "sgc_estandar")
@NamedQueries({
    @NamedQuery(name = "SgcStandard.findByIdModeloAndNumero", query = "SELECT d FROM SgcStandard d WHERE d.idModelo = :idModelo AND d.numero = :numero")})

public class SgcStandard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(table="sequence",pkColumnValue="id_estand",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_estand", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_estand")
    @Column(name = "id_estandar", nullable = false)
    private Integer idEstandar;
    @Basic(optional = false)
    @Column(name = "numero", nullable = false)
    private int numero;
    @Basic(optional = false)
    @Column(name = "id_factor", nullable = false)
    private int idFactor;
    @Basic(optional = false)
    @Column(name = "id_criterio", nullable = false)
    private int idCriterio;

    public String getConsideracion() {
        return consideracion;
    }

    public void setConsideracion(String consideracion) {
        this.consideracion = consideracion;
    }
    @Basic(optional = false)
    @Column(name = "id_modelo", nullable = false)
    private int idModelo;
    @Basic(optional = false)
    @Column(name = "estandar", nullable = false, length = 2147483647)
    private String estandar;
    @Basic(optional = false)
    @Column(name = "consideracion",length = 2147483647)
    private String consideracion;
    @Basic(optional = false)
    @Column(name = "id_tipo", nullable = false)
    private int idTipo;

    public SgcStandard() {
    }

    public SgcStandard(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public Integer getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(int idFactor) {
        this.idFactor = idFactor;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getEstandar() {
        return estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstandar != null ? idEstandar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcStandard)) {
            return false;
        }
        SgcStandard other = (SgcStandard) object;
        if ((this.idEstandar == null && other.idEstandar != null) || (this.idEstandar != null && !this.idEstandar.equals(other.idEstandar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceca.sgc.SgcStandard[idEstandar=" + idEstandar + "]";
    }

}
