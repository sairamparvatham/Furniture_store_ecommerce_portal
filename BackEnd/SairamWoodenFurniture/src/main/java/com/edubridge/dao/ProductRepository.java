package com.edubridge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edubridge.Entites.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

	
}
