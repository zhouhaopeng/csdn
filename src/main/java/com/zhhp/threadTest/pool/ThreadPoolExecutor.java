package com.zhhp.threadTest.pool;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor extends AbstractExecutorService {




    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable runnable) {

    }
}
