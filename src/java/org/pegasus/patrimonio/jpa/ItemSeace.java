/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "ITEM_SEACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSeace.findAll", query = "SELECT i FROM ItemSeace i"),
    @NamedQuery(name = "ItemSeace.findByTipoBien", query = "SELECT i FROM ItemSeace i WHERE i.tipoBien = :tipoBien"),
    @NamedQuery(name = "ItemSeace.findByGrupoBien", query = "SELECT i FROM ItemSeace i WHERE i.grupoBien = :grupoBien"),
    @NamedQuery(name = "ItemSeace.findByClaseBien", query = "SELECT i FROM ItemSeace i WHERE i.claseBien = :claseBien"),
    @NamedQuery(name = "ItemSeace.findByFamiliaBien", query = "SELECT i FROM ItemSeace i WHERE i.familiaBien = :familiaBien"),
    @NamedQuery(name = "ItemSeace.findByItemBien", query = "SELECT i FROM ItemSeace i WHERE i.itemBien = :itemBien"),
    @NamedQuery(name = "ItemSeace.findByNombreItem", query = "SELECT i FROM ItemSeace i WHERE i.nombreItem = :nombreItem"),
    @NamedQuery(name = "ItemSeace.findByFlagActivo", query = "SELECT i FROM ItemSeace i WHERE i.flagActivo = :flagActivo"),
    @NamedQuery(name = "ItemSeace.findByFechaAlta", query = "SELECT i FROM ItemSeace i WHERE i.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "ItemSeace.findByUserRegistra", query = "SELECT i FROM ItemSeace i WHERE i.userRegistra = :userRegistra"),
    @NamedQuery(name = "ItemSeace.findByIdItem", query = "SELECT i FROM ItemSeace i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemSeace.findByDivisionaria", query = "SELECT i FROM ItemSeace i WHERE i.divisionaria = :divisionaria")})
public class ItemSeace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_bien")
    private Character tipoBien;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "grupo_bien")
    private String grupoBien;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "clase_bien")
    private String claseBien;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "familia_bien")
    private String familiaBien;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "item_bien")
    private String itemBien;
    @Size(max = 1000)
    @Column(name = "nombre_item")
    private String nombreItem;
    @Column(name = "flag_activo")
    private Character flagActivo;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Size(max = 8)
    @Column(name = "user_registra")
    private String userRegistra;
    @Size(max = 13)
    @Column(name = "id_item")
    private String idItem;
    @Size(max = 11)
    @Column(name = "divisionaria")
    private String divisionaria;
    @JoinColumn(name = "tipo_unidad", referencedColumnName = "id_unidad")
    @ManyToOne
    private UnidadMef tipoUnidad;

    public ItemSeace() {
    }

    public ItemSeace(String itemBien) {
        this.itemBien = itemBien;
    }

    public Character getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(Character tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getGrupoBien() {
        return grupoBien;
    }

    public void setGrupoBien(String grupoBien) {
        this.grupoBien = grupoBien;
    }

    public String getClaseBien() {
        return claseBien;
    }

    public void setClaseBien(String claseBien) {
        this.claseBien = claseBien;
    }

    public String getFamiliaBien() {
        return familiaBien;
    }

    public void setFamiliaBien(String familiaBien) {
        this.familiaBien = familiaBien;
    }

    public String getItemBien() {
        return itemBien;
    }

    public void setItemBien(String itemBien) {
        this.itemBien = itemBien;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Character getFlagActivo() {
        return flagActivo;
    }

    public void setFlagActivo(Character flagActivo) {
        this.flagActivo = flagActivo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getUserRegistra() {
        return userRegistra;
    }

    public void setUserRegistra(String userRegistra) {
        this.userRegistra = userRegistra;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getDivisionaria() {
        return divisionaria;
    }

    public void setDivisionaria(String divisionaria) {
        this.divisionaria = divisionaria;
    }

    public UnidadMef getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(UnidadMef tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemBien != null ? itemBien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSeace)) {
            return false;
        }
        ItemSeace other = (ItemSeace) object;
        if ((this.itemBien == null && other.itemBien != null) || (this.itemBien != null && !this.itemBien.equals(other.itemBien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ItemSeace[ itemBien=" + itemBien + " ]";
    }
    
}
