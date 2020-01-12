package com.junzixiehui.netty.peer;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/1/29  6:08 PM
 * @version: 1.0
 */
public class ClientTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		Bootstrap b = new Bootstrap();
		b.group(new NioEventLoopGroup()).channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel ch) throws Exception {
						ch.pipeline().addLast(new SimpleClientHandler());
					}
				});

		b.connect("localhost", 8090)
				.addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) throws Exception {
				if (future.isSuccess()) {
					future.channel().write(Unpooled.buffer().writeBytes("123".getBytes()));
					future.channel().flush();
				}
			}
		});
	}
}
