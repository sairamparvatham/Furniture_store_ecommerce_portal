package com.edubridge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.edubridge.Entites.Category;

@RepositoryRestResource(
	collectionResourceRel="productCategory",path="product-category")
public interface ProductCategoryRepository extends JpaRepository<Category, Long> {

	
}
