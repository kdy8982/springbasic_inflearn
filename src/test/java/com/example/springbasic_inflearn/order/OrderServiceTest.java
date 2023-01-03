package com.example.springbasic_inflearn.order;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.member.Grade;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemberService;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.Assert.*;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    public void VIP인_경우_1000원_할인() throws Exception {
        //given
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDicountPrice()).isEqualTo(1000);
    }

}