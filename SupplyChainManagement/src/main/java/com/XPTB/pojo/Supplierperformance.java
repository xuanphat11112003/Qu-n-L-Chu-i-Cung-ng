/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "supplierperformance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplierperformance.findAll", query = "SELECT s FROM Supplierperformance s"),
    @NamedQuery(name = "Supplierperformance.findById", query = "SELECT s FROM Supplierperformance s WHERE s.id = :id"),
    @NamedQuery(name = "Supplierperformance.findByEvaluationDate", query = "SELECT s FROM Supplierperformance s WHERE s.evaluationDate = :evaluationDate"),
    @NamedQuery(name = "Supplierperformance.findByDeliveryTimelinessRating", query = "SELECT s FROM Supplierperformance s WHERE s.deliveryTimelinessRating = :deliveryTimelinessRating"),
    @NamedQuery(name = "Supplierperformance.findByQualityRating", query = "SELECT s FROM Supplierperformance s WHERE s.qualityRating = :qualityRating"),
    @NamedQuery(name = "Supplierperformance.findByCustomerServiceRating", query = "SELECT s FROM Supplierperformance s WHERE s.customerServiceRating = :customerServiceRating")})
public class Supplierperformance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EvaluationDate")
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;
    @Column(name = "DeliveryTimelinessRating")
    private Integer deliveryTimelinessRating;
    @Column(name = "QualityRating")
    private Integer qualityRating;
    @Column(name = "CustomerServiceRating")
    private Integer customerServiceRating;
    @Lob
    @Size(max = 65535)
    @Column(name = "Comments")
    private String comments;
    @JoinColumn(name = "SupplierID", referencedColumnName = "id")
    @ManyToOne
    private Suppliers supplierID;

    public Supplierperformance() {
    }

    public Supplierperformance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Integer getDeliveryTimelinessRating() {
        return deliveryTimelinessRating;
    }

    public void setDeliveryTimelinessRating(Integer deliveryTimelinessRating) {
        this.deliveryTimelinessRating = deliveryTimelinessRating;
    }

    public Integer getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(Integer qualityRating) {
        this.qualityRating = qualityRating;
    }

    public Integer getCustomerServiceRating() {
        return customerServiceRating;
    }

    public void setCustomerServiceRating(Integer customerServiceRating) {
        this.customerServiceRating = customerServiceRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Suppliers getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Suppliers supplierID) {
        this.supplierID = supplierID;
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
        if (!(object instanceof Supplierperformance)) {
            return false;
        }
        Supplierperformance other = (Supplierperformance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Supplierperformance[ id=" + id + " ]";
    }
    
}
