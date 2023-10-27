package com.example.Mapping1.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Column(name = "address_id")
    private int aid;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
