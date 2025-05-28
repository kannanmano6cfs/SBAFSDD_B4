package com.learning.orderservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue
    int orderId;
    int prdid;
    String prdname;
    int orderqty;

    public Order() {

    }
    public Order(int orderId, int prdid, String prdname, int orderqty) {
        this.orderId = orderId;
        this.prdid = prdid;
        this.prdname = prdname;
        this.orderqty = orderqty;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrdid() {
        return prdid;
    }

    public void setPrdid(int prdid) {
        this.prdid = prdid;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }
}
