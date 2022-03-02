package com.study.java8;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Method {
    public static void main(String[] args) {
        // 특정 객체의 인스턴스 메소드 참조
        Function<Integer, String> intToString = (i) -> "number";

        // 입력값과 결과값이 같은 경우
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;  // 인스턴스 메소드 참조
        System.out.println(hello.apply("wook"));

        // 입력값이 없는 생성자
        Supplier<Greeting> newGreeting = Greeting::new;

        // 입력값을 받는 생성자
        Function<String, Greeting> sangwook = Greeting::new;
        Greeting wook = sangwook.apply("sangwook");
//        System.out.println(wook.getName());


    }
}
