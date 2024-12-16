package com.edubridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edubridge.Entites.Products;


import com.edubridge.service.CategoryServices;


@CrossOrigin("http://localhost:4200")//angular url acess by angular or any
@RestController
@RequestMapping("/api/v1")
public class ProductCategoryController {
 
	@Autowired
	private CategoryServices productCategoryService;
	
	@PostMapping("/category/{categoryId}/products")
	public ResponseEntity<Products>addProductToCategory(
	 @PathVariable Long categoryId ,@RequestBody Products product
			){
		productCategoryService.addProductToCategory(categoryId, product);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
