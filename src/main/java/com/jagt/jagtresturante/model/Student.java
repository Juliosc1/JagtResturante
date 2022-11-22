package com.jagt.jagtresturante.model;

import javax.persistence.*;

@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long Id;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
