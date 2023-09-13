package com.tenant.tenant.entity;

import jakarta.persistence.*;
import lombok.Data;



import java.io.Serializable;


@Entity
@Data
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "quantity",nullable = false)
    private String quantity;

    @Column(name = "size",nullable = false,unique = true)
    private String size;

}
