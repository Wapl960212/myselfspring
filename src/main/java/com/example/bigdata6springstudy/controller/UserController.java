package com.example.bigdata6springstudy.controller;

import com.example.bigdata6springstudy.controller.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/list.do")
    public String list(
            HttpServletRequest req,
            @RequestParam(defaultValue = "1") int page){
        String rows_str=req.getParameter("rows");
        int rows=(rows_str==null)?10:Integer.parseInt(rows_str);

        System.out.println("page: "+page );
        System.out.println("rows: "+ rows);
        return "/userList";
    }
    @GetMapping("/detail.do")
    public String detail(@RequestParam int userNo, Model model){
        //@RequestParam 을 명시하면 자동으로 required=true 가 된다.( 이 동적 페이지에 해당 파라미터가 꼭 필요하다)
        //@RequestParam 를 생략할수도 있다.(생략시 required=true 애매하게 동작한다.)
        System.out.println("요청된 유저 상세 번호: "+userNo);

        UserDto user=new UserDto();
        user.setUserNo(3);
        user.setName("홍길동");
        user.setBirth(new Date());
        user.setSal(999999);
        model.addAttribute("user",user);

        return "/userDetail";
    }
    @PostMapping("/update.do")
    public String update(){
        int update=0;
        if(update>0){
            return  "redirect:/user/list.do";
        }else {
            return  "redirect:/user/detail.do?userNo=1";
        }
    }
}