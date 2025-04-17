package oop;

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    @Override
    void move() {
        System.out.println("Car is driving on the road.");
    }
}

class Bicycle extends Vehicle {
    Bicycle(String brand) {
        super(brand);
    }

    @Override
    void move() {
        System.out.println("Bicycle is pedaling.");
    }
}

