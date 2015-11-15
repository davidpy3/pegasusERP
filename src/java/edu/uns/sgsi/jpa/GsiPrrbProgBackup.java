/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "gsi_prrb_prog_backup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsiPrrbProgBackup.findAll", query = "SELECT g FROM GsiPrrbProgBackup g"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByIdProg", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.idProg = :idProg"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByIdEsc", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.idEsc = :idEsc"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFechaProgInicio", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.fechaProgInicio = :fechaProgInicio"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFechaProgFin", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.fechaProgFin = :fechaProgFin"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByCompresion", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.compresion = :compresion"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByCifrado", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.cifrado = :cifrado"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByInterval", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.interval = :interval"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByPathDestLocal", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.pathDestLocal = :pathDestLocal"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByPathDestFtp", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.pathDestFtp = :pathDestFtp"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByTareaNombre", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.tareaNombre = :tareaNombre"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByUbigeoDestLocal", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ubigeoDestLocal = :ubigeoDestLocal"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByUbigeoDestFtp", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ubigeoDestFtp = :ubigeoDestFtp"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByUbigeoFuente", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ubigeoFuente = :ubigeoFuente"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByPathFuente", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.pathFuente = :pathFuente"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFtpIp", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ftpIp = :ftpIp"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFtpPort", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ftpPort = :ftpPort"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFtpUsuario", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ftpUsuario = :ftpUsuario"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFtpPass", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ftpPass = :ftpPass"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByFtpPathFile", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.ftpPathFile = :ftpPathFile"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByEmailNotificador", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.emailNotificador = :emailNotificador"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByEmailDestino", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.emailDestino = :emailDestino"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByTelefonoNotificador", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.telefonoNotificador = :telefonoNotificador"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByTelefonoDestino", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.telefonoDestino = :telefonoDestino"),
    @NamedQuery(name = "GsiPrrbProgBackup.findByEmailPassNotificador", query = "SELECT g FROM GsiPrrbProgBackup g WHERE g.emailPassNotificador = :emailPassNotificador")})
public class GsiPrrbProgBackup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prog")
    private Integer idProg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_esc")
    private int idEsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compresion")
    private boolean compresion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cifrado")
    private boolean cifrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interval")
    private double interval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "path_dest_local")
    private String pathDestLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "path_dest_ftp")
    private String pathDestFtp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tarea_nombre")
    private String tareaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubigeo_dest_local")
    private String ubigeoDestLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubigeo_dest_ftp")
    private String ubigeoDestFtp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubigeo_fuente")
    private String ubigeoFuente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "path_fuente")
    private String pathFuente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ftp_ip")
    private String ftpIp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ftp_port")
    private double ftpPort;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ftp_usuario")
    private String ftpUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ftp_pass")
    private String ftpPass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ftp_path_file")
    private String ftpPathFile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email_notificador")
    private String emailNotificador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email_destino")
    private String emailDestino;
    @Size(max = 50)
    @Column(name = "telefono_notificador")
    private String telefonoNotificador;
    @Size(max = 50)
    @Column(name = "telefono_destino")
    private String telefonoDestino;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "email_sujeto")
    private String emailSujeto;
    @Size(max = 50)
    @Column(name = "email_pass_notificador")
    private String emailPassNotificador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProg")
    private Collection<GsiPrrbBackup> gsiPrrbBackupCollection;

    public GsiPrrbProgBackup() {
    }

    public GsiPrrbProgBackup(Integer idProg) {
        this.idProg = idProg;
    }

    public GsiPrrbProgBackup(Integer idProg, int idEsc, Date fechaProgInicio, Date fechaProgFin, boolean compresion, boolean cifrado, double interval, String pathDestLocal, String pathDestFtp, String tareaNombre, String ubigeoDestLocal, String ubigeoDestFtp, String ubigeoFuente, String pathFuente, String ftpIp, double ftpPort, String ftpUsuario, String ftpPass, String ftpPathFile, String emailNotificador, String emailDestino, String emailSujeto) {
        this.idProg = idProg;
        this.idEsc = idEsc;
        this.fechaProgInicio = fechaProgInicio;
        this.fechaProgFin = fechaProgFin;
        this.compresion = compresion;
        this.cifrado = cifrado;
        this.interval = interval;
        this.pathDestLocal = pathDestLocal;
        this.pathDestFtp = pathDestFtp;
        this.tareaNombre = tareaNombre;
        this.ubigeoDestLocal = ubigeoDestLocal;
        this.ubigeoDestFtp = ubigeoDestFtp;
        this.ubigeoFuente = ubigeoFuente;
        this.pathFuente = pathFuente;
        this.ftpIp = ftpIp;
        this.ftpPort = ftpPort;
        this.ftpUsuario = ftpUsuario;
        this.ftpPass = ftpPass;
        this.ftpPathFile = ftpPathFile;
        this.emailNotificador = emailNotificador;
        this.emailDestino = emailDestino;
        this.emailSujeto = emailSujeto;
    }

    public Integer getIdProg() {
        return idProg;
    }

    public void setIdProg(Integer idProg) {
        this.idProg = idProg;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public Date getFechaProgInicio() {
        return fechaProgInicio;
    }

    public void setFechaProgInicio(Date fechaProgInicio) {
        this.fechaProgInicio = fechaProgInicio;
    }

    public Date getFechaProgFin() {
        return fechaProgFin;
    }

    public void setFechaProgFin(Date fechaProgFin) {
        this.fechaProgFin = fechaProgFin;
    }

    public boolean getCompresion() {
        return compresion;
    }

    public void setCompresion(boolean compresion) {
        this.compresion = compresion;
    }

    public boolean getCifrado() {
        return cifrado;
    }

    public void setCifrado(boolean cifrado) {
        this.cifrado = cifrado;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public String getPathDestLocal() {
        return pathDestLocal;
    }

    public void setPathDestLocal(String pathDestLocal) {
        this.pathDestLocal = pathDestLocal;
    }

    public String getPathDestFtp() {
        return pathDestFtp;
    }

    public void setPathDestFtp(String pathDestFtp) {
        this.pathDestFtp = pathDestFtp;
    }

    public String getTareaNombre() {
        return tareaNombre;
    }

    public void setTareaNombre(String tareaNombre) {
        this.tareaNombre = tareaNombre;
    }

    public String getUbigeoDestLocal() {
        return ubigeoDestLocal;
    }

    public void setUbigeoDestLocal(String ubigeoDestLocal) {
        this.ubigeoDestLocal = ubigeoDestLocal;
    }

    public String getUbigeoDestFtp() {
        return ubigeoDestFtp;
    }

    public void setUbigeoDestFtp(String ubigeoDestFtp) {
        this.ubigeoDestFtp = ubigeoDestFtp;
    }

    public String getUbigeoFuente() {
        return ubigeoFuente;
    }

    public void setUbigeoFuente(String ubigeoFuente) {
        this.ubigeoFuente = ubigeoFuente;
    }

    public String getPathFuente() {
        return pathFuente;
    }

    public void setPathFuente(String pathFuente) {
        this.pathFuente = pathFuente;
    }

    public String getFtpIp() {
        return ftpIp;
    }

    public void setFtpIp(String ftpIp) {
        this.ftpIp = ftpIp;
    }

    public double getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(double ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUsuario() {
        return ftpUsuario;
    }

    public void setFtpUsuario(String ftpUsuario) {
        this.ftpUsuario = ftpUsuario;
    }

    public String getFtpPass() {
        return ftpPass;
    }

    public void setFtpPass(String ftpPass) {
        this.ftpPass = ftpPass;
    }

    public String getFtpPathFile() {
        return ftpPathFile;
    }

    public void setFtpPathFile(String ftpPathFile) {
        this.ftpPathFile = ftpPathFile;
    }

    public String getEmailNotificador() {
        return emailNotificador;
    }

    public void setEmailNotificador(String emailNotificador) {
        this.emailNotificador = emailNotificador;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public String getTelefonoNotificador() {
        return telefonoNotificador;
    }

    public void setTelefonoNotificador(String telefonoNotificador) {
        this.telefonoNotificador = telefonoNotificador;
    }

    public String getTelefonoDestino() {
        return telefonoDestino;
    }

    public void setTelefonoDestino(String telefonoDestino) {
        this.telefonoDestino = telefonoDestino;
    }

    public String getEmailSujeto() {
        return emailSujeto;
    }

    public void setEmailSujeto(String emailSujeto) {
        this.emailSujeto = emailSujeto;
    }

    public String getEmailPassNotificador() {
        return emailPassNotificador;
    }

    public void setEmailPassNotificador(String emailPassNotificador) {
        this.emailPassNotificador = emailPassNotificador;
    }

    @XmlTransient
    public Collection<GsiPrrbBackup> getGsiPrrbBackupCollection() {
        return gsiPrrbBackupCollection;
    }

    public void setGsiPrrbBackupCollection(Collection<GsiPrrbBackup> gsiPrrbBackupCollection) {
        this.gsiPrrbBackupCollection = gsiPrrbBackupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProg != null ? idProg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsiPrrbProgBackup)) {
            return false;
        }
        GsiPrrbProgBackup other = (GsiPrrbProgBackup) object;
        if ((this.idProg == null && other.idProg != null) || (this.idProg != null && !this.idProg.equals(other.idProg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgsi.entity.GsiPrrbProgBackup[ idProg=" + idProg + " ]";
    }
    
}
