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
@Table(name = "omar_partida_def")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OmarPartidaDef.findAll", query = "SELECT o FROM OmarPartidaDef o"),
    @NamedQuery(name = "OmarPartidaDef.findByIdPartidadef", query = "SELECT o FROM OmarPartidaDef o WHERE o.idPartidadef = :idPartidadef"),
    @NamedQuery(name = "OmarPartidaDef.findByIdUsuario", query = "SELECT o FROM OmarPartidaDef o WHERE o.idUsuario = :idUsuario"),
    @NamedQuery(name = "OmarPartidaDef.findByNombPartida", query = "SELECT o FROM OmarPartidaDef o WHERE o.nombPartida = :nombPartida"),
    @NamedQuery(name = "OmarPartidaDef.findByNombPartidar", query = "SELECT o FROM OmarPartidaDef o WHERE o.nombPartidar = :nombPartidar"),
    @NamedQuery(name = "OmarPartidaDef.findByLibro", query = "SELECT o FROM OmarPartidaDef o WHERE o.libro = :libro"),
    @NamedQuery(name = "OmarPartidaDef.findByFolio", query = "SELECT o FROM OmarPartidaDef o WHERE o.folio = :folio"),
    @NamedQuery(name = "OmarPartidaDef.findByNombreCompleto", query = "SELECT o FROM OmarPartidaDef o WHERE o.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "OmarPartidaDef.findBySexo", query = "SELECT o FROM OmarPartidaDef o WHERE o.sexo = :sexo"),
    @NamedQuery(name = "OmarPartidaDef.findByEdad", query = "SELECT o FROM OmarPartidaDef o WHERE o.edad = :edad"),
    @NamedQuery(name = "OmarPartidaDef.findByFechaDefuncion", query = "SELECT o FROM OmarPartidaDef o WHERE o.fechaDefuncion = :fechaDefuncion"),
    @NamedQuery(name = "OmarPartidaDef.findByFechaRegistro", query = "SELECT o FROM OmarPartidaDef o WHERE o.fechaRegistro = :fechaRegistro")})
public class OmarPartidaDef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partidadef")
    private Integer idPartidadef;
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
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_defuncion")
    @Temporal(TemporalType.DATE)
    private Date fechaDefuncion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public OmarPartidaDef() {
    }

    public OmarPartidaDef(Integer idPartidadef) {
        this.idPartidadef = idPartidadef;
    }

    public OmarPartidaDef(Integer idPartidadef, int idUsuario, String nombPartida, int libro, int folio, String nombreCompleto, String sexo, int edad, Date fechaDefuncion, Date fechaRegistro) {
        this.idPartidadef = idPartidadef;
        this.idUsuario = idUsuario;
        this.nombPartida = nombPartida;
        this.libro = libro;
        this.folio = folio;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.edad = edad;
        this.fechaDefuncion = fechaDefuncion;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPartidadef() {
        return idPartidadef;
    }

    public void setIdPartidadef(Integer idPartidadef) {
        this.idPartidadef = idPartidadef;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
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
        hash += (idPartidadef != null ? idPartidadef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OmarPartidaDef)) {
            return false;
        }
        OmarPartidaDef other = (OmarPartidaDef) object;
        if ((this.idPartidadef == null && other.idPartidadef != null) || (this.idPartidadef != null && !this.idPartidadef.equals(other.idPartidadef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.registro_civil.OmarPartidaDef[ idPartidadef=" + idPartidadef + " ]";
    }
    
}
