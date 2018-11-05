package com.zhhp.java8;

public class TaskTest {

    interface Task{
        public void execute();
    }

    public static void doSomething(Runnable r){
        r.run();
    }

    public static void doSomething(Task t){
        t.execute();
    }

    public static void main(String[] args){
        doSomething((Task) ()->System.out.println("aaa"));
    }
}
