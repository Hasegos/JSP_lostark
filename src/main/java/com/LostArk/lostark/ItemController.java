package com.LostArk.lostark;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor // repository등록할떄 필요
public class ItemController {

    private final ItemRepository itemRepository; // 원하는 클래스에 repository등록
    /*  다른 방법 (constructor이용)
    @Autowired
    public ItemController(ItemReposiory itemReposiory) {
        this.itemReposiory = itemReposiory;
    }
    */
    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll(); //List 자료로 가져옴
        //System.out.println(result.get(0).price);
        model.addAttribute("items", result);

        var a = new Item();
        System.out.println(a.toString());

        return "list.html";
    }
}
