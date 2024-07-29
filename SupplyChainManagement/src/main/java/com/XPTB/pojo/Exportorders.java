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
@Table(name = "exportorders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exportorders.findAll", query = "SELECT e FROM Exportorders e"),
    @NamedQuery(name = "Exportorders.findById", query = "SELECT e FROM Exportorders e WHERE e.id = :id"),
    @NamedQuery(name = "Exportorders.findByCreateDate", query = "SELECT e FROM Exportorders e WHERE e.createDate = :createDate"),
    @NamedQuery(name = "Exportorders.findByState", query = "SELECT e FROM Exportorders e WHERE e.state = :state"),
    @NamedQuery(name = "Exportorders.findByTotalAmount", query = "SELECT e FROM Exportorders e WHERE e.totalAmount = :totalAmount")})
public class Exportorders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 25)
    @Column(name = "State")
    private String state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;
    @OneToMany(mappedBy = "orderID")
    private Set<Transport> transportSet;
    @OneToMany(mappedBy = "exportOrderID")
    private Set<Supportcustomer> supportcustomerSet;
    @OneToMany(mappedBy = "exportOrderID")
    private Set<Detailexportorder> detailexportorderSet;

    public Exportorders() {
    }

    public Exportorders(Integer id) {
        this.id = id;
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
    public Set<Transport> getTransportSet() {
        return transportSet;
    }

    public void setTransportSet(Set<Transport> transportSet) {
        this.transportSet = transportSet;
    }

    @XmlTransient
    public Set<Supportcustomer> getSupportcustomerSet() {
        return supportcustomerSet;
    }

    public void setSupportcustomerSet(Set<Supportcustomer> supportcustomerSet) {
        this.supportcustomerSet = supportcustomerSet;
    }

    @XmlTransient
    public Set<Detailexportorder> getDetailexportorderSet() {
        return detailexportorderSet;
    }

    public void setDetailexportorderSet(Set<Detailexportorder> detailexportorderSet) {
        this.detailexportorderSet = detailexportorderSet;
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
        if (!(object instanceof Exportorders)) {
            return false;
        }
        Exportorders other = (Exportorders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Exportorders[ id=" + id + " ]";
    }
    
}
