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
@Table(name = "TIPO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findNomTipoDoc", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codCia = :codCia and t.tipoDocumentoPK.codTipoDocto = :codTipoDocto and t.tipoDocumentoPK.codDepto = :codDepto"),
    @NamedQuery(name = "TipoDocumento.findByCodCia", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codCia = :codCia"),
    @NamedQuery(name = "TipoDocumento.findByCodDepto", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codDepto = :codDepto"),
    @NamedQuery(name = "TipoDocumento.findByCodTipoDocto", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoPK.codTipoDocto = :codTipoDocto"),
    @NamedQuery(name = "TipoDocumento.findByUsaAutorizacion", query = "SELECT t FROM TipoDocumento t WHERE t.usaAutorizacion = :usaAutorizacion"),
    @NamedQuery(name = "TipoDocumento.findByNomTipoDocto", query = "SELECT t FROM TipoDocumento t WHERE t.nomTipoDocto = :nomTipoDocto")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoDocumentoPK tipoDocumentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USA_AUTORIZACION")
    private String usaAutorizacion;
    @Size(max = 50)
    @Column(name = "NOM_TIPO_DOCTO")
    private String nomTipoDocto;

    public TipoDocumento() {
    }

    public TipoDocumento(TipoDocumentoPK tipoDocumentoPK) {
        this.tipoDocumentoPK = tipoDocumentoPK;
    }

    public TipoDocumento(TipoDocumentoPK tipoDocumentoPK, String usaAutorizacion) {
        this.tipoDocumentoPK = tipoDocumentoPK;
        this.usaAutorizacion = usaAutorizacion;
    }

    public TipoDocumento(short codCia, short codDepto, String codTipoDocto) {
        this.tipoDocumentoPK = new TipoDocumentoPK(codCia, codDepto, codTipoDocto);
    }

    public TipoDocumentoPK getTipoDocumentoPK() {
        return tipoDocumentoPK;
    }

    public void setTipoDocumentoPK(TipoDocumentoPK tipoDocumentoPK) {
        this.tipoDocumentoPK = tipoDocumentoPK;
    }

    public String getUsaAutorizacion() {
        return usaAutorizacion;
    }

    public void setUsaAutorizacion(String usaAutorizacion) {
        this.usaAutorizacion = usaAutorizacion;
    }

    public String getNomTipoDocto() {
        return nomTipoDocto;
    }

    public void setNomTipoDocto(String nomTipoDocto) {
        this.nomTipoDocto = nomTipoDocto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocumentoPK != null ? tipoDocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocumentoPK == null && other.tipoDocumentoPK != null) || (this.tipoDocumentoPK != null && !this.tipoDocumentoPK.equals(other.tipoDocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.TipoDocumento[ tipoDocumentoPK=" + tipoDocumentoPK + " ]";
    }
    
}
