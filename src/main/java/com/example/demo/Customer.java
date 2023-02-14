package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @NonNull
    private String name;

    @Id
    @GeneratedValue
    private int id;

}
