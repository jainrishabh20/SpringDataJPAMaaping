package com.example.Mapping.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "product_id")
    private int pid;
    @Column(name = "product_name")
    private String productName;

    @ManyToMany(mappedBy = "product")
    private List<Category> category= new ArrayList<>();

}
