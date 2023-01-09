package com.example.springbasic_inflearn.singleton;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이너")
    public void pureContainer() throws Exception {
        AppConfig appConfig = new AppConfig();

        // 조회 첫번째: 호출할 때 마다 객체를 생성한다.
        MemberService memberService1 = appConfig.memberService();

        // 조회 두번째: 호출할 때 마다 객체를 생성한다.
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체를 사용")
    public void singletonServiceTest() throws Exception {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }

}
