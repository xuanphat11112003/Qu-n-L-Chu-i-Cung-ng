/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "agency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agency.findAll", query = "SELECT a FROM Agency a"),
    @NamedQuery(name = "Agency.findByUserId", query = "SELECT a FROM Agency a WHERE a.userId = :userId"),
    @NamedQuery(name = "Agency.findByType", query = "SELECT a FROM Agency a WHERE a.type = :type")})
public class Agency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    @OneToMany(mappedBy = "agencyId")
    private Collection<Supportcustomer> supportcustomerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private Collection<Exportorder> exportorderCollection;

    public Agency() {
    }

    public Agency(Integer userId) {
        this.userId = userId;
    }

    public Agency(Integer userId, String type) {
        this.userId = userId;
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<Supportcustomer> getSupportcustomerCollection() {
        return supportcustomerCollection;
    }

    public void setSupportcustomerCollection(Collection<Supportcustomer> supportcustomerCollection) {
        this.supportcustomerCollection = supportcustomerCollection;
    }

    @XmlTransient
    public Collection<Exportorder> getExportorderCollection() {
        return exportorderCollection;
    }

    public void setExportorderCollection(Collection<Exportorder> exportorderCollection) {
        this.exportorderCollection = exportorderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agency)) {
            return false;
        }
        Agency other = (Agency) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Agency[ userId=" + userId + " ]";
    }
    
}
