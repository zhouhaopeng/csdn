package com.zhhp.core;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadTest {

    class ReenttrantLockThread implements Runnable{

        private ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
           try{
               lock.lock();
               for (int i = 0 ; i < 10 ; i++){
                   System.out.println(Thread.currentThread().getName()+"output: "+i);
               }
           }finally {
               lock.unlock();
           }
        }
    }


    @Test
    public void firstReentrantLock() throws InterruptedException {
        new Thread(new ReenttrantLockThread(),"a").start();
        new Thread(new ReenttrantLockThread(),"b").start();
        Thread.sleep(20000);
    }

    @Test
    public void test1(){
        HashMap<Integer,String> a = new HashMap<>(16);
        a.put(1,"abc");
        //System.out.println( new ThreadTest()&2);
    }
}
