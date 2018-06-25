package com.junzixiehui.common.aqs;

import java.util.concurrent.atomic.AtomicInteger;
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

    public CountDownLatchSimple(int count) {
        this.state = count;
    }


    public void await() {

        for (;;){
            if (state > 0){
               continue;
            }
            return;
        }
    }

    public void countDown() {
        for (;;){
            if (state == 0){

                return;
            }
            AtomicInteger atimicState = new AtomicInteger(state);
            state = atimicState.decrementAndGet();
            if (state == 0){
                return;
            }
        }
    }



}
