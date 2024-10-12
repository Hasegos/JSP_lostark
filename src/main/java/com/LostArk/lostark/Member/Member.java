package com.LostArk.lostark.Member;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // 중복 방지
    private String username; // 아이디
    private String password; // 비번
    private String displayName; // 이름

}
