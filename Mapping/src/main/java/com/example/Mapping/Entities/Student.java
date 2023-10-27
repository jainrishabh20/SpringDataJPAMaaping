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
@Table(name = "Student_Table")
public class Student {
    @Id
    @Column(name = "Student_id")
    private int sid;
    @Column(name = "Student_name")
    private String sname;
    @Column(name = "Student_age")
    private int age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address =new ArrayList<>();

//    @OneToOne(mappedBy = "student")
//    private Laptop laptop;
//
//    @OneToMany
//    @JoinColumn(name = "address_id")
//    private List<Address> addressList =new ArrayList<>();

}
