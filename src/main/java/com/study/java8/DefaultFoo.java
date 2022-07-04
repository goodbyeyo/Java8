package com.study.java8;

public class DefaultFoo implements Foo, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void printName() {
        System.out.println(this.name.toUpperCase());

    }

    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
