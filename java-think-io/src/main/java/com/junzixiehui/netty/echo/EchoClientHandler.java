package com.junzixiehui.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/19  下午2:44
 * @version: 1.0
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {


	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("Active");
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
		//#2 通道连接上后写入消息 记得flush() 很重要
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object in) {
		System.out.println("Read");
		System.out.println("Client received: " + in);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}


}
