/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dromero
 */
@Embeddable
public class CategoriasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_CAT")
    private String codCat;

    public CategoriasPK() {
    }

    public CategoriasPK(short codCia, String codCat) {
        this.codCia = codCia;
        this.codCat = codCat;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (codCat != null ? codCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasPK)) {
            return false;
        }
        CategoriasPK other = (CategoriasPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.codCat == null && other.codCat != null) || (this.codCat != null && !this.codCat.equals(other.codCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.CategoriasPK[ codCia=" + codCia + ", codCat=" + codCat + " ]";
    }
    
}
