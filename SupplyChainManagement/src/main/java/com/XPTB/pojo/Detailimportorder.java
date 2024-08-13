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
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @JoinColumn(name = "import_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Importorder importOrderId;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;

    public Detailimportorder() {
    }

    public Detailimportorder(Integer id) {
        this.id = id;
    }

    public Detailimportorder(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Importorder getImportOrderId() {
        return importOrderId;
    }

    public void setImportOrderId(Importorder importOrderId) {
        this.importOrderId = importOrderId;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
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
