package com.example.springbasic_inflearn.autowired;

import com.example.springbasic_inflearn.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // Spring에서 관리하지 않는 Bean을 주입받으려고 할 때, 어떻게 처리할 것인지에 대한 '옵션 처리'에 대해 알아본다.
    // 상황. Member 클래스는 Spring에서 관리하는 Bean이 아니다.
    static class TestBean {

        @Autowired(required = false) // required = false일 경우, 호출 자체가 되지 않는다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // null로 들어온다.
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3) { // Optional.empty
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
