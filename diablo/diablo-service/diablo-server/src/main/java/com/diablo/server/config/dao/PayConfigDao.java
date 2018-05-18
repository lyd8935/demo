package com.diablo.server.config.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.diablo.common.config.entity.domain.PayConfig;

@Mapper
public interface PayConfigDao {
    
    @Select("SELECT * FROM pay_config WHERE type = #{type}")
    List<PayConfig> queryList(@Param("type") Integer type);
    
    @Insert("INSERT INTO pay_config(name, channel, type, min_amount, max_amount, status, create_time) "
            + "values(#{name}, #{channel}, #{type}, #{minAmount}, #{maxAmount}, #{status}, #{createTime})")
    Integer save(PayConfig payConfig);
}
