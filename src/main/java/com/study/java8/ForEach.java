package com.study.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class ForEach {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("wook");
        name.add("hoho");
        name.add("kim");
        name.add("park");
        name.add("choi");

        // 인자가 하나일때 (s) 괄호생략가능
        // name.forEach(System.out::println);

        /**
         * Iterable의 기본 메소드 : forEach(), spliterator
         */
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===========");
        while (stringSpliterator.tryAdvance(System.out::println));
//        for (String n : name) {
//            System.out.println(n);
//        }

        /**
         *  Collection의 기본 메소드
         */
        List<String> list = name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());
        System.out.println("list =" + list);

        name.removeIf(s -> s.startsWith("K"));
        name.forEach(System.out::println);

        /**
         * Comparator의 기본 메소드 및 스태틱 메소드
         */
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.sort(compareToIgnoreCase.reversed().thenComparing(compareToIgnoreCase));
    }
}
