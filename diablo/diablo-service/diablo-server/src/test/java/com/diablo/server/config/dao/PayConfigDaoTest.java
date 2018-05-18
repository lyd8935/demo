package com.diablo.server.config.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.diablo.common.config.entity.domain.PayConfig;
import com.diablo.server.BaseTest;

public class PayConfigDaoTest extends BaseTest {
    
    @Autowired
    private PayConfigDao payConfigDao;
    
    @Test
    public void queryList() {
       List<PayConfig> list = payConfigDao.queryList(12);
       System.out.println(list);
    }
}
