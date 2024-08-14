/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_amount")
    private Long totalAmount;
    @JoinColumn(name = "ImportOder_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Importorder importOderID;
    @JoinColumn(name = "Material_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialID;

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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Importorder getImportOderID() {
        return importOderID;
    }

    public void setImportOderID(Importorder importOderID) {
        this.importOderID = importOderID;
    }

    public Material getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Material materialID) {
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
