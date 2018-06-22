package com.codeup.blog.repositories;


import com.codeup.blog.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("from Product p where p.id = ?1")
    Product findById(long id);

}
