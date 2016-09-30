package br.com.gustavorodrig.dynamicdatabase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by gustavo
 */
@Configuration
public class DynamicDatabaseConfiguration {

    @Bean
    public AbstractRoutingDataSource routingDataSource(){
        AbstractRoutingDataSource routingDataSource = new RoutingDataSource();
        return routingDataSource;
    }

}
