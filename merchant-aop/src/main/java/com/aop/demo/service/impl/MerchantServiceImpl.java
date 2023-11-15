package com.aop.demo.service.impl;

import com.aop.demo.dto.Merchant;
import com.aop.demo.entity.MerchantEntity;
import com.aop.demo.exceptionHandling.BusinessException;
import com.aop.demo.exceptionHandling.Error;
import com.aop.demo.repo.MerchantRepo;
import com.aop.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private transient MerchantRepo merchantRepo;
    @Override
    @Transactional
    public Merchant createMerchant(final String name, final String merchantId) {
        if (name == null || name.trim().isEmpty()){
            throw new BusinessException(new Error(9000,"Merchant Name is required"));
        }
        if (merchantId == null || merchantId.trim().isEmpty()){
            throw new BusinessException(new Error(9000,"Merchant Id is required"));
        }
        merchantRepo.save(new MerchantEntity(name,merchantId));
        return new Merchant(name,merchantId);
    }

    @Override
    @Transactional
    public void deleteMerchant(final String merchantId) {
        if (merchantId == null || merchantId.trim().isEmpty()){
            throw new BusinessException(new Error(9000,"Merchant Id is required"));
        }
        final int numberOfDeletedRecords = merchantRepo.deleteByMerchantId(merchantId);
        if (numberOfDeletedRecords<0){
            throw new BusinessException(new Error(9001,"MerchantId does not exist"));
        }
    }
}
