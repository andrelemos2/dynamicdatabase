package br.com.gustavorodrig.dynamicdatabase.resource;

import br.com.gustavorodrig.dynamicdatabase.model.Product;
import br.com.gustavorodrig.dynamicdatabase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gustavo
 */
@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<Product> findOne(@PathVariable("id") String identifier) {
        Long id = Long.parseLong(identifier);
        Product product = productService.findOne(id);
        if(product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        if(products == null || products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
