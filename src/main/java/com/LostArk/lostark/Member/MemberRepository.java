package com.LostArk.lostark.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findAllByUsername(String name); //여기서 All붙이면 일치하는 행을 전부다 찾아옴
}
