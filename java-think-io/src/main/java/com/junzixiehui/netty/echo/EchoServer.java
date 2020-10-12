package com.junzixiehui.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/19  下午2:51
 * @version: 1.0
 */
public class EchoServer {

	static final boolean SSL = System.getProperty("ssl") != null;
	static final int PORT = Integer.parseInt(System.getProperty("PORT","8007"));

	public static void main(String[] args) throws Exception{

		final SslContext sslContext;
		if (SSL){
			SelfSignedCertificate ssc = new SelfSignedCertificate();
			sslContext = SslContextBuilder.forServer(ssc.certificate(),ssc.privateKey()).build();
		} else {
			sslContext = null;
		}


		EventLoopGroup eventLoopGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();//工作线程

		final EchoServerHandler echoServerHandler = new EchoServerHandler();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(eventLoopGroup,workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {


						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline p = socketChannel.pipeline();
							if (sslContext !=  null){
								p.addLast(sslContext.newHandler(socketChannel.alloc()));
							}

							p.addLast(echoServerHandler);

						}
					});
			ChannelFuture f = serverBootstrap.bind(PORT).sync();
			System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync();
		} finally {
			eventLoopGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

















}
