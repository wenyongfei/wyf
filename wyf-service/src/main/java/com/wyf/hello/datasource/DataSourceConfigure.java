package com.wyf.hello.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfigure {

    private  final String DATASOURCE_PREFIX = "spring.datasource.druid.";
    @Bean("wyfMaster")
    @Primary
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX+"wyfdb.master")
    public DataSource wyfMaster() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("wyfSlave")
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX+"wyfdb.slave")
    public DataSource wyfSlave() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("refundMaster")
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX+"refundsdb.master")
    public DataSource refundMaster() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("refundSlave")
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX+"refundsdb.slave")
    public DataSource refundSlave() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSources = new HashMap<Object, Object>(4);
        dynamicRoutingDataSource.setDefaultTargetDataSource(wyfMaster());

        dataSources.put(DataSourceType.WYF_MASTER.name(), wyfMaster());
        dataSources.put(DataSourceType.WYF_SLAVE.name(), wyfSlave());
        dataSources.put(DataSourceType.REFUND_MASTER.name(), refundMaster());
        dataSources.put(DataSourceType.REFUND_SLAVE.name(), refundSlave());
        dynamicRoutingDataSource.setTargetDataSources(dataSources);

        DynamicDataSourceHolder.DATASOURCES.add(DataSourceType.WYF_MASTER);
        DynamicDataSourceHolder.DATASOURCES.add(DataSourceType.WYF_SLAVE);
        DynamicDataSourceHolder.DATASOURCES.add(DataSourceType.REFUND_MASTER);
        DynamicDataSourceHolder.DATASOURCES.add(DataSourceType.REFUND_SLAVE);
        return dynamicRoutingDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource 作为数据源则不能实现切换
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }

    /**
     * 注入 DataSourceTransactionManager 用于事务管理
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
