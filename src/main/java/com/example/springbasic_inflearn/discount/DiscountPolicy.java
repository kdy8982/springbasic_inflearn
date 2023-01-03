package com.example.springbasic_inflearn.discount;

import com.example.springbasic_inflearn.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);



}
