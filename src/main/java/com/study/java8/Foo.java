package com.study.java8;

@FunctionalInterface
public interface  Foo {

    // abstract는 생략가능
    // 다른형태의 메서드가 있더라도 추상화 메서드가 1개있으면 functional 인터페이스에 해당한다
    abstract int init(int i);

    static void printName() {
        System.out.println("name");
    }

    default void printAge() {
        System.out.println("age");
    }
}
