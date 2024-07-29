/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "detailsimportordercost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detailsimportordercost.findAll", query = "SELECT d FROM Detailsimportordercost d"),
    @NamedQuery(name = "Detailsimportordercost.findById", query = "SELECT d FROM Detailsimportordercost d WHERE d.id = :id"),
    @NamedQuery(name = "Detailsimportordercost.findByCostAmount", query = "SELECT d FROM Detailsimportordercost d WHERE d.costAmount = :costAmount")})
public class Detailsimportordercost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CostAmount")
    private BigDecimal costAmount;
    @JoinColumn(name = "CostID", referencedColumnName = "ID")
    @ManyToOne
    private Importordercosts costID;
    @JoinColumn(name = "ImportOrderID", referencedColumnName = "ID")
    @ManyToOne
    private Importorders importOrderID;

    public Detailsimportordercost() {
    }

    public Detailsimportordercost(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public Importordercosts getCostID() {
        return costID;
    }

    public void setCostID(Importordercosts costID) {
        this.costID = costID;
    }

    public Importorders getImportOrderID() {
        return importOrderID;
    }

    public void setImportOrderID(Importorders importOrderID) {
        this.importOrderID = importOrderID;
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
        if (!(object instanceof Detailsimportordercost)) {
            return false;
        }
        Detailsimportordercost other = (Detailsimportordercost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Detailsimportordercost[ id=" + id + " ]";
    }
    
}
