package com.example.springbasic_inflearn.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
