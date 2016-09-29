package br.com.gustavorodrig.dynamicdatabase.configuration;

import br.com.gustavorodrig.dynamicdatabase.model.DbConfig;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gustavo
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    public static Map<Object, Object> resolvedDataSources = new ConcurrentHashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Object lookupKey = determineCurrentLookupKey();
        DataSource dataSource = (DataSource) this.resolvedDataSources.get(lookupKey);
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
        }
        return dataSource;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.resolvedDataSources = targetDataSources;
    }

    @Override
    public void afterPropertiesSet() {}

    public static void addDataSource(DbConfig dbConfig){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbConfig.getDriverClass());
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        resolvedDataSources.put(dbConfig.getId(), dataSource);

    }






}
