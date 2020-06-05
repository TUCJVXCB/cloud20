package cn.tanyu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tanyu.springcloud.dao")
public class MyBatisConfig {
}
