package com.example.springbasic_inflearn.singleton;

public class StatefulService {
    // 상태를 유지하는 필드(stateful field ; 주석처리)
    // private int price;

    // stateful field를 제거하고, 지역변수로 변경한다.
    public int order(String name, int price) {
        System.out.println("name : " + name + "// price" + price);
        return price;
    }
}
