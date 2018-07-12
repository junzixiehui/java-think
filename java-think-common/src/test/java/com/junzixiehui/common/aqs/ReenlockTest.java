package com.junzixiehui.common.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/25  下午4:18
 * @version: 1.0
 */
public class ReenlockTest {


    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
      /*  for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
            thread.start();
        }*/
    }

}
