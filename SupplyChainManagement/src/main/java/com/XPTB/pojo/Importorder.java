/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;
import com.XPTB.utils.StringUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "importorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Importorder.findAll", query = "SELECT i FROM Importorder i"),
    @NamedQuery(name = "Importorder.findById", query = "SELECT i FROM Importorder i WHERE i.id = :id"),
    @NamedQuery(name = "Importorder.findByExpectDate", query = "SELECT i FROM Importorder i WHERE i.expectDate = :expectDate"),
    @NamedQuery(name = "Importorder.findByDeliveryDate", query = "SELECT i FROM Importorder i WHERE i.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Importorder.findByTotalPrice", query = "SELECT i FROM Importorder i WHERE i.totalPrice = :totalPrice"),
    @NamedQuery(name = "Importorder.findByActive", query = "SELECT i FROM Importorder i WHERE i.active = :active"),
    @NamedQuery(name = "Importorder.findByPayment", query = "SELECT i FROM Importorder i WHERE i.payment = :payment")})
public class Importorder implements Serializable {
//    private String v1 = "thanh toán ngay lập tức";
//    private String v2 = "thanh toán sau 1 ngày nhận hóa đơn";
//    private String v3 = "thanh toán sau khi nhận hàng";
    //ENUM('thanh toán ngay lập tức', 'thanh toán sau 1 ngày nhận hóa đơn', 'thanh toán sau khi nhận hàng')

    public enum Payment {
        V1("thanh toán ngay lập tức"),
        V2("thanh toán sau 1 ngày nhận hóa đơn"),
        V3("thanh toán sau khi nhận hàng");
        private String value;

        Payment(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Payment fromValue(String value) {
            for (Payment payment : Payment.values()) {
                if (payment.getValue().equalsIgnoreCase(value)) {
                    return payment;
                }
            }
            throw new IllegalArgumentException("Không tìm thấy giá trị phù hợp cho Payment: " + value);
        }
    }
    @Transient
    private String payenum;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expect_date")
    @Temporal(TemporalType.DATE)
    private Date expectDate;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Column(name = "total_price")
    private Long totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 34)
    @Column(name = "Payment")
    private String payment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importOrderId")
    private Collection<Detailsimportordercost> detailsimportordercostCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importOderID")
    private Collection<Detailimportorder> detailimportorderCollection;

    public Importorder() {
    }

    public Importorder(Integer id) {
        this.id = id;
    }

    public Importorder(Integer id, Date expectDate, boolean active, String payment) {
        this.id = id;
        this.expectDate = expectDate;
        this.active = active;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @XmlTransient
    public Collection<Detailsimportordercost> getDetailsimportordercostCollection() {
        return detailsimportordercostCollection;
    }

    public void setDetailsimportordercostCollection(Collection<Detailsimportordercost> detailsimportordercostCollection) {
        this.detailsimportordercostCollection = detailsimportordercostCollection;
    }

    @XmlTransient
    public Collection<Detailimportorder> getDetailimportorderCollection() {
        return detailimportorderCollection;
    }

    public void setDetailimportorderCollection(Collection<Detailimportorder> detailimportorderCollection) {
        this.detailimportorderCollection = detailimportorderCollection;
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
        if (!(object instanceof Importorder)) {
            return false;
        }
        Importorder other = (Importorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Importorder[ id=" + id + " ]";
    }

}
