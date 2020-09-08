package web.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
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
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
	webServerFactoryCustomizer() {
		// server.servlet.context-path=/corona_map
		return factory -> factory.setContextPath("/corona_map");
	}

}
