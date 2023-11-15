package com.aop.demo.repo;

import com.aop.demo.dto.Merchant;
import com.aop.demo.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MerchantRepo extends JpaRepository<MerchantEntity,Integer> {

    @Transactional
    int deleteByMerchantId(final String merchantId);
}
