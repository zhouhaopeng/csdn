package com.zhhp.java8;

import java.util.Optional;

public class CarTest {

    public class Person {
        private Optional<Car> car;
        public Optional<Car> getCar() { return car; }
    }
    public class Car {
        private Optional<Insurance> insurance;
        public Optional<Insurance> getInsurance() { return insurance; }
    }
    public class Insurance {
        private String name;
        public String getName() { return name; }
    }

    Optional<Car> optCar = Optional.empty();

    public void test(){
        Optional<Person> person = Optional.ofNullable(null);

        person.map(Person::getCar);

        person.flatMap(Person::getCar);
    }

}
