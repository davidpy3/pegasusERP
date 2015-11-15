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
@Table(name = "omar_partida_nac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OmarPartidaNac.findAll", query = "SELECT o FROM OmarPartidaNac o"),
    @NamedQuery(name = "OmarPartidaNac.findByIdPartidanac", query = "SELECT o FROM OmarPartidaNac o WHERE o.idPartidanac = :idPartidanac"),
    @NamedQuery(name = "OmarPartidaNac.findByIdUsuario", query = "SELECT o FROM OmarPartidaNac o WHERE o.idUsuario = :idUsuario"),
    @NamedQuery(name = "OmarPartidaNac.findByCui", query = "SELECT o FROM OmarPartidaNac o WHERE o.cui = :cui"),
    @NamedQuery(name = "OmarPartidaNac.findByNombPartida", query = "SELECT o FROM OmarPartidaNac o WHERE o.nombPartida = :nombPartida"),
    @NamedQuery(name = "OmarPartidaNac.findByNombPartidar", query = "SELECT o FROM OmarPartidaNac o WHERE o.nombPartidar = :nombPartidar"),
    @NamedQuery(name = "OmarPartidaNac.findByLibro", query = "SELECT o FROM OmarPartidaNac o WHERE o.libro = :libro"),
    @NamedQuery(name = "OmarPartidaNac.findByFolio", query = "SELECT o FROM OmarPartidaNac o WHERE o.folio = :folio"),
    @NamedQuery(name = "OmarPartidaNac.findByNombreCompleto", query = "SELECT o FROM OmarPartidaNac o WHERE o.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "OmarPartidaNac.findBySexo", query = "SELECT o FROM OmarPartidaNac o WHERE o.sexo = :sexo"),
    @NamedQuery(name = "OmarPartidaNac.findByFechaNacimiento", query = "SELECT o FROM OmarPartidaNac o WHERE o.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "OmarPartidaNac.findByPadre", query = "SELECT o FROM OmarPartidaNac o WHERE o.padre = :padre"),
    @NamedQuery(name = "OmarPartidaNac.findByMadre", query = "SELECT o FROM OmarPartidaNac o WHERE o.madre = :madre"),
    @NamedQuery(name = "OmarPartidaNac.findByFechaRegistro", query = "SELECT o FROM OmarPartidaNac o WHERE o.fechaRegistro = :fechaRegistro")})
public class OmarPartidaNac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partidanac")
    private Integer idPartidanac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cui")
    private int cui;
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
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "padre")
    private String padre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "madre")
    private String madre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public OmarPartidaNac() {
    }

    public OmarPartidaNac(Integer idPartidanac) {
        this.idPartidanac = idPartidanac;
    }

    public OmarPartidaNac(Integer idPartidanac, int idUsuario, int cui, String nombPartida, int libro, int folio, String nombreCompleto, String sexo, Date fechaNacimiento, String padre, String madre, Date fechaRegistro) {
        this.idPartidanac = idPartidanac;
        this.idUsuario = idUsuario;
        this.cui = cui;
        this.nombPartida = nombPartida;
        this.libro = libro;
        this.folio = folio;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.padre = padre;
        this.madre = madre;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPartidanac() {
        return idPartidanac;
    }

    public void setIdPartidanac(Integer idPartidanac) {
        this.idPartidanac = idPartidanac;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
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
        hash += (idPartidanac != null ? idPartidanac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OmarPartidaNac)) {
            return false;
        }
        OmarPartidaNac other = (OmarPartidaNac) object;
        if ((this.idPartidanac == null && other.idPartidanac != null) || (this.idPartidanac != null && !this.idPartidanac.equals(other.idPartidanac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.registro_civil.OmarPartidaNac[ idPartidanac=" + idPartidanac + " ]";
    }
    
}
