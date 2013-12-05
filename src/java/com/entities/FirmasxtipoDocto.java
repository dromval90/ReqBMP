/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "FIRMASXTIPO_DOCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FirmasxtipoDocto.findAll", query = "SELECT f FROM FirmasxtipoDocto f"),
    @NamedQuery(name = "FirmasxtipoDocto.findByCodCia", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.firmasxtipoDoctoPK.codCia = :codCia"),
    @NamedQuery(name = "FirmasxtipoDocto.findByCodDepto", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.firmasxtipoDoctoPK.codDepto = :codDepto"),
    @NamedQuery(name = "FirmasxtipoDocto.findByCodTipoDocto", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.firmasxtipoDoctoPK.codTipoDocto = :codTipoDocto"),
    @NamedQuery(name = "FirmasxtipoDocto.findByUsuario", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.firmasxtipoDoctoPK.usuario = :usuario"),
    @NamedQuery(name = "FirmasxtipoDocto.findByFirmaActivo", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.firmaActivo = :firmaActivo"),
    @NamedQuery(name = "FirmasxtipoDocto.findByPrioridad", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.prioridad = :prioridad"),
    @NamedQuery(name = "FirmasxtipoDocto.findByValidadGrupinv", query = "SELECT f FROM FirmasxtipoDocto f WHERE f.validadGrupinv = :validadGrupinv")})
public class FirmasxtipoDocto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected com.entities.FirmasxtipoDoctoPK firmasxtipoDoctoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FIRMA_ACTIVO")
    private String firmaActivo;
    @Column(name = "PRIORIDAD")
    private Short prioridad;
    @Size(max = 1)
    @Column(name = "VALIDAD_GRUPINV")
    private String validadGrupinv;

    public FirmasxtipoDocto() {
    }

    public FirmasxtipoDocto(com.entities.FirmasxtipoDoctoPK firmasxtipoDoctoPK) {
        this.firmasxtipoDoctoPK = firmasxtipoDoctoPK;
    }

    public FirmasxtipoDocto(com.entities.FirmasxtipoDoctoPK firmasxtipoDoctoPK, String firmaActivo) {
        this.firmasxtipoDoctoPK = firmasxtipoDoctoPK;
        this.firmaActivo = firmaActivo;
    }

    public FirmasxtipoDocto(short codCia, short codDepto, String codTipoDocto, String usuario) {
        this.firmasxtipoDoctoPK = new FirmasxtipoDoctoPK(codCia, codDepto, codTipoDocto, usuario);
    }

    public com.entities.FirmasxtipoDoctoPK getFirmasxtipoDoctoPK() {
        return firmasxtipoDoctoPK;
    }

    public void setFirmasxtipoDoctoPK(com.entities.FirmasxtipoDoctoPK firmasxtipoDoctoPK) {
        this.firmasxtipoDoctoPK = firmasxtipoDoctoPK;
    }

    public String getFirmaActivo() {
        return firmaActivo;
    }

    public void setFirmaActivo(String firmaActivo) {
        this.firmaActivo = firmaActivo;
    }

    public Short getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Short prioridad) {
        this.prioridad = prioridad;
    }

    public String getValidadGrupinv() {
        return validadGrupinv;
    }

    public void setValidadGrupinv(String validadGrupinv) {
        this.validadGrupinv = validadGrupinv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firmasxtipoDoctoPK != null ? firmasxtipoDoctoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmasxtipoDocto)) {
            return false;
        }
        FirmasxtipoDocto other = (FirmasxtipoDocto) object;
        if ((this.firmasxtipoDoctoPK == null && other.firmasxtipoDoctoPK != null) || (this.firmasxtipoDoctoPK != null && !this.firmasxtipoDoctoPK.equals(other.firmasxtipoDoctoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.FirmasxtipoDocto[ firmasxtipoDoctoPK=" + firmasxtipoDoctoPK + " ]";
    }
    
}
