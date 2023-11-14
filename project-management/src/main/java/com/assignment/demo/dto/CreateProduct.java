package com.assignment.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CreateProduct {
    @NotBlank(message = "Product Code is required")
    private String productCode;
    @NotBlank(message = "Product Category is required")
    private String productCategory;
    @NotBlank(message = "Product Category is required")
    private String productDescription;
    @NotBlank(message = "Brand Name is required")
    private String brandName;
    private String manufacturer;
    private String supplierInformation;
    @NotNull(message = "Number of items in stock is required")
    private Integer inStock;
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be less than zero")
    private Double price;
}
