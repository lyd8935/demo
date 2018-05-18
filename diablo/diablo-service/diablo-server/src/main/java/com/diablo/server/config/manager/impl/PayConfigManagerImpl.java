package com.diablo.server.config.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diablo.common.config.entity.domain.PayConfig;
import com.diablo.server.config.dao.PayConfigDao;
import com.diablo.server.config.manager.PayConfigManager;

@Service
public class PayConfigManagerImpl implements PayConfigManager {

    @Autowired
    private PayConfigDao payConfigDao;
    
    @Transactional
    @Override
    public Integer save(PayConfig payConfig) {
        return payConfigDao.save(payConfig);
    }

}
