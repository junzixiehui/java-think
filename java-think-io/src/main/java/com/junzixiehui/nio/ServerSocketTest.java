package com.junzixiehui.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/1/30  3:42 PM
 * @version: 1.0
 */
public class ServerSocketTest {

	public static void main(String[] args) {
		try {
			final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

			serverSocketChannel.socket().bind(new InetSocketAddress(8888));

			serverSocketChannel.configureBlocking(false);

			boolean stop = true;
			while (stop){
				final SocketChannel socketChannel = serverSocketChannel.accept();
				if (socketChannel == null){

					Thread.sleep(1000);
					System.out.println("==1===");
				} else {
					System.out.println(socketChannel.getLocalAddress());

					ByteBuffer readBuf = ByteBuffer.allocate(1024);

					int len = 0;
					while ((len = socketChannel.read(readBuf)) != -1){
						readBuf.flip();
						System.out.println(new String(readBuf.array(),0,len));
						readBuf.clear();
					}

					socketChannel.write(ByteBuffer.wrap("接收到数据".getBytes()));
					socketChannel.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
