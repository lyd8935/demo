package com.diablo.server.config.manager.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.diablo.common.config.entity.domain.PayConfig;
import com.diablo.server.BaseTest;
import com.diablo.server.config.manager.PayConfigManager;

public class PayConfigManagerImplTest extends BaseTest {
    @Autowired
    private PayConfigManager payConfigManager;
    
    @Test
    public void save() {
        PayConfig payConfig = new PayConfig();
        payConfig.setName("支付宝");
        payConfig.setChannel("123");
        payConfig.setType(1);
        payConfig.setMinAmount(BigDecimal.valueOf(100));
        payConfig.setMaxAmount(BigDecimal.valueOf(10000));
        payConfig.setStatus(1);
        payConfig.setCreateTime(LocalDateTime.now());
        int count = payConfigManager.save(payConfig);
        System.out.println(count);
    }
}
