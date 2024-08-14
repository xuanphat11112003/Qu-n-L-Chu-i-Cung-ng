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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigDecimal discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @JoinColumn(name = "export_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Exportorder exportOrderId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public Detailexportorder() {
    }

    public Detailexportorder(Integer id) {
        this.id = id;
    }

    public Detailexportorder(Integer id, int amount, BigDecimal price, BigDecimal discount, BigDecimal totalPrice) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public Exportorder getExportOrderId() {
        return exportOrderId;
    }

    public void setExportOrderId(Exportorder exportOrderId) {
        this.exportOrderId = exportOrderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
