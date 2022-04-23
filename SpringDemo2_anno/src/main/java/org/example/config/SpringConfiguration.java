package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//标志该类是Spring的核心配置类
@Configuration


//配置组件扫描 <context:component-scan base-package="org.example"/>
@ComponentScan("org.example")

//加载外部的properties文件 <context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource("classpath:jdbc.properties")

//导入其他配置文件<import resource=""/>
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
