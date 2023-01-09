package com.example.springbasic_inflearn.beanfind;

import com.example.springbasic_inflearn.AppConfig;
import com.example.springbasic_inflearn.discount.DiscountPolicy;
import com.example.springbasic_inflearn.discount.FixDiscountPolicy;
import com.example.springbasic_inflearn.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.ls.LSOutput;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상이 있으면, 중복 오류가 발생한다.")
    public void findBeanByParentTypeDuplicate() throws Exception {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

   @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상이 있으면, 빈 이름을 지정하면 된다.")
    public void findBeanByParentTypeBeanName() throws Exception {
       assertThat(ac.getBean("rateDiscountPolicy",DiscountPolicy.class))
               .isInstanceOf(DiscountPolicy.class);
    }


    @Test
    @DisplayName("특정 하위 타입으로 조회")
    public void findBeanBySubType() throws Exception {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    public void fidnAllBeanByParentType() throws Exception {

        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        for (String key:
             beansOfType.keySet()) {
            DiscountPolicy discountPolicy = beansOfType.get(key);
            System.out.println(key);
        }

        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    public void fidnAllBeanByObjectType() throws Exception {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for (String key:
                beansOfType.keySet()) {
            System.out.println("name : " + key + " // value : " + beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }


}
