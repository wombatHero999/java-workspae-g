package com.kh.practice.network.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hostname = sc.nextLine();
		
		try {
			InetAddress arr[] = InetAddress.getAllByName(hostname);
			System.out.println(hostname+"는 "+arr.length+"개의 IP주소를 가지고 있습니다.");
			
			int count = 1;
			for(InetAddress i : arr) {
				System.out.println(count++ +"번 IP = "+i.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}





