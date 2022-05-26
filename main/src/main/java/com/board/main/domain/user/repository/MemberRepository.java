package com.board.main.domain.user.repository;

import com.board.main.domain.user.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  //회원 저장
    Optional<Member> findById(Long id);  //회원의 id값으로 정보 찾기
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
}
