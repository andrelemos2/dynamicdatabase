package br.com.gustavorodrig.dynamicdatabase.repository;

import br.com.gustavorodrig.dynamicdatabase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gustavo
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

}
