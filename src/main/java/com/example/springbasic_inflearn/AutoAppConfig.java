package com.example.springbasic_inflearn;


import com.example.springbasic_inflearn.member.MemberRepository;
import com.example.springbasic_inflearn.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 기존 @Configuration코드 를 유지하기 위해서 임시로 추가해놓았다.
        // 실무에서는 이렇게 사용하지 않음 !
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /*@Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository () {
        return new MemoryMemberRepository();
    }*/

}
