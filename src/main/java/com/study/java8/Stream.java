package com.study.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 중개 오퍼레이션
 *  - Stream을 리턴한다
 *  - Stateless /Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다
 *  - 대부분은 Stateless지만 distinct나 sorted처럼 이전 소스 데이터를 참조해야 하는 오퍼레이션은 Stateful 오퍼레이션
 *  - filter, map, limit, skip, sorted, ...
 * 종료 오퍼레이션
 *  - Stream을 리턴하지 않는다
 *  - collect, allMatch, count, forEach, min, max, ...
 */
public class Stream {
    public static void main(String[] args) {
        List<String> citys = new ArrayList<>();
        citys.add("seoul");
        citys.add("busan");
        citys.add("changwon");
        citys.add("paris");

        java.util.stream.Stream<String> stringStream = citys.stream().map(String::toUpperCase);

        citys.stream().map((s) -> {
            System.out.println(s);  // 실행안함
            return s.toUpperCase();
        }).collect(Collectors.toList());    // 종료형 operator 있어야 실행함
        System.out.println("=================");
        citys.forEach(System.out::println);
    }
}
