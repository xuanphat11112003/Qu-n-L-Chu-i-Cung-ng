/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "importordercost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importordercost.findAll", query = "SELECT i FROM Importordercost i"),
    @NamedQuery(name = "Importordercost.findById", query = "SELECT i FROM Importordercost i WHERE i.id = :id"),
    @NamedQuery(name = "Importordercost.findByCostType", query = "SELECT i FROM Importordercost i WHERE i.costType = :costType"),
    @NamedQuery(name = "Importordercost.findByCostAmount", query = "SELECT i FROM Importordercost i WHERE i.costAmount = :costAmount"),
    @NamedQuery(name = "Importordercost.findByCostDate", query = "SELECT i FROM Importordercost i WHERE i.costDate = :costDate")})
public class Importordercost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cost_type")
    private String costType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_amount")
    private BigDecimal costAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost_date")
    @Temporal(TemporalType.DATE)
    private Date costDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costid")
    private Collection<Detailsimportordercost> detailsimportordercostCollection;

    public Importordercost() {
    }

    public Importordercost(Integer id) {
        this.id = id;
    }

    public Importordercost(Integer id, String costType, BigDecimal costAmount, Date costDate) {
        this.id = id;
        this.costType = costType;
        this.costAmount = costAmount;
        this.costDate = costDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    @XmlTransient
    public Collection<Detailsimportordercost> getDetailsimportordercostCollection() {
        return detailsimportordercostCollection;
    }

    public void setDetailsimportordercostCollection(Collection<Detailsimportordercost> detailsimportordercostCollection) {
        this.detailsimportordercostCollection = detailsimportordercostCollection;
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
        if (!(object instanceof Importordercost)) {
            return false;
        }
        Importordercost other = (Importordercost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Importordercost[ id=" + id + " ]";
    }
    
}
