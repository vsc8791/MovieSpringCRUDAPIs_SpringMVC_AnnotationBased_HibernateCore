package com.amigos.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amigos.dto.Movie;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.amigos.dao"), @ComponentScan("com.amigos.service") })
public class HibernateConfig {

	public SessionFactory sessionFactory = null;

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			try {
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
				properties.put(Environment.USER, "root");
				properties.put(Environment.PASS, "JaiGanpati@8");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.FORMAT_SQL, "true");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(properties);
				// mapping resources
				configuration.addAnnotatedClass(Movie.class);
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Configuration Service Registry Created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (HibernateException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		return sessionFactory;
	}

}
