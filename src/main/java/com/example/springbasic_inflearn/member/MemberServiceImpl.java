package com.example.springbasic_inflearn.member;

public class MemberServiceImpl implements MemberService {

    // 추상화와 구체화 모두를 의존하고 있다. 매우 안좋은 상태.
    // OCP 원칙을 위배한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
