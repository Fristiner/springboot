package com.ma;

import com.alibaba.druid.pool.DruidDataSource;
import com.ma.config.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(ServletConfig.class)
public class Springboot13ConfigurationApplication {

    @ConfigurationProperties(prefix = "datasource")
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
        ServletConfig bean = ctx.getBean(ServletConfig.class);
        System.out.println(bean);
        DruidDataSource druidDataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getDriverClassName());

    }

}
