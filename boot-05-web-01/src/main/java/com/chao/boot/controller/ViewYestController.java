package com.chao.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewYestController {
    @GetMapping("/chao")
    public String chao(Model model){
        model.addAttribute("xixi","你好 @超");

        return "success";
    }
}
