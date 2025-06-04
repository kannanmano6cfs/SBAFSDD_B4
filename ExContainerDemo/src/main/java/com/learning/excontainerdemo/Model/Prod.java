package com.learning.excontainerdemo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Prod {

    @Id
    @GeneratedValue
    int prodid;
    String prodname;
    String proddesc;
    String prodprice;

    public Prod() {
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProddesc() {
        return proddesc;
    }

    public void setProddesc(String proddesc) {
        this.proddesc = proddesc;
    }

    public String getProdprice() {
        return prodprice;
    }

    public void setProdprice(String prodprice) {
        this.prodprice = prodprice;
    }
}
