package com.zhhp.threadTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Food {

    private static LinkedList<String> capacity = new LinkedList<>();
    private String[] menus = {"apple","banana","orange","peer"};

    private  volatile boolean flag = false;
    private ReentrantLock lock = new ReentrantLock();
    private Condition pCdn = lock.newCondition();
    private Condition cCdn = lock.newCondition();


    public void produce(){
        try {
            lock.lock();
            while (flag) {
                System.out.println("producer begin wait");
                pCdn.await();
            }
            System.out.println("producer begin produce");
            for (int i = 0; i < 4; i++) {
                capacity.add(Thread.currentThread().getName() + "_produce_" + menus[i] + "_" + i);
                System.out.println(Thread.currentThread().getName() + "_produce_" + menus[i] + "_" + i);
            }
            System.out.println("producer end produce_"+capacity.size());
            flag = true;
            cCdn.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(){
        try {
            lock.lock();
            while (!flag){
                System.out.println("consumer begin wait");
                cCdn.await();
            }
            System.out.println("consumer begin consume");
            Iterator it = capacity.iterator();
            while (it.hasNext()){
                System.out.println(Thread.currentThread().getName() + "_consume_" + capacity.poll());
            }
            System.out.println("consumer end consume_"+capacity.size());
            flag = false;
            pCdn.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
