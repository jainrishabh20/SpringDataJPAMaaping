package com.example.Mapping1.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Laptop")
public class Laptop {
    @Id
    @Column(name = "laptop_id")
    private int lid;
    @Column(name = "brand_name")
    private String bname;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
