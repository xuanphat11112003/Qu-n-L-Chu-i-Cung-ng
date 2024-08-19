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
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Supplierperformance.findByDeliveryRating", query = "SELECT s FROM Supplierperformance s WHERE s.deliveryRating = :deliveryRating"),
    @NamedQuery(name = "Supplierperformance.findByQualityRating", query = "SELECT s FROM Supplierperformance s WHERE s.qualityRating = :qualityRating"),
    @NamedQuery(name = "Supplierperformance.findByPriceRating", query = "SELECT s FROM Supplierperformance s WHERE s.priceRating = :priceRating")})
public class Supplierperformance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluation_date")
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_rating")
    private int deliveryRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quality_rating")
    private int qualityRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price_rating")
    private int priceRating;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplier;

    public Supplierperformance() {
    }

    public Supplierperformance(Integer id) {
        this.id = id;
    }

    public Supplierperformance(Integer id, Date evaluationDate, int deliveryRating, int qualityRating, int priceRating) {
        this.id = id;
        this.evaluationDate = evaluationDate;
        this.deliveryRating = deliveryRating;
        this.qualityRating = qualityRating;
        this.priceRating = priceRating;
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

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public void setDeliveryRating(int deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
    }

    public int getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(int priceRating) {
        this.priceRating = priceRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
