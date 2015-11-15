package org.pegasus.patrimonio.jpa;

import org.pegasus.personal.jpa.Planilla;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mes")
public class Mes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mes_eje")
    private String mesEje;
    @Column(name = "n_mes")
    private Integer nMes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(mappedBy = "mes")
    private Collection<Planilla> planillaCollection;

    public Mes() {
    }

    public Mes(String mesEje) {
        this.mesEje = mesEje;
    }

    public Mes(String mesEje, String nombre) {
        this.mesEje = mesEje;
        this.nombre = nombre;
    }

    public String getMesEje() {
        return mesEje;
    }

    public void setMesEje(String mesEje) {
        this.mesEje = mesEje;
    }

    public Integer getNMes() {
        return nMes;
    }

    public void setNMes(Integer nMes) {
        this.nMes = nMes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Collection<Planilla> getPlanillaCollection() {
        return planillaCollection;
    }

    public void setPlanillaCollection(Collection<Planilla> planillaCollection) {
        this.planillaCollection = planillaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesEje != null ? mesEje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mes)) {
            return false;
        }
        Mes other = (Mes) object;
        if ((this.mesEje == null && other.mesEje != null) || (this.mesEje != null && !this.mesEje.equals(other.mesEje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Mes[ mesEje=" + mesEje + " ]";
    }
    
}
