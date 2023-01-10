package com.example.springbasic_inflearn.singleton;


import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.member.MemberRepository;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import com.example.springbasic_inflearn.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    public void configurationTest() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        // AppConfig.java 에서는 memberRepository가 세번이나 new로 초기화 되었지만, 실제로는 하나의 객체로 되어있다.
        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
    }
}
