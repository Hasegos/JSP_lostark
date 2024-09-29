package com.LostArk.lostark;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(result);
        model.addAttribute("items", result);

        //var a = new Item();
        //System.out.println(a.toString());

        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    // 원하는 타입으로 바꾸기
    String addPost( @ModelAttribute Item item
            /* @RequestParam Map title */){

        System.out.println(item);

        /* input값을 여러개 받았을때 Map사용해서 받기

        var Title = title.get("title");
        var Price = title.get("price");

        System.out.println(Title);
        System.out.println(Price);
        */

        /*   HashMap 사용법
        HashMap<Object, Object>test = new HashMap<>();
        test.put("name","kim");
        test.put("age","20");
        System.out.println(test.get("name"));
        */

        /*
        var a = new Item(Title.toString(),Price.toString());

        오류 발생했던 이유 : 저장 까지는 OK 그 데이터를 가져오는게 문제
        해결법 -> @Getter를 이용해서 가져오기

        @Entity 쪽에서 Setter메소드 작성은 OK 꼭 데이터를 가져올떄는 @Getter사용하기

        만약 생성자를 이용해서 저장시 기본생성자는 생성해줘야함.
         */
        // itemRepository.save(item);
        return "redirect:/list";
    }
}
