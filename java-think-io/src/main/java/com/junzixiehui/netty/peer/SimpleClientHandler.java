package com.junzixiehui.netty.peer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/1/29  6:09 PM
 * @version: 1.0
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//ctx.channel().close().sync();
		System.out.println("channelActive client");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, final Object msg) throws Exception {
		System.out.println("channelRead client");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("client  inactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		System.out.println("=====client=="+cause);
		cause.printStackTrace();
		System.out.println("=====client2=="+cause);
	}
}