/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "materialprice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialprice.findAll", query = "SELECT m FROM Materialprice m"),
    @NamedQuery(name = "Materialprice.findById", query = "SELECT m FROM Materialprice m WHERE m.id = :id"),
    @NamedQuery(name = "Materialprice.findByUnitPrice", query = "SELECT m FROM Materialprice m WHERE m.unitPrice = :unitPrice"),
    @NamedQuery(name = "Materialprice.findByChangeDate", query = "SELECT m FROM Materialprice m WHERE m.changeDate = :changeDate")})
public class Materialprice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "change_date")
    @Temporal(TemporalType.DATE)
    private Date changeDate;
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialId;

    public Materialprice() {
    }

    public Materialprice(Integer id) {
        this.id = id;
    }

    public Materialprice(Integer id, BigDecimal unitPrice, Date changeDate) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.changeDate = changeDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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
        if (!(object instanceof Materialprice)) {
            return false;
        }
        Materialprice other = (Materialprice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Materialprice[ id=" + id + " ]";
    }
    
}
