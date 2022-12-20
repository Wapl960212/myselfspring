package com.example.bigdata6springstudy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping("/user/list.do")
    public String list(@RequestParam(defaultValue = "1") int page){
        System.out.println(page);
        return "/userList";
    }
}
