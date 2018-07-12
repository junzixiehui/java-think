package com.junzixiehui.common.aqs;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/25  下午6:40
 * @version: 1.0
 */
public class FutureSimple<V> implements Future<V>, Runnable {

    private volatile V income = null;
    private volatile int state = 0;
    private volatile Callable<V> callable;


    public FutureSimple(Callable<V> callable) {
        this.callable = callable;
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return income != null;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {

        for (;;){
            if (income != null){
                return income;
            }

            continue;
        }

    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void run() {

        try {
            V v = callable.call();

            AtomicInteger a = new AtomicInteger();
            a.set(1);
            income = v;
        } catch (Exception e) {

        }

    }


}
