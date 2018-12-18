package com.zhhp.test;

public class MyConunt implements Runnable{

    private static Integer i = new Integer(0);

    @Override
    public void run() {
        while (true){
            synchronized (i){
                if (i < 10000){
                    i ++;
                    System.out.println("i= " + i);
                }else break;
            }
        }
    }

    public static void main(String[] ars){
        Thread t1 = new Thread(new MyConunt());
        Thread t2 = new Thread(new MyConunt());

        t1.start();
        t2.start();
    }
}
