package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Customer {

    private String name;

    @Id
    @GeneratedValue
    private int id;

    public Customer() {
    }
    public Customer(String name) {
        this.name = name;
    }
}
