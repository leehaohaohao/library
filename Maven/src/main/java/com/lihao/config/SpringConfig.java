package com.lihao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: SpringConfig
 * Description:
 * Datetime: 2024/4/1 14:22
 * Author: lihao
 * Version: 1.0
 */
@Configuration
@ComponentScan({"com.lihao.dao","com.lihao.service","com.lihao.utils","com.lihao.service.serviceImpl","com.lihao.filter","com.lihao.handler"})
@PropertySource("classpath:jdbc.properties")
@Import({DataSourceConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {

}