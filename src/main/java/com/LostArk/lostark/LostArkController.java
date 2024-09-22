package com.LostArk.lostark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

@Controller // 서버 기능 추가
public class LostArkController {
    @GetMapping("/") // <-메인페이지 접속시
    // @ResponseBody 문자 그래도 반환해줌
    String hello(){
        return "index.html"; // html 반환
    }

    @GetMapping("/about")
    @ResponseBody
    String hello2(){
        return "피싱사이트예요";
    }

    // 시간 그대로 보여주기
    @GetMapping("/date")
    @ResponseBody
    String hello3(){
        return ZonedDateTime.now().toString(); 
    }
}
