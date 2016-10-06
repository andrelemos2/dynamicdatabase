package br.com.gustavorodrig.dynamicdatabase.repository;

import br.com.gustavorodrig.dynamicdatabase.Application;
import br.com.gustavorodrig.dynamicdatabase.configuration.DbContextHolder;
import br.com.gustavorodrig.dynamicdatabase.model.DbConfig;
import br.com.gustavorodrig.dynamicdatabase.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.*;

/**
 * Created by Gustavo on 28/09/2016.
 */

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testaProductRepository(){

        DbConfig dbConfig = new DbConfig();
        dbConfig.setId("BD1");
        dbConfig.setDriverClass("org.postgresql.Driver");
        dbConfig.setUrl("jdbc:postgresql://localhost:5432/dynamicdatabase");
        dbConfig.setUsername("postgres");
        dbConfig.setPassword("postgres");
        DbContextHolder.setDbType(dbConfig);

        Iterable<Product> productsDB1 = productRepository.findAll();

	System.out.println(productsDB1);

        DbConfig dbConfig2 = new DbConfig();
        dbConfig2.setId("BD2");
        dbConfig2.setDriverClass("org.postgresql.Driver");
        dbConfig2.setUrl("jdbc:postgresql://localhost:5432/dynamicdatabase2");
        dbConfig2.setUsername("postgres");
        dbConfig2.setPassword("postgres");
        DbContextHolder.setDbType(dbConfig2);

        Iterable<Product> productsDB2 = productRepository.findAll();

	System.out.println(productsDB2);

        assertTrue(true);




    }


}