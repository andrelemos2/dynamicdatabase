package br.com.gustavorodrig.dynamicdatabase.configuration;

import br.com.gustavorodrig.dynamicdatabase.model.DbConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gustavo
 */
@Configuration
public class DynamicDatabaseConfiguration {

    @Bean
    public AbstractRoutingDataSource routingDataSource(){
        AbstractRoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object, Object> customerIndexMap = new HashMap<>();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("fake");
        dataSource.setUsername("fake");
        dataSource.setPassword("fake");

        DbConfig dbConfig = new DbConfig();
        dbConfig.setId("BD1");
        dbConfig.setDriverClass("org.postgresql.Driver");
        dbConfig.setUrl("fake");
        dbConfig.setUsername("fake");
        dbConfig.setPassword("fake");

        DbContextHolder.setDbType(dbConfig);
        customerIndexMap.put(dbConfig.getId(), dataSource);

        routingDataSource.setTargetDataSources(customerIndexMap);
        return routingDataSource;
    }

}
