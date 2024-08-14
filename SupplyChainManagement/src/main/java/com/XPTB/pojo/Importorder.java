/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "importorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importorder.findAll", query = "SELECT i FROM Importorder i"),
    @NamedQuery(name = "Importorder.findById", query = "SELECT i FROM Importorder i WHERE i.id = :id"),
    @NamedQuery(name = "Importorder.findByExpectDate", query = "SELECT i FROM Importorder i WHERE i.expectDate = :expectDate"),
    @NamedQuery(name = "Importorder.findByDeliveryDate", query = "SELECT i FROM Importorder i WHERE i.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Importorder.findByTotalPrice", query = "SELECT i FROM Importorder i WHERE i.totalPrice = :totalPrice"),
    @NamedQuery(name = "Importorder.findByTotalCost", query = "SELECT i FROM Importorder i WHERE i.totalCost = :totalCost"),
    @NamedQuery(name = "Importorder.findByActive", query = "SELECT i FROM Importorder i WHERE i.active = :active")})
public class Importorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expect_date")
    @Temporal(TemporalType.DATE)
    private Date expectDate;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Column(name = "total_price")
    private Long totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cost")
    private long totalCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importOrderId")
    private Collection<Detailsimportordercost> detailsimportordercostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importOderID")
    private Collection<Detailimportorder> detailimportorderCollection;

    public Importorder() {
    }

    public Importorder(Integer id) {
        this.id = id;
    }

    public Importorder(Integer id, Date expectDate, long totalCost, boolean active) {
        this.id = id;
        this.expectDate = expectDate;
        this.totalCost = totalCost;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Detailsimportordercost> getDetailsimportordercostCollection() {
        return detailsimportordercostCollection;
    }

    public void setDetailsimportordercostCollection(Collection<Detailsimportordercost> detailsimportordercostCollection) {
        this.detailsimportordercostCollection = detailsimportordercostCollection;
    }

    @XmlTransient
    public Collection<Detailimportorder> getDetailimportorderCollection() {
        return detailimportorderCollection;
    }

    public void setDetailimportorderCollection(Collection<Detailimportorder> detailimportorderCollection) {
        this.detailimportorderCollection = detailimportorderCollection;
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
        if (!(object instanceof Importorder)) {
            return false;
        }
        Importorder other = (Importorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Importorder[ id=" + id + " ]";
    }
    
}
