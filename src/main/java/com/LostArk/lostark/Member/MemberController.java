package com.LostArk.lostark.Member;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    String login(){
        return "login.html";
    }
    @PostMapping("/Login")
    String Login(String username, String password, String displayName, HttpServletResponse response) throws IOException {
        
        // PrintWriter 사용법
        /*
         PrintWriter를 이용해 script 파일를 보내는거임 이때 HHttpServletResponsett를 가져와야함
         추가로 response.setContentType("text/html;charset=UTF-8"); 사용하기전에 필요함
         그리고 사용법은 PrintWriter out = response.getWriter(); 형태로 선언후
         out.println(<script> ~~~~ </script>) 로 작성한 후
         out.flush();로 닫아줘야함
        */
        response.setContentType("text/html;charset=UTF-8");

        if(password.length() < 6){
            PrintWriter out = response.getWriter();
            out.println("<script> alert('비밀번호 숫자자리가 너무짧습니다 6자리이상으로 해주세요'); </script>");
            out.flush();
            return "login.html";
        }else{
            var hashing = passwordEncoder.encode(password);
            memberService.login(username,hashing,displayName);
            System.out.println(username + password + displayName);
            return  "redirect:/list";
        }
    }


}
