package com.rental.controller;

import com.rental.model.Product;
import com.rental.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){this.repo=repo;}

    @GetMapping public List<Product> all(){return repo.findAll();}
    @GetMapping("/{id}") public Product one(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }
    @GetMapping("/category/{category}") public List<Product> category(@PathVariable String category){
        return repo.findByCategoryIgnoreCase(category);
    }
    @GetMapping("/search") public List<Product> search(@RequestParam String q){
        return repo.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(q,q);
    }
    @PostMapping public Product create(@RequestBody Product product){return repo.save(product);}
    @PutMapping("/{id}") public Product update(@PathVariable Long id,@RequestBody Product p){
        Product x=repo.findById(id).orElseThrow();
        x.setName(p.getName()); x.setBrand(p.getBrand()); x.setCategory(p.getCategory());
        x.setDescription(p.getDescription()); x.setPricePerDay(p.getPricePerDay());
        x.setSecurityDeposit(p.getSecurityDeposit()); x.setImageUrl(p.getImageUrl());
        x.setAvailable(p.isAvailable()); return repo.save(x);
    }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){repo.deleteById(id);}
}
