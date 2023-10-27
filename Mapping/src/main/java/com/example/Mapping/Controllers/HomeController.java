package com.example.Mapping.Controllers;

import com.example.Mapping.Dao.CategoryRepo;
import com.example.Mapping.Entities.*;
import com.example.Mapping.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private StudentService studentService;



    @Autowired
    private CategoryRepo categoryRepo;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(){
        System.out.println("Rishabh Jain");
        return "Rishabh jain";
    }

    @RequestMapping(value = "createUser")
    public void createStudent(){
        Student st=new Student();

        st.setSid(1);
        st.setAge(26);
        st.setSname("Rishabh jain");

        Laptop l1=new Laptop();
        l1.setLid(25);
        l1.setBrand("Samsung");
        l1.setPrice(65000);
        //imp
        l1.setStudent(st);
        st.setLaptop(l1);

        Address address=new Address();
        address.setAid(101);
        address.setCity("Agra");
        address.setState("U.P");
        address.setStudent(st);

        Address address1=new Address();
        address1.setAid(102);
        address1.setCity("Moradabad");
        address1.setState("U.P");
        address1.setStudent(st);

        st.setAddress(Arrays.asList(address, address1));
        this.studentService.createStudent(st);
    }

    @RequestMapping(value = "items", method = RequestMethod.GET)
    public void items(){
        System.out.println("Rishabh Jain");
        Category category=new Category();
        category.setCid(101);
        category.setCategoryName("Electronic_Items");

        Category category1=new Category();
        category1.setCid(102);
        category1.setCategoryName("Mobile_Phones");


        Product product =new Product();
        product.setPid(201);
        product.setProductName("IPhone");

        Product product1=new Product();
        product1.setPid(202);
        product1.setProductName("Samsung");


        category.getProduct().add(product);
        category.getProduct().add(product1);

        category1.getProduct().add(product);
        category1.getProduct().add(product1);


        this.categoryRepo.save(category);
        this.categoryRepo.save(category1);



    }

    @RequestMapping(value = "delete/{sid}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("sid") int sid){
        this.studentService.deleteStudent(sid);
    }
}
