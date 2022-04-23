package org.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
/**
 *
 * 加载外部的properties文件
 *
 *     <context:property-placeholder location="classpath:jdbc.properties"/>
 * <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
 *     <property name="driverClass" value="${jdbc.driver}"/>
 *     <property name="jdbcUrl" value="${jdbc.url}"/>
 *     <property name="user" value="${jdbc.username}"/>
 *     <property name="password" value="${jdbc.password}"/>
 * </bean>
 */

//配置组件扫描 <context:component-scan base-package="org.example"/>
@ComponentScan("org.example")

//加载外部的properties文件 <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource") //Spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DataSource getDatasource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;

    }
}
