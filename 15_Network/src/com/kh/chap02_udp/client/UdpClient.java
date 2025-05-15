package com.kh.chap02_udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient {
	public static void main(String[] args) {
		try {
			InetAddress server = InetAddress.getByName("localhost");
			int serverPort = 30001;
			
			// 랜덤 포트번호 사용.
			DatagramSocket socket = new DatagramSocket();
			String message = "udp 클라이언트가 작성한 메세지";
			byte[] sendData = message.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length
					,server, serverPort);
			
			socket.send(sendPacket);
			
			// 서버로부터 데이터 수신 대기
			socket.receive(sendPacket);
			
			String receiveData = new String(sendPacket.getData(), 0 , sendPacket.getLength());
			System.out.println(receiveData);
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}













