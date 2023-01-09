package com.example.springbasic_inflearn.singleton;

public class SingletonService {
    // 자기 자신을 내부에 static으로 선언하여 미리 생성해둔다.
    // 클래스 레벨에 있기 때문에 하나만 존재한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 하여서, 외부에서 임의로 생성할 수 없도록 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}