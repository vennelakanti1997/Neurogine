package com.assignment.demo;

import com.assignment.demo.dto.CreateProduct;
import com.assignment.demo.entiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.productCode IN :productCodes")
    void deleteAllByProductId(@Param("productCodes") final List<String> productCodes);

    @Transactional(readOnly = true)
    Optional<Product>findByProductCode(final String productCode);

    @Transactional(readOnly = true)
    @Query("SELECT new com.assignment.demo.dto.CreateProduct(p.productCode, p.productCategory,p.productDescription,p.brandName,p.manufacturer,p.supplierInformation,p.inStock,p.price) FROM Product p" +
            " WHERE (COALESCE(:productCodes) IS NULL OR  p.productCode IN :productCodes) OR (COALESCE(:brandNames) IS NULL OR  p.brandName IN :brandNames) OR (COALESCE(:manufacturers) IS NULL OR  p.manufacturer IN :manufacturers)")
    List<CreateProduct> findAllByProductCodesOrBrandNamesOrManufacturers(@Param("productCodes") final List<String> productCodes, @Param("brandNames")final List<String> brandNames, @Param("manufacturers") final List<String>manufacturers);

    @Transactional(readOnly = true)
    @Query("SELECT new com.assignment.demo.dto.CreateProduct(p.productCode, p.productCategory,p.productDescription,p.brandName,p.manufacturer,p.supplierInformation,p.inStock,p.price) FROM Product p" +
            " WHERE (:productCodes IS NULL OR  p.productCode IN :productCodes) AND (:brandNames IS NULL OR  p.brandName IN :brandNames) AND (:manufacturers IS NULL OR  p.manufacturer IN :manufacturers) AND (:categories IS NULL OR  p.productCategory IN :categories)")
    List<CreateProduct> findAllByProductCodesAndBrandNamesAndManufacturers(@Param("productCodes") final List<String> productCodes, @Param("brandNames")final List<String> brandNames,@Param("categories") final List<String>categories, @Param("manufacturers") final List<String>manufacturers);
}
