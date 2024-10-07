package com.LostArk.lostark.homework;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class homeworkItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String 글제목;
    private String 날짜;

    public homeworkItem(){

    }
    public homeworkItem(String 글제목, String 날짜){
        this.글제목 = 글제목;
        this.날짜 = 날짜;
    }
}
