package com.charitra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataClass {
	@Bean
	public JdbcTemplate jdbctemplate(DriverManagerDataSource datasource) {
	    return new JdbcTemplate(datasource);
	}
}
