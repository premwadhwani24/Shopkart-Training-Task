package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
	private List<Product> productList;

	public ProductService() {
		productList = new ArrayList<>();
	}
}
