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
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_id")
    private int sid;
    @Column(name = "student_name")
    private String sname;
    @Column(name = "student_age")
    private int age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address =new ArrayList<>();
}
