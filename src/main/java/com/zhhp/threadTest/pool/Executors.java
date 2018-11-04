package com.zhhp.threadTest.pool;

import java.util.concurrent.atomic.AtomicInteger;

public class Executors {

    public static <T> Callable<T> callable(Runnable runnable,T t){
        if (runnable == null){
            throw new NullPointerException();
        }
        return new RunnableAdapter<T>(runnable,t);
    }

    static final class RunnableAdapter<V> implements Callable<V>{

        private Runnable runnable;

        private V v;

        public RunnableAdapter(Runnable runnable, V v) {
            this.runnable = runnable;
            this.v = v;
        }

        @Override
        public V call() throws Exception {
            runnable.run();
            return v;
        }
    }

    static class DefaultThreadFactory implements ThreadFactory{
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }

    }

}
