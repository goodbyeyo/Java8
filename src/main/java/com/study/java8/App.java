package com.study.java8;

import java.time.Duration;
import java.util.*;

public class App {
    public static void main(String[] args) {

        String[] names = {"wook", "sumin", "temin"};

        // Comparator 함수형 인터페이스
//        Arrays.sort(names, new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//
//        // 임의 객체의 인스턴스 메소드 참조
//        Arrays.sort(names, String::compareToIgnoreCase);
//
//        Foo foo = new DefaultFoo("wook");
//        foo.printName();
//        foo.printNameUpperCase();
//        Foo.printAnything();

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        // Reference Progress 의 기본값이 null 이기 때문에 nullPointException 발생
        // Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        // System.out.println("studyDuration = " + studyDuration);
        // if (spring_boot.getProgress() != null) {
        //     System.out.println("spring_boot = " + spring_boot.getProgress().getStudyDuration());
        // }

        /*
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        */

        /* 값이 없는 경우 */
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println("present = " + present);
        
        // 꺼낼때 값이 없으면 noSuchElementException 발생
        /*
        if (optional.isPresent()) { // null check
            OnlineClass onlineClass = optional.get();
            System.out.println("onlineClass.getTitle() = " + onlineClass.getTitle());
        }
        */

        /* ifPresend() : if exist value then action */
        optional.ifPresent(oc -> System.out.println("oc.getTitle() = " + oc.getTitle()));

        /* orElse()  : if exist value then return value, if null action and return */
        // 상수로 만들어져 있는 대상에 적합...
        OnlineClass onlineClass = optional.orElse(createNewJpaClass());

        /* orELseGet() : if exist value then get value, is null action */
        // 동적으로 작업하는 경우 적합
        OnlineClass onlineClass1 = optional.orElseGet(App::createNewJpaClass);
        System.out.println("online = " + onlineClass1.getTitle());

        /* orELseThrow() : 값있으면 가져오고 없으면 에러 리턴 */
        // -> noSuchElementException 발생
        OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new);
        System.out.println("onlineClass2 = " + onlineClass2.getTitle());

        /* filter() : 들어있는값 걸러내기 */
        Optional<OnlineClass> onlineClass3 = optional.filter(oc -> !oc.isClosed());
        System.out.println("onlineClass3.isEmpty() = " + onlineClass3.isEmpty());

        /* map(function), flatMap(function) */
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println("integer = " + integer.isPresent());

        Optional<Optional<Progress>> progress  = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        Optional<Progress> pro = optional.flatMap(OnlineClass::getProgress);

        /*springClasses.stream()
                .map()          // 1:1 맵핑
             .flatMap()      // input 1, ouput 여러개..
        */


    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "jpa class", true);
    }
}
