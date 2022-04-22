package com.chao.controller;

import com.chao.entity.Books;
import com.chao.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class BooksController {
    //controller调用service层
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService bookService;

    //查询全部的书籍 并且放回一个书记展示页面
    @RequestMapping("/allbook")
    public String list(Model model){
        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allbook";
    }



}
