package com.example.Mapping.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @Column(name = "Address_id")
    private int aid;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
}
