package com.fpi.bims;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置类
 * 
 * @author yangwei
 *
 */
@Configuration
public class CorsConfig {

	//自己的git  在册时候   有的
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 允许任何域名使用
		corsConfiguration.addAllowedOrigin("*");
		// 允许任何头
		corsConfiguration.addAllowedHeader("*");
		// 允许任何方法get post
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
}