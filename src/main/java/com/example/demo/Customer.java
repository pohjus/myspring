package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private static int numberOfCustomers = 0;

    private String name;
    private int id;

    public Customer() {
        numberOfCustomers++;
        setId(numberOfCustomers);
    }
    public Customer(String name) {
        numberOfCustomers++;
        setId(numberOfCustomers);

        this.name = name;
    }
}
