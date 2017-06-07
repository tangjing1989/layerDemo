package com.tangjing;


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.util.Arrays;
import javax.sql.DataSource;


@EnableAutoConfiguration
@ComponentScan
@MapperScan({"com.tangjing.web.dao","com.tangjing.web.mp.dao"})
@Controller
@ConfigurationProperties
//@EnableRedisHttpSession
@ImportResource({"classpath:spring-common.xml"})
@SpringBootApplication
public class LayerApplication extends WebMvcConfigurationSupport {


    @Autowired
    private Environment env;


    /**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }


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
        Interceptor[] plugins                       = new Interceptor[1];
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


        Resource[] first=resolver.getResources("classpath:/com/tangjing/web/mapping/*.xml");
        Resource[] second=resolver.getResources("classpath:/com/tangjing/web/mp/mapping/*.xml");

        Resource[] result = Arrays.copyOf(first, first.length + second.length);


        System.arraycopy(second, 0, result, first.length, second.length);


        sqlSessionFactoryBean.setMapperLocations(result);



        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(LayerApplication.class, args);
    }

//    public  static  void  main(String [] m){
//        ApplicationContext ctx = SpringApplication.run(LayerApplication.class, m);
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//                 System.out.println(beanName);
//        }
//    }


}
