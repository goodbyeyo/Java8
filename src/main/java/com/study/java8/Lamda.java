package com.study.java8;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * 람다
 *  : (인자리스트) -> { 바디 }
 * 인자리스트
 *  : 인자가 없을때 : ()
 *  : 인자가 한개일때 : (one) 또는 one
 *  : 인자가 여러개일때 : (one, two)
 *  : 인자의 타입은 생략가능, 컴파일러가 추론(infer) 하지만 명시할 수도 있다(Integer one, Integer two)
 * 바디
 *  : 화살표 오른쪽에 함수 본문을 정의한다
 *  : 여러 줄인 경우에 { } 를 사용해서 묶는다
 *  : 한줄인 경우에 생략가능, return 도 생략 가능하다
 * 변수 캡처
 *  : 로컬변수캡처
 *   - final 이거나 effetive final 인 경우에만 참조할 수 있다
 *   - 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일 방지한다
 *  : effective final
 *   - 이것도 역시 자바8부터 지원하는 기능으로 사실상 final 인 변수
 *   - fianl 키워드 사용하지 않을 변수를 익명 클래스 구현지 또는 람다에서 참조 할 수 있다
 *  : 익명 클래스 구현체와 달리 '쉐도잉' 하지 않는다
 *   - 익명클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.
 */
public class Lamda {
    public static void main(String[] args) {
        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        UnaryOperator<Integer> multiply3 = (i) -> i * 3;
        System.out.println(plus20.andThen(multiply3).apply(2));

        // Generic 으로부터 인자의 Type 추론 가능 -> 따라서 생략가능 (a, b)
        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;
    }
}
