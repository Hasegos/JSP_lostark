package com.LostArk.lostark.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor // repository등록할떄 필요
public class ItemController {

    private final ItemRepository itemRepository; // 원하는 클래스에 repository등록
    private final ItemService itemService;
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
        // System.out.println(result);
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
    String addPost( /* @ModelAttribute Item item*/
             /*@RequestParam Map title*/
             String title, Integer price){

        // System.out.println(title);

        //input값을 여러개 받았을때 Map사용해서 받기
        /*
        var Title = title.get("title");
        var Price = title.get("price");

        System.out.println(Title);
        System.out.println(Price);
        */

        // HashMap 사용법
        /*
        HashMap<Object, Object>test = new HashMap<>();
        test.put("name","kim");
        test.put("age","20");
        System.out.println(test.get("name"));
        */

        // 유저로부터 데이터를 넘겨받고 그걸 저장했을때 오류난 이유
        /* var a = new Item(Title.toString(),Price.toString());

        오류 발생했던 이유 : 저장 까지는 OK 그 데이터를 가져오는게 문제
        해결법 -> @Getter를 이용해서 가져오기

        @Entity 쪽에서 Setter메소드 작성은 OK 꼭 데이터를 가져올떄는 @Getter사용하기

        만약 생성자를 이용해서 저장시 기본생성자는 생성해줘야함.

        itemRepository.save(a);
        */

        itemService.saveItem(title,price);

        return "redirect:/list";
    }
    
    // 유저가 해당 URL를 입력시 해당 값을 가져오는 구조
    @GetMapping("/detail/{id}" /*{아무문자}*/)
    String detail(@PathVariable Long id, Model model){ // 유저가 URL 파라미터에 입력한 값을 가져올 수 있음
        //throw new Exception();
        try  {
           // throw new Exception("이런 저런에러임");
            Optional<Item> result = itemRepository.findById(id);
            if(result.isPresent()){ //  있을 떄만
                System.out.println(result.get());
                // Optional 안에있는 자료를 .get()으로 가져오기
                model.addAttribute("abc", result.get());
                return "detail.html";
            }
            else {
                return "redirect:/list";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            // 유저 잘못 : 4xx / 서버 잘못 : 5xx / 정상 : 2xx
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("니잘못임");
            return  "redirect:/list.html";
        }
    }

    //모든 API에서 에러발생시 대신 실행해줌
    /*
        @ExceptionHandler(Exception.class)
        public void handler(){
            return ResponseEntity.status(400).body("니잘못임");
        }
    */

    // 해당 id값으로 URL 잡기 ex) edit/1 ... 등등
    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            // 기존 데이터를 넘겨주기 
            // -> 그래야 Post할때 기존데이터 값을 가지고 Post가능
            model.addAttribute("data",result.get());
            return "edit.html";
        }
        else{
            return  "redirect:/list";
        }
    }
    // 기존 데이터 넘겨준 id 값으로 Post하기 (데이터값을 수정하기위해 )
    @PostMapping("/edit/{id}")
    // @PathVariable로 유저로부터 데이터를 받기
    String edit2(@PathVariable Long id, String title, Integer price) throws Exception {
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            // 해당 id값에 덮어씌우기(즉, 저장기능) -> JPA에서는 저장기능이 따로 구현되어있지않고
            // .save()로 해결한다
            itemService.update(id,title,price);
            return "redirect:/list";
        }
        else{
            return  "edit.html";
        }
    }

    // delete 삭제기능  button에서 바로 받아서하는법
    /*
        @DeleteMapping("/delete")
        ResponseEntity<String> delete(@RequestParam Long id){
            itemRepository.deleteById(id);
            return ResponseEntity.status(200).body("삭제완료");

        }
    */

    // id값을 입력받아서 삭제기능!
    @PostMapping("/delete")
    ResponseEntity<String> delete(@RequestBody Long id){
        itemService.delete(id);
        return ResponseEntity.status(200).body("삭제완료");
    }


    @GetMapping("/test2")
    String test2(){
        var a = new BCryptPasswordEncoder().encode(" 문자~~");
        System.out.println(a);
        return  "redirect:/list";
    }


}

