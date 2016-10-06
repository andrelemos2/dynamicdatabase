package br.com.gustavorodrig.dynamicdatabase.service;

import br.com.gustavorodrig.dynamicdatabase.configuration.DbContextHolder;
import br.com.gustavorodrig.dynamicdatabase.model.DbConfig;
import br.com.gustavorodrig.dynamicdatabase.model.Product;
import br.com.gustavorodrig.dynamicdatabase.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gustavo
 */
@Service
public class ProductService extends AbstractService<Product, Long, ProductRepository> {


    public Product findOne(Long id, DbConfig dbConfig) {

        try {
            DbContextHolder.setDbType(dbConfig);
            return this.findOne(id);
        } finally {
            DbContextHolder.clearDbType();
        }
    }

    public List<Product> findAll(DbConfig dbConfig) {

        DbContextHolder.setDbType(dbConfig);
        try {
            List<Product> products = this.findAll();
            return products;
        } finally {
            DbContextHolder.clearDbType();
        }
    }

}
