/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.domain;

import java.lang.annotation.Native;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity(name = "OrderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

//    @Native
//    @Column(name = "OrdDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private String locFrom;

    private String locTo;

    private String custName;

    private String vin;

    private Integer amt;

    /**
     * Get the value of amt
     *
     * @return the value of amt
     */
    public Integer getAmt() {
        return amt;
    }

    /**
     * Set the value of amt
     *
     * @param amt new value of amt
     */
    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    /**
     * Get the value of vin
     *
     * @return the value of vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * Set the value of vin
     *
     * @param vin new value of vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Get the value of custName
     *
     * @return the value of custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * Set the value of custName
     *
     * @param custName new value of custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * Get the value of locTo
     *
     * @return the value of locTo
     */
    public String getLocTo() {
        return locTo;
    }

    /**
     * Set the value of locTo
     *
     * @param locTo new value of locTo
     */
    public void setLocTo(String locTo) {
        this.locTo = locTo;
    }

    /**
     * Get the value of locFrom
     *
     * @return the value of locFrom
     */
    public String getLocFrom() {
        return locFrom;
    }

    /**
     * Set the value of locFrom
     *
     * @param locFrom new value of locFrom
     */
    public void setLocFrom(String locFrom) {
        this.locFrom = locFrom;
    }

    /**
     * Get the value of orderDate
     *
     * @return the value of orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the value of orderDate
     *
     * @param orderDate new value of orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
