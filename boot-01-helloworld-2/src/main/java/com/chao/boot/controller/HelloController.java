package com.chao.boot.controller;

import com.chao.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        System.out.println(person);
        return person;
    }
}
