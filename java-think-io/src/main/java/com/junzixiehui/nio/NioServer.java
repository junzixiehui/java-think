package com.junzixiehui.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/20  下午5:52
 * @version: 1.0
 */
public class NioServer {

	public static void main(String[] args) throws Exception {
		new NioServer().serve(8888);
	}

	public void serve(int port) throws Exception {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket ss = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		ss.bind(address);
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (selector.select() > 0) {

			Set<SelectionKey> readyKeys = selector.selectedKeys();

			Iterator<SelectionKey> iterator = readyKeys.iterator();

			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();

				if (key.isAcceptable()) {
					//ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = serverChannel.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_READ);
					System.out.println("Accepted connection from " + client);

					sayHello(client);
				} else if (key.isWritable()) {
					SocketChannel client = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					while (buffer.hasRemaining()) {
						if (client.write(buffer) == 0) {
							break;
						}
					}
					client.close();
				} else if (key.isReadable()){
					SocketChannel clientChannel = (SocketChannel) key.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

					int len = 0;
					while ((len = clientChannel.read(byteBuffer)) != -1){
						byteBuffer.flip();
						System.out.println(new String(byteBuffer.array(),0,len));
						byteBuffer.clear();
					}
					clientChannel.close();

				}
				iterator.remove();
			}
		}
	}

	final static ByteBuffer buffer = ByteBuffer.allocate(1024);
	private static void sayHello(SocketChannel channel) throws Exception {
		buffer.clear();
		buffer.put("Hi there!\r\n".getBytes());
		buffer.flip();
		channel.write(buffer);
	}
}