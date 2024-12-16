package com.edubridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.dao.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
}
