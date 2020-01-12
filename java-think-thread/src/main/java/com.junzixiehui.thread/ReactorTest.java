package com.junzixiehui.thread;

import reactor.core.publisher.Flux;

import javax.activation.MailcapCommandMap;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/1/14  3:31 PM
 * @version: 1.0
 */
public class ReactorTest {

	public static void main(String[] args) {
		Flux.generate(sink -> {
			sink.next("hello");
			sink.complete();
		}).subscribe(System.out::println);



	}

}
