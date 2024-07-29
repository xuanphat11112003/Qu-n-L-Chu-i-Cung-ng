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
@Table(name = "detailimportorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailimportorder.findAll", query = "SELECT d FROM Detailimportorder d"),
    @NamedQuery(name = "Detailimportorder.findById", query = "SELECT d FROM Detailimportorder d WHERE d.id = :id"),
    @NamedQuery(name = "Detailimportorder.findByQuantity", query = "SELECT d FROM Detailimportorder d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "Detailimportorder.findByTotalAmount", query = "SELECT d FROM Detailimportorder d WHERE d.totalAmount = :totalAmount")})
public class Detailimportorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;
    @JoinColumn(name = "ImportOrderID", referencedColumnName = "ID")
    @ManyToOne
    private Importorders importOrderID;
    @JoinColumn(name = "MaterialID", referencedColumnName = "ID")
    @ManyToOne
    private Materials materialID;

    public Detailimportorder() {
    }

    public Detailimportorder(Integer id) {
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Importorders getImportOrderID() {
        return importOrderID;
    }

    public void setImportOrderID(Importorders importOrderID) {
        this.importOrderID = importOrderID;
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
        if (!(object instanceof Detailimportorder)) {
            return false;
        }
        Detailimportorder other = (Detailimportorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Detailimportorder[ id=" + id + " ]";
    }
    
}
