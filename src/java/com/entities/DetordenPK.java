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
public class DetordenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NUM_ORDEN")
    private String numOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_PROD")
    private String codProd;

    public DetordenPK() {
    }

    public DetordenPK(String numOrden, short codCia, String codProd) {
        this.numOrden = numOrden;
        this.codCia = codCia;
        this.codProd = codProd;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numOrden != null ? numOrden.hashCode() : 0);
        hash += (int) codCia;
        hash += (codProd != null ? codProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetordenPK)) {
            return false;
        }
        DetordenPK other = (DetordenPK) object;
        if ((this.numOrden == null && other.numOrden != null) || (this.numOrden != null && !this.numOrden.equals(other.numOrden))) {
            return false;
        }
        if (this.codCia != other.codCia) {
            return false;
        }
        if ((this.codProd == null && other.codProd != null) || (this.codProd != null && !this.codProd.equals(other.codProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.DetordenPK[ numOrden=" + numOrden + ", codCia=" + codCia + ", codProd=" + codProd + " ]";
    }
    
}
