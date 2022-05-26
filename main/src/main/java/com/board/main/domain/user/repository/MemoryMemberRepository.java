package com.board.main.domain.user.repository;

import com.board.main.domain.user.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();  //메모리에 저장할 자료구
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // user의 ID를 키 값으로 하는 member 객체를 store에 저장
    @Override
    public Optional<Member> findById(Long userId) {
        return Optional.ofNullable(store.get(userId));
    }//저장된 ID값을 가지고 member객체 return

    public Optional<Member> findByEmail(String email) {

        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
