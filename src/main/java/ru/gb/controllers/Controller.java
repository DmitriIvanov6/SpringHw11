package ru.gb.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Product;
import ru.gb.entities.User;
import ru.gb.repositories.ProductRepository;
import ru.gb.repositories.UserRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class Controller {

    ProductRepository productRepository;
    UserRepository userRepository;

    public Controller(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String home() {
        return "This can see any1";
    }

    @GetMapping("/secure")
    public String secure() {
        return "This can see only logged in users";
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product productNew = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + productNew.getId())).body(productNew);
    }

    @GetMapping("/users")
    public List<User> showUsers() {
        return userRepository.findAll();
    }
}
