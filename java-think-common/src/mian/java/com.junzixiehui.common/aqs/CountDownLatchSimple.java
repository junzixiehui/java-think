package com.junzixiehui.common.aqs;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/25  10:40
 * @version: 1.0
 */
public class CountDownLatchSimple {

    private volatile int state;
    Node node = new Node();

    public CountDownLatchSimple(int count) {
        this.state = count;
    }


    public int getcount() {
        return state;
    }

    public void await() {

        for (; ; ) {
            if (state > 0) {
                node.add(Thread.currentThread());
                LockSupport.park(Thread.currentThread());
            }
            return;
        }
    }

    public void countDown() {
        for (; ; ) {
            if (state <= 0) {

                LockSupport.unpark(node.get().thread);
                return;
            }
            AtomicInteger atimicState = new AtomicInteger(state);
            state = atimicState.decrementAndGet();
            if (state <= 0) {
                LockSupport.unpark(node.get().thread);
                return;
            }
        }
    }


    static final class Node {

        volatile Node next;

        volatile Thread thread;

        public Node(Thread thread) {
            this.thread = thread;
        }

        public Node() {
        }


        final Node get() {
            return next;
        }

        final void add(Thread thread) {
            next = new Node(thread);
        }

    }


}
