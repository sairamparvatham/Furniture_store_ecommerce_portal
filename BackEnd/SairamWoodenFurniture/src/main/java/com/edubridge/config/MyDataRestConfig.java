package com.edubridge.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer  {
	
	@Autowired
	private EntityManager entityManager;
	
	@Value("${allowed.origins}")
	private String[] theAllowedOrigins;
	
	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entites=entityManager.getMetamodel().getEntities();
		List<Class> entityClasses= new ArrayList<>();
		for(EntityType tempEntity: entites) {
			entityClasses.add(tempEntity.getJavaType());
		}
		
		Class[] domainType=entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainType);
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		exposeIds(config);
		cors.addMapping(config.getBasePath()+"/**")
		.allowedOrigins(theAllowedOrigins)
		.allowedMethods("GET","POST","PUT","DELETE");
	}
}
