package ru.vladislav.dao.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.dao.UserDao;
import ru.vladislav.dao.impl.jdbc.ChildrenDaoJdbcImpl;
import ru.vladislav.dao.impl.jdbc.UserDaoJdbcImpl;

import javax.sql.DataSource;

@Configuration
public class TestDaoJdbcConfig {

    @Bean
    UserDao userDao(){
        return new UserDaoJdbcImpl(dataSource());
    }

    @Bean
    ChildrenDao childrenDao(){
        return new ChildrenDaoJdbcImpl(dataSource());
    }

    @Bean
    DataSource dataSource(){
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("scripts/schema.sql")
                .addScript("scripts/insert.sql")
                .build();

        /*EmbeddedDatabase database = new EmbeddedDatabaseBuilder().addDefaultScripts().build();*/
        return database;
    }

}
