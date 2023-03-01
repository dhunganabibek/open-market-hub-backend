package com.openmarkethub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.openmarkethub.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
