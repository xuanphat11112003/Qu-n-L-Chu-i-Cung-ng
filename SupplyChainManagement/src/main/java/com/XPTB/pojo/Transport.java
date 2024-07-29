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
@Table(name = "transport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findById", query = "SELECT t FROM Transport t WHERE t.id = :id"),
    @NamedQuery(name = "Transport.findByPrice", query = "SELECT t FROM Transport t WHERE t.price = :price"),
    @NamedQuery(name = "Transport.findByEvaluate", query = "SELECT t FROM Transport t WHERE t.evaluate = :evaluate"),
    @NamedQuery(name = "Transport.findByDeliveryDate", query = "SELECT t FROM Transport t WHERE t.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Transport.findByShipmentDate", query = "SELECT t FROM Transport t WHERE t.shipmentDate = :shipmentDate")})
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "Price")
    private Integer price;
    @Lob
    @Size(max = 65535)
    @Column(name = "FeedBack")
    private String feedBack;
    @Column(name = "Evaluate")
    private Integer evaluate;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Column(name = "ShipmentDate")
    @Temporal(TemporalType.DATE)
    private Date shipmentDate;
    @JoinColumn(name = "OrderID", referencedColumnName = "id")
    @ManyToOne
    private Exportorders orderID;
    @JoinColumn(name = "TransportCompanyID", referencedColumnName = "id")
    @ManyToOne
    private Transportcompanies transportCompanyID;

    public Transport() {
    }

    public Transport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Exportorders getOrderID() {
        return orderID;
    }

    public void setOrderID(Exportorders orderID) {
        this.orderID = orderID;
    }

    public Transportcompanies getTransportCompanyID() {
        return transportCompanyID;
    }

    public void setTransportCompanyID(Transportcompanies transportCompanyID) {
        this.transportCompanyID = transportCompanyID;
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
        if (!(object instanceof Transport)) {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Transport[ id=" + id + " ]";
    }
    
}
