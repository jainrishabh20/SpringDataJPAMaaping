package com.example.Mapping.Entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Laptop_table")
public class Laptop {
    @Id
    @Column(name = "laptop_id")
    private int lid;
    @Column(name = "laptop_brand")
    private String brand;
    @Column(name = "laptop_price")
    private int price;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

//    @OneToOne
//    @JoinColumn(name = "student_id")
//    private Student student;

}
