package com.amigos.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.amigos.filter.SameOriginPolicyFilter;

public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { HibernateConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { WebMvcConfigurer.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		Filter[] singleton = { new SameOriginPolicyFilter() };
		return singleton;
	}

}
