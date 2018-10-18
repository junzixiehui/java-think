package com.junzixiehui.common.lang;

/**
 * <p>Description: </p>
 *
 * @author: by qulibin
 * @date: 2018/6/26  下午7:39
 * @version: 1.0
 */
public class IntegetSimple {



	public int testCov(){
		Object obj = new Object();
		int i = 0;
		synchronized (obj){
			i ++ ;
		}

		return i;
	}

	public int testCov2(){
		Object obj = new Object();
		int i = 0;
		synchronized (obj){
			i ++ ;
		}

		return i;
	}





}
