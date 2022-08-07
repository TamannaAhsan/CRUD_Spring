package com.example.products.cotroller;

import com.example.products.entity.Product;
import com.example.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/allProducts")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }
    @GetMapping("/Product/{id}")
    public Product findProductsById (@PathVariable Integer id){
        return productService.getProductById(id);
    }
    @GetMapping("find/Product/{name}")
    public Product findProductsByName (@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping ("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/Product/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
