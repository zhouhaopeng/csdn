package com.zhhp.threadTest.pool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface ExecuteService extends Executor {

    void shutdown();

    List<Runnable> shutdownNow();

    boolean isShutdown();

    boolean isTerminated();

    boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException;

    <T> Future<T> submit(Callable<T> task);

    <T> Future<T> submit(Runnable runnable,T t);

    <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
            throws InterruptedException;

    <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends java.util.concurrent.Callable<T>> tasks,
                                                       long timeout, TimeUnit unit)
            throws InterruptedException;

    <T> T invokeAny(Collection<? extends java.util.concurrent.Callable<T>> tasks)
            throws InterruptedException, ExecutionException;

    <T> T invokeAny(Collection<? extends java.util.concurrent.Callable<T>> tasks,
                    long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException;

}
