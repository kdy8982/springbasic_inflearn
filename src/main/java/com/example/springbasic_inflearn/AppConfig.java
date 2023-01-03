package com.example.springbasic_inflearn;

import com.example.springbasic_inflearn.discount.FixDiscountPolicy;
import com.example.springbasic_inflearn.discount.RateDiscountPolicy;
import com.example.springbasic_inflearn.member.MemberService;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import com.example.springbasic_inflearn.member.MemoryMemberRepository;
import com.example.springbasic_inflearn.order.OrderService;
import com.example.springbasic_inflearn.order.OrderServiceImpl;

/**
 * 애플리케이션의 전체 설정 및 기획
 */
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
