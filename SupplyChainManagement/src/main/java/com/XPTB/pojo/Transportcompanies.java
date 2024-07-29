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
@Table(name = "transportcompanies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportcompanies.findAll", query = "SELECT t FROM Transportcompanies t"),
    @NamedQuery(name = "Transportcompanies.findById", query = "SELECT t FROM Transportcompanies t WHERE t.id = :id"),
    @NamedQuery(name = "Transportcompanies.findByTransportCompanyName", query = "SELECT t FROM Transportcompanies t WHERE t.transportCompanyName = :transportCompanyName"),
    @NamedQuery(name = "Transportcompanies.findByInformation", query = "SELECT t FROM Transportcompanies t WHERE t.information = :information"),
    @NamedQuery(name = "Transportcompanies.findByTermsOfCooperation", query = "SELECT t FROM Transportcompanies t WHERE t.termsOfCooperation = :termsOfCooperation")})
public class Transportcompanies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TransportCompanyName")
    private String transportCompanyName;
    @Size(max = 500)
    @Column(name = "Information")
    private String information;
    @Size(max = 100)
    @Column(name = "TermsOfCooperation")
    private String termsOfCooperation;
    @OneToMany(mappedBy = "transportCompanyID")
    private Set<Transport> transportSet;

    public Transportcompanies() {
    }

    public Transportcompanies(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransportCompanyName() {
        return transportCompanyName;
    }

    public void setTransportCompanyName(String transportCompanyName) {
        this.transportCompanyName = transportCompanyName;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTermsOfCooperation() {
        return termsOfCooperation;
    }

    public void setTermsOfCooperation(String termsOfCooperation) {
        this.termsOfCooperation = termsOfCooperation;
    }

    @XmlTransient
    public Set<Transport> getTransportSet() {
        return transportSet;
    }

    public void setTransportSet(Set<Transport> transportSet) {
        this.transportSet = transportSet;
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
        if (!(object instanceof Transportcompanies)) {
            return false;
        }
        Transportcompanies other = (Transportcompanies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Transportcompanies[ id=" + id + " ]";
    }
    
}
