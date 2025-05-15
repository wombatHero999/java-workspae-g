package com.kh.chap02_tcp.server.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Run {
	
	public static void main(String[] args) {
		/* 
		 * TCP
		 *  - 서버와 클라이언트간의 연결지향형 통신 방법
		 *  - 서버와 클라이언트간의 연결이 되어 있어야 데이터를 교환한다.
		 *  - 신뢰성있고 안전한 데이터 전달이 가능
		 *  - 클라이언트와 서버간에 연결이 되어 있으므로 "실시간"으로 데이터 송수신이 가능. 
		 *  
		 * Socket
		 *  - 클라이언트와 서버간에 실시간 "통신"에 사용되는 객체 
		 *  - 소켓이 소유한 ip번호와 port번호를 통해 소켓을 식별한다.
		 *  
		 * ServerSocket
		 *  - 서버에서 생성하는 소켓으로 클라이언트의 연결요청을 대기한다.
		 *  - 연결요청이 들어오면 Socket을 생성하여 클라이언트에게 전달.
		 *  
		 * ClientSocket(Socket)
		 *  - 서버와 통신에 사용되는 클라이언트 소켓. 
		 *  - 서버의 ip주소, 포트번호를 통해 서버에게 연결요청을 보낸다.
		 * */
		
		// 1) 소켓의 포트번호 지정
		//     - 0 ~ 1023 시스템 포트 번호
		//     - 1024 ~ 65535사이의 포트번호 사용.
		int port = 30000;
		
		// 2) 서버소켓 객체 생성
		// 현재 pc의 ip주소와 port번호를 가진 소켓생성.
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			
			System.out.println("### 서버 시작 ###");
			// 3) 클라이언트의 접속 요청이 오기까지 대기
			while(true) {
				System.out.println("### 클라이언트의 요청 대기 중 ###");
				Socket client = server.accept(); // 클라이언트의 요청이 들어오기까지 대기.
				System.out.println("### 클라이언트 연결 !!! ###");
				
				// 4) 연결된 클라이언트와 통신할 수 있는 입출력 스트림 생성
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
				
				while(true) {
					String message = br.readLine();
					
					if(message == null || message.equals("exit")) {
						System.out.println("접속 종료 !!!");
						break;
					}
					
					System.out.println(client.getInetAddress().getHostAddress()+"가 보낸 메세지 : " + message);
					pw.println("메세지 받기 성공");					
				}
				
				// 5) 통신종료 
				br.close();
				pw.close();
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
	}
}












