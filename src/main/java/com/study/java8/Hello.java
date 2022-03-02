package com.study.java8;

import java.util.function.*;

public class Hello {
    public static void main(String[] args) {
        /**
         * 함수를 First class object로 사용 할 수 있다
         * pure function(순수 함수) : 함수 밖의 값을 참조하거나 변경하면 할 수 없다 -> 사이드 이펙트 만들수 없다
         * 상태가 없다 (함수 밖에 정의되어 있는)
         * 함수 내부에 전달받은 파라미터만 사용가능하다
         */
        // Function<T,R> : T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        plus10.compose(multiply2);  // higher order function : 값이 들어오면 x2를 하고 plus10을 실행
        plus10.andThen(multiply2);  // 값이 들어오면 plus10을 실행하고 x2을 실행
        System.out.println(plus10.andThen(multiply2).apply(1));

        // Consumer<T> : T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier<T> : T 타입의 값을 제공하는 함수 인터페이스 (받아올 값을 정의)
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate<T> : T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
        Predicate<String> stringPredicate = (s) -> s.startsWith("wook");
        stringPredicate.negate();

        // UnaraOprator : 입력하는값의 타입과 결과값의 타입이 같은 경우
        // Function을 상속받았기 때문에 compose, and, then 모두 사용 가능하다
        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        UnaryOperator<Integer> multiply3 = (i) -> i * 3;
        
//        int baseNumbber = 10;   // final 로 가정하고 사용
//        Foo function = number -> number + baseNumbber;
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));

        // 익명 내부 클래스 annoymous inner class
//        Functional functional = new Functional() {
//
//            @Override
//            public void init() {
//                System.out.println("Hello");
//                System.out.println("Lamda");
//            }
//        };
//
//        Functional functional = () -> {
//            System.out.println("Hello");
//            System.out.println("Lamda");
//        };

//        Functional functional = new Functional() {
//
//            @Override
//            public void init() {
//                System.out.println("Hello");
//
//            }
//        };

//        Function function = () -> System.out.println("Hello");
//        functional.init();



//        Function function = new Function() {
//
//            @Override
//            public int init(int number) {
//                return number + baseNumbber;
//            }
//        };

    }
}
