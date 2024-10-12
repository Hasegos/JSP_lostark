package com.LostArk.lostark.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void login(String username, String password, String displayName){
        Member member = new Member();

        member.setUsername(username);
        member.setPassword(password);
        member.setDisplayName(displayName);
        memberRepository.save(member);
    }
}
