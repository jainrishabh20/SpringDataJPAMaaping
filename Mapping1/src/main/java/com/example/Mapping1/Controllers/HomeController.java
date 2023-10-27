package com.example.Mapping1.Controllers;

import com.example.Mapping1.Dao.ProductRepo;
import com.example.Mapping1.Dao.StudentRepo;
import com.example.Mapping1.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Controller
@RequestMapping("home") //Adding for git
public class HomeController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ProductRepo productRepo;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public void create(){
        Student student=new Student();
        student.setSid(1);
        student.setSname("Rishabh Jain");
        student.setAge(26);

        Laptop laptop=new Laptop();
        laptop.setLid(101);
        laptop.setBname("Apple");
        laptop.setStudent(student);
        student.setLaptop(laptop);

        Address address =new Address();
        address.setAid(101);
        address.setCity("Agra");
        address.setState("U.P");

        Address address1=new Address();
        address1.setAid(102);
        address1.setCity("Moradabad");
        address1.setState("U.P");

        address.setStudent(student);
        address1.setStudent(student);

        student.getAddress().add(address);
        student.getAddress().add(address1);

        this.studentRepo.save(student);

        Student student1=this.studentRepo.findById(1).get();

        //Student Details
        System.out.println("Name: "+student1.getSname()+" Age: "+student1.getAge());

        //Laptop Details
        System.out.println("My Laptop details are: "+ student1.getLaptop().getBname());

        //Address Details
//        List<Address> address2=student1.getAddress();
//        for (Address address3:address2){
//            System.out.println("City: "+address3.getCity()+" State: "+address3.getState());
//        }
        student1.getAddress().forEach((ad)-> System.out.println("City: "+ad.getCity()+" State: "+ad.getState()));

        List<Integer> ls= Arrays.asList(1,2,3,4,5);
        ls.forEach((i)-> System.out.print(i));
    }

    @RequestMapping(value = "items", method = RequestMethod.GET)
    public void items(){
        System.out.println("Rishabh Jain");
        Product product1=new Product();
        product1.setPid(101);
        product1.setPname("IPhone");

        Product product2=new Product();
        product2.setPid(102);
        product2.setPname("Samsung");

        Category category1=new Category();
        category1.setCid(201);
        category1.setCname("Electronic_Items");

        Category category2=new Category();
        category2.setCid(202);
        category2.setCname("Phone_brands");

        product1.getCategory().add(category1);
        product1.getCategory().add(category2);

        product2.getCategory().add(category1);
        product2.getCategory().add(category2);

        this.productRepo.save(product1);
        this.productRepo.save(product2);
    }
}
