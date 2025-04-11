package io.github.dbc2201.spring.boot.demos.shopkart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatabaseProductService implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public DatabaseProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {return productRepository.save(product); }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    @Override
    public Product updateProductPrice(long id, double newPrice) {
        Product product=getProductById(id) ;
        if(product!=null) {
            product.setPrice(newPrice);
            productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product updateProductName(long id, String newName) {
        Product product=getProductById(id) ;
        if(product!=null) {
            product.setName(newName);
            productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product updateProductDescription(long id, String newDescription) {
        Product product=getProductById(id) ;
        if(product!=null) {
            product.setDescription(newDescription);
            return productRepository.save(product);
        }
        return null;
    }


    @Override
    public Product updateProductImageUrl(long id, String newImageUrl) {
        Product product=getProductById(id) ;
        if(product!=null) {
            product.setImageUrl(newImageUrl);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
       if (productRepository.existsById(id)) {
       productRepository.deleteById(id);
       return true;
    }
    return false;
}
}
