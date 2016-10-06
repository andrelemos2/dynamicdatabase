package br.com.gustavorodrig.dynamicdatabase.configuration.rest;

import br.com.gustavorodrig.dynamicdatabase.configuration.Interceptor.RestResponseInterceptor;
import br.com.gustavorodrig.dynamicdatabase.configuration.Interceptor.RestRequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by gustavo
 */
@Configuration
public class ControllerConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ClientHttpRequestInterceptor getControllerInterceptor() {
        RestResponseInterceptor interceptor = new RestResponseInterceptor();
        return interceptor;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PUT");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        RestRequestInterceptor interceptor = new RestRequestInterceptor();
        registry.addInterceptor(interceptor);
    }
}
