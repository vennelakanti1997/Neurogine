package com.assignment.demo.entiy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
//Excluding id and product info because they are sensitive info
@ToString(exclude = {"id","supplierInformation","manufacturer"})
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "product_code", nullable = false, unique = true, length = 10)
    private String productCode;

    @Column(name = "product_category",nullable = false, length = 50)
    private String productCategory;

    @Column(name = "product_description", nullable = false, length = 500)
    @ColumnDefault(value = "'Not Available'")
    private String productDescription;

    @Column(name = "brand_name",nullable = false,length = 100)
    private String brandName;

    @Column(name = "manufacturer", nullable = false)
    @ColumnDefault(value = "'Not Available'")
    private String manufacturer;

    @Column(name = "supplier_information", length = 500)
    @ColumnDefault(value = "'Not Available'")
    private String supplierInformation;

    @Column(name = "in_stock", nullable = false)
    @ColumnDefault(value = "0")
    private Integer inStock;

    @Column(name = "price",nullable = false)
    private Double price;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_on")
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_on")
    private Date updatedOn;
}
