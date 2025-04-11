package io.github.dbc2201.spring.boot.demos.shopkart.product;

import java.util.List;

public class DatabaseProductService implements ProductService {
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public Product updateProductPrice(long id, double newPrice) {
        return null;
    }

    @Override
    public Product updateProductName(long id, String newName) {
        return null;
    }

    @Override
    public Product updateProductDescription(long id, String newDescription) {
        return null;
    }

    @Override
    public Product updateProductImageUrl(long id, String newImageUrl) {
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        return false;
    }
}
