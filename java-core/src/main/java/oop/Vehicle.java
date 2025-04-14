package oop;

abstract class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    abstract void move();

    void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

