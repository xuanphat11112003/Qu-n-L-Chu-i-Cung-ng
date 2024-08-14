/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.XPTB.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Detailsimportordercost.findById", query = "SELECT d FROM Detailsimportordercost d WHERE d.id = :id")})
public class Detailsimportordercost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "import_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Importorder importOrderId;
    @JoinColumn(name = "Cost_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Importordercost costid;

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

    public Importorder getImportOrderId() {
        return importOrderId;
    }

    public void setImportOrderId(Importorder importOrderId) {
        this.importOrderId = importOrderId;
    }

    public Importordercost getCostid() {
        return costid;
    }

    public void setCostid(Importordercost costid) {
        this.costid = costid;
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
