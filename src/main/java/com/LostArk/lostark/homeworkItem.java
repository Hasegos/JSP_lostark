package com.LostArk.lostark;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class homeworkItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String 글제목;
    public String 날짜;
}
