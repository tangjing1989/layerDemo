package com.tangjing.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Describe:
 * User:tangjing
 * Date:2017/6/8
 * Time:下午5:46
 */

@Configuration
public class DataSourceManage {


    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url")+env.getProperty("spring.datasource.name"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        /*****替换成 mybatis-plus的SqlSessionFactory开始 ****/
        com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean();

        //mybatis-plus分页插件配置
        Interceptor[]         plugins               = new Interceptor[1];
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        plugins[0]=paginationInterceptor;
        sqlSessionFactoryBean.setPlugins(plugins);

        //mybatis-plus全局配置
        GlobalConfiguration globalConfig =new GlobalConfiguration();

        /** 主键策略
         * AUTO->`0`("数据库ID自增")
         * INPUT->`1`(用户输入ID")
         * ID_WORKER->`2`("全局唯一ID")
         * UUID->`3`("全局唯一ID") **/
        globalConfig.setIdType(2);

        /** 数据库类型
         * Oracle必须要添加该项
         * MYSQL->`mysql`
         * ORACLE->`oracle`
         * DB2->`db2`
         * H2->`h2`
         * HSQL->`hsql`
         * SQLITE->`sqlite`
         * POSTGRE->`postgresql`
         * SQLSERVER2005->`sqlserver2005`
         * SQLSERVER->`sqlserver`
         ***/
        //globalConfig.setDbType("oracle");

        //全局表为下划线命名设置 true
//        globalConfig.setDbColumnUnderline(false);

        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
        /*****替换成 mybatis-plus的SqlSessionFactory结束****/



        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();


        Resource[] first  =resolver.getResources("classpath:/com/tangjing/web/mapping/*.xml");
        Resource[] second =resolver.getResources("classpath:/com/tangjing/web/mp/mapping/*.xml");

        Resource[] result = Arrays.copyOf(first, first.length + second.length);


        System.arraycopy(second, 0, result, first.length, second.length);


        sqlSessionFactoryBean.setMapperLocations(result);



        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
