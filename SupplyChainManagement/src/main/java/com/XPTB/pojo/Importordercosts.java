/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "importordercosts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importordercosts.findAll", query = "SELECT i FROM Importordercosts i"),
    @NamedQuery(name = "Importordercosts.findById", query = "SELECT i FROM Importordercosts i WHERE i.id = :id"),
    @NamedQuery(name = "Importordercosts.findByCostType", query = "SELECT i FROM Importordercosts i WHERE i.costType = :costType"),
    @NamedQuery(name = "Importordercosts.findByCostAmount", query = "SELECT i FROM Importordercosts i WHERE i.costAmount = :costAmount"),
    @NamedQuery(name = "Importordercosts.findByCostDate", query = "SELECT i FROM Importordercosts i WHERE i.costDate = :costDate")})
public class Importordercosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "CostType")
    private String costType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CostAmount")
    private BigDecimal costAmount;
    @Column(name = "CostDate")
    @Temporal(TemporalType.DATE)
    private Date costDate;
    @OneToMany(mappedBy = "costID")
    private Set<Detailsimportordercost> detailsimportordercostSet;

    public Importordercosts() {
    }

    public Importordercosts(Integer id) {
        this.id = id;
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
    public Set<Detailsimportordercost> getDetailsimportordercostSet() {
        return detailsimportordercostSet;
    }

    public void setDetailsimportordercostSet(Set<Detailsimportordercost> detailsimportordercostSet) {
        this.detailsimportordercostSet = detailsimportordercostSet;
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
        if (!(object instanceof Importordercosts)) {
            return false;
        }
        Importordercosts other = (Importordercosts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Importordercosts[ id=" + id + " ]";
    }
    
}
