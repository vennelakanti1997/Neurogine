package com.assignment.demo.service.impl;

import com.assignment.demo.ProductRepository;
import com.assignment.demo.dto.CreateProduct;
import com.assignment.demo.entiy.Product;
import com.assignment.demo.exceptionHandling.BusinessException;
import com.assignment.demo.exceptionHandling.Error;
import com.assignment.demo.exceptionHandling.ErrorConstants;
import com.assignment.demo.service.ProductCrudService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductCrudServiceImpl implements ProductCrudService {

    @Autowired
    private transient ProductRepository productRepository;
    /**
     * @param createProduct
     * @return created Object
     */
    @Override
    public CreateProduct createProduct(final CreateProduct createProduct, final boolean isUpdate) {
        if (isUpdate && createProduct.getProductCode() == null || createProduct.getProductCode().isEmpty()){
            throw new BusinessException(new Error(ErrorConstants.FAILED_TO_SAVE,"Failed to Update product"));
        }
        final Product product= productRepository.findByProductCode(createProduct.getProductCode()).orElse(new Product());
        if (createProduct.getProductCategory() !=null){
            product.setProductCategory(createProduct.getProductCategory());
        }
        product.setProductCode(createProduct.getProductCode());
        if (createProduct.getBrandName() != null){
            product.setBrandName(createProduct.getBrandName());
        }
        if (createProduct.getProductDescription() !=null){
            product.setProductDescription(createProduct.getProductDescription());
        }
        if (createProduct.getManufacturer() !=null){
            product.setManufacturer(createProduct.getManufacturer());
        }
        if (createProduct.getSupplierInformation() != null){
            product.setSupplierInformation(createProduct.getSupplierInformation());
        }
        if (createProduct.getInStock() != null){
            product.setInStock(createProduct.getInStock());
        }
        if (createProduct.getPrice() !=null){
            product.setPrice(createProduct.getPrice());
        }
        productRepository.save(product);
        return createProduct;
    }

    /**
     * @param productCodes
     * @return deleted product codes
     */
    @Override
    public List<String> deleteProducts(final List<String> productCodes) {

        productRepository.deleteAllByProductId(productCodes);
        return  productCodes;
    }


    @Override
    public List<CreateProduct> getProducts(final List<String> productCodes,final List<String> brandNames,final List<String> manufacturers,final List<String> categories) {
        return  productRepository.findAllByProductCodesAndBrandNamesAndManufacturers(productCodes,brandNames,categories,manufacturers);
    }
}
