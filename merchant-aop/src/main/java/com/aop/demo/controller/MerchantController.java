package com.aop.demo.controller;

import com.aop.demo.dto.Merchant;
import com.aop.demo.service.MerchantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchantController {

    @Autowired
    private transient MerchantService merchantService;

    @Operation(description = "Create Merchant")
    @PostMapping("/merchant")
    public ResponseEntity<Merchant> createMerchant(@RequestBody final Merchant merchant) {
        return ResponseEntity.status(HttpStatus.CREATED).body(merchantService.createMerchant(merchant.getName(),merchant.getMerchantId()));
    }

    @DeleteMapping("/merchant")
    @Operation(description = "Delete Merchant")
    public ResponseEntity<Object> deleteMerchant(@RequestParam(name = "merchantId") final String merchantId) {
        merchantService.deleteMerchant(merchantId);
        return ResponseEntity.ok(null);
    }
}
