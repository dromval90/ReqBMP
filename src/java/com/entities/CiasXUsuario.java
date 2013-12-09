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
@Table(name = "CIAS_X_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CiasXUsuario.findAll", query = "SELECT c FROM CiasXUsuario c"),
    @NamedQuery(name = "CiasXUsuario.findCiaEncaragoDepto", query = "SELECT c FROM CiasXUsuario c WHERE c.ciasXUsuarioPK.codCia = :codCia and c.ciasXUsuarioPK.usuario = :usuario"),
    @NamedQuery(name = "CiasXUsuario.findByCodCia", query = "SELECT c FROM CiasXUsuario c WHERE c.ciasXUsuarioPK.codCia = :codCia"),
    @NamedQuery(name = "CiasXUsuario.findByUsuario", query = "SELECT c FROM CiasXUsuario c WHERE c.ciasXUsuarioPK.usuario = :usuario"),
    @NamedQuery(name = "CiasXUsuario.findByDescripcion", query = "SELECT c FROM CiasXUsuario c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CiasXUsuario.findByFirma", query = "SELECT c FROM CiasXUsuario c WHERE c.firma = :firma"),
    @NamedQuery(name = "CiasXUsuario.findByCodEmp", query = "SELECT c FROM CiasXUsuario c WHERE c.codEmp = :codEmp"),
    @NamedQuery(name = "CiasXUsuario.findByCorreoUsuario", query = "SELECT c FROM CiasXUsuario c WHERE c.correoUsuario = :correoUsuario"),
    @NamedQuery(name = "CiasXUsuario.findByPathFirmas", query = "SELECT c FROM CiasXUsuario c WHERE c.pathFirmas = :pathFirmas"),
    @NamedQuery(name = "CiasXUsuario.findByCodVendedor", query = "SELECT c FROM CiasXUsuario c WHERE c.codVendedor = :codVendedor"),
    @NamedQuery(name = "CiasXUsuario.findByVip", query = "SELECT c FROM CiasXUsuario c WHERE c.vip = :vip"),
    @NamedQuery(name = "CiasXUsuario.findByCorreoDepto", query = "SELECT c FROM CiasXUsuario c WHERE c.correoDepto = :correoDepto"),
    @NamedQuery(name = "CiasXUsuario.findByCel", query = "SELECT c FROM CiasXUsuario c WHERE c.cel = :cel"),
    @NamedQuery(name = "CiasXUsuario.findByTmpPdw", query = "SELECT c FROM CiasXUsuario c WHERE c.tmpPdw = :tmpPdw")})
public class CiasXUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiasXUsuarioPK ciasXUsuarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FIRMA")
    private String firma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP")
    private int codEmp;
    @Size(max = 50)
    @Column(name = "CORREO_USUARIO")
    private String correoUsuario;
    @Size(max = 75)
    @Column(name = "PATH_FIRMAS")
    private String pathFirmas;
    @Size(max = 4)
    @Column(name = "COD_VENDEDOR")
    private String codVendedor;
    @Size(max = 1)
    @Column(name = "VIP")
    private String vip;
    @Size(max = 50)
    @Column(name = "CORREO_DEPTO")
    private String correoDepto;
    @Column(name = "CEL")
    private Long cel;
    @Size(max = 25)
    @Column(name = "TMP_PDW")
    private String tmpPdw;

    public CiasXUsuario() {
    }

    public CiasXUsuario(CiasXUsuarioPK ciasXUsuarioPK) {
        this.ciasXUsuarioPK = ciasXUsuarioPK;
    }

    public CiasXUsuario(CiasXUsuarioPK ciasXUsuarioPK, String descripcion, String firma, int codEmp) {
        this.ciasXUsuarioPK = ciasXUsuarioPK;
        this.descripcion = descripcion;
        this.firma = firma;
        this.codEmp = codEmp;
    }

    public CiasXUsuario(short codCia, String usuario) {
        this.ciasXUsuarioPK = new CiasXUsuarioPK(codCia, usuario);
    }

    public CiasXUsuarioPK getCiasXUsuarioPK() {
        return ciasXUsuarioPK;
    }

    public void setCiasXUsuarioPK(CiasXUsuarioPK ciasXUsuarioPK) {
        this.ciasXUsuarioPK = ciasXUsuarioPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getPathFirmas() {
        return pathFirmas;
    }

    public void setPathFirmas(String pathFirmas) {
        this.pathFirmas = pathFirmas;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getCorreoDepto() {
        return correoDepto;
    }

    public void setCorreoDepto(String correoDepto) {
        this.correoDepto = correoDepto;
    }

    public Long getCel() {
        return cel;
    }

    public void setCel(Long cel) {
        this.cel = cel;
    }

    public String getTmpPdw() {
        return tmpPdw;
    }

    public void setTmpPdw(String tmpPdw) {
        this.tmpPdw = tmpPdw;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciasXUsuarioPK != null ? ciasXUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiasXUsuario)) {
            return false;
        }
        CiasXUsuario other = (CiasXUsuario) object;
        if ((this.ciasXUsuarioPK == null && other.ciasXUsuarioPK != null) || (this.ciasXUsuarioPK != null && !this.ciasXUsuarioPK.equals(other.ciasXUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.CiasXUsuario[ ciasXUsuarioPK=" + ciasXUsuarioPK + " ]";
    }
    
}
