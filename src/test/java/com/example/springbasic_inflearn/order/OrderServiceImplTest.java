package com.example.springbasic_inflearn.order;

import com.example.springbasic_inflearn.discount.FixDiscountPolicy;
import com.example.springbasic_inflearn.member.Grade;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {

        // 문제 상황.
        // OrderServiceImpl orderService = new OrderServiceImpl();
        // 수정자 주입의 경우, 사용자 입장에서는 어떤 의존관계를 미리 설정해주어야 하는지, 알 수가 없다.

        // 생성자 주입을 사용하는 경우, 개발자가 컴파일 단계에서 문제를 미리 알아챌 수 있다!!
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDicountPrice()).isEqualTo(1000);
    }
}