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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "gsi_prrb_backup")
public class GsiPrrbBackup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(table = "sequence", pkColumnValue = "id_backup", pkColumnName = "seq_name", valueColumnName = "seq_count",
            name = "id_backup", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_backup")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_backup")
    private Integer idBackup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tamano")
    private int tamano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cifrado")
    private int cifrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "servidor")
    private String servidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resultado")
    private boolean resultado;
    @JoinColumn(name = "id_prog", referencedColumnName = "id_prog")
    @ManyToOne(optional = false)
    private GsiPrrbProgBackup idProg;

    public GsiPrrbBackup() {
    }

    public GsiPrrbBackup(Integer idBackup) {
        this.idBackup = idBackup;
    }

    public GsiPrrbBackup(Integer idBackup, String nombre, Date fechaInicio, Date fechaTermino, Date tiempo, int tamano, int cifrado, String servidor, boolean resultado) {
        this.idBackup = idBackup;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.tiempo = tiempo;
        this.tamano = tamano;
        this.cifrado = cifrado;
        this.servidor = servidor;
        this.resultado = resultado;
    }

    public Integer getIdBackup() {
        return idBackup;
    }

    public void setIdBackup(Integer idBackup) {
        this.idBackup = idBackup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getCifrado() {
        return cifrado;
    }

    public void setCifrado(int cifrado) {
        this.cifrado = cifrado;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public GsiPrrbProgBackup getIdProg() {
        return idProg;
    }

    public void setIdProg(GsiPrrbProgBackup idProg) {
        this.idProg = idProg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBackup != null ? idBackup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsiPrrbBackup)) {
            return false;
        }
        GsiPrrbBackup other = (GsiPrrbBackup) object;
        if ((this.idBackup == null && other.idBackup != null) || (this.idBackup != null && !this.idBackup.equals(other.idBackup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgsi.entity.GsiPrrbBackup[ idBackup=" + idBackup + " ]";
    }
    
}
