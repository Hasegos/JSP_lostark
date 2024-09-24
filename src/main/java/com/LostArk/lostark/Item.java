package com.LostArk.lostark;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString // Lombok 함수로 Object 한번에 보여줌
@Getter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Text" /* 매우 긴 문자 가능*/, nullable = false /* 무조건 입력해야되는 컬럼 */)
    private String title;
    private Integer price;

    // 숙제부분부터하기

//    // getter 함수
//    public String getTitle(){
//        return  title;
//    }
//
//    // setter 함수
//    public void setTitle(String title){
//        this.title = title;
//    }

    /* Object를 한번에 보여주는 함수
    public String toString() {
        return this.title + this.price;
    }
    */
     
}
