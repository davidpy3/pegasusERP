package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.pegasus.personal.jpa.Cargo;

@Entity
@Table(name = "son_empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "nom_per")
    private String nombreCompleto;
    @Column(name = "dir_per")
    private String dirPer;
    @Column(name = "tel_per")
    private String telPer;
    @Column(name = "tel2_per")
    private String tel2Per;
    @Column(name = "img_per")
    private String imgPer;
    @Column(name = "est_per")
    private Character estPer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo")
    private BigDecimal sueldo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne(optional = false)
    private SonAlmacen idAlmacen;
    @JoinColumn(name = "id_metas", referencedColumnName = "id_meta")
    @ManyToOne(optional = false)
    private SMeta idMetas;

    public Empleado() {
    }

    public Empleado(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nomPer) {
        this.nombreCompleto = nomPer;
    }

    public String getDireccion() {
        return dirPer;
    }

    public void setDireccion(String dirPer) {
        this.dirPer = dirPer;
    }

    public String getTelefono() {
        return telPer;
    }

    public void setTelefono(String telPer) {
        this.telPer = telPer;
    }

    public String getTelefono2() {
        return tel2Per;
    }

    public void setTelefono2(String tel2Per) {
        this.tel2Per = tel2Per;
    }

    public String getImage() {
        return imgPer;
    }

    public void setImage(String imgPer) {
        this.imgPer = imgPer;
    }

    public Character getEstPer() {
        return estPer;
    }

    public void setEstPer(Character estPer) {
        this.estPer = estPer;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNac() {
        return fecha;
    }

    public void setFechaNac(Date fecha) {
        this.fecha = fecha;
    }

    public Cargo getCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public SonAlmacen getAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SonAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public SMeta getMeta() {
        return idMetas;
    }

    public void setIdMeta(SMeta idMetas) {
        this.idMetas = idMetas;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Empleado[ dni=" + dni + " ]";
    }
    
}
