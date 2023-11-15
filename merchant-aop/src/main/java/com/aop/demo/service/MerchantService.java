package com.aop.demo.service;

import com.aop.demo.dto.Merchant;

public interface MerchantService {
    Merchant createMerchant(final String name, final String merchantId);

    void deleteMerchant(final String merchantId);
}
