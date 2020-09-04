package web.spring;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

    public DataConfig() {
    }

    @Bean
    public DataSource getDataSource() {
        /**
         * spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/map
         * spring.datasource.username=postgres
         * spring.datasource.password=a
         * spring.datasource.driver-class-name=org.postgresql.Driver

         * #spring.jpa.database-platform = org.hibernate.dialect.PostgreSQLDialect
         * spring.jpa.database-platform=org.hibernate.spatial.dialect.postgis.PostgisDialect
         * spring.jpa.generate-ddl=true
         * spring.jpa.show-sql=true
         * spring.jpa.hibernate.ddl-auto = update
         */
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url("jdbc:postgresql://127.0.0.1:5432/map");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("a");
        dataSourceBuilder.driverClassName("org.postgresql.Driver");

        return dataSourceBuilder.build();
    }

}
