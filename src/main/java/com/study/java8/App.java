package com.study.java8;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        String[] names = {"wook", "sumin", "temin"};

        // Comparator 함수형 인터페이스
        Arrays.sort(names, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        // 임의 객체의 인스턴스 메소드 참조
        Arrays.sort(names, String::compareToIgnoreCase);

        Foo foo = new DefaultFoo("wook");
        foo.printName();
        foo.printNameUpperCase();
        Foo.printAnything();
    }
}
