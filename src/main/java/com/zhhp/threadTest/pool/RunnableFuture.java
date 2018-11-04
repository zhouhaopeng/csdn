package com.zhhp.threadTest.pool;

public interface RunnableFuture<V> extends Future<V>,Runnable{

    @Override
    void run();
}
