package com.example.springbasic_inflearn.scan;

import com.example.springbasic_inflearn.AutoAppConfig;
import com.example.springbasic_inflearn.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    @DisplayName("컴포넌트 스캔으로 빈이 등록되었는지 확인")
    public void basicScan() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isNotNull();
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}