package br.com.gustavorodrig.dynamicdatabase.repository;

import br.com.gustavorodrig.dynamicdatabase.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gustavo
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
