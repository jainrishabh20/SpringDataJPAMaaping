package com.example.Mapping1.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private int pid;
    @Column(name = "product_name")
    private String pname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CategoryAndProductTable",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name ="category_id")
    )
    private List<Category> category=new ArrayList<>();
}
