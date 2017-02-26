package ru.vladislav.dao.impl.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.dao.impl.hibernate.ChildrenDaoHibernateImpl;

import javax.sql.DataSource;

@Configuration
public class TestDaoHibernateConfig {

    @Bean
    public ChildrenDao childrenDao(){
        return new ChildrenDaoHibernateImpl();
    }

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
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("scripts/schema.sql")
                .addScript("scripts/insert.sql")
                .build();

        return database;
    }

}
