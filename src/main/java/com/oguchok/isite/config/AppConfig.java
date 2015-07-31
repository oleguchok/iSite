package com.oguchok.isite.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.oguchok.isite.*" })
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig {
 
	private final String MODELS_PACKAGE = "com.oguchok.isite.models";
	
//    @Bean
//    public SessionFactory sessionFactory() {
//    	LocalSessionFactoryBuilder builder = 
//			new LocalSessionFactoryBuilder(dataSource());
//        builder.scanPackages("com.oguchok.isite.models")
//            .addProperties(getHibernateProperties());
// 
//        return builder.buildSessionFactory();
//    }

	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan(MODELS_PACKAGE);
        entityManagerFactory.setJpaProperties(getHibernateProperties());

        return entityManagerFactory;
    }
	
	private Properties getHibernateProperties() {
                Properties prop = new Properties();
                prop.put("hibernate.format_sql", "true");
                prop.put("hibernate.show_sql", "true");
                prop.put("hibernate.dialect", 
                    "org.hibernate.dialect.MySQL5Dialect");
                return prop;
        }
 
	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {
 
		BasicDataSource ds = new BasicDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/site_creator");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
 
//	@Bean
//        public HibernateTransactionManager txManager() {
//                return new HibernateTransactionManager(sessionFactory());
//        }
 
	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver 
                             = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
 
}