package com.zhhp.threadTest.pool;

public interface Callable<V> {

    V call() throws Exception;
}
