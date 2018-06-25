package com.junzixiehui.common.aqs;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/25  10:47
 * @version: 1.0
 */
public class CountDownLatchSimpleTest {

    CountDownLatch countDownLatch = new CountDownLatch(3);
    CountDownLatchSimple countDownLatchSimple = new CountDownLatchSimple(3);


    @Test
    public void test1() throws Exception{


        System.out.println("主线程start执行");
        Thread countThread1 = new Thread(new CountThread("countThread1"));
        Thread countThread2 = new Thread(new CountThread("countThread2"));
        Thread countThread3 = new Thread(new CountThread("countThread3"));

        countThread1.start();
        countThread2.start();
        countThread3.start();


        System.out.println("主线程await执行");
        countDownLatch.await();
        System.out.println("主线程继续执行");

    }


    @Test
    public void test2() throws Exception{


        System.out.println("主线程start执行");
        Thread countThread1 = new Thread(new CountThread("countThread1"));
        Thread countThread2 = new Thread(new CountThread("countThread2"));
        Thread countThread3 = new Thread(new CountThread("countThread3"));

        countThread1.start();
        countThread2.start();
        countThread3.start();


        System.out.println("主线程await执行");
        countDownLatchSimple.await();
        System.out.println("主线程继续执行");

        System.out.println(countDownLatchSimple.getcount());

    }




    public class CountThread implements Runnable {
        private String threadName;


        public CountThread(String threadName){
             this.threadName = threadName;
        }
        Random random = new Random();

        public void run() {
            try {
                int i =  random.nextInt(10);
                System.out.println(threadName +" :子线程开始执行" + i);
                Thread.sleep(i * 1000);
                countDownLatchSimple.countDown();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }




}