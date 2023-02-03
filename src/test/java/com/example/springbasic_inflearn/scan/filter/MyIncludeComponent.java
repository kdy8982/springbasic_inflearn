package com.example.springbasic_inflearn.scan.filter;

import java.lang.annotation.*;

//@ComponentScan 에 붙어있던 애노테이션을 그대로 가져옴.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
