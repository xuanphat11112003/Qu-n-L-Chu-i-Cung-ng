/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "productstock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productstock.findAll", query = "SELECT p FROM Productstock p"),
    @NamedQuery(name = "Productstock.findById", query = "SELECT p FROM Productstock p WHERE p.id = :id"),
    @NamedQuery(name = "Productstock.findByQuantity", query = "SELECT p FROM Productstock p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Productstock.findByTotalProductValue", query = "SELECT p FROM Productstock p WHERE p.totalProductValue = :totalProductValue")})
public class Productstock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalProductValue")
    private BigDecimal totalProductValue;
    @JoinColumn(name = "InventoryID", referencedColumnName = "ID")
    @ManyToOne
    private Inventory inventoryID;
    @JoinColumn(name = "ProductID", referencedColumnName = "id")
    @ManyToOne
    private Products productID;

    public Productstock() {
    }

    public Productstock(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalProductValue() {
        return totalProductValue;
    }

    public void setTotalProductValue(BigDecimal totalProductValue) {
        this.totalProductValue = totalProductValue;
    }

    public Inventory getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Inventory inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
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
        if (!(object instanceof Productstock)) {
            return false;
        }
        Productstock other = (Productstock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Productstock[ id=" + id + " ]";
    }
    
}
