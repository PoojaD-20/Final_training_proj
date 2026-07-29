package com.example.final_proj_training.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.final_proj_training.jwt.JwtFilters;



@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<JwtFilters> jwtFilter(){
		FilterRegistrationBean<JwtFilters> bean=new FilterRegistrationBean<>();
		bean.setFilter(new JwtFilters());
		
		bean.addUrlPatterns("/categories/*","/purchases/*","/categories","/purchases","/medicines/*","/medicines","/prescriptions/*","/prescriptions");
		
		return bean;
	}

}
