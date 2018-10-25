package com.zhhp.threadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,30,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(20));


        for (int i = 0 ; i < 25 ; i ++){
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
    }


    static class MyTask implements Runnable{

        private int taskNum;

        public MyTask(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {

            System.out.println("正在执行task"+taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕task"+taskNum);
        }
    }
}
