package com.openmarkethub.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.openmarkethub.dtos.ProductDTO;
import com.openmarkethub.entities.Product;
import com.openmarkethub.exceptions.ResourceNotFoundException;
import com.openmarkethub.repositories.ProductRepository;
import com.openmarkethub.services.ProductService;
import com.openmarkethub.utilities.ApiResponse;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO,Product.class);
		Product retunedProduct = productRepository.save(product);
		return modelMapper.map(retunedProduct, ProductDTO.class);
	}




	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDTO.class)).toList();
	}


	@Override
	public ProductDTO getProductByID(int id) {
		 Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product","product", id));
		 return modelMapper.map(product, ProductDTO.class);
	}


	@Override
	public ProductDTO updateProduct(int id, ProductDTO productDTO) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "product", id));
		Product updatedProduct = modelMapper.map(productDTO, Product.class);
		updatedProduct.setId(product.getId());
		Product returnProduct =  productRepository.save(updatedProduct);
		return modelMapper.map(returnProduct, ProductDTO.class);
	}




	@Override
	public void deleteProduct(int id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product","product", id));
		productRepository.deleteById(id);
	}
	
	

}
