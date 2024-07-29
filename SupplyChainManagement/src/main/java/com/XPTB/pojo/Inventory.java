/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findById", query = "SELECT i FROM Inventory i WHERE i.id = :id"),
    @NamedQuery(name = "Inventory.findByEntryDate", query = "SELECT i FROM Inventory i WHERE i.entryDate = :entryDate"),
    @NamedQuery(name = "Inventory.findByExitDate", query = "SELECT i FROM Inventory i WHERE i.exitDate = :exitDate")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EntryDate")
    @Temporal(TemporalType.DATE)
    private Date entryDate;
    @Column(name = "ExitDate")
    @Temporal(TemporalType.DATE)
    private Date exitDate;
    @OneToMany(mappedBy = "productID")
    private Set<Materialsstock> materialsstockSet;
    @JoinColumn(name = "StockID", referencedColumnName = "ID")
    @ManyToOne
    private Warehouse stockID;
    @OneToMany(mappedBy = "inventoryID")
    private Set<Productstock> productstockSet;

    public Inventory() {
    }

    public Inventory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    @XmlTransient
    public Set<Materialsstock> getMaterialsstockSet() {
        return materialsstockSet;
    }

    public void setMaterialsstockSet(Set<Materialsstock> materialsstockSet) {
        this.materialsstockSet = materialsstockSet;
    }

    public Warehouse getStockID() {
        return stockID;
    }

    public void setStockID(Warehouse stockID) {
        this.stockID = stockID;
    }

    @XmlTransient
    public Set<Productstock> getProductstockSet() {
        return productstockSet;
    }

    public void setProductstockSet(Set<Productstock> productstockSet) {
        this.productstockSet = productstockSet;
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
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Inventory[ id=" + id + " ]";
    }
    
}
