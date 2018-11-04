package com.zhhp.threadTest.pool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractExecutorService implements ExecuteService{

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable,T t){
        return new FutureTask<T>(runnable,t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable){
        return new FutureTask<T>(callable);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        if (task == null)
            throw new NullPointerException();
        RunnableFuture<T> future = newTaskFor(task);
        execute(future);
        return future;
    }

    @Override
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null)
            throw new NullPointerException();
        RunnableFuture<T> future = newTaskFor(runnable,t);
        execute(future);
        return future;
    }

    @Override
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends java.util.concurrent.Callable<T>> tasks) {
        return null;
    }

    @Override
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, TimeUnit unit) {
        return null;
    }
}
