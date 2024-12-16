package com.edubridge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.Entites.Category;
import com.edubridge.Entites.Products;
import com.edubridge.dao.ProductCategoryRepository;
import com.edubridge.dao.ProductRepository;

@Service
public class CategoryServices {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
		
	@Autowired
	private ProductRepository productRepository;

	public Products addProductToCategory(Long categoryId,Products product) {
		
		Optional<Category>optional=productCategoryRepository.findById(categoryId);
		
		if(optional.isPresent()) {
			Category category=optional.get();
			product.setCategory(category);
			return productRepository.save(product);
		}else {
			throw new RuntimeException("category not found");
		}
	}
	
}
