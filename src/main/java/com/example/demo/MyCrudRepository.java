package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface MyCrudRepository {
    public List<Customer> getAll();
    public Customer save(Customer customer);
    public Optional<Customer> find(int id);
    public boolean delete(int id);
}
