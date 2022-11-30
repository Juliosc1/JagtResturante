package com.jagt.jagtresturante.model;

import javax.persistence.*;

@Entity
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long Id;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;

    @Column (name = "discount")
    private Integer discount;

    public Client() {
    }

    public Client(String name, String email, String phone, Integer discount) {
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

    public String getPhone() {
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void discount(Integer discount) {
        this.discount = discount;
    }

}
