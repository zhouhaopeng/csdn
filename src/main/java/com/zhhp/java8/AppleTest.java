package com.zhhp.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

interface ApplePrd{
    Apple prd(int id,int weight,String color);
}

public class AppleTest {

    private ApplePrd applePrd = Apple::new;

    public List<Apple> map(List<Integer> list, Function<Integer,Apple> f){
        List<Apple> result = new ArrayList<>();
        for (Integer e : list){
            result.add(f.apply(e));
        }
        return result;
    }

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(7,3,2);
        List<Apple> apples = map(list,Apple::new);
    }

    private Comparator<Apple> comparator = (Apple a, Apple b) -> { return a.compareTo(b);};

    private Comparable<Apple> comparable = (Apple a) -> a.getId();

    private Comparable<Apple> c2 = Apple::getId;

    public static void filterApple(List<Apple> list,ApplePredicate p){
        for (Apple apple : list){
            if (p.test(apple)){
                System.out.println(apple.getId());
            }
        }
    }

    public static void main(String[] args){
        List<Apple> inventory = Arrays.asList(new Apple(1,80,"green"),
                new Apple(2,155, "green"),
                new Apple(3,120, "red"));

        inventory.sort(Comparator.comparing(Apple::getId));

        filterApple(inventory,apple -> "green".endsWith(apple.getColor()));
    }
}

class Apple implements Comparable<Apple>{
    private int id;
    private String color;
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(){}

    public Apple(int id , int weight , String color) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Apple o) {
        return 0;
    }
}

interface ApplePredicate{
    boolean test(Apple apple);
}