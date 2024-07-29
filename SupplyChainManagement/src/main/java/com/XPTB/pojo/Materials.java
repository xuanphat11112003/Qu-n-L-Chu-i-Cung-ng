/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m"),
    @NamedQuery(name = "Materials.findById", query = "SELECT m FROM Materials m WHERE m.id = :id"),
    @NamedQuery(name = "Materials.findByName", query = "SELECT m FROM Materials m WHERE m.name = :name"),
    @NamedQuery(name = "Materials.findByPrice", query = "SELECT m FROM Materials m WHERE m.price = :price")})
public class Materials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;
    @OneToMany(mappedBy = "materialID")
    private Set<Detailimportorder> detailimportorderSet;
    @OneToMany(mappedBy = "materialID")
    private Set<Materialsstock> materialsstockSet;
    @OneToMany(mappedBy = "materialID")
    private Set<Materialprice> materialpriceSet;
    @JoinColumn(name = "SupplierID", referencedColumnName = "id")
    @ManyToOne
    private Suppliers supplierID;

    public Materials() {
    }

    public Materials(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public Set<Detailimportorder> getDetailimportorderSet() {
        return detailimportorderSet;
    }

    public void setDetailimportorderSet(Set<Detailimportorder> detailimportorderSet) {
        this.detailimportorderSet = detailimportorderSet;
    }

    @XmlTransient
    public Set<Materialsstock> getMaterialsstockSet() {
        return materialsstockSet;
    }

    public void setMaterialsstockSet(Set<Materialsstock> materialsstockSet) {
        this.materialsstockSet = materialsstockSet;
    }

    @XmlTransient
    public Set<Materialprice> getMaterialpriceSet() {
        return materialpriceSet;
    }

    public void setMaterialpriceSet(Set<Materialprice> materialpriceSet) {
        this.materialpriceSet = materialpriceSet;
    }

    public Suppliers getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Suppliers supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materials)) {
            return false;
        }
        Materials other = (Materials) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Materials[ id=" + id + " ]";
    }
    
}
