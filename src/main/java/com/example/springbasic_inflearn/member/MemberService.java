package com.example.springbasic_inflearn.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
