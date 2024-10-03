package com.LostArk.lostark;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class homeworkItemController {

    private final homeworkItemRepository homeworkItemRepository;
    private  final  homeworkService homeworkService;

    @GetMapping("/homeworklist")
    String homework(Model model){
       List<homeworkItem> result = homeworkItemRepository.findAll();

        model.addAttribute("homeworkItem" , result);

        /*
        homework object = new homework();
        object.나이설정(12);
        object.한살더하기();
        System.out.println(object.getAge());
        */

        return "homeworklist.html";
    }

    @GetMapping("/homeworkWrite")
    String homeworkWrite(){
        return "homeworkWrite.html";
    }

    @PostMapping("/homeworkAdd")
    String homeworkPost(String 글제목 , String 날짜){

        homeworkService.savehomework(글제목, 날짜);

        return "redirect:/homeworklist";
    }

    @GetMapping("/homeworkDetail/{아무런}") //여기서 넣은 문자랑 밑에 변수 문자랑 같아야함
    String 아무(@PathVariable Long 아무런, Model model){
        Optional<homeworkItem> result = homeworkItemRepository.findById(아무런);
        System.out.println(result.get());
        if(result.isPresent()){
            model.addAttribute("아무런",result.get());
            return "homeworkDetail.html";
        }
        else {
            return "redirect:/homeworklist";
        }
    }
}

// 숙제 - private 사용시 getter / 직접적으로 사용없이 조건 붙이기
/*
@Getter
class homework{

    private String name;
    private Integer age;

    public void 나이설정(Integer age){
        if(0< age && age < 100){
            this.age = age;
        }
    }
    public void 한살더하기(){
        this.age = this.age + 1;
    }
}
 */
