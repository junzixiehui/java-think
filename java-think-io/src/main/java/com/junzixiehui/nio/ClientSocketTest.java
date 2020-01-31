package com.junzixiehui.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2020/1/30  3:59 PM
 * @version: 1.0
 */
public class ClientSocketTest {

	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
			//socketChannel.connect();

			System.out.println ("connection established");

			socketChannel.configureBlocking(false);

			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

			byteBuffer.put(LocalDateTime.now().toString().getBytes());


			byteBuffer.flip();
			socketChannel.write(byteBuffer);
			byteBuffer.clear();




			/*int len = 0;
			while ((len = socketChannel.read(byteBuffer)) != -1){
				byteBuffer.flip();
				System.out.println(new String(byteBuffer.array(),0,len));
				byteBuffer.clear();
			}*/

			/*ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			while (socketChannel.read(byteBuffer) != -1){
				byteBuffer.flip();
				System.out.println(new String(byteBuffer.array()));
				byteBuffer.clear();
			}*/
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
