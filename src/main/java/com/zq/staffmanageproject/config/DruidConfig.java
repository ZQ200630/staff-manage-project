package com.zq.staffmanageproject.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConditionalOnClass(DruidDataSource.class)
    @ConditionalOnProperty(name = "spring.datasource.type",
            havingValue = "com.alibaba.druid.pool.DruidDataSource",
            matchIfMissing = true)


    static class Druid extends DruidConfig{


        //配置Druid的监控
        //1、配置一个管理后台的Servlet
        @Bean
        public ServletRegistrationBean statViewServlet(){
            ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

            Map<String,String> initParams = new HashMap<>();

            initParams.put("loginUsername","admin");
            initParams.put("loginPassword","123456");
            initParams.put("allow","");//默认就是允许所有访问
            //initParams.put("allow", "localhost")：表示只有本机可以访问
            initParams.put("deny","");
            //设置初始化参数
            bean.setInitParameters(initParams);
            return bean;
        }


        //2、配置一个web监控的filter

        //配置 Druid 监控 之  web 监控的 filter
        //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
        @Bean
        public FilterRegistrationBean webStatFilter(){
            FilterRegistrationBean bean = new FilterRegistrationBean();
            bean.setFilter(new WebStatFilter());
            //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
            Map<String,String> initParams = new HashMap<>();
            initParams.put("exclusions","*.js,*.css,/druid/*");
            bean.setInitParameters(initParams);
            //"/*" 表示过滤所有请求
            bean.setUrlPatterns(Arrays.asList("/*"));
            return  bean;
        }

        @Bean
        @ConfigurationProperties("spring.datasource.druid")
        public DruidDataSource dataSource(DataSourceProperties properties){
            DruidDataSource druidDataSource = (DruidDataSource) properties.initializeDataSourceBuilder()
                    .type(DruidDataSource.class).build();
            DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
            String validationQuery = databaseDriver.getValidationQuery();
            if(validationQuery != null){
                druidDataSource.setValidationQuery(validationQuery);
            }
            return druidDataSource;
        }

        @Bean
        public WallFilter wallFilter(){
            WallFilter wallFilter = new WallFilter();
            wallFilter.setConfig(wallConfig());
            return wallFilter;
        }

        @Bean
        public WallConfig wallConfig(){
            WallConfig wallConfig = new WallConfig();
            wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
            wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
            return wallConfig;
        }
    }
}