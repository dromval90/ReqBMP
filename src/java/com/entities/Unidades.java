/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "UNIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u"),
    @NamedQuery(name = "Unidades.findByCodigoUnidad", query = "SELECT u FROM Unidades u WHERE u.codigoUnidad = :codigoUnidad"),
    @NamedQuery(name = "Unidades.findByDescripcion", query = "SELECT u FROM Unidades u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Unidades.findByAbreviatura", query = "SELECT u FROM Unidades u WHERE u.abreviatura = :abreviatura")})
public class Unidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_UNIDAD")
    private Short codigoUnidad;
    @Size(max = 40)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 3)
    @Column(name = "ABREVIATURA")
    private String abreviatura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidades")
    private List<Detorden> detordenList;
    
    public Unidades() {
    }

    public Unidades(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public Short getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUnidad != null ? codigoUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.codigoUnidad == null && other.codigoUnidad != null) || (this.codigoUnidad != null && !this.codigoUnidad.equals(other.codigoUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Unidades[ codigoUnidad=" + codigoUnidad + " ]";
    }

    public List<Detorden> getDetordenList() {
        return detordenList;
    }

    public void setDetordenList(List<Detorden> detordenList) {
        this.detordenList = detordenList;
    }
    
    
    
}
