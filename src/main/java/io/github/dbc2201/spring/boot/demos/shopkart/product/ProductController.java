package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Product related endpoints.
 * This class handles HTTP requests related to Products.
 */
@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

	private final ProductService productService;

	@Autowired // dependency injection
	public ProductController(@Qualifier("databaseProductService")
			ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Creates a new product.
	 *
	 * @param product The product data from request body
	 * @return The newly created product
	 */
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct=productService.createProduct(product);
		return new  ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	/**
	 * Gets all products.
	 *
	 * @return List of all products
	 */
	@GetMapping
	public ResponseEntity<List<Product> >
	getAllProducts() {
		List<Product> products=productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	/**
	 * Gets a product by its ID.
	 *
	 * @param id The ID of the product from path variable
	 * @return The found product
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product product = productService.getProductById(id);
		if (product == null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Gets a product by its name.
	 *
	 * @param name The name of the product from request parameter
	 * @return The found product
	 */
	@GetMapping("/byName")
	public ResponseEntity<Product> getProductByName(@RequestParam String name) {
		Product product = productService.getProductByName(name);
		if (product == null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Updates the price of a product.
	 *
	 * @param id    The ID of the product from path variable
	 * @param price The new price from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/price")
	public ResponseEntity<Product> updateProductPrice(@PathVariable long id, @RequestParam double price) {
		Product product = productService.updateProductPrice(id,price);
		if(product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Updates the name of a product.
	 *
	 * @param id   The ID of the product from path variable
	 * @param name The new name from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/name")
	public ResponseEntity<Product> updateProductName(@PathVariable long id, @RequestParam String name) {
		Product product = productService.updateProductName(id,name);
		if(product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Updates the description of a product.
	 *
	 * @param id          The ID of the product from path variable
	 * @param description The new description from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/description")
	public ResponseEntity<Product> updateProductDescription(@PathVariable long id, @RequestParam String description) {
		Product product = productService.updateProductDescription(id, description);
		if(product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Updates the image URL of a product.
	 *
	 * @param id       The ID of the product from path variable
	 * @param imageUrl The new image URL from request parameter
	 * @return The updated product
	 */
	@PutMapping("/{id}/imageUrl")
	public ResponseEntity<Product> updateProductImageUrl(@PathVariable long id, @RequestParam String imageUrl) {
		Product product = productService.updateProductImageUrl(id,imageUrl);
		if(product==null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product from path variable
	 * @return A message indicating success or failure
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		boolean deleted = productService.deleteProduct(id);
		if (deleted) {
			return ResponseEntity.ok("Product deleted successfully");
		}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
	}
