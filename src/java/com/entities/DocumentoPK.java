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
public class DocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CIA")
    private short codCia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DEPTO")
    private short codDepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_TIPO_DOCTO")
    private String codTipoDocto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "NUM_DOCTO")
    private String numDocto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CASO")
    private long numCaso;

    public DocumentoPK() {
    }

    public DocumentoPK(short codCia, short codDepto, String codTipoDocto, String numDocto, long numCaso) {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codTipoDocto = codTipoDocto;
        this.numDocto = numDocto;
        this.numCaso = numCaso;
    }

    public short getCodCia() {
        return codCia;
    }

    public void setCodCia(short codCia) {
        this.codCia = codCia;
    }

    public short getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(short codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodTipoDocto() {
        return codTipoDocto;
    }

    public void setCodTipoDocto(String codTipoDocto) {
        this.codTipoDocto = codTipoDocto;
    }

    public String getNumDocto() {
        return numDocto;
    }

    public void setNumDocto(String numDocto) {
        this.numDocto = numDocto;
    }

    public long getNumCaso() {
        return numCaso;
    }

    public void setNumCaso(long numCaso) {
        this.numCaso = numCaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (codTipoDocto != null ? codTipoDocto.hashCode() : 0);
        hash += (numDocto != null ? numDocto.hashCode() : 0);
        hash += (int) numCaso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPK)) {
            return false;
        }
        DocumentoPK other = (DocumentoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if ((this.codTipoDocto == null && other.codTipoDocto != null) || (this.codTipoDocto != null && !this.codTipoDocto.equals(other.codTipoDocto))) {
            return false;
        }
        if ((this.numDocto == null && other.numDocto != null) || (this.numDocto != null && !this.numDocto.equals(other.numDocto))) {
            return false;
        }
        if (this.numCaso != other.numCaso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.DocumentoPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codTipoDocto=" + codTipoDocto + ", numDocto=" + numDocto + ", numCaso=" + numCaso + " ]";
    }
    
}
