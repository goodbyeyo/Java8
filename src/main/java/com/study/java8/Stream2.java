package com.study.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import java.util.stream.Collectors;

public class Stream2 {

        public static void main(String[] args) {
//            List<String> names = new ArrayList<>();
//            names.add("keesun");
//            names.add("whiteship");
//            names.add("toby");
//            names.add("foo");
//
//            List<String> collect = names.stream().map((s) -> {
//                System.out.println(s + " " + Thread.currentThread().getName());
//                return s.toUpperCase();
//            }).collect(Collectors.toList());
//            collect.forEach(System.out::println);
            List<OnlineClass> springClasses = new ArrayList<>();
            springClasses.add(new OnlineClass(1, "spring boot", true));
            springClasses.add(new OnlineClass(2, "spring data jpa", true));
            springClasses.add(new OnlineClass(3, "spring mvc", false));
            springClasses.add(new OnlineClass(4, "spring core", false));
            springClasses.add(new OnlineClass(5, "rest api development", false));

            System.out.println("spring 으로 시작하는 수업");
            springClasses.stream()
                    .filter(oc -> oc.getTitle().startsWith("spring"))
                    .forEach(oc -> System.out.println(oc.getId())); // stream을 리턴하지 않는것은 모두 종료 operator

            System.out.println("close 되지 않은 수업");
             // # Using Predicate.not() Method
             springClasses.stream()
                     .filter(Predicate.not(OnlineClass::isClosed))
                     .forEach(oc -> System.out.println(oc.getId()));
             // springClasses.stream()
             //       .filter(oc -> !oc.isClosed())
             //       .forEach(oc -> System.out.println(oc.getId()));

            System.out.println("수업 이름만 모아서 스트림 만들기");
            // # Using Method Reference
            springClasses.stream()
                    .map(OnlineClass::getTitle)
                    .forEach(System.out::println);
            // springClasses.stream()
            //        .map(oc -> oc.getTitle())
            //        .forEach(s -> System.out.println(s));

            List<OnlineClass> javaClasses = new ArrayList<>();
            javaClasses.add(new OnlineClass(6, "The Java, Test", true));
            javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
            javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

            List<List<OnlineClass>> bothEvents = new ArrayList<>();
            bothEvents.add(springClasses);
            bothEvents.add(javaClasses);

            System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
            bothEvents.stream().flatMap(Collection::stream)
                    .forEach(oc -> System.out.println(oc.getId()));

            System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
            Stream.iterate(10, i -> i + 1)
                    .skip(10)
                    .limit(10)
                    .forEach(System.out::println);

            System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
            boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
            System.out.println("test = " + test);

            System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
            List<String> spring = springClasses.stream()
                    .filter(oc -> oc.getTitle().contains("spring"))
                    .map(OnlineClass::getTitle) // map(oc -> oc.getTitle())
                    .collect(Collectors.toList());
            spring.forEach(System.out::println);
            
            // # map과 filter 순서를 변경 할 경우
            List<String> spring2 = springClasses.stream()
                    .map(OnlineClass::getTitle) 
                    .filter(t -> t.contains("spring"))  // 문자열이 온다
                    .collect(Collectors.toList());
            spring.forEach(System.out::println);

        }
}
