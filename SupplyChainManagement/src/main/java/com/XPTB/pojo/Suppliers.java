/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "suppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s"),
    @NamedQuery(name = "Suppliers.findById", query = "SELECT s FROM Suppliers s WHERE s.id = :id"),
    @NamedQuery(name = "Suppliers.findByName", query = "SELECT s FROM Suppliers s WHERE s.name = :name"),
    @NamedQuery(name = "Suppliers.findByAddress", query = "SELECT s FROM Suppliers s WHERE s.address = :address"),
    @NamedQuery(name = "Suppliers.findByPhoneNumber", query = "SELECT s FROM Suppliers s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Suppliers.findByEvaluate", query = "SELECT s FROM Suppliers s WHERE s.evaluate = :evaluate")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 100)
    @Column(name = "Address")
    private String address;
    @Size(max = 20)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "FeedBack")
    private String feedBack;
    @Column(name = "Evaluate")
    private Integer evaluate;
    @OneToMany(mappedBy = "supplierID")
    private Set<Materials> materialsSet;
    @OneToMany(mappedBy = "supplierID")
    private Set<Supplierperformance> supplierperformanceSet;

    public Suppliers() {
    }

    public Suppliers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    @XmlTransient
    public Set<Materials> getMaterialsSet() {
        return materialsSet;
    }

    public void setMaterialsSet(Set<Materials> materialsSet) {
        this.materialsSet = materialsSet;
    }

    @XmlTransient
    public Set<Supplierperformance> getSupplierperformanceSet() {
        return supplierperformanceSet;
    }

    public void setSupplierperformanceSet(Set<Supplierperformance> supplierperformanceSet) {
        this.supplierperformanceSet = supplierperformanceSet;
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
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Suppliers[ id=" + id + " ]";
    }
    
}
