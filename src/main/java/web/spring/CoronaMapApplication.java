package web.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@SpringBootApplication
@EnableWebMvc
@ComponentScan( "web" )
@EnableJpaRepositories( "web" )
@EntityScan(basePackageClasses=web.model.EntityCommon.class)
public class CoronaMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaMapApplication.class, args);
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
