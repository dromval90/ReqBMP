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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CATEGORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByCodCia", query = "SELECT c FROM Categorias c WHERE c.categoriasPK.codCia = :codCia"),
    @NamedQuery(name = "Categorias.findByCodCat", query = "SELECT c FROM Categorias c WHERE c.categoriasPK.codCat = :codCat"),
    @NamedQuery(name = "Categorias.findByNomCat", query = "SELECT c FROM Categorias c WHERE c.nomCat = :nomCat"),
    @NamedQuery(name = "Categorias.findByTipoCat", query = "SELECT c FROM Categorias c WHERE c.tipoCat = :tipoCat"),
    @NamedQuery(name = "Categorias.findByCta1", query = "SELECT c FROM Categorias c WHERE c.cta1 = :cta1"),
    @NamedQuery(name = "Categorias.findByCta2", query = "SELECT c FROM Categorias c WHERE c.cta2 = :cta2"),
    @NamedQuery(name = "Categorias.findByCta3", query = "SELECT c FROM Categorias c WHERE c.cta3 = :cta3"),
    @NamedQuery(name = "Categorias.findByCta4", query = "SELECT c FROM Categorias c WHERE c.cta4 = :cta4"),
    @NamedQuery(name = "Categorias.findByCta5", query = "SELECT c FROM Categorias c WHERE c.cta5 = :cta5"),
    @NamedQuery(name = "Categorias.findByVta1", query = "SELECT c FROM Categorias c WHERE c.vta1 = :vta1"),
    @NamedQuery(name = "Categorias.findByVta2", query = "SELECT c FROM Categorias c WHERE c.vta2 = :vta2"),
    @NamedQuery(name = "Categorias.findByVta3", query = "SELECT c FROM Categorias c WHERE c.vta3 = :vta3"),
    @NamedQuery(name = "Categorias.findByVta4", query = "SELECT c FROM Categorias c WHERE c.vta4 = :vta4"),
    @NamedQuery(name = "Categorias.findByVta5", query = "SELECT c FROM Categorias c WHERE c.vta5 = :vta5"),
    @NamedQuery(name = "Categorias.findByInv1", query = "SELECT c FROM Categorias c WHERE c.inv1 = :inv1"),
    @NamedQuery(name = "Categorias.findByInv2", query = "SELECT c FROM Categorias c WHERE c.inv2 = :inv2"),
    @NamedQuery(name = "Categorias.findByInv3", query = "SELECT c FROM Categorias c WHERE c.inv3 = :inv3"),
    @NamedQuery(name = "Categorias.findByInv4", query = "SELECT c FROM Categorias c WHERE c.inv4 = :inv4"),
    @NamedQuery(name = "Categorias.findByInv5", query = "SELECT c FROM Categorias c WHERE c.inv5 = :inv5"),
    @NamedQuery(name = "Categorias.findBySal5", query = "SELECT c FROM Categorias c WHERE c.sal5 = :sal5"),
    @NamedQuery(name = "Categorias.findByEnt1", query = "SELECT c FROM Categorias c WHERE c.ent1 = :ent1"),
    @NamedQuery(name = "Categorias.findByEnt2", query = "SELECT c FROM Categorias c WHERE c.ent2 = :ent2"),
    @NamedQuery(name = "Categorias.findByEnt3", query = "SELECT c FROM Categorias c WHERE c.ent3 = :ent3"),
    @NamedQuery(name = "Categorias.findByEnt4", query = "SELECT c FROM Categorias c WHERE c.ent4 = :ent4"),
    @NamedQuery(name = "Categorias.findByEnt5", query = "SELECT c FROM Categorias c WHERE c.ent5 = :ent5"),
    @NamedQuery(name = "Categorias.findBySal1", query = "SELECT c FROM Categorias c WHERE c.sal1 = :sal1"),
    @NamedQuery(name = "Categorias.findBySal2", query = "SELECT c FROM Categorias c WHERE c.sal2 = :sal2"),
    @NamedQuery(name = "Categorias.findBySal3", query = "SELECT c FROM Categorias c WHERE c.sal3 = :sal3"),
    @NamedQuery(name = "Categorias.findBySal4", query = "SELECT c FROM Categorias c WHERE c.sal4 = :sal4"),
    @NamedQuery(name = "Categorias.findByNomTecnico", query = "SELECT c FROM Categorias c WHERE c.nomTecnico = :nomTecnico"),
    @NamedQuery(name = "Categorias.findByPresup", query = "SELECT c FROM Categorias c WHERE c.presup = :presup")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriasPK categoriasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOM_CAT")
    private String nomCat;
    @Size(max = 1)
    @Column(name = "TIPO_CAT")
    private String tipoCat;
    @Column(name = "CTA_1")
    private Short cta1;
    @Column(name = "CTA_2")
    private Short cta2;
    @Column(name = "CTA_3")
    private Short cta3;
    @Column(name = "CTA_4")
    private Short cta4;
    @Column(name = "CTA_5")
    private Integer cta5;
    @Column(name = "VTA_1")
    private Short vta1;
    @Column(name = "VTA_2")
    private Short vta2;
    @Column(name = "VTA_3")
    private Short vta3;
    @Column(name = "VTA_4")
    private Short vta4;
    @Column(name = "VTA_5")
    private Integer vta5;
    @Column(name = "INV_1")
    private Short inv1;
    @Column(name = "INV_2")
    private Short inv2;
    @Column(name = "INV_3")
    private Short inv3;
    @Column(name = "INV_4")
    private Short inv4;
    @Column(name = "INV_5")
    private Integer inv5;
    @Column(name = "SAL_5")
    private Integer sal5;
    @Column(name = "ENT_1")
    private Short ent1;
    @Column(name = "ENT_2")
    private Short ent2;
    @Column(name = "ENT_3")
    private Short ent3;
    @Column(name = "ENT_4")
    private Short ent4;
    @Column(name = "ENT_5")
    private Integer ent5;
    @Column(name = "SAL_1")
    private Short sal1;
    @Column(name = "SAL_2")
    private Short sal2;
    @Column(name = "SAL_3")
    private Short sal3;
    @Column(name = "SAL_4")
    private Short sal4;
    @Size(max = 15)
    @Column(name = "NOM_TECNICO")
    private String nomTecnico;
    @Size(max = 1)
    @Column(name = "PRESUP")
    private String presup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private List<Ordenenc> ordenencList;
    
    public Categorias() {
    }

    public Categorias(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public Categorias(CategoriasPK categoriasPK, String nomCat) {
        this.categoriasPK = categoriasPK;
        this.nomCat = nomCat;
    }

    public Categorias(short codCia, String codCat) {
        this.categoriasPK = new CategoriasPK(codCia, codCat);
    }

    public CategoriasPK getCategoriasPK() {
        return categoriasPK;
    }

    public void setCategoriasPK(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getTipoCat() {
        return tipoCat;
    }

    public void setTipoCat(String tipoCat) {
        this.tipoCat = tipoCat;
    }

    public Short getCta1() {
        return cta1;
    }

    public void setCta1(Short cta1) {
        this.cta1 = cta1;
    }

    public Short getCta2() {
        return cta2;
    }

    public void setCta2(Short cta2) {
        this.cta2 = cta2;
    }

    public Short getCta3() {
        return cta3;
    }

    public void setCta3(Short cta3) {
        this.cta3 = cta3;
    }

    public Short getCta4() {
        return cta4;
    }

    public void setCta4(Short cta4) {
        this.cta4 = cta4;
    }

    public Integer getCta5() {
        return cta5;
    }

    public void setCta5(Integer cta5) {
        this.cta5 = cta5;
    }

    public Short getVta1() {
        return vta1;
    }

    public void setVta1(Short vta1) {
        this.vta1 = vta1;
    }

    public Short getVta2() {
        return vta2;
    }

    public void setVta2(Short vta2) {
        this.vta2 = vta2;
    }

    public Short getVta3() {
        return vta3;
    }

    public void setVta3(Short vta3) {
        this.vta3 = vta3;
    }

    public Short getVta4() {
        return vta4;
    }

    public void setVta4(Short vta4) {
        this.vta4 = vta4;
    }

    public Integer getVta5() {
        return vta5;
    }

    public void setVta5(Integer vta5) {
        this.vta5 = vta5;
    }

    public Short getInv1() {
        return inv1;
    }

    public void setInv1(Short inv1) {
        this.inv1 = inv1;
    }

    public Short getInv2() {
        return inv2;
    }

    public void setInv2(Short inv2) {
        this.inv2 = inv2;
    }

    public Short getInv3() {
        return inv3;
    }

    public void setInv3(Short inv3) {
        this.inv3 = inv3;
    }

    public Short getInv4() {
        return inv4;
    }

    public void setInv4(Short inv4) {
        this.inv4 = inv4;
    }

    public Integer getInv5() {
        return inv5;
    }

    public void setInv5(Integer inv5) {
        this.inv5 = inv5;
    }

    public Integer getSal5() {
        return sal5;
    }

    public void setSal5(Integer sal5) {
        this.sal5 = sal5;
    }

    public Short getEnt1() {
        return ent1;
    }

    public void setEnt1(Short ent1) {
        this.ent1 = ent1;
    }

    public Short getEnt2() {
        return ent2;
    }

    public void setEnt2(Short ent2) {
        this.ent2 = ent2;
    }

    public Short getEnt3() {
        return ent3;
    }

    public void setEnt3(Short ent3) {
        this.ent3 = ent3;
    }

    public Short getEnt4() {
        return ent4;
    }

    public void setEnt4(Short ent4) {
        this.ent4 = ent4;
    }

    public Integer getEnt5() {
        return ent5;
    }

    public void setEnt5(Integer ent5) {
        this.ent5 = ent5;
    }

    public Short getSal1() {
        return sal1;
    }

    public void setSal1(Short sal1) {
        this.sal1 = sal1;
    }

    public Short getSal2() {
        return sal2;
    }

    public void setSal2(Short sal2) {
        this.sal2 = sal2;
    }

    public Short getSal3() {
        return sal3;
    }

    public void setSal3(Short sal3) {
        this.sal3 = sal3;
    }

    public Short getSal4() {
        return sal4;
    }

    public void setSal4(Short sal4) {
        this.sal4 = sal4;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    public String getPresup() {
        return presup;
    }

    public void setPresup(String presup) {
        this.presup = presup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriasPK != null ? categoriasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.categoriasPK == null && other.categoriasPK != null) || (this.categoriasPK != null && !this.categoriasPK.equals(other.categoriasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Categorias[ categoriasPK=" + categoriasPK + " ]";
    }

    public List<Ordenenc> getOrdenencList() {
        return ordenencList;
    }

    public void setOrdenencList(List<Ordenenc> ordenencList) {
        this.ordenencList = ordenencList;
    }
    
    
    
}
