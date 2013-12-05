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
public class FirmasxtipoDoctoPK implements Serializable {
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
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO")
    private String usuario;

    public FirmasxtipoDoctoPK() {
    }

    public FirmasxtipoDoctoPK(short codCia, short codDepto, String codTipoDocto, String usuario) {
        this.codCia = codCia;
        this.codDepto = codDepto;
        this.codTipoDocto = codTipoDocto;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCia;
        hash += (int) codDepto;
        hash += (codTipoDocto != null ? codTipoDocto.hashCode() : 0);
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmasxtipoDoctoPK)) {
            return false;
        }
        FirmasxtipoDoctoPK other = (FirmasxtipoDoctoPK) object;
        if (this.codCia != other.codCia) {
            return false;
        }
        if (this.codDepto != other.codDepto) {
            return false;
        }
        if ((this.codTipoDocto == null && other.codTipoDocto != null) || (this.codTipoDocto != null && !this.codTipoDocto.equals(other.codTipoDocto))) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.FirmasxtipoDoctoPK[ codCia=" + codCia + ", codDepto=" + codDepto + ", codTipoDocto=" + codTipoDocto + ", usuario=" + usuario + " ]";
    }
    
}
