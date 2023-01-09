package com.example.springbasic_inflearn.singleton;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.member.MemberService;
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
}
