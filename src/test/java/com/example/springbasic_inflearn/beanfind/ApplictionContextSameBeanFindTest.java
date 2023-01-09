package com.example.springbasic_inflearn.beanfind;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.discount.DiscountPolicy;
import com.example.springbasic_inflearn.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplictionContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시에 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    public void findBeanByType() throws Exception {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    public void findBeanByName() throws Exception {
        MemberRepository memberRepository1 = ac.getBean("memberRepository1", MemberRepository.class);

        assertThat(memberRepository1).isInstanceOf(MemoryMemberRepository.class);
    }


    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    public void findAllBeanByType() throws Exception {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);


        for (String key :
             beansOfType.keySet()) {
            MemberRepository repository = beansOfType.get(key);

            System.out.println("key : " + key + "value : " + beansOfType.get(key));
        }

        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig { // scope을 해당 클래스로 제한
        @Bean
        MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
