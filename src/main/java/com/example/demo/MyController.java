package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Safari ---------> new Thread(() -> getPage()).start()
//                                    olio (controller)
//                                       getPage()
// Edge ---------> new Thread(() -> getPage()).start()

// RestController -------> MyCrudRepository ----------> MyCrudRepositoryImpl
//                                                                 DB

@RestController
public class MyController {

    @Autowired
    MyCrudRepository repository;

    @GetMapping("customers")
    public List<Customer> getCustomers() {
        return repository.getAll();
    }

    @DeleteMapping("customers/{userId}")
    public void deleteCustomer(@PathVariable int userId) {
        repository.delete(userId);
    }

    @GetMapping("customers/{userId}")
    public Customer getCustomer(@PathVariable int userId) {
        Optional<Customer> customer = repository.find(userId);
        return customer.isPresent() ? customer.get() : null;
    }

    @PostMapping("customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

}


// Safari: ABCDE
// EDGE:        ABCDE

// Safari: ABCDE
// EDGE:   ABCDE

// => AABBCCDDEE   (A)
// => ABCDE ABCDE  (B)