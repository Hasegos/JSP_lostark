package com.LostArk.lostark;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString // Lombok 함수로 Object 한번에 보여줌
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "Text" /* 매우 긴 문자 가능*/, nullable = false /* 무조건 입력해야되는 컬럼 */)
    public String title;
    public Integer price;




    /* Object를 한번에 보여주는 함수
    public String toString() {
        return this.title + this.price;
    }
    */
     
}
