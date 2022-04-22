package com.chao.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTest {

    @GetMapping("/car/{id}/ownr/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,@PathVariable("username")String name,Map<String,String> pv){
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
 
        return map;
    }
}
