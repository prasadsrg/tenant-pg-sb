package com.tenant.master.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tenant_master")
public class MasterTenant implements Serializable {


    @Id
    @Column(name = "id")
    private String tenantClientId;


    @Column(name = "db_name",nullable = false)
    private String dbName;


    @Column(name = "url",nullable = false)
    private String url;


    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "driver_class",nullable = false)
    private String driverClass;

    @Column(name = "status",nullable = false)
    private String status;

}
