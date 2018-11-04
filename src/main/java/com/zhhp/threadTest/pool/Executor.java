package com.zhhp.threadTest.pool;


import com.sun.istack.internal.NotNull;

public interface Executor {

    void execute(@NotNull Runnable runnable);
}
