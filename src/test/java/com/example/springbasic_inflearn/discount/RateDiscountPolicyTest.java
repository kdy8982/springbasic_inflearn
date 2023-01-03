package com.example.springbasic_inflearn.discount;

import com.example.springbasic_inflearn.member.Grade;
import com.example.springbasic_inflearn.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    public void vip_o() throws Exception {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(memberVIP, 40000);

        //then
        assertThat(discount).isEqualTo(4000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    public void vip_x() throws Exception {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 40000);

        //then
        assertThat(discount).isEqualTo(0);

    }

}