package com.zhhp.threadTest.pool;

public interface ThreadFactory {

    Thread newThread(Runnable runnable);
}
