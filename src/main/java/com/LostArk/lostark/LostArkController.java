package com.LostArk.lostark;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController // 서버 기능 추가
public class LostArkController {
    /*
        템플릿 엔진 사용시!!!

        기존 Controller사용한 곳은 RestController로 바꿔줘야하고
        GetMapping(경로는 직접 입력)해야된다.
        아마 템플릿으로 경로가 옮겨가서 인식이 안된듯한다.
     */
    @GetMapping("static") // <-메인페이지 접속시
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
