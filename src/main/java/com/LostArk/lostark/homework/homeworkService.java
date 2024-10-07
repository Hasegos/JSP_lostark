package com.LostArk.lostark.homework;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class homeworkService {

    private  final com.LostArk.lostark.homework.homeworkItemRepository homeworkItemRepository;

    public void savehomework(String 글제목,  String 날짜){
        homeworkItem homeworkItem = new homeworkItem();
        homeworkItem.set날짜(날짜);
        homeworkItem.set글제목(글제목);
        homeworkItemRepository.save(homeworkItem);
    }
}
