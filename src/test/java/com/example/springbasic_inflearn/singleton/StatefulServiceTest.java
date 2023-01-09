package com.example.springbasic_inflearn.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 객체 공유필드 stateful 상황 예시")
    public void statefulServiceSingleton() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // ThreadA: A사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        // ThreadB: B사용자가 20000원 주문 (ThreadA 의 주문을 덮어씌워 버림)
        int userBPrice = statefulService2.order("userB", 20000);

//        assertThat(price).isEqualTo(10000); // error
        assertThat(userAPrice).isEqualTo(10000);
        assertThat(userBPrice).isEqualTo(20000);

    }


    static class TestConfig {
        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }

}