package com.example.springbasic_inflearn;

import com.example.springbasic_inflearn.discount.DiscountPolicy;
import com.example.springbasic_inflearn.discount.FixDiscountPolicy;
import com.example.springbasic_inflearn.discount.RateDiscountPolicy;
import com.example.springbasic_inflearn.member.MemberRepository;
import com.example.springbasic_inflearn.member.MemberService;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import com.example.springbasic_inflearn.member.MemoryMemberRepository;
import com.example.springbasic_inflearn.order.OrderService;
import com.example.springbasic_inflearn.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 전체 설정 및 기획
 */
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //AppConfig Refactoring
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
