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
@Table(name = "transportcompany")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportcompany.findAll", query = "SELECT t FROM Transportcompany t"),
    @NamedQuery(name = "Transportcompany.findById", query = "SELECT t FROM Transportcompany t WHERE t.id = :id"),
    @NamedQuery(name = "Transportcompany.findByName", query = "SELECT t FROM Transportcompany t WHERE t.name = :name"),
    @NamedQuery(name = "Transportcompany.findByPerformanceEvaluation", query = "SELECT t FROM Transportcompany t WHERE t.performanceEvaluation = :performanceEvaluation"),
    @NamedQuery(name = "Transportcompany.findByCooperationCondition", query = "SELECT t FROM Transportcompany t WHERE t.cooperationCondition = :cooperationCondition")})
public class Transportcompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "performance_evaluation")
    private String performanceEvaluation;
    @Size(max = 100)
    @Column(name = "cooperation_condition")
    private String cooperationCondition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportCompanyId")
    private Collection<Transport> transportCollection;

    public Transportcompany() {
    }

    public Transportcompany(Integer id) {
        this.id = id;
    }

    public Transportcompany(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getPerformanceEvaluation() {
        return performanceEvaluation;
    }

    public void setPerformanceEvaluation(String performanceEvaluation) {
        this.performanceEvaluation = performanceEvaluation;
    }

    public String getCooperationCondition() {
        return cooperationCondition;
    }

    public void setCooperationCondition(String cooperationCondition) {
        this.cooperationCondition = cooperationCondition;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection() {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection) {
        this.transportCollection = transportCollection;
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
        if (!(object instanceof Transportcompany)) {
            return false;
        }
        Transportcompany other = (Transportcompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Transportcompany[ id=" + id + " ]";
    }
    
}
