package com.LostArk.lostark.Item;

import com.LostArk.lostark.Member.Member;
import com.LostArk.lostark.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Service 클래스에 기본적으로 붙어야함
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public void update(Long id, String getTitle, Integer getPrice) throws Exception {
        // 엔티티 복사후 넘겨받은 값들을 set으로 저장하기 이후 save(행렬)
        Item item = new Item();

        if(getPrice < 0 || getTitle.length() >100){
            throw new Exception();
        }
        else {
            item.setId(id);
            item.setTitle(getTitle);
            item.setPrice(getPrice);
            itemRepository.save(item);
        }
    }

    public void delete(Long id){
        itemRepository.deleteById(id);
        System.out.println(id+ "번호 삭제완료했습니다.");
    }
}
