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
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "feed_back")
    private String feedBack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluate")
    private int evaluate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipment_date")
    @Temporal(TemporalType.DATE)
    private Date shipmentDate;
    @JoinColumn(name = "export_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Exportorder exportOrderId;
    @JoinColumn(name = "transport_company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transportcompany transportCompanyId;

    public Transport() {
    }

    public Transport(Integer id) {
        this.id = id;
    }

    public Transport(Integer id, int price, String feedBack, int evaluate, Date deliveryDate, Date shipmentDate) {
        this.id = id;
        this.price = price;
        this.feedBack = feedBack;
        this.evaluate = evaluate;
        this.deliveryDate = deliveryDate;
        this.shipmentDate = shipmentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
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

    public Exportorder getExportOrderId() {
        return exportOrderId;
    }

    public void setExportOrderId(Exportorder exportOrderId) {
        this.exportOrderId = exportOrderId;
    }

    public Transportcompany getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Transportcompany transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
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
