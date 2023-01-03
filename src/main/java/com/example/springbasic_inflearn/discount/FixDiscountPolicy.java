package com.example.springbasic_inflearn.discount;

import com.example.springbasic_inflearn.member.Grade;
import com.example.springbasic_inflearn.member.Member;

/**
 * 고정할인 정책. VIP일 경우 1000원을 할인해준다.
 */
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
