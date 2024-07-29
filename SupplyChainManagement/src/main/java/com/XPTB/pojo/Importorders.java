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
@Table(name = "importorders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importorders.findAll", query = "SELECT i FROM Importorders i"),
    @NamedQuery(name = "Importorders.findById", query = "SELECT i FROM Importorders i WHERE i.id = :id"),
    @NamedQuery(name = "Importorders.findByExpectDate", query = "SELECT i FROM Importorders i WHERE i.expectDate = :expectDate"),
    @NamedQuery(name = "Importorders.findByDeliveryDate", query = "SELECT i FROM Importorders i WHERE i.deliveryDate = :deliveryDate")})
public class Importorders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ExpectDate")
    @Temporal(TemporalType.DATE)
    private Date expectDate;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @OneToMany(mappedBy = "importOrderID")
    private Set<Detailsimportordercost> detailsimportordercostSet;
    @OneToMany(mappedBy = "importOrderID")
    private Set<Detailimportorder> detailimportorderSet;
    @OneToMany(mappedBy = "importOrderID")
    private Set<Payments> paymentsSet;

    public Importorders() {
    }

    public Importorders(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Set<Detailsimportordercost> getDetailsimportordercostSet() {
        return detailsimportordercostSet;
    }

    public void setDetailsimportordercostSet(Set<Detailsimportordercost> detailsimportordercostSet) {
        this.detailsimportordercostSet = detailsimportordercostSet;
    }

    @XmlTransient
    public Set<Detailimportorder> getDetailimportorderSet() {
        return detailimportorderSet;
    }

    public void setDetailimportorderSet(Set<Detailimportorder> detailimportorderSet) {
        this.detailimportorderSet = detailimportorderSet;
    }

    @XmlTransient
    public Set<Payments> getPaymentsSet() {
        return paymentsSet;
    }

    public void setPaymentsSet(Set<Payments> paymentsSet) {
        this.paymentsSet = paymentsSet;
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
        if (!(object instanceof Importorders)) {
            return false;
        }
        Importorders other = (Importorders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Importorders[ id=" + id + " ]";
    }
    
}
