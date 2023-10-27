package com.example.Mapping.Service;

import com.example.Mapping.Dao.StudentRepo;
import com.example.Mapping.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void createStudent(Student st){
        studentRepo.save(st);
    }

    public void deleteStudent(int sid){
        studentRepo.deleteById(sid);
    }
}
