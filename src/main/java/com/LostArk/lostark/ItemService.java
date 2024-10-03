package com.LostArk.lostark;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Service 클래스에 기본적으로 붙어야함
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }
}
