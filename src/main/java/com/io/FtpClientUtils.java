package com.io;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.net.ftp.Configurable;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClientUtils extends FTP implements Configurable{

	private static String FTP_USERNAME = "develop";
	private static String FTP_PASSWORD = "develop";
	
	public void configure(FTPClientConfig config) {
		
	}

	public static void main(String[] args) {
		FTPClient ftp = new FTPClient();
		boolean error = false;
		try {
			int reply;
			/*String server = "ftp.example.com";
			ftp.connect(server);*/
			ftp.connect(InetAddress.getByName("172.26.141.121"), 21);
			ftp.login(FTP_USERNAME, FTP_PASSWORD);
			//System.out.println("Connected to " + server + ".");
			ftp.setControlEncoding("UTF-8");
			System.out.print(ftp.getReplyString());
			// After connection attempt, you should check the reply code to
			// verify
			// success.
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			ftp.logout();
		} catch (IOException e) {
			error = true;
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					// do nothing
				}
			}
			System.exit(error ? 1 : 0);
		}
	}
}
