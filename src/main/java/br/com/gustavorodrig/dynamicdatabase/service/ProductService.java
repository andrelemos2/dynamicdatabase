package br.com.gustavorodrig.dynamicdatabase.service;

import br.com.gustavorodrig.dynamicdatabase.model.Product;
import br.com.gustavorodrig.dynamicdatabase.repository.ProductRepository;
import org.springframework.stereotype.Service;

/**
 * Created by gustavo
 */
@Service
public class ProductService extends AbstractService<Product, Long, ProductRepository> {

}
