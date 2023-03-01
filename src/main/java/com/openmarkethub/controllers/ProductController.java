package com.openmarkethub.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openmarkethub.dtos.ProductDTO;
import com.openmarkethub.entities.Product;
import com.openmarkethub.services.ProductService;
import com.openmarkethub.utilities.ApiResponse;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	
	@PostMapping("/")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO returnedProductDTO =productService.createProduct(productDTO);
		return new ResponseEntity<ProductDTO>(returnedProductDTO,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> allProductsDTO = productService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(allProductsDTO, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
		return new ResponseEntity<ProductDTO>(productService.getProductByID(id),HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
		return new ResponseEntity<ProductDTO>(productService.updateProduct(id, productDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id){
		productService.deleteProduct(id);
		ApiResponse response = new ApiResponse("Deleted Sucessfully", true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
	

}
