package com.example.springbasic_inflearn.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 추상화와 구체화 모두를 의존하고 있다. 매우 안좋은 상태.
    // OCP 원칙을 위배한다.
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 변경 : 생성자 주입. 생성자를 선언하고, 구현체는 AppConfig.class에서 한다.
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도. 인터페이스에 없다.
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
