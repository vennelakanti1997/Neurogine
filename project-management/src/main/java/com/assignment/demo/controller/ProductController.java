package com.assignment.demo.controller;

import com.assignment.demo.dto.CreateProduct;
import com.assignment.demo.service.ProductCrudService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
@Validated
public class ProductController {

    @Autowired
    private transient ProductCrudService productCrudService;

    @PostMapping(name = "/item")
    @Operation(description = "Create Product")
    public ResponseEntity<CreateProduct> createProduct(@RequestBody @Valid final CreateProduct createProduct){
        return ResponseEntity.status(HttpStatus.CREATED).body(productCrudService.createProduct(createProduct,false));
    }

    @PutMapping(name = "/item")
    @Operation(description = "Update Product")
    public ResponseEntity<CreateProduct> updateProduct(@RequestBody final CreateProduct createProduct){
        return ResponseEntity.ok(productCrudService.createProduct(createProduct,true));
    }

    @DeleteMapping(name = "/items")
    @Operation(description = "Delete Product")
    public ResponseEntity<List<String>>deleteProducts(@RequestParam(name = "productCodes") @NotEmpty(message = "Product Codes are required") final List<String> productCodes){
        return ResponseEntity.ok(productCrudService.deleteProducts(productCodes));
    }

    @GetMapping("/items")
    @Operation(description = "Get Product")
    public ResponseEntity<List<CreateProduct>> getAllProducts(@RequestParam(required = false, name = "productCodes") final List<String> productCodes,
                                                              @RequestParam(required = false, name = "brandNames") final List<String> brandNames,
                                                              @RequestParam(required = false, name = "manufacturers") final List<String> manufacturers,
                                                              @RequestParam(required = false, name = "categories") final List<String> categories) {
        return ResponseEntity.ok(productCrudService.getProducts(productCodes,brandNames,manufacturers, categories));
    }
}

