package com.openmarkethub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openmarkethub.dtos.ProductDTO;
import com.openmarkethub.dtos.UserDTO;


public interface ProductService {
	
	ProductDTO createProduct(ProductDTO productDTO);
	void deleteProduct(int id);
    ProductDTO updateProduct(int id, ProductDTO productDTO);
	ProductDTO getProductByID(int id);
	List<ProductDTO> getAllProducts();
	
	



}
