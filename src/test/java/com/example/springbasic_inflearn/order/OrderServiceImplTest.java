package com.example.springbasic_inflearn.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();

        // 문제 상황.
        // 수정자 주입의 경우, 사용자 입장에서는 어떤 의존관계를 미리 설정해주어야 하는지, 알 수가 없다.
        orderService.createOrder(1L, "itemA", 10000);

    }
}