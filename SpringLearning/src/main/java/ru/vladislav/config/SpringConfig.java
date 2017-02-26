package ru.vladislav.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru.vladislav")
@PropertySource("ru.vladislav/springdb.properties")
public class SpringConfig {

    @Autowired
    private Environment environment;

    @Bean
    public SessionFactory sessionFactory(){
        return new LocalSessionFactoryBuilder(dataSource())
                .addResource("ru.vladislav/hibernate/User.hbm.xml")
                .addResource("ru.vladislav/hibernate/Children.hbm.xml")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect")
                .buildSessionFactory();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

}
