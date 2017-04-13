package com.anishsneh.demo.spring.microservice.testdriven;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.anishsneh.demo.spring.microservice.testdriven.util.ApplicationUtil;

/**
 * The Class HelloWorldApplication.
 * 
 * @author Anish Sneh
 */
@EnableEurekaClient
@SpringBootApplication
public class HelloTestDrivenApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(HelloTestDrivenApplication.class, args);
	}
	
	/**
	 * Servlet initializer.
	 *
	 * @return the servlet context initializer
	 */
	@Bean
	public ServletContextInitializer servletInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(final ServletContext servletContext) throws ServletException {
				ApplicationUtil.initJerseyServlet(servletContext);
			}
		};
	}
}