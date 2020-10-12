package com.junzixiehui.io;

import sun.awt.geom.AreaOp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2018/10/19  下午8:32
 * @version: 1.0
 */
public class Server {


	private static final int port = 8115;


	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(port);

		Socket socket = serverSocket.accept();

		InputStream inputStream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream);

		String request = in.readLine();
		while (request != null){
			if (request.equals("")){
				break;
			}
			System.out.println(request);
			printWriter.write(request);
		}

		socket.close();
		serverSocket.close();


	}
}
