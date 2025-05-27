package com.learning.productservice.Model;

import com.learning.productservice.Util.ValidName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int prdid;
    @ValidName
    private String prdname;
    @Positive(message="Only absolute price value to be given")
    private double prdprice;
    @NotEmpty(message="Product description is required")
    private String prddesc;

    public Product() {
    }

    public Product(int prdid, String prdname, double prdprice, String prddesc) {
        this.prdid = prdid;
        this.prdname = prdname;
        this.prdprice = prdprice;
        this.prddesc = prddesc;
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

    public double getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(double prdprice) {
        this.prdprice = prdprice;
    }

    public String getPrddesc() {
        return prddesc;
    }

    public void setPrddesc(String prddesc) {
        this.prddesc = prddesc;
    }
}
