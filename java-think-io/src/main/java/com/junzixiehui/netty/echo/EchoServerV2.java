package com.junzixiehui.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/19  下午5:49
 * @version: 1.0
 */
public class EchoServerV2 {
	private final int port;

	public EchoServerV2(int port) {
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); //#1
			b.group(group) //#2
					.channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new EchoServerHandler());
						}
					});
			ChannelFuture f = b.bind().sync();
			System.out.println(
					EchoServerV2.class.getSimpleName() + " started and listener on " + f.channel().localAddress());
			f.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoServerV2(8989).start();
	}
}