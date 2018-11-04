package com.zhhp.threadTest.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Future<V> {

    boolean cancel(boolean myInternetIfRunning);

    boolean isCancelled();

    boolean isDone();

    V get() throws InterruptedException;

    V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException;
}
