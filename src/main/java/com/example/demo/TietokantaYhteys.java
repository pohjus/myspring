package com.example.demo;

import org.springframework.data.repository.CrudRepository;

// -> hibernate: ORM

// -> Java EE
//          JPA
//              hibernate
//              a
//              b

import java.util.List;

public interface TietokantaYhteys extends CrudRepository<Customer, Integer> {
    public List<Customer> findByName(String name);
}
