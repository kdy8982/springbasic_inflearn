package com.example.springbasic_inflearn.order;

import com.example.springbasic_inflearn.discount.DiscountPolicy;
import com.example.springbasic_inflearn.discount.FixDiscountPolicy;
import com.example.springbasic_inflearn.discount.RateDiscountPolicy;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemberRepository;
import com.example.springbasic_inflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository = new MemoryMemberRepository();

    // OrderServiceImpl은 추상(DiscountPolicy)과 구현(RateDiscountPolicy) 모두 의존하고 있는 형국이다..
    // ==> DIP 위반.
    // 이로인해 할인 정책 변경할 때, 클라이언트(OrderServiceImpl)의 수정이 불가피하다.
    // ==> OCP 위반
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 단일 책임의 원칙.
        // 할인율에 대하여 OrderService는 관여하지 않고, DiscountPolicy 인터페이스에 완전히 위임하였다.
        // 할인과 관련된 변경이 있더라도 OrderService를 수정하지 않아도 된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
