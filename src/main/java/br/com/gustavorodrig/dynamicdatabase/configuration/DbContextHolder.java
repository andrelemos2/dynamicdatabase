package br.com.gustavorodrig.dynamicdatabase.configuration;

import br.com.gustavorodrig.dynamicdatabase.model.DbConfig;

/**
 * Created by gustavo
 */
public class DbContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDbType(DbConfig dbConfig) {
        if(dbConfig == null){
            throw new NullPointerException();
        }

        RoutingDataSource.addDataSource(dbConfig);
        contextHolder.set(dbConfig.getId());
    }

    public static String getDbType() {
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
