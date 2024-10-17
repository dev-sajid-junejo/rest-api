package com.example.repository;

import com.example.repository.model.Product;
import com.example.repository.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

	private ProductRepository productRepository;

	@Autowired
	public void productRepository(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();

		// Set the product's properties
//		product.setName("T-Shirt");
//		product.setType("Clothing");
//		product.setCategory("Men's");
//		product.setDescription("A comfortable and stylish T-shirt.");
//		product.setPrice(19.99);
//		productRepository.save(product);

		// First Product - T-Shirt
		Product product1 = new Product();
		product1.setName("T-Shirt");
		product1.setType("Clothing");
		product1.setCategory("Men's");
		product1.setDescription("A comfortable and stylish T-shirt.");
		product1.setPrice(19.99);

// Second Product - Laptop
		Product product2 = new Product();
		product2.setName("Laptop");
		product2.setType("Electronics");
		product2.setCategory("Computers");
		product2.setDescription("A high-performance laptop for work and gaming.");
		product2.setPrice(999.99);

// Third Product - Coffee Mug
		Product product3 = new Product();
		product3.setName("Coffee Mug");
		product3.setType("Home & Kitchen");
		product3.setCategory("Drinkware");
		product3.setDescription("A ceramic mug for hot beverages.");
		product3.setPrice(7.99);

// Fourth Product - Sneakers
		Product product4 = new Product();
		product4.setName("Sneakers");
		product4.setType("Footwear");
		product4.setCategory("Men's");
		product4.setDescription("Comfortable and durable running shoes.");
		product4.setPrice(59.99);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);


//		productRepository.delete(product1);
//		productRepository.delete(product2);

		Product updateProduct = productRepository.findByType("Clothing");

		if(updateProduct!= null){
			updateProduct.setName("Updated Name");
			updateProduct.setDescription("Updated Description");
			Product updated =  productRepository.save(updateProduct);
		}

	}
}
