/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "omar_partida_mat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OmarPartidaMat.findAll", query = "SELECT o FROM OmarPartidaMat o"),
    @NamedQuery(name = "OmarPartidaMat.findByIdPartidamat", query = "SELECT o FROM OmarPartidaMat o WHERE o.idPartidamat = :idPartidamat"),
    @NamedQuery(name = "OmarPartidaMat.findByIdUsuario", query = "SELECT o FROM OmarPartidaMat o WHERE o.idUsuario = :idUsuario"),
    @NamedQuery(name = "OmarPartidaMat.findByNombPartida", query = "SELECT o FROM OmarPartidaMat o WHERE o.nombPartida = :nombPartida"),
    @NamedQuery(name = "OmarPartidaMat.findByNombPartidar", query = "SELECT o FROM OmarPartidaMat o WHERE o.nombPartidar = :nombPartidar"),
    @NamedQuery(name = "OmarPartidaMat.findByLibro", query = "SELECT o FROM OmarPartidaMat o WHERE o.libro = :libro"),
    @NamedQuery(name = "OmarPartidaMat.findByFolio", query = "SELECT o FROM OmarPartidaMat o WHERE o.folio = :folio"),
    @NamedQuery(name = "OmarPartidaMat.findByEsposo", query = "SELECT o FROM OmarPartidaMat o WHERE o.esposo = :esposo"),
    @NamedQuery(name = "OmarPartidaMat.findByEdadEsposo", query = "SELECT o FROM OmarPartidaMat o WHERE o.edadEsposo = :edadEsposo"),
    @NamedQuery(name = "OmarPartidaMat.findByEsposa", query = "SELECT o FROM OmarPartidaMat o WHERE o.esposa = :esposa"),
    @NamedQuery(name = "OmarPartidaMat.findByEdadEsposa", query = "SELECT o FROM OmarPartidaMat o WHERE o.edadEsposa = :edadEsposa"),
    @NamedQuery(name = "OmarPartidaMat.findByFechaMatrimonio", query = "SELECT o FROM OmarPartidaMat o WHERE o.fechaMatrimonio = :fechaMatrimonio"),
    @NamedQuery(name = "OmarPartidaMat.findByFechaRegistro", query = "SELECT o FROM OmarPartidaMat o WHERE o.fechaRegistro = :fechaRegistro")})
public class OmarPartidaMat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partidamat")
    private Integer idPartidamat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nomb_partida")
    private String nombPartida;
    @Size(max = 30)
    @Column(name = "nomb_partidar")
    private String nombPartidar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libro")
    private int libro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "folio")
    private int folio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "esposo")
    private String esposo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_esposo")
    private int edadEsposo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "esposa")
    private String esposa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_esposa")
    private int edadEsposa;
    @Column(name = "fecha_matrimonio")
    @Temporal(TemporalType.DATE)
    private Date fechaMatrimonio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public OmarPartidaMat() {
    }

    public OmarPartidaMat(Integer idPartidamat) {
        this.idPartidamat = idPartidamat;
    }

    public OmarPartidaMat(Integer idPartidamat, int idUsuario, String nombPartida, int libro, int folio, String esposo, int edadEsposo, String esposa, int edadEsposa, Date fechaRegistro) {
        this.idPartidamat = idPartidamat;
        this.idUsuario = idUsuario;
        this.nombPartida = nombPartida;
        this.libro = libro;
        this.folio = folio;
        this.esposo = esposo;
        this.edadEsposo = edadEsposo;
        this.esposa = esposa;
        this.edadEsposa = edadEsposa;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPartidamat() {
        return idPartidamat;
    }

    public void setIdPartidamat(Integer idPartidamat) {
        this.idPartidamat = idPartidamat;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombPartida() {
        return nombPartida;
    }

    public void setNombPartida(String nombPartida) {
        this.nombPartida = nombPartida;
    }

    public String getNombPartidar() {
        return nombPartidar;
    }

    public void setNombPartidar(String nombPartidar) {
        this.nombPartidar = nombPartidar;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getEsposo() {
        return esposo;
    }

    public void setEsposo(String esposo) {
        this.esposo = esposo;
    }

    public int getEdadEsposo() {
        return edadEsposo;
    }

    public void setEdadEsposo(int edadEsposo) {
        this.edadEsposo = edadEsposo;
    }

    public String getEsposa() {
        return esposa;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public int getEdadEsposa() {
        return edadEsposa;
    }

    public void setEdadEsposa(int edadEsposa) {
        this.edadEsposa = edadEsposa;
    }

    public Date getFechaMatrimonio() {
        return fechaMatrimonio;
    }

    public void setFechaMatrimonio(Date fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartidamat != null ? idPartidamat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OmarPartidaMat)) {
            return false;
        }
        OmarPartidaMat other = (OmarPartidaMat) object;
        if ((this.idPartidamat == null && other.idPartidamat != null) || (this.idPartidamat != null && !this.idPartidamat.equals(other.idPartidamat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.registro_civil.OmarPartidaMat[ idPartidamat=" + idPartidamat + " ]";
    }
    
}
