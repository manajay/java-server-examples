package com.manajay.cay.common.configuration.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author manajay
 * @date 2017/12/17$
 */
@Configuration
@MapperScan(basePackages = "com.manajay.cay.mapper.mybatis", sqlSessionTemplateRef = "mybatisSqlSessionTemplate")
public class MybatisDatasourceConfiguration {

    @Bean(name = "mybatisDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.mybatis")
    @Primary
    public DataSource createDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mybatisSqlSessionFactory")
    @Primary
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("mybatisDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:database/mapper/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mybatisDataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager createSourceTransactionManager(@Qualifier("mybatisDatasource") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean(name = "mybatisSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("mybatisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
