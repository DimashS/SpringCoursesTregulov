package com.shynggysdimash.spring.rest.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.integrator.spi.Integrator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;


// настройка applicationContext.xml
@Configuration
@ComponentScan(basePackages = "com.shynggysdimash.spring.rest")
// <context:component-scan base-package="com.shynggysdimash.spring.mvc_hibernate_aop" /> => строка из application -
// context
@EnableWebMvc
// замена нижней строки из applicationContext
//    <mvc:annotation-driven/>

// instead of  <tx:annotation-driven transaction-manager="transactionManager" /> in the end applicationcontext.xml.file
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // создание бина dataSoruce => connection to database
        try {
            comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            // creation of Driver Class
            comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false"); // к какой базе подключаемся
            // creation of jdbcurl
            comboPooledDataSource.setUser("bestuser");
            comboPooledDataSource.setPassword("bestuser");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        // устанавливали datasource при создании sessionFactory
        sessionFactory.setPackagesToScan("com.shynggysdimash.spring.rest.entity");
        // packagesToScan in applicationContext


        // creation properties (свойства)
        Properties hibernateProperties = new Properties();
        // property of dialect in applicationContext
        // it's first property
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        // second property
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        // назначаем этот setProperty нашему sessionFactory
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}

