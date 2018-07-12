package com.junzixiehui.common.aqs;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.*;

/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/25  下午6:44
 * @version: 1.0
 */
public class FutureSimpleTest {




    @Test
    public void test() throws Exception{
        FutureTask futureTask1 = new FutureTask(new Task());
        FutureTask futureTask2 = new FutureTask(new Task());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);

        if (futureTask1.isDone()){
            System.out.println("判断是否结束1");
        }

        int result = (Integer)futureTask1.get();
        System.out.println("结果1：" + result);


        int result2 = (Integer)futureTask2.get();
        System.out.println("结果2：" + result2);

        if (futureTask1.isDone()){
            System.out.println("判断是否结束2");
        }

        futureTask1.cancel(true);


        executorService.shutdown();

    }


    @Test
    public void test1() throws Exception{
        FutureSimple futureTask1 = new FutureSimple(new Task());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(futureTask1);


        if (futureTask1.isDone()){
            System.out.println("判断是否结束1");
        }

        int result = (Integer)futureTask1.get();
        System.out.println("结果1：" + result);

        if (futureTask1.isDone()){
            System.out.println("判断是否结束2");
        }

        executorService.shutdown();

    }








    static class Task  implements Callable<Integer> {

        public Integer call() throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");
            int result = 0;
            for(int i = 0; i < 100;++i) {
                result += i;
            }

            Thread.sleep(1000);
            return result;
        }
    }

}