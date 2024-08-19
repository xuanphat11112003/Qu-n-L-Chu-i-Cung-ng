/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByName", query = "SELECT m FROM Material m WHERE m.name = :name"),
    @NamedQuery(name = "Material.findByPrice", query = "SELECT m FROM Material m WHERE m.price = :price")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialID")
    private Collection<Detailimportorder> detailimportorderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<Manufacture> manufactureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<Materialprice> materialpriceCollection;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Supplier supplierId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialId")
    private Collection<Materialstock> materialstockCollection;

    public Material() {
    }

    public Material(Integer id) {
        this.id = id;
    }

    public Material(Integer id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Detailimportorder> getDetailimportorderCollection() {
        return detailimportorderCollection;
    }

    public void setDetailimportorderCollection(Collection<Detailimportorder> detailimportorderCollection) {
        this.detailimportorderCollection = detailimportorderCollection;
    }

    @XmlTransient
    public Collection<Manufacture> getManufactureCollection() {
        return manufactureCollection;
    }

    public void setManufactureCollection(Collection<Manufacture> manufactureCollection) {
        this.manufactureCollection = manufactureCollection;
    }

    @XmlTransient
    public Collection<Materialprice> getMaterialpriceCollection() {
        return materialpriceCollection;
    }

    public void setMaterialpriceCollection(Collection<Materialprice> materialpriceCollection) {
        this.materialpriceCollection = materialpriceCollection;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    @XmlTransient
    public Collection<Materialstock> getMaterialstockCollection() {
        return materialstockCollection;
    }

    public void setMaterialstockCollection(Collection<Materialstock> materialstockCollection) {
        this.materialstockCollection = materialstockCollection;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Material[ id=" + id + " ]";
    }
    
}
