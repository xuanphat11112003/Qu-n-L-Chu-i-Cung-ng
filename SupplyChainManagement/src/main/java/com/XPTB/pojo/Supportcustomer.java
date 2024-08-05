/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "supportcustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supportcustomer.findAll", query = "SELECT s FROM Supportcustomer s"),
    @NamedQuery(name = "Supportcustomer.findById", query = "SELECT s FROM Supportcustomer s WHERE s.id = :id"),
    @NamedQuery(name = "Supportcustomer.findByProblem", query = "SELECT s FROM Supportcustomer s WHERE s.problem = :problem"),
    @NamedQuery(name = "Supportcustomer.findBySupportstate", query = "SELECT s FROM Supportcustomer s WHERE s.supportstate = :supportstate")})
public class Supportcustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "problem")
    private String problem;
    @Size(max = 20)
    @Column(name = "supportstate")
    private String supportstate;
    @JoinColumn(name = "CustomerID", referencedColumnName = "id")
    @ManyToOne
    private Customers customerID;
    @JoinColumn(name = "ExportOrderID", referencedColumnName = "id")
    @ManyToOne
    private Exportorders exportOrderID;

    public Supportcustomer() {
    }

    public Supportcustomer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSupportstate() {
        return supportstate;
    }

    public void setSupportstate(String supportstate) {
        this.supportstate = supportstate;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Exportorders getExportOrderID() {
        return exportOrderID;
    }

    public void setExportOrderID(Exportorders exportOrderID) {
        this.exportOrderID = exportOrderID;
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
        if (!(object instanceof Supportcustomer)) {
            return false;
        }
        Supportcustomer other = (Supportcustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.XPTB.pojo.Supportcustomer[ id=" + id + " ]";
    }
    
}