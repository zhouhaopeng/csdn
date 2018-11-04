package com.zhhp.threadTest.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTask<V> implements RunnableFuture<V> {

    /**
     *      * Possible state transitions:
     *      * NEW -> COMPLETING -> NORMAL
     *      * NEW -> COMPLETING -> EXCEPTIONAL
     *      * NEW -> CANCELLED
     *      * NEW -> INTERRUPTING -> INTERRUPTED
     *
     */

    private volatile int state;
    private static final int NEW          = 0;
    private static final int COMPLETING   = 1;
    private static final int NORMAL       = 2;
    private static final int EXCEPTIONAL  = 3;
    private static final int CANCELLED    = 4;
    private static final int INTERRUPTING = 5;
    private static final int INTERRUPTED  = 6;

    private Callable<V> callable;

    private Object outCome;

    private volatile Thread runner;




    public FutureTask(Callable<V> callable){
        if (callable == null){
            throw new NullPointerException();
        }
        this.callable = callable;
        this.state = NEW;
    }

    public FutureTask(Runnable runnable,V v){
        if (runnable == null){
            throw new NullPointerException();
        }
        this.callable = Executors.callable(runnable,v);
        this.state = NEW;
    }


    @Override
    public void run() {
        Callable<V> c = callable;
        if (c != null){
            try {
                V result ;
                boolean ran = false;
                try {
                    result = c.call();
                    ran = true;

                }catch (Exception e){
                    result = null;
                    ran = false;
                }
                if (ran)
                    outCome = result;
            }
            finally {
                runner = null;
            }
        }
    }

    @Override
    public boolean cancel(boolean myInternetIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return state >= CANCELLED;
    }

    @Override
    public boolean isDone() {
        return state != NEW;
    }

    @Override
    public V get() throws InterruptedException {
        int s = state;
        if (s < COMPLETING)
            s = awaitDone(false,0);
        return report(s);
    }

    public V report(int state){
        Object x = outCome;
        if (state == NORMAL)
            return (V)x;
        return null;
    }

    private int awaitDone(boolean timed,long nanos) throws InterruptedException {
        final long deadline = timed ? System.nanoTime() + nanos : 0L;
        WaitNode q = null;
        boolean queued = false;
        for (;;){
            if (Thread.interrupted()){
                ////////
                throw new InterruptedException();
            }
            int s = state;
            if (s > COMPLETING){
                if (q != null){
                    q.thread = null;
                }
                return s;
            }else if (s == COMPLETING){
                Thread.yield();
            }else if (q == null){
                q = new WaitNode();
            }

        }

    }

    static final class WaitNode {
        volatile Thread thread;
        volatile FutureTask.WaitNode next;
        WaitNode() { thread = Thread.currentThread(); }
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
