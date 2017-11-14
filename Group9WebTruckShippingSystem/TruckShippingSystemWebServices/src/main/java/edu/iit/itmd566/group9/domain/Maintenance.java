/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Manish Vishwakarma
 */
@Entity
@Table(name = "maintenance")
@NamedQueries({
@NamedQuery(name="Maintenance.getAllMaintenance",query = "select m from Maintenance m")
})
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double cost;
    @Column(name = "description")
    private String desc;
    private String status;

    public Maintenance() {
    }

    public Maintenance(int id, Date date, double cost, String desc, String status, Truck truck) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.desc = desc;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "id=" + id + ", date=" + date + ", cost=" + cost + ", desc=" + desc + ", status=" + status + '}';
    }

}
