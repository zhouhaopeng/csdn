package com.zhhp.java8;

import org.junit.Test;

import java.util.function.Function;

public class LambdaTest {

    @Test
    public void test(){
       final String name = "abc";
        //name = "df";
        Function<String,String> function = a -> name;
    }
}
