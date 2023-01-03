package com.example.springbasic_inflearn.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
