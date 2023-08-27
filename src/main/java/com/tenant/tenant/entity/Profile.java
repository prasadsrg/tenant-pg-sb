package com.tenant.tenant.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name",nullable = false)
    private String fullName;


    @Column(name = "gender",nullable = false)
    private String gender;


    @Column(name = "user_name",nullable = false,unique = true)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "status",nullable = false)
    private String status;

    public Profile() {
    }

    public Profile(String fullName, String gender, String userName, String password, String status) {
        this.fullName = fullName;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Profile setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Profile setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Profile setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Profile setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Profile setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Profile setStatus(String status) {
        this.status = status;
        return this;
    }
}
