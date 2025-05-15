package com.kh.chap02_tcp.client.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		// 1) 서버소켓과 연결하기위해, 서버의 ip주소와 port번호를 확인.
		int serverPort = 30000;
		Socket socket = null;
		try {
			String serverIp = "192.168.10.2";
			String localIp = InetAddress.getLocalHost().getHostAddress();
			
			// 2) 서버의 ip주소와 port번호를 제시하여 소켓객채 생성 (연결요청) 
			socket = new Socket(serverIp, serverPort);
			
			// 3) 서버소켓과 연결된 입출력 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.print("서버에 보낼 메세지 : ");
				String str = sc.nextLine();
				
				pw.println(str);
				
				if(str != null && str.equals("exit")) {
					System.out.println("접속종료!!");
					break;
				}
				
				System.out.println("받은 메세지 : " + br.readLine());
			}
			
			pw.close();
			br.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}








