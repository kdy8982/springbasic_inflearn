package com.example.springbasic_inflearn;

import com.example.springbasic_inflearn.member.Grade;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemberService;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import com.example.springbasic_inflearn.order.Order;
import com.example.springbasic_inflearn.order.OrderService;
import com.example.springbasic_inflearn.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
