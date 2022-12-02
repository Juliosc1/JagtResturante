package com.jagt.jagtresturante.model;

import javax.persistence.*;

@Entity
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long Id;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private Integer phone;

    @Column (name = "discount")
    private Integer discount;

    public Customer() {
    }

    public Customer(String name, String email, Integer phone, Integer discount) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.discount = discount;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhone() {
        return phone;
    }

    public Integer discount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void discount(Integer discount) {
        this.discount = discount;
    }

}
