package com.usmansarwar.hiaichi.Models;

public class UserModel2 {
    String trxid;
    String username;
    String price;
    String tittle;
    String key;



    public UserModel2() {
        this.trxid=trxid;
        this.tittle=tittle;
        this.username=username;
        this.price=price;
        this.key=key;


    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTrxid() {
        return trxid;
    }

    public void setTrxid(String trxid) {
        this.trxid = trxid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
