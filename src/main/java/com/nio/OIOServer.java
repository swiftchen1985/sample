package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OIOServer {

	public static void main(String[] args) {
		try {
			startServer(9000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void startServer(int port) throws IOException{
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("server start.");
		while(true) {
			//The method blocks until a connection is made.
			final Socket socket = serverSocket.accept();
			
			handleSocket(socket);
		}
		
	}

	private static void handleSocket(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		byte[] buffer = new byte[1024];
		System.out.println(" client connection.");
		while(true) {
			int read = is.read(buffer);
			if(read !=-1) {
				System.out.println(new String(buffer, 0, read));
			} else {
				break;
			}
		}
		
	}
}
