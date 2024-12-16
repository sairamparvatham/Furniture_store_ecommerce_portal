package com.edubridge.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 
@Entity
@Table(name="product")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 private String name;
	 
	 private String description;
	 
	 private String productSize;
	 
	 private String width;
	 
	 private String height;
	 
	 private String woodType;
	 
	 private Double unitPrice;
	 
	 private String imageUrl;
	 
	 private Integer unitsInStock;
	
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="category_id")
	 private Category category;
	 
	 
}
