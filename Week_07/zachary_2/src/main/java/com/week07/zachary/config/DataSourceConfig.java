package com.week07.zachary.config;

import com.week07.zachary.constant.DSNames;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement(order = 100)
@ConditionalOnClass(JdbcOperations.class)
@ConditionalOnProperty(prefix = "spring.datasource", name = "master.jdbc-url")
public class DataSourceConfig {

  @Bean
  public DataSourceAspect DataSourceAspect() {
    return new DataSourceAspect();
  }

  @Bean(name = "masterDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.master")
  public DataSource masterDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "slaveDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.slave")
  public DataSource slaveDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "dataSource")
  @Qualifier(value = "dataSource")
  @DependsOn({"masterDataSource", "slaveDataSource"})
  public DataSource dynamicDataSource() {
    DataSource masterDataSource = masterDataSource();
    DataSource slaveDataSource = slaveDataSource();

    Map<Object, Object> targetDataSources = new HashMap<>();
    targetDataSources.put(DSNames.MASTER, masterDataSource);
    targetDataSources.put(DSNames.SLAVE, slaveDataSource);
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
    dynamicDataSource.setTargetDataSources(targetDataSources);
    return dynamicDataSource;
  }

}
