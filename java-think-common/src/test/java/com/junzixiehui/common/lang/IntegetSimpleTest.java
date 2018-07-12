package com.junzixiehui.common.lang;

import org.junit.Test;


/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/26  下午7:40
 * @version: 1.0
 */
public class IntegetSimpleTest {



    @Test
    public void test(){

        Integer i = 2;

        int a = i;

        int b = Integer.valueOf(a);
        int c = Integer.valueOf(a);

        System.out.println(a);
        System.out.println(b);

    }


}