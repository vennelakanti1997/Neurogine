package com.assignment.demo.service;

import com.assignment.demo.dto.CreateProduct;

import java.util.List;

public interface ProductCrudService {

    /**
     *
     * @param createProduct
     * @return created Object
     */
    CreateProduct createProduct(final CreateProduct createProduct, final boolean isUpdate);

    /**
     *
     * @param productCodes
     * @return deleted product codes
     */
    List<String> deleteProducts(final List<String> productCodes);


    List<CreateProduct> getProducts(final List<String> productCodes,final List<String> brandNames,final List<String> manufacturers,final List<String> categories);
}
