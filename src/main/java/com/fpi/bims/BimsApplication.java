package com.fpi.bims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

import java.util.concurrent.TimeUnit;

/**
 * @author  kangkang_sun
 * @date  2018/01/15
 */
@ComponentScan
@SpringBootApplication
public class BimsApplication {
	@Bean
	EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory factory =new TomcatEmbeddedServletContainerFactory();
		factory.setPort(8099);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);

		return factory;
	}
	public static void main(String[] args) {
		SpringApplication.run(BimsApplication.class, args);
	}
}
