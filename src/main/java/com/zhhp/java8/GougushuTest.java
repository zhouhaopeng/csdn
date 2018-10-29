package com.zhhp.java8;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GougushuTest {

    @Test
    public void test(){
        IntStream.rangeClosed(1,200).boxed()
                .flatMap(a -> IntStream.rangeClosed(a,100)
                        .filter(b -> Math.sqrt( a*a + b*b) % 1 ==0)
                        .mapToObj(b -> new int[]{a,b,(int)Math.sqrt( a*a + b*b)})
                ).forEach(c -> System.out.println(c[0]+"-"+c[1]+"-"+c[2]));
//        Stream<int[]> pythagoreanTriples =
//                IntStream.rangeClosed(1, 100).boxed()
//                        .flatMap(a ->
//                                IntStream.rangeClosed(a, 100)
//                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                                        .mapToObj(b ->
//                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
//                        );
    }

    //generate 不会保留上一次的状态，但是 iterator会表保留
    @Test
    public void test2(){
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    @Test
    public void test3(){
        Stream.iterate(0,n -> n+1).limit(100).forEach(System.out::println);
    }

}
