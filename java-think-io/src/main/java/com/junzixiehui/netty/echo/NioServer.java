package com.junzixiehui.netty.echo;

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
	public static void main(String[] args) throws IOException {
		new NioServer().serve(8080);
	}

	public void serve(int port) throws IOException {
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		ServerSocket ss = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		ss.bind(address);
		Selector selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
		for (; ; ) {
			selector.select();
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				if (key.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) key.channel();
					SocketChannel client = server.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
					System.out.println("Accepted connection from " + client);
				}
				if (key.isWritable()) {
					SocketChannel client = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					while (buffer.hasRemaining()) {
						if (client.write(buffer) == 0) {
							break;
						}
					}
					client.close();
				}
			}
		}
	}


}