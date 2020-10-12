package com.junzixiehui.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;


/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 0/0/  下午:0
 * @version: .0
 */
public class EchoClient {

	static final boolean SSL = System.getProperty("ssl") != null;
	static final String HOST = System.getProperty("host", "127.0.0.1");
	static final int PORT = Integer.parseInt(System.getProperty("port", "8115"));
	static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

	public static void main(String[] args) throws Exception {
		// Configure SSL.git
		final SslContext sslCtx;
		if (SSL) {
			sslCtx = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
		} else {
			sslCtx = null;
		}

		// Configure the client.
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline p = ch.pipeline();
							if (sslCtx != null) {
								p.addLast(sslCtx.newHandler(ch.alloc(), HOST, PORT));
							}
							//p.addLast(new LoggingHandler(LogLevel.INFO));
							p.addLast(new EchoClientHandler());
						}
					});

			// Start the client.
			ChannelFuture f = b.connect(HOST, PORT).sync();

			f.addListener(new ChannelFutureListener() {

				public void operationComplete(ChannelFuture future) throws Exception {
					if(future.isSuccess()){
						System.out.println(HOST + PORT+"client connected");
					}else{
						System.out.println("server attemp failed");
						future.cause().printStackTrace();
					}

				}
			});

			// Wait until the connection is closed.
			f.channel().closeFuture().sync();
		} finally {
			// Shut down the event loop to terminate all threads.
			group.shutdownGracefully();
		}
	}

}
