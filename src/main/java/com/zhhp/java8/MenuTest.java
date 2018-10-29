package com.zhhp.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuTest {


    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );
    private List<Dish> menu1;

    @Test
    public void test1(){
        List<String> threeHeightCaloricDish = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHeightCaloricDish);
    }

    @Test
    public void test2(){
        List<String> names = menu.parallelStream().filter(dish -> {
            System.out.println("filter "+dish.getName());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("map "+dish.getName());
            return dish.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void test3(){
        menu.stream().map(Dish::getName).forEach(System.out::println);
    }

    @Test
    public void test4(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<Stream<String>> streams = streamOfwords.map(s -> s.split(""))
                .map(Arrays::stream).distinct().collect(Collectors.toList());
    }

    @Test
    public void test5(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> streams = streamOfwords.map(s -> s.split(""))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(streams);
    }

    @Test
    public void test6(){
        if (menu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("isVegetarian");

        //menu.stream().find
    }

    @Test
    public void test7(){
        int[] x = new int[]{1,2,3,4,5,6};
        Arrays.stream(x).reduce(1,(a,b)->a+b);
    }

     static class Dish{
        public enum Type { MEAT, FISH, OTHER }
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

         @Override
         public String toString() {
             return "Dish{" +
                     "name='" + name + '\'' +
                     ", vegetarian=" + vegetarian +
                     ", calories=" + calories +
                     ", type=" + type +
                     '}';
         }
     }
}
