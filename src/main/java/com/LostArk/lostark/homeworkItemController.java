package com.LostArk.lostark;

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

        return "homeworklist.html";
    }
}
