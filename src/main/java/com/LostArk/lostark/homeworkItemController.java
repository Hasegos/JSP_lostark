package com.LostArk.lostark;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class homeworkItemController {

    private final homeworkItemRepository homeworkItemRepository;

    @GetMapping("/homework")
    String homework(Model model){
       List<homeworkItem> result = homeworkItemRepository.findAll();

        model.addAttribute("homeworkItem" , result);

        homework object = new homework();
        object.나이설정(12);
        object.한살더하기();
        System.out.println(object.getAge());


        return "homeworklist.html";
    }
}

// 숙제 - private 사용시 getter / 직접적으로 사용없이 조건 붙이기
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
