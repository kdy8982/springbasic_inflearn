package com.example.springbasic_inflearn.order;

import com.example.springbasic_inflearn.discount.DiscountPolicy;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService {

    //    private MemberRepository memberRepository = new MemoryMemberRepository();

    // OrderServiceImpl은 추상(DiscountPolicy)과 구현(RateDiscountPolicy) 모두 의존하고 있는 형국이다..
    // ==> DIP 위반.
    // 이로인해 할인 정책 변경할 때, 클라이언트(OrderServiceImpl)의 수정이 불가피하다.
    // ==> OCP 위반
    //    private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 해결책. 생성자 주입.
    // DIP : 인터페이스에만 의존하고 있음.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 수정자 주입 (권장하지 않는 방법. 수정자 주입 대신 생성자 주입을 사용하라!)
    /*
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
    */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 단일 책임의 원칙.
        // 할인율에 대하여 OrderService는 관여하지 않고, DiscountPolicy 인터페이스에 완전히 위임하였다.
        // 할인과 관련된 변경이 있더라도 OrderService를 수정하지 않아도 된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도. 인터페이스에 없다.
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
