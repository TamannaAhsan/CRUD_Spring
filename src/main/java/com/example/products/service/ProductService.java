package com.example.products.service;

import com.example.products.entity.Product;
import com.example.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct (Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts (){
        return productRepository.findAll();
    }

    public Product getProductById (Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName (String name){
        return productRepository.findByName(name);
    }

    public String deleteProduct(Integer id){
        productRepository.deleteById(id);
        return "Product removed successfully!!" +id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);

    }

}
