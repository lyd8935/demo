package com.diablo.server.config.service.impl;

import org.springframework.stereotype.Component;

import com.diablo.common.config.service.PayConfigService;

@Component
public class PayConfigServiceImpl implements PayConfigService {

    @Override
    public String query() {
        return "query";
    }
    
}
