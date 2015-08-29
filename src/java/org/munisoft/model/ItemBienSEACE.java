/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Item_bien_SEACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemBienSEACE.findAll", query = "SELECT i FROM ItemBienSEACE i"),
    @NamedQuery(name = "ItemBienSEACE.findByTipoBien", query = "SELECT i FROM ItemBienSEACE i WHERE i.itemBienSEACEPK.tipoBien = :tipoBien"),
    @NamedQuery(name = "ItemBienSEACE.findByGrupoBien", query = "SELECT i FROM ItemBienSEACE i WHERE i.itemBienSEACEPK.grupoBien = :grupoBien"),
    @NamedQuery(name = "ItemBienSEACE.findByClaseBien", query = "SELECT i FROM ItemBienSEACE i WHERE i.itemBienSEACEPK.claseBien = :claseBien"),
    @NamedQuery(name = "ItemBienSEACE.findByFamiliaBien", query = "SELECT i FROM ItemBienSEACE i WHERE i.itemBienSEACEPK.familiaBien = :familiaBien"),
    @NamedQuery(name = "ItemBienSEACE.findByItemBien", query = "SELECT i FROM ItemBienSEACE i WHERE i.itemBienSEACEPK.itemBien = :itemBien"),
    @NamedQuery(name = "ItemBienSEACE.findByNombreItem", query = "SELECT i FROM ItemBienSEACE i WHERE i.nombreItem = :nombreItem"),
    @NamedQuery(name = "ItemBienSEACE.findByFlagActivo", query = "SELECT i FROM ItemBienSEACE i WHERE i.flagActivo = :flagActivo"),
    @NamedQuery(name = "ItemBienSEACE.findByFechaAlta", query = "SELECT i FROM ItemBienSEACE i WHERE i.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "ItemBienSEACE.findByUserRegistra", query = "SELECT i FROM ItemBienSEACE i WHERE i.userRegistra = :userRegistra"),
    @NamedQuery(name = "ItemBienSEACE.findByIdItem", query = "SELECT i FROM ItemBienSEACE i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemBienSEACE.findByDivisionaria", query = "SELECT i FROM ItemBienSEACE i WHERE i.divisionaria = :divisionaria")})
public class ItemBienSEACE implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemBienSEACEPK itemBienSEACEPK;
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

    public ItemBienSEACE() {
    }

    public ItemBienSEACE(ItemBienSEACEPK itemBienSEACEPK) {
        this.itemBienSEACEPK = itemBienSEACEPK;
    }

    public ItemBienSEACE(Character tipoBien, String grupoBien, String claseBien, String familiaBien, String itemBien) {
        this.itemBienSEACEPK = new ItemBienSEACEPK(tipoBien, grupoBien, claseBien, familiaBien, itemBien);
    }

    public ItemBienSEACEPK getItemBienSEACEPK() {
        return itemBienSEACEPK;
    }

    public void setItemBienSEACEPK(ItemBienSEACEPK itemBienSEACEPK) {
        this.itemBienSEACEPK = itemBienSEACEPK;
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
        hash += (itemBienSEACEPK != null ? itemBienSEACEPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemBienSEACE)) {
            return false;
        }
        ItemBienSEACE other = (ItemBienSEACE) object;
        if ((this.itemBienSEACEPK == null && other.itemBienSEACEPK != null) || (this.itemBienSEACEPK != null && !this.itemBienSEACEPK.equals(other.itemBienSEACEPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ItemBienSEACE[ itemBienSEACEPK=" + itemBienSEACEPK + " ]";
    }
    
}
