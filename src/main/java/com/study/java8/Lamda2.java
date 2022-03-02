package com.study.java8;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Lamda2 {
    public static void main(String[] args) {
        Lamda2 foo  = new Lamda2();
        foo.run();
    }

    private void run() {
        // fianl 예약어가 있어야만 익명클래스 또는 내부클래스
        final int baseNumber = 10;

        // 로컬클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // local variable 참조 // 파라미터 baseNumber을 참조함
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {  // 인자를 baseNumber로 사용할수 없다 같은 스코프안에 변수 재사용 불가)
            System.out.println(i+ baseNumber); // Lamda에서 local variable 참조
        };
        // baseNumber++;   // 값을 변경하면 effective final이 아니기때문에 값을 변경할수없다

        // 공통점
        // 1. 참조 가능
        // 2. 사실상 final 인 경우(effective final) 생략 할 수 있다
        // 3. 로컬클래스와 익명클래스는 쉐도잉(다른 변수를 가린다)이 된다 (별도의 스코프에 해당함)
        // 4. 람다는 안된다 (람다는 감싸도 있는 메서드와 스코프가 같다) 즉 같은 스코프안에 같은 변수를 선언할수없다

        printInt.accept(10);
    }
}
