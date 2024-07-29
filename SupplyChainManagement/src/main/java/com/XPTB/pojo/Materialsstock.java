/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
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
@Table(name = "materialsstock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialsstock.findAll", query = "SELECT m FROM Materialsstock m"),
    @NamedQuery(name = "Materialsstock.findById", query = "SELECT m FROM Materialsstock m WHERE m.id = :id"),
    @NamedQuery(name = "Materialsstock.findByAmount", query = "SELECT m FROM Materialsstock m WHERE m.amount = :amount")})
public class Materialsstock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Amount")
    private Integer amount;
    @JoinColumn(name = "ProductID", referencedColumnName = "ID")
    @ManyToOne
    private Inventory productID;
    @JoinColumn(name = "MaterialID", referencedColumnName = "ID")
    @ManyToOne
    private Materials materialID;

    public Materialsstock() {
    }

    public Materialsstock(Integer id) {
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

    public Inventory getProductID() {
        return productID;
    }

    public void setProductID(Inventory productID) {
        this.productID = productID;
    }

    public Materials getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Materials materialID) {
        this.materialID = materialID;
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
        if (!(object instanceof Materialsstock)) {
            return false;
        }
        Materialsstock other = (Materialsstock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Materialsstock[ id=" + id + " ]";
    }
    
}
