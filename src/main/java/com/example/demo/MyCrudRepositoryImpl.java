package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MyCrudRepositoryImpl implements MyCrudRepository {
    List<Customer> customers = new ArrayList<Customer>();
    @PostConstruct
    public void init() {
        customers.add(new Customer("jack"));    // id = 1
        customers.add(new Customer("tiina"));   // id = 2
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> find(int id) {
        Optional<Customer> customer = customers.stream()
                .filter(cust -> cust.getId() == id)
                .findFirst();

        return customer;
    }

    @Override
    public boolean delete(int id) {
        this.customers = customers.stream()
                .filter(cust -> cust.getId() != id)
                .collect(Collectors.toList());
        return true;
    }
}
