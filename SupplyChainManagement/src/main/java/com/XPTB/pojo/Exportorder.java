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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "exportorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exportorder.findAll", query = "SELECT e FROM Exportorder e"),
    @NamedQuery(name = "Exportorder.findById", query = "SELECT e FROM Exportorder e WHERE e.id = :id"),
    @NamedQuery(name = "Exportorder.findByCreateDate", query = "SELECT e FROM Exportorder e WHERE e.createDate = :createDate"),
    @NamedQuery(name = "Exportorder.findByState", query = "SELECT e FROM Exportorder e WHERE e.state = :state"),
    @NamedQuery(name = "Exportorder.findByTotalAmount", query = "SELECT e FROM Exportorder e WHERE e.totalAmount = :totalAmount")})
public class Exportorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "state")
    private String state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exportOrderId")
    private Collection<Transport> transportCollection;
    @OneToMany(mappedBy = "exportOrderId")
    private Collection<Supportcustomer> supportcustomerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exportOrderId")
    private Collection<Detailexportorder> detailexportorderCollection;
    @JoinColumn(name = "agency_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Agency agencyId;

    public Exportorder() {
    }

    public Exportorder(Integer id) {
        this.id = id;
    }

    public Exportorder(Integer id, Date createDate, String state, BigDecimal totalAmount) {
        this.id = id;
        this.createDate = createDate;
        this.state = state;
        this.totalAmount = totalAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection() {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection) {
        this.transportCollection = transportCollection;
    }

    @XmlTransient
    public Collection<Supportcustomer> getSupportcustomerCollection() {
        return supportcustomerCollection;
    }

    public void setSupportcustomerCollection(Collection<Supportcustomer> supportcustomerCollection) {
        this.supportcustomerCollection = supportcustomerCollection;
    }

    @XmlTransient
    public Collection<Detailexportorder> getDetailexportorderCollection() {
        return detailexportorderCollection;
    }

    public void setDetailexportorderCollection(Collection<Detailexportorder> detailexportorderCollection) {
        this.detailexportorderCollection = detailexportorderCollection;
    }

    public Agency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Agency agencyId) {
        this.agencyId = agencyId;
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
        if (!(object instanceof Exportorder)) {
            return false;
        }
        Exportorder other = (Exportorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Exportorder[ id=" + id + " ]";
    }
    
}
