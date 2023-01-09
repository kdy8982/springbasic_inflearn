package com.example.springbasic_inflearn.beanfind;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.member.Member;
import com.example.springbasic_inflearn.member.MemberService;
import com.example.springbasic_inflearn.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름 조회")
    public void findBeanByName() throws Exception {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService)
                .isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름없이 타입으로만 조회")
    public void findBeanByType() throws Exception {
        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService)
                .isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByType2() throws Exception {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);

        Assertions.assertThat(memberService)
                .isInstanceOf(MemberServiceImpl.class);
    }

    //실패 테스트
    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void findByBeanNameX() throws Exception {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }


}
