package com.zhhp.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTest {


    @Test
    public void test1(){
        LocalDate date = LocalDate.of(2014,3,18);

        System.out.println(date);

        System.out.println(LocalDate.now());
    }

    @Test
    public void test2(){
        LocalTime time = LocalTime.of(12,3,12);

        System.out.println(time);

        System.out.println(LocalTime.now());
    }
}
