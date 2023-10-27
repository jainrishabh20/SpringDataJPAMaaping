package com.example.Mapping.Entities;


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
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "category_id")
    private int cid;
    @Column(name = "category_name")
    private String categoryName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> product =new ArrayList<>();


}
