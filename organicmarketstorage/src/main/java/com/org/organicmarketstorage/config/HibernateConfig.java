package com.org.organicmarketstorage.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.org.organicmarketstorage.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/organicmarketdb";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	
	//private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/organicmarketdb?useSSL=true";
	//private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	// providing connection info of the database
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);

		return datasource;
	}

	// Sessionfactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.org.organicmarketstorage.dto");

		return builder.buildSessionFactory();
	}

	// setting the properties for hibernate
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.formate_sql", "true");
		return properties;
	}

	// to manage the hibernate Transaction

	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionfactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionfactory);
		return transactionManager;

	}

}
