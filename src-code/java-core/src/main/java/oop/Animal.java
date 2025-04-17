package oop;

public interface Animal {
    void speak();

    default void output(){
        System.out.println("This is animal.");
    }
}


