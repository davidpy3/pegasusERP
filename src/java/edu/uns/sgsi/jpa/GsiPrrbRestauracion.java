/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "gsi_prrb_restauracion")
@NamedQueries({
    @NamedQuery(name = "GsiPrrbRestauracion.findAll", query = "SELECT g FROM GsiPrrbRestauracion g")})
public class GsiPrrbRestauracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_backup")
    private String nombreBackup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tamano")
    private String tamano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "servidor")
    private String servidor;
    @JoinColumn(name = "id_backup", referencedColumnName = "id_backup")
    @ManyToOne(optional = false)
    private GsiPrrbBackup idBackup;

    public GsiPrrbRestauracion() {
    }

    public GsiPrrbRestauracion(Integer id) {
        this.id = id;
    }

    public GsiPrrbRestauracion(Integer id, String nombreBackup, Date fechaInicio, Date fechaTermino, Date tiempo, String tamano, String servidor) {
        this.id = id;
        this.nombreBackup = nombreBackup;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.tiempo = tiempo;
        this.tamano = tamano;
        this.servidor = servidor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreBackup() {
        return nombreBackup;
    }

    public void setNombreBackup(String nombreBackup) {
        this.nombreBackup = nombreBackup;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public GsiPrrbBackup getIdBackup() {
        return idBackup;
    }

    public void setIdBackup(GsiPrrbBackup idBackup) {
        this.idBackup = idBackup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsiPrrbRestauracion)) {
            return false;
        }
        GsiPrrbRestauracion other = (GsiPrrbRestauracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgsi.entity.GsiPrrbRestauracion[ id=" + id + " ]";
    }
    
}
