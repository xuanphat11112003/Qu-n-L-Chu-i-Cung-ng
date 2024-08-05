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
@Table(name = "detailexportorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailexportorder.findAll", query = "SELECT d FROM Detailexportorder d"),
    @NamedQuery(name = "Detailexportorder.findById", query = "SELECT d FROM Detailexportorder d WHERE d.id = :id"),
    @NamedQuery(name = "Detailexportorder.findByAmount", query = "SELECT d FROM Detailexportorder d WHERE d.amount = :amount"),
    @NamedQuery(name = "Detailexportorder.findByPrice", query = "SELECT d FROM Detailexportorder d WHERE d.price = :price"),
    @NamedQuery(name = "Detailexportorder.findByDiscount", query = "SELECT d FROM Detailexportorder d WHERE d.discount = :discount"),
    @NamedQuery(name = "Detailexportorder.findByTotalPrice", query = "SELECT d FROM Detailexportorder d WHERE d.totalPrice = :totalPrice")})
public class Detailexportorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "Discount")
    private BigDecimal discount;
    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;
    @JoinColumn(name = "ExportOrderID", referencedColumnName = "id")
    @ManyToOne
    private Exportorders exportOrderID;
    @JoinColumn(name = "ProductID", referencedColumnName = "id")
    @ManyToOne
    private Products productID;

    public Detailexportorder() {
    }

    public Detailexportorder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Exportorders getExportOrderID() {
        return exportOrderID;
    }

    public void setExportOrderID(Exportorders exportOrderID) {
        this.exportOrderID = exportOrderID;
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
        if (!(object instanceof Detailexportorder)) {
            return false;
        }
        Detailexportorder other = (Detailexportorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Detailexportorder[ id=" + id + " ]";
    }
    
}