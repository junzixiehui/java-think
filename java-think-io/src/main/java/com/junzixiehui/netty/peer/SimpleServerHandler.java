package com.junzixiehui.netty.peer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/1/29  6:09 PM
 * @version: 1.0
 */
public class SimpleServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channelActive");
		//ctx.channel().close().sync();
		System.out.println("channelActive close");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, final Object msg) throws Exception {
		System.out.println(123);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("inactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		System.out.println("=======server========"+cause);
	}
}